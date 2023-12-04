package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.ResetPassword;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class ResetPasswordTest {

    /*
    * Positive test-Validate successful password reset
    * Negative test1-Validate it is failed when authentication is missing
    * Negative test2- with invalid user and password credentials
    *
    * */

    private static ExtentReports extent;
    private static ExtentTest testLog;

    @BeforeMethod
    public void beforeTests(){
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate Password Reset Test");
    }
    @AfterClass
    public void aftertests(){
        extent.flush();
    }
    @Test
    public void successRestTest(){
        Response rs=ResetPassword.resetPassword();
        BaseAssertion.verifySpecificMessage(rs,"statusCode","200");
        BaseAssertion.verifySpecificMessage(rs,"message","Password set successfully!");

    }

    @Test
    public void unsuccessfulReset(){

        Response rs= ResetPassword.resetPasswordNoAuth();
        BaseAssertion.verifyStatusCode(rs,401);
        BaseAssertion.verifySpecificMessage(rs,"message","Unauthorized");


    }

    @Test
    public void resetWithInvalidCredentialTest(){

        Response rs=ResetPassword.resetPasswordInvalidCredentials();
        BaseAssertion.verifySpecificMessage(rs,"statusCode","400");
        BaseAssertion.verifySpecificMessage(rs,"message","User does not exist.");
    }
}
