package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.CreateUser;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class CreateUserTest {
    /*
    * positive test= validate user is created successfully
    * negative test1= with existing user body
    * negative test2= when json body is empty
    *
    * */
    private static ExtentReports extent;
    private static ExtentTest testLog;

    @BeforeMethod
    public void beforeTests(){
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate User Created Successfully");
    }
    @AfterClass
    public void aftertests(){
        extent.flush();
    }
    @Test(priority = 1,groups = "acceptenceTests")
    public void newUsertest(){
        CreateUser newUser=new CreateUser();
        Response rs=newUser.createNewUser();

        BaseAssertion.verifyStatusCode(rs,200);
        BaseAssertion.verifySpecificMessage(rs,"message","User Created successfully!");

    }

    @Test (priority = 2)
    public void createUserWithExistingInfo(){
        CreateUser user=new CreateUser();
        Response rs=user.createUserWithExistBody();

        BaseAssertion.verifySpecificMessage(rs,"statusCode","400");
        BaseAssertion.verifySpecificMessage(rs,"message","User account already exists");


    }
    @Test
    public void createUserWithEmptyBodyTest(){
        CreateUser user=new CreateUser();
        Response rs=user.createUserWithEmptyBody();

        BaseAssertion.verifySpecificMessage(rs,"errorMessage","'ParamValidationError' object has no attribute 'response'");



    }

}
