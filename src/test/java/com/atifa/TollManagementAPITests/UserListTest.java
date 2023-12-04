package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.UserList;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class UserListTest {

    /*
    * positive test-validate to get user list successfully
    * negative test1-validate 401 unauthorized response received if no auth is given
    * negative test2-validate 403 status code received if invalid url is given
    *
    * */
    private static ExtentReports extent;
    private static ExtentTest testLog;

    @BeforeMethod
    public void beforeTests(){
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate User list test");
    }
    @AfterClass
    public void aftertests(){
        extent.flush();
    }
    @Test
    public void validateUserList(){
        Response rs= UserList.getUserList();

        BaseAssertion.verifyStatusCode(rs,200);
        BaseAssertion.verifySpecificMessage(rs,"message","User List!");
    }

    @Test
    public void userListNegtest(){
        Response rs=UserList.getUserListNegTestWithoutAuth();

        BaseAssertion.verifyStatusCode(rs,401);

    }
    @Test
    public void userListInvalidURLTest(){
        Response rs=UserList.getUserListWithInvalidURL();

        BaseAssertion.verifyStatusCode(rs,403);

    }





}
