package com.adyax.api.automation.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.adyax.api.automation.Utils.*;

public class GetWeatherHeadersTest  extends  MainTest {
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
    public void GetWeatherHeadersFeaturesTest()
    {
        // Header named Content-Type
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
        LOGGER.info("Content Type : " + contentType);
        // Reader header of a give name. In this line we will get
        // Header named Server
        String serverType =  response.header("Server");
        Assert.assertEquals(serverType /* actual value */, "nginx/1.14.0" /* expected value */);
        LOGGER.info("Server Type : " + serverType);
        // Reader header of a give name. In this line we will get
        // Header named Content-Encoding
        String contentEncoding = response.header("Content-Encoding");
        Assert.assertEquals(contentEncoding /* actual value */, "gzip" /* expected value */);
        LOGGER.info("Content Encoding : " + contentEncoding);
        LOGGER.info("Test is finished" );
    }
}
