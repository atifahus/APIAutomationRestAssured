package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.TollCollectionList;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TollCollectionListTest {

    @Test
    public void validateTollCollectionList(){
        TollCollectionList list= new TollCollectionList();
        Response rs=list.getTollCollectList();

        BaseAssertion.verifyStatusCode(rs,200);
        BaseAssertion.verifySpecificMessage(rs,"message","success");

    }


}
