  package api.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpint.LoginEndPoint;
import api.payload.Loginpayload;
import io.restassured.response.Response;

public class LoginTestcase {

	Loginpayload plod ;
	
	@BeforeClass
	public void getdata() {
		plod = new Loginpayload();
		
		plod.setEmail("eve.holt@reqres.in");
		plod.setPassword("cityslicka");
	}
	
	@Test(priority=1)
	public void login_testcase() {
	Response response =	LoginEndPoint.Login(plod);
	response.then().log().all().extract().response();
	Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	
	@Test (priority=2)
	public void get_login_testcase() {
	Response response =	LoginEndPoint.Login(plod);
	response.then().log().all().extract().response();
	Assert.assertEquals(response.getStatusCode(), 200);
    String token = response.jsonPath().getString("token");
   Assert.assertNotNull(token, "Token should not be null");
	}
	
	

	@Test (priority=3)
	public void login_failed_testcase() {
	Response response =	LoginEndPoint.Loginfailed("fscgfgchscvh");
	response.then().log().all().extract().response();
	Assert.assertEquals(response.getStatusCode(), 400);
   Assert.assertNull(null);
   Assert.assertNull(null);
	}
	
	
}
