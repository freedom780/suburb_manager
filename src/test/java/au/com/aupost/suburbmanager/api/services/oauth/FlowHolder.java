package au.com.aupost.suburbmanager.api.services.oauth;

public class FlowHolder {

    private String baseUrl;
    private String session;
    private String authorisationCode;
    private String accessToken;

    public FlowHolder(String baseUrl) {
        super();
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getAuthorisationCode() {
        return authorisationCode;
    }

    public void setAuthorisationCode(String authorisationCode) {
        this.authorisationCode = authorisationCode;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}