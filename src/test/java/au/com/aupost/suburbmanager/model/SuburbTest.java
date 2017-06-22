package au.com.aupost.suburbmanager.model;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SuburbTest {

    private static final String SUBURB_NAME = "Melbourne";
    private static final int POST_CODE = 3000;
    private static final long SUBURB_ID = 1;

    @Test
    public void instantiate() {

        // exercise SUT
        Suburb suburb = new Suburb();

        // verify
        assertThat(suburb, is(not(nullValue())));
    }
    
    
    @Test
    public void getId() {
        
        // setup fixture
        PostCode postCode = createPostCode(POST_CODE);
        Suburb suburb = new Suburb(SUBURB_NAME, postCode, State.VIC);
        suburb.setId(SUBURB_ID);
        
        // exercise SUT
        Long id = suburb.getId();
        
        // verify
        assertThat(id, is(SUBURB_ID));
    }


    private PostCode createPostCode(int code) {
        return new PostCode(code, PostCodeCategory.DELIVERY);
    }

}
