package api.endpint;

import api.payload.Loginpayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginEndPoint {

	public static Response Login(Loginpayload plod ) {
		Response response = given()
		.header("x-api-key", "reqres-free-v1")
		.contentType(ContentType.JSON)
		.body(plod)
		
		.when()
		.post(Routes.Login_url);
		
				return response;
	} 
	
	
	
	public static Response Loginfailed(String plod ) {
		Response response = given()
		.header("x-api-key", "reqres-free-v1")
		.contentType(ContentType.JSON)
		.body(plod)
		
		.when()
		.post(Routes.Login_url);
		
				return response;
	} 
}
