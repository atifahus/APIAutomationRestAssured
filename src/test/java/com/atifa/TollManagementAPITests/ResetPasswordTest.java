package com.atifa.TollManagementAPITests;

import base.BaseAssertion;
import com.atifa.TollManagementAPI.ResetPassword;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ResetPasswordTest {

    /*
    * Positive test-Validate successful password reset
    * Negative test-Validate it is failed when authentication is missing
    *
    * */
    @Test
    public void successRestTest(){
        Response rs=ResetPassword.resetPassword();
        BaseAssertion.verifySpecificMessage(rs,"statusCode","200");

    }

    @Test
    public void unsuccessfulReset(){
        Response rs= ResetPassword.resetPasswordNegTest();
        BaseAssertion.verifyStatusCode(rs,401);

    }
}
