package com.adyax.api.automation.tests;

import com.adyax.api.automation.Utils;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import com.jayway.restassured.specification.RequestSpecification;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.adyax.api.automation.Utils.testSite;

public class GetWeatherStatusLineTest extends  MainTest {
    private static final Logger LOGGER = Logger.getLogger(GetWeatherDetailsInvalidCityTest.class);

    @BeforeClass
    public void testBeforeTest() throws InterruptedException {
        response = testSite();
        LOGGER.info("testBeforeTest()");
    }

    @AfterTest
    public void testAfterTest() {
        LOGGER.info("testAfterTest()");
    }
    @Test
    public void GetWeatherStatusLine()
    {


        // Get the status line from the Response and store it in a variable called statusLine
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
        LOGGER.info("Status Code : " + statusLine);
        LOGGER.info("Test is finished" );
    }
}
