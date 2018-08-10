package com.adyax.api.automation.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestServiceTest extends  MainTest{
    private static final Logger LOGGER = Logger.getLogger(RestServiceTest.class);
    @BeforeClass
    public void setUp() throws InterruptedException {
        //response = testSite();
       // RestAssured.authentication = basic("login","password");    //// important
        LOGGER.info("testBeforeTest()");
    }

    @AfterTest
    public void testAfterTest() {
        LOGGER.info("testAfterTest()");
    }
    @Test
    public void RestTest (){
        RestAssured.baseURI = "http://parabank.parasoft.com/parabank/services/bank/customers";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/12212");
        String xml = response.andReturn().asString();
        // Retrieve the values to be checked from the XML as a String
        XmlPath xmlPath = new XmlPath(xml).setRoot("customer");
        String customerId = xmlPath.getString("id");
        String firstName = xmlPath.getString("firstName");
        String lastName = xmlPath.getString("lastName");
        Assert.assertEquals(customerId, "12212");
        LOGGER.info("customerId is corrrect - " + customerId);
        Assert.assertEquals(firstName, "John");
        LOGGER.info("FirstName is corrrect - " + firstName);
        Assert.assertEquals(lastName, "Smith");
        LOGGER.info("LastName is corrrect - " + lastName);
        LOGGER.info("Test is finished" );
    }
}
