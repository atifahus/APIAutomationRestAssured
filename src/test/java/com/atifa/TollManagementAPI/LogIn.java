package com.atifa.TollManagementAPI;

import base.AccessToken;
import base.Base;
import io.restassured.response.Response;
import utility.URL;

public class LogIn {
    public static Response login(){
        String bearerToken="Bearer "+ AccessToken.getToken();
        String url= URL.getEndPoint("/cognito-login");
        String jsonBody= Base.generatePayLoadString("logIn.json");

        Response response=Base.POSTRequest(url,jsonBody,bearerToken);
        return response;

    }
    public static Response negLogin(){
        String bearerToken="Bearer "+ AccessToken.getToken();
        String url= URL.getEndPoint("/cognito-login");
        String jsonBodyNeg= Base.generatePayLoadString("negLogin.json");

        Response response=Base.POSTRequest(url,jsonBodyNeg,bearerToken);
        return response;

    }


}
