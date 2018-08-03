package com.adyax.api.automation.tests;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.adyax.api.automation.Utils.testSite;

public class WeatherBodyTest extends MainTest {
    private static final Logger LOGGER = Logger.getLogger(WeatherBodyTest.class);

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
    public void WeatherBodyMessage(){
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String city = jsonPathEvaluator.get("City");
        LOGGER.info("Responce body is : " + bodyAsString + "\n");
        LOGGER.info("City received from Response : " + city + "\n");
        //Assert.assertEquals(bodyAsString.contains("Hyderabad") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
        Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");
        LOGGER.info("********* Test is finished ************" );
    }
}
