package com.adyax.api.automation.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class GetWeatherDetailsInvalidCityTest {
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
    public void GetInvalidCityTest() {
//        System.err.close();
//        System.setErr(System.out);
//        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = httpRequest.get("/Hyderabad");
//        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
//        LOGGER.info("Status Code : " + statusCode);
        LOGGER.info("Test is finished" );
    }

}
