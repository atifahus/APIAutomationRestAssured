package com.atifa.TollManagementAPI;


import base.AccessToken;
import base.Base;
import io.restassured.response.Response;
import utility.URL;

public class ResetPassword {

    public static Response reset() {
        String bearerToken = "Bearer " + AccessToken.getToken();

        String url = "https://jnswdazms1.execute-api.us-east-1.amazonaws.com/dev/cognito-admin-set-user-password";

        String bodyOfReset = "reset.json";

        Response response = Base.POSTRequest(url, bodyOfReset, bearerToken);
        return response;

    }


    }

