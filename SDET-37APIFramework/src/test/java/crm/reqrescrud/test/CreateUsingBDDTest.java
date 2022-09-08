package crm.reqrescrud.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUsingBDDTest 
{
	@Test
	public void createaproject()
	{
		//create a json object for storing data
		JSONObject obj=new JSONObject();
		obj.put("name", "heloo");
		obj.put("job", "manager");
		obj.put("id", "123");
		obj.put("createdAt", "12/10/21");

		//pre condition
		RestAssured.given()
		.body(obj).contentType(ContentType.JSON)

		//request
		.when().post("https://reqres.in/api/users")

		//response validation
		.then().assertThat().statusCode(201).contentType(ContentType.JSON)

		//print all the information
		.log().all();
	}
}
