package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.TollListBasedOnCollectionPoint;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TollListBasedOnCollectionPointTest {
    @Test
    public void validateTollList(){
        Response rs= TollListBasedOnCollectionPoint.tollList();

        BaseAssertion.verifyStatusCode(rs,200);

    }

    @Test
    public void invalidCollectionPointTollList(){
        //With invalid collection point ID, expected result is 400 status code

        Response rs= TollListBasedOnCollectionPoint.tollListWithInvalidCollectionPoint();

        BaseAssertion.verifyStatusCode(rs,400);

    }



}
