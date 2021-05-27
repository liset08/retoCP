package com.cayhualla.ecommerce_cineplanet.model;
import org.simpleframework.xml.Root;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "merchant")

public class Merchant {

    private String apiLogin;
    private String apiKey;


    public String getApiLogin() {
        return apiLogin;
    }
    @Root(name = "apiLogin")

    public void setApiLogin(String apiLogin) {
        this.apiLogin = apiLogin;
    }

    public String getApiKey() {
        return apiKey;
    }
    @Root(name = "apiKey")

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "apiLogin='" + apiLogin + '\'' +
                ", apiKey='" + apiKey + '\'' +
                '}';
    }
}
