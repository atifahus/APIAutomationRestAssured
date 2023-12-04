package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.SubmitToll;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SubmitTollTest {
    /*
    * Positive test-validate Toll is submitted successfully
    * Negative test-Validate unsuccessful to submit toll when id info is missing in body
    *
    * */
    @Test
    public void validateSubmitToll(){
        Response rs=SubmitToll.getSubmitToll();

        BaseAssertion.verifyStatusCode(rs,200);
        BaseAssertion.verifySpecificMessage(rs,"message","success");


    }

    @Test
    public void submitTollTestWithoutData(){
        //With missing ID data, expected result is 400 status code

        Response rs=SubmitToll.submitTollWithoutID();

        BaseAssertion.verifySpecificMessage(rs,"statusCode","400");
        BaseAssertion.verifySpecificMessage(rs,"message","error occured!");




    }

}
