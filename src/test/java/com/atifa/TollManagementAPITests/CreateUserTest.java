package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.CreateUser;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateUserTest {
    @Test
    public void newUsertest(){
        CreateUser newUser=new CreateUser();
        Response rs=newUser.createNewUser();

        BaseAssertion.verifyStatusCode(rs,200);
       // BaseAssertion.verifySpecificMessage(rs,"","");

    }

    @Test
    public void negnewusertest(){
        CreateUser user=new CreateUser();
        Response rs=user.createUserWithExistBody();

        BaseAssertion.verifyStatusCode(rs,400);

    }
}
