package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.TollListBasedOnCollectionPoint;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class TollListBasedOnCollectionPointTest {

    /*
    * Positive test-validate user get toll list based on collection point ID successfully
    * Negative test1-unsuccessful to get toll list if used POST method instead of GET
    * Negative test2-unsuccessful to get toll list if "Bearer " missing from Token
    *
    *
    * */
    private static ExtentReports extent;
    private static ExtentTest testLog;

    @BeforeMethod
    public void beforeTests(){
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate user gets Toll list based on Collection Point ID");
    }
    @AfterClass
    public void aftertests(){
        extent.flush();
    }
    @Test
    public void validateTollList(){
        Response rs= TollListBasedOnCollectionPoint.tollList();

        BaseAssertion.verifyStatusCode(rs,200);
        BaseAssertion.verifySpecificMessage(rs,"message","success");

    }

    @Test
    public void invalidCollectionPointTollList(){


        Response rs= TollListBasedOnCollectionPoint.tollListWithInvalidMethod();

        BaseAssertion.verifyStatusCode(rs,403);


    }
    @Test
    public void collectionPointTollListInvalidTokenTest(){


        Response rs= TollListBasedOnCollectionPoint.tollListWithInvalidToken();

        BaseAssertion.verifyStatusCode(rs,403);



    }



}
