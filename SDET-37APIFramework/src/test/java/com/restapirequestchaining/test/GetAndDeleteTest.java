package com.restapirequestchaining.test;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAndDeleteTest 
{
	@Test
	public void getanddelete()
	{

		//getting all the projects from the response body
		Response res = given().contentType(ContentType.JSON)
				.when().get("http://localhost:8084/projects");
		String var = res.jsonPath().get("[12].projectId");
		res.then().assertThat().statusCode(200).log().all();


		//setting the path parameter
		given().pathParam("id", var).contentType(ContentType.JSON)

		//performing delete operation
		.when().delete("http://localhost:8084/projects/{id}")

		//response validation
		.then().assertThat().statusCode(204).assertThat()
		.time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS).contentType(ContentType.JSON)
		.log().all();
	}
}
