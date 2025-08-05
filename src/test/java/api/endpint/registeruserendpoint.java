package api.endpint;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.payload.resuserpayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class registeruserendpoint {

	
	/* this method was failed again again beacuse i was hiting wrong method * 
	 * 
	public static  Response ResUser(resuserpayload payload) {	
		Response response = given()
				.baseUri(Routes.res_url)
		.header("x-api-key", "reqres-free-v1")
		.contentType(ContentType.JSON)
		.body(payload)	
		
		.when()
		.put();
		
		return response;
	}*/
	
	


	   

	   
	    public static Response testRegisterUser(resuserpayload payld) {
	    	Response response = given()
	                .header("x-api-key", "reqres-free-v1")
	                .contentType(ContentType.JSON)
	                .body(payld)
	            .when()
	                .post(Routes.res_url);
	    	return response;
	    }
	    
	    
	    
	    public static Response UnsessRegisterUser(String string) {
	    	Response response = given()
	                .header("x-api-key", "reqres-free-v1")
	                .contentType(ContentType.JSON)
	                .body(string)
	            .when()
	                .post(Routes.res_url);
	    	return response;
	    }
	}

