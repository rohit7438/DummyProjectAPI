package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviderClass;
import io.restassured.response.Response;

public class DDTests {

	@BeforeClass
	public void dataSetUP() {


	}

	@Test(priority = 0, dataProvider = "getAllData", dataProviderClass = DataProviderClass.class, enabled = true)
	public void testPostUser(String userID, String UserName, String Fname, String Lname, String Useremail, String pwd,
			String ph) {
		User userPayload = new User();

		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(Fname);
		userPayload.setLastName(Lname);
		userPayload.setEmail(Useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);

		Response res = UserEndPoints.createUser(userPayload);
//		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}

	
	@Test(priority = 1, dataProvider = "UserNames", dataProviderClass = DataProviderClass.class, enabled = true)
	public void getUser(String username) {
		Response res = UserEndPoints.readUser(username);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}	
	
	
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviderClass.class, enabled = true)
	public void deleteUserByName(String username) {
		Response res = UserEndPoints.deleteUser(username);
//		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	
}
