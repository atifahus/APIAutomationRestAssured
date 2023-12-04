package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.TollCollectionList;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TollCollectionListTest {

    /*
    * Positive test-Validate to get toll collection list successfully
    * Negative test-Validate it is unsuccessful to get toll collection list if endpoint is missing
    * */

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
