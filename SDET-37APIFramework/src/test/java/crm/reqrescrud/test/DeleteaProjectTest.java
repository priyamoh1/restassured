package crm.reqrescrud.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteaProjectTest 
{
	@Test
	public void deleteaproject()
	{
		//pre condition
		RestAssured.given().contentType(ContentType.JSON)

		//request
		.when().delete("https://reqres.in/api/users/2")

		//response validation
		.then().assertThat().statusCode(204)
		//print all the information
		.log().all();
	}
}
