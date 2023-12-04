package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.TollListBasedOnCollectionPoint;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TollListBasedOnCollectionPointTest {

    /*
    * Positive test-validate user get toll list based on collection point ID successfully
    * Negative test-validate user is unsuccessful to get toll list if used wrong method.
    *
    * */
    @Test
    public void validateTollList(){
        Response rs= TollListBasedOnCollectionPoint.tollList();

        BaseAssertion.verifyStatusCode(rs,200);

    }

    @Test
    public void invalidCollectionPointTollList(){
        //With invalid collection point ID, expected result is 400 status code

        Response rs= TollListBasedOnCollectionPoint.tollListWithInvalidMethod();

        BaseAssertion.verifyStatusCode(rs,403);


    }



}
