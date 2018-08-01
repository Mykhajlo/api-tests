package com.adyax.api.automation.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.adyax.api.automation.Utils.testSite;


public class SimpleGetTest extends  MainTest {
   private static final Logger LOGGER = Logger.getLogger(SimpleGetTest.class);
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
    public void GetWeatherDetails()
    {
        // for closing warning message about illegal activity
//        System.err.close();
//        System.setErr(System.out);
       // BasicConfigurator.configure();
        // Specify the base URL to the RESTful web service
       // RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
       // RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
//        String sssss = "/Hyderabad";
//        LOGGER.info("Test" );
//        Response response = httpRequest.get(sssss);
        //Response response = httpRequest.request(Method.GET, sssss);

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        String responseBody = response.getBody().asString();
        //System.out.println("Response Body is =>  " + responseBody);
        LOGGER.info("Response Body is =>  " + responseBody);

        int statusCode = response.getStatusCode();
        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        LOGGER.info("Status Code : " + statusCode);
        LOGGER.info("Test is finished" );

    }
}
