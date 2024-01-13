package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload) {

		Response response = given().contentType("application/json").accept("application/json").body(payload).when()
				.post(Routes.post_url);

		return response;
	}

	public static Response readUser(String UserName) {

		Response response = given().pathParam("username",UserName)

				.when().get(Routes.get_url);

		return response;
	}

	public static Response updateUser(String UserName, User payload) {

		Response response = given()
				.pathParam("username", UserName)
				.contentType("application/json")
				.accept("application/json")
				.body(payload)
			

				.when()
				.put(Routes.put_url);

		return response;
	}
	
	public static Response deleteUser(String UserName) {

		Response response = given()
				.pathParam("username", UserName)
				.contentType("application/json")
				.accept("application/json")
				

				.when()
				.delete(Routes.delete_url);

		return response;
	}

}
