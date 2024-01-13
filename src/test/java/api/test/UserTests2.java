package api.test;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;

import io.restassured.response.Response;

public class UserTests2 {

	Faker faker;
	User userPayload;
	
	public Logger logger;

	@BeforeClass
	public void dataSetUP() {
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		//logs initiator
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	
	@Test(priority = 0)
	public void testPostUser() {
		logger.info("*********CREATING USER**********");
		Response res = UserEndPoints2.createUser(userPayload);
//		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("*********USER CREATED**********");
	}
	
	@Test(priority = 1,dependsOnMethods = "testPostUser")
	public void getUser() {
		Response res = UserEndPoints2.readUser(this.userPayload.getUsername());
//		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 2,dependsOnMethods = "getUser")
	public void updateUser() {
//		regenerate mail id to update
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response res = UserEndPoints2.updateUser(this.userPayload.getUsername(), userPayload);
		res.then().log().all();
		res.getBody();		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3,dependsOnMethods = "updateUser")
	public void deleteUser() {
		Response res = UserEndPoints2.deleteUser(this.userPayload.getUsername());
//		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}
