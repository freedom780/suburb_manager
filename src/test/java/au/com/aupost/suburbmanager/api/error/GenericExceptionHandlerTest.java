package au.com.aupost.suburbmanager.api.error;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

public class GenericExceptionHandlerTest {

    private WebRequest request = mock(WebRequest.class);
    
    @Test
    public void onDataIntegrityViolation() {

        // setup fixture
        GenericExceptionHandler handler = new GenericExceptionHandler();
        IllegalStateException exception = new IllegalStateException("Illegal state");

        // exercise SUT
        ResponseEntity<Object> response = handler.onDataIntegrityViolation(exception, request);

        // verify
        assertThat(response.getBody(), is(not(nullValue())));

    }

}
