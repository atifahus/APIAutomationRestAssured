package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.SubmitToll;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SubmitTollTest {
    @Test
    public void validateSubmitToll(){
        Response rs=SubmitToll.getSubmitToll();

        BaseAssertion.verifyStatusCode(rs,200);
        BaseAssertion.verifySpecificMessage(rs,"message","success");


    }

    @Test
    public void validateSubmitTollWithNegativeData(){
        //With invalid data, expected result is 400 status code

        Response rs=SubmitToll.getSubmitToll();

        BaseAssertion.verifyStatusCode(rs,400);



    }

}
