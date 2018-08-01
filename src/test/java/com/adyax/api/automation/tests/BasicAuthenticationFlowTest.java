package com.adyax.api.automation.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class BasicAuthenticationFlowTest {
    private static final Logger LOGGER = Logger.getLogger(BasicAuthenticationFlowTest.class);

    @BeforeTest
    public void testBeforeTest() {
        LOGGER.info("testBeforeTest()");
    }

    @AfterTest
    public void testAfterTest() {
        LOGGER.info("testAfterTest()");
    }
    @Test
    public void AuthenticationBasics()
    {
        System.err.close();
        System.setErr(System.out);
        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
        RequestSpecification request = RestAssured.given();

        Response response = request.get();
        LOGGER.info("Status code: " + response.getStatusCode());
        LOGGER.info("Status message " + response.body().asString());
    }
}
