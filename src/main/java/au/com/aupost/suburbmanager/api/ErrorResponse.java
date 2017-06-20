package au.com.aupost.suburbmanager.api;

public class ErrorResponse {

    private final String errorCode;
    private final String message;

    public ErrorResponse(String errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

}
