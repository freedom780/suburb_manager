package au.com.aupost.suburbmanager.api.error;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.http.HttpStatus;

public class ErrorResponseTest {

    @Test
    public void instantiate() {

        // setup fixture
        String httpStatus = String.format("%s - %s", HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.name());
        String errorCode = "Error code";
        String errorMessage = "Error message";

        // exercise SUT
        ErrorResponse response = new ErrorResponse(httpStatus, errorCode, errorMessage);

        // verify
        assertThat(response.getHttpStatus(), is(httpStatus));
        assertThat(response.getErrorCode(), is(errorCode));
        assertThat(response.getErrorMessage(), is(errorMessage));
    }

}
