package com.atifa.TollManagementAPI;

import base.AccessToken;
import base.Base;
import base.PayloadProcessor;
import io.restassured.response.Response;
import utility.URL;

import java.util.Map;
import java.util.Properties;

public class SubmitToll {

    public static Response getSubmitToll(){
        String token= AccessToken.getToken();
        String bearerToken="Bearer "+token;

        String url= URL.getEndPoint("/tollcollection");

        String jsonBody=Base.generatePayLoadString("submitToll.json");

        Response response= Base.POSTRequest(url,jsonBody,bearerToken);

        return response;

    }
    public static Response submitTollWithoutID(){
        String token= AccessToken.getToken();
        String bearerToken="Bearer "+token;

        String url= URL.getEndPoint("/tollcollection");

        Properties properties=new Properties();
        Map<String ,Object> payloadInMap= PayloadProcessor.getProcessedPayloadInJson("submitToll.json",properties);
        payloadInMap.put("id","");
        String payloadInString=PayloadProcessor.payloadFromMapToString(payloadInMap);

        Response response= Base.POSTRequest(url,payloadInString,bearerToken);

        return response;

    }

}
