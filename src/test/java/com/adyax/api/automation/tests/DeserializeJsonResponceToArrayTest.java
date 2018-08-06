package com.adyax.api.automation.tests;

import com.adyax.api.automation.Book;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.*;



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



        //Book targetObject = new Gson().fromJson(jsonjhj, Book.class);


     //   LOGGER.info("Books as String " + targetObject.title + targetObject.isbn);




        ObjectMapper mapper = new ObjectMapper();

            RestAssured.baseURI = "http://restapi.demoqa.com/utilities/books/getallbooks";
            //RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
            RequestSpecification request = RestAssured.given();

            Response response = request.get("");
            String json = response.body().asString();

            //LOGGER.info("Response Body -> " + json);
            LOGGER.info("*********************Book********************");
           // Book jsonFrom = mapper.readValue(json, "books",Book.class);

            //myProduct = objectMapper.readValue(productJson, new TypeReference<List<product>>() {});
            List<String> jsonResponse = response.jsonPath().getList("books");
            LOGGER.info(jsonResponse.size());
            LOGGER.info(jsonResponse);

            //List<Book> jsonFrom = response.jsonPath().getList("books", Book.class);
            //LOGGER.info("Total responses = " + jsonFrom);

           /* TreeSet<Book> Products = new TreeSet<>();

            for (int i = 0; i < Book.size(); i++) {

                Book book = new Book(responses[i], warranties[i], prices[i], webElementPrices.get(i));

                Products.add(book);

                //LOGGER.info(Good.toString());

            } */

           // LOGGER.info(jsonFrom.toString());


    }
}
