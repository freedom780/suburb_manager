package au.com.aupost.suburbmanager.api.services.common;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import au.com.aupost.suburbmanager.api.services.oauth.OAuthAccessTokenRetriever;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public abstract class ApiServiceTest {

    protected static final int PAGE_SIZE = 20;

    @LocalServerPort
    private int port;

    protected URL baseUrl;

    @Autowired
    protected TestRestTemplate template;

    protected OAuthAccessTokenRetriever jwtAccessTokenRetriever = new OAuthAccessTokenRetriever();
    
    protected void buildBaseUrl() throws MalformedURLException {
        this.baseUrl = new URL("http://localhost:" + port + "/");
    }

}
