package api.endpint;
import static io.restassured.RestAssured.given;


import api.payload.userpayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class userendpoint {

	
	
	public static  Response createUser(userpayload payload) {	
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)	
		.when()
		.post(Routes.post_url);
		return response;
	}
	


public static Response GetUser(String userName)
{
	Response response = given()
	.accept(ContentType.JSON)
	.pathParam("username", userName)
	
	.when()
	.get(Routes.get_url);
	
	return response;
}





public static  Response updateUser(String  username, userpayload payload) {
	
	Response response = given()
	.accept(ContentType.JSON)
	.contentType(ContentType.JSON)
	.pathParam("username", username)
	.body(payload)			
	.when()
	.put(Routes.put_url);
	return response;
}



public static  Response delUser(String  username) {
	
	Response response = given()
	.accept(ContentType.JSON)
	.pathParam("username", username)			
	.when()
	.delete(Routes.del_url);
	return response;
}

}
