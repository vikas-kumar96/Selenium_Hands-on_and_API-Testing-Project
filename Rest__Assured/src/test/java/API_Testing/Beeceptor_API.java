package API_Testing;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Beeceptor_API {
	
		@Test
		public void Register_a_user_and_create_his_wallet() {
			JSONObject json = new JSONObject();
			json.put("username", "user123");
			json.put("password", "securepassword");
			json.put("email", "user@example.com");
			
			given().contentType(ContentType.JSON).body(json.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/register").then().statusCode(200).log().all();
		}
		
		@Test
		public void Login_the_user_and_generate_a_session_token() {
			JSONObject json = new JSONObject();
			json.put("username", "user123");
			json.put("password", "securepassword");
			
			given().contentType(ContentType.JSON).body(json.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/login").then().statusCode(200).log().all();
		}
		
		@Test
		public void Retrieve_the_wallet_balance() {
			given().get("https://crypto-wallet-server.mock.beeceptor.com/api/v1/balance").then().statusCode(200).log().all();
		}
		
		@Test
		public void List_all_the_transactions_done_by_the_user() {
			given().get("https://crypto-wallet-server.mock.beeceptor.com/api/v1/transactions").then().statusCode(200).log().all();
		}
		
		
		@Test
		public void Transfer_5_ETH_to_a_recipient() {
			JSONObject json = new JSONObject();
			json.put("recipient_address", "0x1234567890ABCDEF");
			json.put( "amount", 5.0);
			json.put("currency", "ETH");
			
			given().contentType(ContentType.JSON).body(json.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/transactions").then().statusCode(200).log().all();
		}
		
		@Test
		public void Calculate_transaction_fees_and_return_estimated_cost() {
			JSONObject json = new JSONObject();
			json.put("amount", 2.5);
			json.put("currency", "BTC");
			json.put("recipient_address", "0x1234567890ABCDEF");
			
			given().contentType(ContentType.JSON).body(json.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/transaction_fee").then().statusCode(200).log().all();
		}
		
		@Test
		public void Get_an_object_with_all_available_currency_exchange_rates() {
			given().get("https://crypto-wallet-server.mock.beeceptor.com/api/v1/exchange_rates").then().statusCode(200).log().all();
		}
	}


