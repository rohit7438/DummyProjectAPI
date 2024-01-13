package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.response.Response;

public class UserEndPoints2 {

	static ResourceBundle getUrl() {

		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}

	public static Response createUser(User payload) {
		

		Response response = given().contentType("application/json").accept("application/json").body(payload).when()
				.post(getUrl().getString("post_url"));

		return response;
	}


	public static Response readUser(String UserName) {
	
		getUrl().getString("post_url");
		Response response = given().pathParam("username", UserName)

				.when().get(getUrl().getString("get_url"));

		return response;
	}

	public static Response updateUser(String UserName, User payload) {

		Response response = given().pathParam("username", UserName).contentType("application/json")
				.accept("application/json").body(payload)

				.when().put(getUrl().getString("put_url"));

		return response;
	}

	public static Response deleteUser(String UserName) {

		Response response = given().pathParam("username", UserName).contentType("application/json")
				.accept("application/json")

				.when().delete(getUrl().getString("delete_url"));

		return response;
	}

}
