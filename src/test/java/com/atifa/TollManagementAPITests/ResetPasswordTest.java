package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.ResetPassword;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ResetPasswordTest {
    @Test
    public void validateReset(){
        Response rs= ResetPassword.reset();
        BaseAssertion.verifyStatusCode(rs,200);
       // BaseAssertion.verifySpecificMessage(rs,"message","Password set successfully!");

    }

    @Test
    public void unsuccessfulReset(){
        Response rs= ResetPassword.reset();
        BaseAssertion.verifyStatusCode(rs,400);

    }
}
