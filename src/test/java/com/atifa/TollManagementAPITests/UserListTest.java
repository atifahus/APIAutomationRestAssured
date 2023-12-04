package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.UserList;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserListTest {

    /*
    * positive test-validate to get user list successfully
    * negative test-validate 401 unauthorized response recieve if no auth is given
    *
    * */
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





}
