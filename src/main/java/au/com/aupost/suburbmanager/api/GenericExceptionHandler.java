package au.com.aupost.suburbmanager.api;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GenericExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> onException(Exception ex) {
        String errorCode = UUID.randomUUID().toString();
        ErrorResponse error = new ErrorResponse(errorCode, getErrorMessage(errorCode));
        LOG.error(getErrorMessage(errorCode), ex);
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getErrorMessage(String errorCode) {
        return String.format("An error occured. Please contact an administrator and quote [%s]", errorCode);
    }
    
}
