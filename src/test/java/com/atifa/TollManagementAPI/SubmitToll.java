package com.atifa.TollManagementAPI;

import base.AccessToken;
import base.Base;
import io.restassured.response.Response;
import utility.URL;

public class SubmitToll {

    public static Response getSubmitToll(){
        String token= AccessToken.getToken();
        String bearerToken="Bearer "+token;

        String url= URL.getEndPoint("/tollcollection");

        String jsonBody=Base.generatePayLoadString("submitToll.json");

        Response response= Base.POSTRequest(url,jsonBody,bearerToken);

        return response;

    }
    public static Response getInvalidSubmitToll(){
        String token= AccessToken.getToken();
        String bearerToken="Bearer "+token;

        String url= URL.getEndPoint("/tollcollection");

        String jsonBody=Base.generatePayLoadString("negSubmitToll.json");

        Response response= Base.POSTRequest(url,jsonBody,bearerToken);

        return response;

    }

}
