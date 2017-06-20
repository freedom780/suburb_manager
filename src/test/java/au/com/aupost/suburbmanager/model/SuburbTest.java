package au.com.aupost.suburbmanager.model;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SuburbTest {

    private static final String SUBURB_NAME = "Warranwood";
    private static final int POST_CODE = 3134;

    @Test
    public void instantiate() {

        // exercise SUT
        Suburb suburb = new Suburb();

        // verify
        assertThat(suburb, is(not(nullValue())));
    }

}
