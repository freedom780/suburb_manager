package au.com.aupost.suburbmanager.api.services.postcode.db;

import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.MELBOURNE;
import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.MELBOURNE_POSTCODE_COUNT;
import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.NEW_POST_CODE_2000;
import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.NON_EXISTING_SUBURB;
import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.ONE_NEWLY_ADDED_POST_CODE;
import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.RINGWOOD;
import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.RINGWOOD_POSTCODE;
import static au.com.aupost.suburbmanager.api.services.postcode.PostcodeTestConstants.TOTAL_NUMBER_OF_POSTCODES;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import au.com.aupost.suburbmanager.api.services.PostCodeRepository;
import au.com.aupost.suburbmanager.model.PostCode;
import au.com.aupost.suburbmanager.model.PostCodeCategory;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostCodeRepositoryTest {
        
    private static final int ZERO = 0;
    private static final int ONE = 1;
    
        
    @Autowired
    private PostCodeRepository postCodeRepository;

    @Test
    public void findBySuburbNameReturnsOneResult() {

        // exercise SUT
        List<PostCode> postCodes = postCodeRepository.findBySuburbName(RINGWOOD);

        // verify
        assertThat(postCodes.size(), equalTo(ONE));
        assertThat(postCodes.get(0).getCode(), equalTo(RINGWOOD_POSTCODE));
    }

    @Test
    public void findBySuburbNameReturnsMultipleResults() {
        
        // exercise SUT
        List<PostCode> postCodes = postCodeRepository.findBySuburbName(MELBOURNE);
        
        // verify
        assertThat(postCodes.size(), equalTo(MELBOURNE_POSTCODE_COUNT));
    }

    @Test
    public void findBySuburbNameReturnsNoResult() {
        
        // exercise SUT
        List<PostCode> postCodes = postCodeRepository.findBySuburbName(NON_EXISTING_SUBURB);
        
        // verify
        assertThat(postCodes.size(), equalTo(ZERO));
    }
    
    @Test
    public void findAll() {
        
        // exercise SUT
        Iterable<PostCode> postCodes = postCodeRepository.findAll();
        
        // verify
        assertThat(getNumberOfResults(postCodes), equalTo(TOTAL_NUMBER_OF_POSTCODES));
    }
    
    @Test
    public void save() {
        
        // setup fixture
        PostCode postCode = new PostCode(NEW_POST_CODE_2000, PostCodeCategory.DELIVERY);

        // exercise SUT
        postCodeRepository.save(postCode);
        
        // verify
        Iterable<PostCode> suburbs = postCodeRepository.findAll();
        assertThat(getNumberOfResults(suburbs), equalTo(TOTAL_NUMBER_OF_POSTCODES + ONE_NEWLY_ADDED_POST_CODE));
    }

    private int getNumberOfResults(Iterable<PostCode> postCodes) {
        return (int) StreamSupport.stream(postCodes.spliterator(), false).count();
    }

}