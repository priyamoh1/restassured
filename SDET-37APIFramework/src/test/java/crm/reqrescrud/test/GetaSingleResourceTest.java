package crm.reqrescrud.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetaSingleResourceTest 
{
	@Test
	public void getasingleresource()
	{
		//pre-condition
		RestAssured.given().contentType(ContentType.JSON)

		//request
		.when().get("https://reqres.in/api/unknown/2")

		//response validation
		.then().assertThat().statusCode(200)
		.contentType(ContentType.JSON)

		//print all the information
		.log().all();
	}
}
