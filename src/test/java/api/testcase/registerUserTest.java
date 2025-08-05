package api.testcase;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpint.Routes;
import api.endpint.registeruserendpoint;
import api.endpint.userendpoint;
import api.payload.resuserpayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class registerUserTest {

	resuserpayload payld;
	static String token;
	
	@BeforeClass
	public void genratedata() {
		payld = new resuserpayload();
		
		
		payld.setEmail("eve.holt@reqres.in");
		payld.setPassword("pistol");
	}
	
	
	@Test(priority=1)
	public void register_user_test_case() {
Response response = registeruserendpoint.testRegisterUser(payld);
         response.then().log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
		
	}
	

	
	
    @Test(priority=2)
	public void get_token_test_case() {
Response response = registeruserendpoint.testRegisterUser(payld);
         response.then().log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
    	String id = response.jsonPath().getString("id");
         token = response.jsonPath().getString("token");
        Assert.assertNotNull(id, "ID should not be null");
        Assert.assertNotNull(token, "Token should not be null");
	}
	
	
    @Test(priority=3)
	public void Print_Token() {
    	System.out.println(token);
    }
    
    @Test(priority=3)
   	public void Unsucessfully_res_test_case() {
   Response response = registeruserendpoint.UnsessRegisterUser("sydney@fife");
            response.then().log().all().extract().response();
           Assert.assertEquals(response.getStatusCode(), 400);
       	String id = response.jsonPath().getString("id");
            token = response.jsonPath().getString("token");
           Assert.assertNull(id, "ID should not be null");
           Assert.assertNull(token, "Token should not be null");
   	}
    
    
    }
    

