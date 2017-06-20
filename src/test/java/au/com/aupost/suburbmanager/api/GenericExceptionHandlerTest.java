package au.com.aupost.suburbmanager.api;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

public class GenericExceptionHandlerTest {

    @Test
    public void onException() {

        // setup fixture
        GenericExceptionHandler handler = new GenericExceptionHandler();
        IllegalStateException exception = new IllegalStateException("Illegal state");

        // exercise SUT
        ResponseEntity<ErrorResponse> response = handler.onException(exception);

        // verify
        assertThat(response.getBody().getMessage(), is(not(nullValue())));

    }

}
