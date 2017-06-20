package au.com.aupost.suburbmanager.integration;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.stream.StreamSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import au.com.aupost.suburbmanager.model.PostCode;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostCodeRepositoryTest {
    
    private static final long TOTAL_NUMBER_OF_POST_CODES = 33;
    private static final long ONE_NEWLY_ADDED_POST_CODE = 1;

    private static final int NEW_POST_CODE = 3136;
    
    @Autowired
    private PostCodeRepository postCodeRepository;

    @Test
    public void findAll() {

        // exercise SUT
        Iterable<PostCode> postCodes = postCodeRepository.findAll();

        // verify
        assertThat(getNumberOfResults(postCodes), is(TOTAL_NUMBER_OF_POST_CODES));
    }
    
    @Test
    public void save() {
        
        // setup fixture
        PostCode postCode = new PostCode(NEW_POST_CODE);

        // exercise SUT
        postCodeRepository.save(postCode);
        
        // verify
        Iterable<PostCode> suburbs = postCodeRepository.findAll();
        assertThat(getNumberOfResults(suburbs), is(TOTAL_NUMBER_OF_POST_CODES + ONE_NEWLY_ADDED_POST_CODE));
    }

    private long getNumberOfResults(Iterable<PostCode> postCodes) {
        return StreamSupport.stream(postCodes.spliterator(), false).count();
    }

}