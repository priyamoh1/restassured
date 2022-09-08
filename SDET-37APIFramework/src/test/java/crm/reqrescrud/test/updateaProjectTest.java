package crm.reqrescrud.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class updateaProjectTest 
{
	@Test
	public void updateaproject()
	{
		//crete a json object for storing data
		JSONObject obj=new JSONObject();
		obj.put("name", "raj");
		obj.put("job", "sale");
		obj.put("updatedAt", "12/10/22");

		//pre condition
		RestAssured.given().body(obj)
		.contentType(ContentType.JSON)

		//request
		.when().put("https://reqres.in/api/users/2")

		//response validation
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)

		//print all the information
		.log().all();
	}
}
