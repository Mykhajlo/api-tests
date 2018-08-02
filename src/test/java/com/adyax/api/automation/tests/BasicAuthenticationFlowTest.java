package com.adyax.api.automation.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.adyax.api.automation.Utils.testSite;

public class BasicAuthenticationFlowTest extends  MainTest {
    private static final Logger LOGGER = Logger.getLogger(BasicAuthenticationFlowTest.class);

    @BeforeClass
    public void testBeforeTest() throws InterruptedException {
        //response = testSite();
        LOGGER.info("testBeforeTest()");
    }

    @AfterTest
    public void testAfterTest() {
        LOGGER.info("testAfterTest()");
    }
    @Test
    public void AuthenticationBasics()
    {
       // System.err.close();
       // System.setErr(System.out);
        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
        RequestSpecification request = RestAssured.given();
        request.auth().preemptive().basic("ToolsQA", "TestPassword");
        Response response = request.get();
        LOGGER.info("Status code: " + response.getStatusCode());
        LOGGER.info("Status message " + response.body().asString());
    }
}
