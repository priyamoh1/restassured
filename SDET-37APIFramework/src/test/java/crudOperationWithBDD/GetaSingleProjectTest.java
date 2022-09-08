package crudOperationWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetaSingleProjectTest 
{
	@Test
	public void getasingleproject()
	{
		given().contentType(ContentType.JSON)
		.when().get("http://localhost:8084/projects/TY_PROJ_1002")
		.then().statusCode(200).contentType(ContentType.JSON)
		.log().all();
	}
}
