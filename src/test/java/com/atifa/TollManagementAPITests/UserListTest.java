package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.UserList;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserListTest {
    @Test
    public void validateUserList(){
        Response rs= UserList.getUserList();

        BaseAssertion.verifyStatusCode(rs,200);
        BaseAssertion.verifySpecificMessage(rs,"message","User List!");
    }






}
