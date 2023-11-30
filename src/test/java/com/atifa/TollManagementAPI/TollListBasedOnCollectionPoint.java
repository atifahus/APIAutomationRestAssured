package com.atifa.TollManagementAPI;

import base.AccessToken;
import base.Base;
import base.BaseAssertion;
import io.restassured.response.Response;
import utility.URL;

public class TollListBasedOnCollectionPoint {
    public static Response tollList(){
        String bearerToken="Bearer "+AccessToken.getToken();

        String url= URL.getEndPoint("/toll-collection-list");

        String queryKey="collectionPointId";
        String queryValue="NY088734";

        Response response= Base.GETRequest(url,bearerToken,queryKey,queryValue);

        return response;


    }
    public static Response tollListWithInvalidCollectionPoint(){
        String bearerToken="Bearer "+AccessToken.getToken();

        String url= URL.getEndPoint("/toll-collection-list");

        String queryKey="collectionPointId";
        String queryValue="][[[[";

        Response response= Base.GETRequest(url,bearerToken,queryKey,queryValue);

        return response;


    }




}
