package com.adyax.api.automation.tests;

import com.adyax.api.automation.Book;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
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
    public void DeserializeJsonToArrayTest () throws IOException {



            RestAssured.baseURI = "http://restapi.demoqa.com/utilities/books/getallbooks";
            //RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
            RequestSpecification request = RestAssured.given();

            Response response = request.get("");
            String json = response.body().asString();
            JsonPath jsonPath = new JsonPath(json);
           // LOGGER.info(json);

            //LOGGER.info("Response Body -> " + allBooks.toString());
            LOGGER.info("*********************Book********************");


       /// HashMap<String,Book> result = new ObjectMapper().readValue(json, Book.class);


        //Map<Integer, Book> book = jsonPathEvaluator.getMap("books", Integer.class, Book.class);

        //List<String> book = jsonPath.from(json).getList("books.findAll { it.pages < 1000 }");
        List<Book> books = response.jsonPath().getList("books", Book.class);

       //List<Book> book = response.jsonPath().getList("books.findAll{ books -> books.pages >= 5 && books.pages <= 1500 }", Book.class);

        //LOGGER.info(books.size());
          //  LOGGER.info(books);

    }
}
