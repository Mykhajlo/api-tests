package com.adyax.api.automation.tests;

import com.adyax.api.automation.Book;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DeserializeJsonResponceToArrayTest {
    private static final Logger LOGGER = Logger.getLogger(DeserializeJsonResponceToArrayTest.class);

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
    public void DeserializeJsonToArrayTest (){
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/books/getallbooks";
        RequestSpecification request = RestAssured.given();

        Response response = request.get("");
        LOGGER.info("Response Body -> " + response.body().asString());

        // Using JsonPath we can convert an Array of Json objects into
        // List of Class Type representing the Json Object.
        // In the below code we can use JsonPath.getList(<NodeName>) method
        // to get a list of Books.


        Map<Book> books  = response.jsonPath().getList("books", Book.class);
        //List<Book> books  = response.jsonPath().getList("books", Book.class);
       // List<Book> books = response.jsonPath().getList("books", Book.class);
        LOGGER.info("Books as String " + books.toString());
    }
}
