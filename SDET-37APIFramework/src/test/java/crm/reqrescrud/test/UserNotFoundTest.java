package crm.reqrescrud.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UserNotFoundTest 
{
	
	@Test

	public void usernotfound()
	{
		
	
		//pre condition
		RestAssured.given().contentType(ContentType.JSON)

		//request
		.when().get("https://reqres.in/api/users/23")

		//response validation
		.then().assertThat().statusCode(404)
		.contentType(ContentType.JSON)

		//print all the information
		.log().all();
	}
}
