package com.adyax.api.automation.tests;

import com.adyax.api.automation.RegistrationFailureResponse;
import com.adyax.api.automation.RegistrationSuccessResponse;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeserializeJsonResponceTest {
    private static final Logger LOGGER = Logger.getLogger(DeserializeJsonResponceTest.class);

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
    public void DeserializeJsonTest () {
        RestAssured.baseURI ="http://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();
        int index = 5 + (int)(Math.random() * ((100 - 5) + 1));
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender414" + index); // Cast
        requestParams.put("LastName", "Singh444" + index);
        requestParams.put("UserName", "simpleuser" + index);
        requestParams.put("Password", "password1" + index);
        requestParams.put("Email",  "someuserjhjh" + index +"@gmail.com");

        request.body(requestParams.toJSONString());
        Response response = request.post("/register");
        ResponseBody body = response.getBody();
        LOGGER.info("Response body : " + response.body().asString() + "\n");
        LOGGER.info("The status code recieved : " + response.statusCode() + "\n");
        if(response.statusCode() == 200)
        {
            // Deserialize the Response body into RegistrationFailureResponse
            RegistrationFailureResponse responseBody = body.as(RegistrationFailureResponse.class);// as(RegistrationFailureResponse.class);

            // Use the RegistrationFailureResponse class instance to Assert the values of
            // Response.
            LOGGER.info("Response body : " + responseBody.FaultId + "__" + responseBody.fault +"\n");
            LOGGER.info("Response body : " + responseBody + "\n");
            Assert.assertEquals("User already exists", responseBody.FaultId);
            Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.fault);
        }
        else if (response.statusCode() == 201)
        {
            // Deserialize the Response body into RegistrationSuccessResponse
            RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
            // Use the RegistrationSuccessResponse class instance to Assert the values of
            // Response.
            LOGGER.info("Response body : " + responseBody.SuccessCode + "__" + responseBody.Message +"\n");
            Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
            Assert.assertEquals("Operation completed successfully", responseBody.Message);
        }
        LOGGER.info("********* Test is finished ************" );
    }
}
