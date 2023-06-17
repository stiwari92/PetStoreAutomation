package api.endpoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;

//Created to perform CRUD Operation (Create, Read, Update, Delete)
public class UserEndPoint2 {
	
	static ResourceBundle getURL() {
		ResourceBundle route = ResourceBundle.getBundle("routes");
		return route;
	}
	
	public static Response createuser(User payload) {
		
		String post_url=getURL().getString("post_url");
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(post_url);
		
		return response;
	}
public static Response getuser(String userName) {
	String get_url=getURL().getString("get_url");
		Response response =given()
		.pathParam("username", userName)
		
		.when()
		.get(get_url);
		
		return response;
}
public static Response updateeuser(String userName, User payload) {
	String put_url=getURL().getString("put_url");
	Response response =given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.pathParam("username", userName)
	.body(payload)
	
	.when()
	.put(put_url);
	
	return response;
}
public static Response deleteuser(String Username) {
	String delete_url=getURL().getString("delete_url");
	Response response =given()
	.pathParam("username", Username)
	
	.when()
	.delete(delete_url);
	
	return response;
}
}
