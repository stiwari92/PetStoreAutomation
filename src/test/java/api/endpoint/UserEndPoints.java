package api.endpoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import api.payload.User;

//Created to perform CRUD Operation (Create, Read, Update, Delete)
public class UserEndPoints {
	
	public static Response createuser(User payload) {
		
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url);
		
		return response;
	}
public static Response getuser(String userName) {
		
		Response response =given()
		.pathParam("username", userName)
		
		.when()
		.get(Routes.get_url);
		
		return response;
}
public static Response updateeuser(String userName, User payload) {
	
	Response response =given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.pathParam("username", userName)
	.body(payload)
	
	.when()
	.put(Routes.put_url);
	
	return response;
}
public static Response deleteuser(String Username) {
	
	Response response =given()
	.pathParam("username", Username)
	
	.when()
	.delete(Routes.delete_url);
	
	return response;
}
}
