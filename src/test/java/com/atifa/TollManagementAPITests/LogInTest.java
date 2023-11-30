package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.LogIn;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LogInTest {
    @Test
    public void successfulLogIn(){
        Response rs= LogIn.logIn();

        BaseAssertion.verifyStatusCode(rs,200);

    }
    @Test
    public void unsuccessfulLogIn(){
        Response rs=LogIn.logIn();

        BaseAssertion.verifyStatusCode(rs,400);


    }
}
