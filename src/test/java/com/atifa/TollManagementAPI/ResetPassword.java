package com.atifa.TollManagementAPI;

import base.AccessToken;
import base.Base;
import groovy.json.JsonException;
import io.restassured.response.Response;
import utility.URL;

public class ResetPassword {
    public static Response resetPassword(){

        String bearerToken= "Bearer "+ AccessToken.getToken();

        String url= URL.getEndPoint("/cognito-admin-set-user-password");
        String jsonBody=Base.generatePayLoadString("reset.json");

         Response   response= Base.POSTRequest(url,jsonBody,bearerToken);

        return response;
    }


    public static Response resetPasswordNoAuth(){

        String url= URL.getEndPoint("/cognito-admin-set-user-password");
        String jsonBody=Base.generatePayLoadString("reset.json");

        Response   response= Base.POSTRequest(url,jsonBody);

        return response;
    }
    }

