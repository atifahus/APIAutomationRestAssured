package com.atifa.TollManagementAPI;

import base.AccessToken;
import base.Base;
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


}
