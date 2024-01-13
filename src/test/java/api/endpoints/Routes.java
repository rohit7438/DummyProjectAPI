package api.endpoints;

//create user(POST)  : https://petstore.swagger.io/v2/user
//get user(GET)      : https//petstore.swagger.io/v2/user/{username}
//update user (PUT)  : https://petstore.swagger.io/v2/user/{username}
//delete user(DELETE): https://petstore.swagger.io/v2/user/{username}

public class Routes {

//	base url
	public static String base_url = "https://petstore.swagger.io/v2";
	
//	user module
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String put_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";

}
