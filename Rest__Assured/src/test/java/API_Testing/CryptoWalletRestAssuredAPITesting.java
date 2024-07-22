package API_Testing;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class CryptoWalletRestAssuredAPITesting {

    private String baseUrl = "https://crypto-wallet-server.mock.beeceptor.com";
    private String token;

    @Test
    public void registerUser() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = given();

        request.header("Content-Type", "application/json");
        request.body("{ \"username\": \"user123\", \"password\": \"securepassword\", \"password\": \"securepassword\" }");

        Response response = request.post("/api/v1/register");

        response.then().statusCode(200)
                .body("username", equalTo("user123"));
    }
    
    @Test

    public void loginUser() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = given();

        request.header("Content-Type", "application/json");
        request.body("{ \"username\": \"user123\", \"password\": \"securepassword\" }");

        Response response = request.post("/api/v1/login");

        response.then().statusCode(200).log().all();;

        token = response.jsonPath().getString("token");
    }

    @Test
    public void getWalletBalance() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = given();

        request.header("Authorization", "Bearer " + token);

        Response response = request.get("/api/v1/balance");

        response.then().statusCode(200).log().all();
    }

    @Test
    public void listTransactions() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = given();

        request.header("Authorization", "Bearer " + token);

        Response response = request.get("/api/v1/transactions");

        response.then().statusCode(200).log().all();
    }

    @Test
    public void transferEth() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = given();

        request.header("Authorization", "Bearer " + token);
        request.header("Content-Type", "application/json");
        request.body("{ \"amount\": 5.0, \"recipient_address\": \"0x1234567890ABCDEF\", \"currency\": \"ETH\" }");

        Response response = request.post("/api/v1/transactions");

        response.then().statusCode(200).log().all();
    }
    
    @Test
    public void calculatefees() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = given();

        request.header("Authorization", "Bearer " + token);
        request.header("Content-Type", "application/json");
        request.body("{ \"amount\": 2.5, \"recipient_address\": \"0x1234567890ABCDEF\", \"currency\": \"BTC\" }");

        Response response = request.post("/api/v1/transaction_fee");

        response.then().statusCode(200).log().all();
    }

    @Test
    public void getExchangeRates() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = given();

        Response response = request.get("/api/v1/exchange_rates");

        response.then().statusCode(200).log().all();
    }
}
