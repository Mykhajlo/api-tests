package com.adyax.api.automation.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class GetWeatherHeadersTest {
    private static final Logger LOGGER = Logger.getLogger(GetWeatherDetailsInvalidCityTest.class);

    @BeforeTest
    public void testBeforeTest() {
        LOGGER.info("testBeforeTest()");
    }

    @AfterTest
    public void testAfterTest() {
        LOGGER.info("testAfterTest()");
    }
    @Test
    public void GetWeatherHeaders()
    {
        System.err.close();
        System.setErr(System.out);
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Reader header of a give name. In this line we will get
        // Header named Content-Type
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
        LOGGER.info("Status Code : " + contentType);
        // Reader header of a give name. In this line we will get
        // Header named Server
        String serverType =  response.header("Server");
        Assert.assertEquals(serverType /* actual value */, "nginx/1.12.2" /* expected value */);
        LOGGER.info("Status Code : " + serverType);
        // Reader header of a give name. In this line we will get
        // Header named Content-Encoding
        String contentEncoding = response.header("Content-Encoding");
        Assert.assertEquals(contentEncoding /* actual value */, "gzip" /* expected value */);
        LOGGER.info("Status Code : " + contentEncoding);
        LOGGER.info("Test is finished" );
    }
}
