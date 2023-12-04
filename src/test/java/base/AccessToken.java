package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static io.restassured.RestAssured.given;

public class AccessToken {


    public static String getToken() {
        // Set the base URL
        RestAssured.baseURI = PayloadProcessor.getValueFromPropertiesFile().getProperty("tokenURI");

        // Create the request body with the parameters
        String requestBody = "scope=feature-toll-plaza%2Fread&grant_type=client_credentials";

        String clientId = PayloadProcessor.getValueFromPropertiesFile().getProperty("clientID");
        String clientSecret = PayloadProcessor.getValueFromPropertiesFile().getProperty("clientSecret");

        // Concatenate client_id and client_secret with a colon
        String credentials = clientId + ":" + clientSecret;

        // Encode the credentials in Base64
        String base64Credentials = Base64.getEncoder().encodeToString(credentials.getBytes());


        // Perform the POST request
        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", "Basic " + base64Credentials)
                .body(requestBody)
                .post("/oauth2/token");

        // Print the response
        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Extract the access_token from the response
        String accessToken = response.jsonPath().getString("access_token");

        // Print the access_token
        System.out.println("access_token: " + accessToken);
        return  accessToken;
    }
    public static void main(String[] args) {

        AccessToken.getToken();




    }

}
