package com.atifa.TollManagementAPI;

import base.AccessToken;
import base.Base;
import io.restassured.response.Response;
import utility.URL;

public class TollCollectionList {

    public static Response getTollCollectList(){
        String token=AccessToken.getToken();
        String bearerToken="Bearer "+token;

        String url= URL.getEndPoint("/toll-collection-list");

        Response response=Base.GETRequest(url,bearerToken);

        return response;

    }
    public static Response getTollCollectionListWithoutEndpoint(){
        String token=AccessToken.getToken();
        String bearerToken="Bearer "+token;

        String url=URL.URL;
        Response response=Base.GETRequest(url,bearerToken);

        return response;

    }


}
