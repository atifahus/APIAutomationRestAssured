package com.atifa.TollManagementAPI;

import base.AccessToken;
import base.Base;
import base.PayloadProcessor;
import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utility.URL;

import java.util.Map;
import java.util.Objects;
import java.util.Properties;

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

    public static Response resetPasswordInvalidCredentials(){
        String bearerToken="Bearer "+AccessToken.getToken();

        String url=URL.getEndPoint("/cognito-admin-set-user-password");

        Properties properties=new Properties();
        Map<String , Object> payloadInMap= PayloadProcessor.getProcessedPayloadInJson("reset.json",properties);
        payloadInMap.put("username","Staff");
        payloadInMap.put("password","1212");
        String payloadInString=PayloadProcessor.payloadFromMapToString(payloadInMap);

        Response response=Base.POSTRequest(url,payloadInString,bearerToken);

        return response;


    }
    }

