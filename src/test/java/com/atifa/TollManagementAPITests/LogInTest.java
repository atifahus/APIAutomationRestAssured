package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.LogIn;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LogInTest {
    @Test
    public void successfulLogIn(){
      Response rs=  LogIn.login();
      BaseAssertion.verifyStatusCode(rs,200);
      BaseAssertion.verifySpecificMessage(rs,"message","Log in successfully!");

    }
    @Test
    public void unsuccessfulLogIn(){
        Response resp=  LogIn.negLogin();
        BaseAssertion.verifySpecificMessage(resp, "statusCode", "400");
        BaseAssertion.verifySpecificMessage(resp,"message","Incorrect username or password.");

    }


}
