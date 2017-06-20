package au.com.aupost.suburbmanager.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.UUID;

import org.junit.Test;

public class ErrorResponseTest {

    @Test
    public void instantiate() {

        // setup fixture
        String code = UUID.randomUUID().toString();
        String message = "Error message";

        // exercise SUT
        ErrorResponse response = new ErrorResponse(code, message);

        // verify
        assertThat(response.getErrorCode(), is(code));
        assertThat(response.getMessage(), is(message));
    }

}
