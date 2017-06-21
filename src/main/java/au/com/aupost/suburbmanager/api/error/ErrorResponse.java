package au.com.aupost.suburbmanager.api.error;

public class ErrorResponse {

    private final String httpStatus;
    private final String errorCode;
    private final String errorMessage;

    public ErrorResponse(String httpStatus, String code, String message) {
        super();
        this.httpStatus = httpStatus;
        this.errorCode = code;
        this.errorMessage = message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}