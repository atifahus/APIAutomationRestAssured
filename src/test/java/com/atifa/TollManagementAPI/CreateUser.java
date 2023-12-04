package com.atifa.TollManagementAPI;

import base.AccessToken;
import base.Base;
import base.PayloadProcessor;
import com.google.gson.Gson;
import io.restassured.response.Response;
import utility.GetCurrentDate;
import utility.URL;

import java.util.Map;
import java.util.Properties;

public class CreateUser {
    static String userId="Random"+ GetCurrentDate.getCurrentTimeStamp();
    static String emailAdd="Random"+GetCurrentDate.getCurrentTimeStamp()+"@gmail.com";

    public Response createNewUser(){

        String token=AccessToken.getToken();
        String bearerToken="Bearer "+token;

        String url= URL.getEndPoint("/cognito-create-user");

        Properties properties=new Properties();

        Map<String,Object> payloadInMap= PayloadProcessor.getProcessedPayloadInJson("createUser.json",properties);


        payloadInMap.put("username",userId);
        payloadInMap.put("email",emailAdd);

        String payloadInString=PayloadProcessor.payloadFromMapToString(payloadInMap);



       Response response= Base.POSTRequest(url,payloadInString,bearerToken);

        return response;
    }

    public Response createUserWithExistBody(){
        String token=AccessToken.getToken();
        String bearerToken="Bearer "+token;

        String url= URL.getEndPoint("/cognito-create-user");
        Properties properties=new Properties();

        Map<String,Object> payloadInMap= PayloadProcessor.getProcessedPayloadInJson("createUser.json",properties);

        payloadInMap.put("username",userId);
        payloadInMap.put("email",emailAdd);

        String payloadInString=PayloadProcessor.payloadFromMapToString(payloadInMap);

        Response response= Base.POSTRequest(url,payloadInString,bearerToken);

        return response;

    }
    public Response createUserWithEmptyBody(){
        String token=AccessToken.getToken();
        String bearerToken="Bearer "+token;

        String url= URL.getEndPoint("/cognito-create-user");
        Properties properties=new Properties();

        Map<String,Object> payloadInMap= PayloadProcessor.getProcessedPayloadInJson("createUser.json",properties);

        payloadInMap.put("username","");
        payloadInMap.put("email","");
        payloadInMap.put("password", "");

        String payloadInString=PayloadProcessor.payloadFromMapToString(payloadInMap);
        Response response= Base.POSTRequest(url,payloadInString,bearerToken);

        return response;

    }



}
