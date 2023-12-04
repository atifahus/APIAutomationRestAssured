package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.TollCollectionList;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class TollCollectionListTest {

    /*
    * Positive test-Validate to get toll collection list successfully
    * Negative test-Validate it is unsuccessful to get toll collection list if endpoint is missing
    * */
    private static ExtentReports extent;
    private static ExtentTest testLog;

    @BeforeMethod
    public void beforeTests(){
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate user gets Toll Collection List");
    }
    @AfterClass
    public void aftertests(){
        extent.flush();
    }
    @Test
    public void validateTollCollectionList(){
        TollCollectionList list= new TollCollectionList();
        Response rs=list.getTollCollectList();

        BaseAssertion.verifySpecificMessage(rs,"statusCode","200");
        BaseAssertion.verifySpecificMessage(rs,"message","success");

    }

    @Test
    public void tollCollectionListWithoutEndpoint(){

        Response rs=TollCollectionList.getTollCollectionListWithoutEndpoint();

        BaseAssertion.verifyStatusCode(rs,403);




    }


}
