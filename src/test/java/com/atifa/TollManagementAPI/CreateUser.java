package com.atifa.TollManagementAPI;

import base.AccessToken;
import base.Base;
import io.restassured.response.Response;
import utility.URL;

public class CreateUser {

    public Response createNewUser(){

        String token=AccessToken.getToken();
        String bearerToken="Bearer "+token;

        String url= URL.getEndPoint("/cognito-create-user");
        String jsonBody=Base.generatePayLoadString("createUser.json");


       Response response= Base.POSTRequest(url,jsonBody,bearerToken);

        return response;
    }

    public Response createUserWithExistBody(){
        String token=AccessToken.getToken();
        String bearerToken="Bearer "+token;

        String url= URL.getEndPoint("/cognito-create-user");
        String jsonBody=Base.generatePayLoadString("createUser.json");

        Response response= Base.POSTRequest(url,jsonBody,bearerToken);

        return response;

    }


}
