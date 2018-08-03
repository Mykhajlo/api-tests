package com.adyax.api.automation.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.adyax.api.automation.Utils.testSite;

public class PostRequestTest extends MainTest {
    private static final Logger LOGGER = Logger.getLogger(PostRequestTest.class);

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
    public void PostRequestFeatureTest(){
        RestAssured.baseURI ="http://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();
        int index = 5 + (int)(Math.random() * ((100 - 5) + 1));
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender414" + index); // Cast
        requestParams.put("LastName", "Singh444" + index);
        requestParams.put("UserName", "simpleuser" + index);
        requestParams.put("Password", "password1" + index);
        requestParams.put("Email",  "someuserjhjh" + index +"@gmail.com");

        // Add a header starting the Request body is a Json
        request.header("Content-Type", "application/json");
        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());
        // Post the request and check the response
        Response response = request.post("/register");

        int statusCode = response.getStatusCode();
        LOGGER.info("The status code recieved : " + statusCode + "\n");
        Assert.assertEquals(statusCode,201);
        LOGGER.info("The status code recieved : " + statusCode + "\n");
        String successCode = response.jsonPath().get("SuccessCode");
        //Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SU CCESS");
        Assert.assertEquals( "OPERATION_SUCCESS", successCode, "Correct Success code was returned");
        LOGGER.info("Response body : " + response.body().asString() + "\n");
        LOGGER.info("********* Test is finished ************" );
    }
}
