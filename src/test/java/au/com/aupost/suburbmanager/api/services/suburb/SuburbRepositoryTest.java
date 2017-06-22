package au.com.aupost.suburbmanager.api.services.suburb;

import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.NEW_SUBURB_NAME;
import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.NEW_SUBURB_POST_CODE;
import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.ONE_NEWLY_ADDED_SUBURB;
import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.POST_CODE_3134;
import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.RINGWOOD;
import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.RINGWOOD_NORTH;
import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.THREE_SUBURBS_WITH_3134_POSTCODE;
import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.TOTAL_NUMBER_OF_SUBURBS;
import static au.com.aupost.suburbmanager.api.services.suburb.SuburbTestConstants.WARRANDYTE_SOUTH;
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
import au.com.aupost.suburbmanager.api.services.SuburbRepository;
import au.com.aupost.suburbmanager.model.PostCode;
import au.com.aupost.suburbmanager.model.State;
import au.com.aupost.suburbmanager.model.Suburb;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SuburbRepositoryTest {

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
        assertThat(getNumberOfResults(suburbs), equalTo(TOTAL_NUMBER_OF_SUBURBS));
    }
    
    @Test
    public void save() {
        
        // setup fixture
        PostCode postCode = postCodeRepository.findByCode(NEW_SUBURB_POST_CODE);
        Suburb suburb = new Suburb(NEW_SUBURB_NAME, postCode, State.VIC);

        // exercise SUT
        suburbRepository.save(suburb);
        
        // verify
        Iterable<Suburb> suburbs = suburbRepository.findAll();
        assertThat(getNumberOfResults(suburbs), equalTo(TOTAL_NUMBER_OF_SUBURBS + ONE_NEWLY_ADDED_SUBURB));
    }

    private int getNumberOfResults(Iterable<Suburb> suburbs) {
        return (int) StreamSupport.stream(suburbs.spliterator(), false).count();
    }

    private void verifyThreeSuburbsWithPostcode3134Retrieved(List<Suburb> suburbs) {
        assertThat(suburbs.size(), equalTo(THREE_SUBURBS_WITH_3134_POSTCODE));
        assertThat(suburbs.get(0).getName(), equalTo(RINGWOOD));
        assertThat(suburbs.get(1).getName(), equalTo(RINGWOOD_NORTH));
        assertThat(suburbs.get(2).getName(), equalTo(WARRANDYTE_SOUTH));
    }

}