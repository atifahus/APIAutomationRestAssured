package com.atifa.TollManagementAPI;


import base.AccessToken;
import base.Base;
import io.restassured.response.Response;
import utility.URL;

import java.util.SplittableRandom;

public class LogIn {

    public static Response logIn(){
        String bearerToken="Bearer "+AccessToken.getToken();

        String url= URL.getEndPoint("/cognito-login");

        String bodyOfLogIn="logIn.json";

        Response response= Base.POSTRequest(url,bodyOfLogIn,bearerToken);

        return response;

    }
}
