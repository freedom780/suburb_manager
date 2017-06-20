package au.com.aupost.suburbmanager.integration;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import au.com.aupost.suburbmanager.model.PostCode;
import au.com.aupost.suburbmanager.model.Suburb;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SuburbRepositoryTest {

    private static final long TOTAL_NUMBER_OF_SUBURBS = 35;

    private static final long ONE_NEWLY_ADDED_SUBURB = 1;
    
    private static final String NEW_SUBURB_NAME = "Warranwood";
    private static final int NEW_SUBURB_POST_CODE = 3134;
   
    private static final int POST_CODE_3134 = 3134;
    
    private static final String RINGWOOD = "Ringwood";
    private static final String RINGWOOD_NORTH = "Ringwood North";
    private static final String WARRANDYTE_SOUTH = "Warrandyte South";
    private static final Object THREE_SUBURBS_WITH_3134_POSTCODE = 3;

    
    @Autowired
    private PostCodeRepository postCodeRepository;
    
    @Autowired
    private SuburbRepository suburbRepository;

    @Test
    public void findByPostCode() {

        // exercise SUT
        List<Suburb> suburbs = suburbRepository.findByPostCode(POST_CODE_3134);

        // verify
        verifyThreeSuburbsWithPostcode3134Retrieved(suburbs);
    }

    @Test
    public void findAll() {

        // exercise SUT
        Iterable<Suburb> suburbs = suburbRepository.findAll();

        // verify
        assertThat(getNumberOfResults(suburbs), is(TOTAL_NUMBER_OF_SUBURBS));
    }
    
    @Test
    public void save() {
        
        // setup fixture
        PostCode postCode = postCodeRepository.findByCode(NEW_SUBURB_POST_CODE);
        Suburb suburb = new Suburb(NEW_SUBURB_NAME, postCode);

        // exercise SUT
        suburbRepository.save(suburb);
        
        // verify
        Iterable<Suburb> suburbs = suburbRepository.findAll();
        assertThat(getNumberOfResults(suburbs), is(TOTAL_NUMBER_OF_SUBURBS + ONE_NEWLY_ADDED_SUBURB));
    }

    private long getNumberOfResults(Iterable<Suburb> suburbs) {
        return StreamSupport.stream(suburbs.spliterator(), false).count();
    }

    private void verifyThreeSuburbsWithPostcode3134Retrieved(List<Suburb> suburbs) {
        assertThat(suburbs.size(), is(THREE_SUBURBS_WITH_3134_POSTCODE));
        assertThat(suburbs.get(0).getName(), is(RINGWOOD));
        assertThat(suburbs.get(1).getName(), is(RINGWOOD_NORTH));
        assertThat(suburbs.get(2).getName(), is(WARRANDYTE_SOUTH));
    }

}