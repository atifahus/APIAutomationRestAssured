package com.atifa.TollManagementAPI;

import base.AccessToken;
import base.Base;
import base.PayloadProcessor;
import io.restassured.response.Response;
import utility.URL;

public class UserList {
    public static Response getUserList(){
        String bearerToken="Bearer "+AccessToken.getToken();

        String url= URL.getEndPoint("/cognito-user-list");

        Response response= Base.GETRequest(url,bearerToken);

        return response;

    }
    public static Response getUserListNegTestWithoutAuth(){

        String url= URL.getEndPoint("/cognito-user-list");

        Response response= Base.GETRequest(url);

        return response;

    }
    public static Response getUserListWithInvalidURL(){

        String bearerToken="Bearer "+AccessToken.getToken();

        String url= URL.URL;

        Response response= Base.GETRequest(url,bearerToken);

        return response;
    }


}
