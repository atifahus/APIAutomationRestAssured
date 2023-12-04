package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.SubmitToll;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class SubmitTollTest {
    /*
    * Positive test-validate Toll is submitted successfully
    * Negative test1-Validate unsuccessful to submit toll when id info is missing in body
    * Negative test2-Using GET method instead of POST
    *
    * */
    private static ExtentReports extent;
    private static ExtentTest testLog;

    @BeforeMethod
    public void beforeTests(){
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate user submitted toll Test");
    }
    @AfterClass
    public void aftertests(){
        extent.flush();
    }
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

    @Test
    public void submitTollTesInvalidMethodTest(){


        Response rs=SubmitToll.submitTollInvalidMethod();

       BaseAssertion.verifyStatusCode(rs,403);


    }

}
