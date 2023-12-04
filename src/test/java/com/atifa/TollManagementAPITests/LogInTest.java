package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.LogIn;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class LogInTest {

    /*
    * Positive test=validate user can log in successfully
    * negative test1=validate user unsuccessful when log in with invalid username
    * negative test2=validate user unsuccessful when log in with invalid password
    *
    * */
    private static ExtentReports extent;
    private static ExtentTest testLog;

    @BeforeMethod
    public void beforeTests(){
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate User Log In Successfully");
    }
    @AfterClass
    public void aftertests(){
        extent.flush();
    }

    @Test
    public void successfulLogIn(){

      Response rs=  LogIn.login();
      BaseAssertion.verifyStatusCode(rs,200);
      BaseAssertion.verifySpecificMessage(rs,"message","Log in successfully!");



    }
    @Test
    public void unsuccessfulLogInWithInvalidUser(){
        Response resp=  LogIn.loginInvalidUser();
        BaseAssertion.verifySpecificMessage(resp, "statusCode", "400");
        BaseAssertion.verifySpecificMessage(resp,"message","Incorrect username or password.");

    }

    @Test
    public void unsuccessfulLogInWithInvalidPassword(){
        Response resp=  LogIn.loginInvalidPassword();
        BaseAssertion.verifySpecificMessage(resp, "statusCode", "400");
        BaseAssertion.verifySpecificMessage(resp,"message","Incorrect username or password.");

    }


}
