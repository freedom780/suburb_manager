package au.com.aupost.suburbmanager.api.error;

import java.util.UUID;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.support.QueryMethodParameterConversionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GenericExceptionHandler.class);

    @ExceptionHandler(value = { ConstraintViolationException.class })
    protected ResponseEntity<Object> onDataIntegrityViolation(RuntimeException exception, WebRequest request) {
        ErrorResponse errorResponse = createErrorResponseForDataIntegrityViolation(HttpStatus.CONFLICT);
        LOG.error(errorResponse.getErrorMessage(), exception);
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = { QueryMethodParameterConversionException.class })
    protected ResponseEntity<Object> onInvalidParameter(RuntimeException exception, WebRequest request) {
        ErrorResponse errorResponse = createErrorResponseForParameterConversionException(HttpStatus.BAD_REQUEST);
        LOG.error(errorResponse.getErrorMessage(), exception);
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    private ErrorResponse createErrorResponseForDataIntegrityViolation(HttpStatus httpStatus) {
        String errorCode = UUID.randomUUID().toString();
        String status = String.format("%s - %s", httpStatus.value(), httpStatus.name());
        return new ErrorResponse(status, errorCode, getErrorMessage("Data integrity violation error", errorCode));
    }

    private ErrorResponse createErrorResponseForParameterConversionException(HttpStatus httpStatus) {
        String errorCode = UUID.randomUUID().toString();
        String status = String.format("%s - %s", httpStatus.value(), httpStatus.name());
        return new ErrorResponse(status, errorCode, getErrorMessage("Incorrect parameter type", errorCode));
    }
    
    private String getErrorMessage(String errorMessage, String errorCode) {
        return String.format("%s. Please contact an administrator and quote '%s'", errorMessage, errorCode);
    }

}