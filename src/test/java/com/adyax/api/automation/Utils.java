package com.adyax.api.automation;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class Utils {
    private static final Logger LOGGER = Logger.getLogger(Utils.class);

    public static Response testSite () throws InterruptedException{
        //System.err.close();
        //System.setErr(System.out);
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");
        return response;
    }

}
