package api.testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpint.userendpoint;

//import api.endpoints.userEndPoints;
import api.payload.userpayload;
import io.restassured.response.Response;

public class userTestCase {

	Faker fakerdata;
	userpayload uplod;
	

	@BeforeClass
	public void genrateTestdata() {
		fakerdata = new Faker();
		uplod = new userpayload();
		uplod.setId(fakerdata.idNumber().hashCode());
		uplod.setUsername(fakerdata.name().username());
		uplod.setFirstName(fakerdata.name().firstName());
		uplod.setLastName(fakerdata.name().lastName());
		uplod.setEmail(fakerdata.internet().safeEmailAddress());
		uplod.setPassword(fakerdata.internet().password(5, 10));
		uplod.setPhone(fakerdata.phoneNumber().cellPhone());
		uplod.setUserStatus(1);
	}
	

	
	@Test(priority=1)
	public void createusertestcase() {
		Response response = userendpoint.createUser(uplod);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	
	@Test(priority=2)
	public void testGetUserData()
	{
		Response response = userendpoint.GetUser(this.uplod.getUsername());

		System.out.println("Read User Data.");
		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);

		
		
	}
	
	
	@Test(priority = 3)
	public void updateusertestcase() {
		uplod.setUsername(fakerdata.name().username());
		Response response = userendpoint.updateUser(this.uplod.getUsername(), uplod);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 4)
	public void deleteusertestcase() {
		
		Response response  = userendpoint.delUser(this.uplod.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	}

	
	