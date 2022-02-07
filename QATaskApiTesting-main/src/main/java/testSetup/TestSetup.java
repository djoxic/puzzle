package testSetup;

import dataProvider.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestSetup {

    public static RequestSpecification SetupURLAndRequestParameters() {
        RequestSpecification request = RestAssured.given();
        ConfigFileReader configFileReader = new ConfigFileReader();
        String URL = configFileReader.getApplicationUrl();
        request.baseUri(URL);
        request.header("Accept", "application/json");
        request.header("Content-Type", "application/json");
        return request;
    }

}
