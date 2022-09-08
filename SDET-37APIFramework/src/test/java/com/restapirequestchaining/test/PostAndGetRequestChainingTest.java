package com.restapirequestchaining.test;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.pojo.test.PojoClassTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAndGetRequestChainingTest 
{
	@Test
	public void requestchaining()
	{
		//creating variable of pojo class
		PojoClassTest pojo = new PojoClassTest("gameon", "jira", "10/1/12", "creted", 10);

		Response res = given().body(pojo).contentType(ContentType.JSON)
				.when().post("http://localhost:8084/addProject");

		//getting the data from response
		String var = res.jsonPath().get("projectId");

		res.then().assertThat().statusCode(201).log().all();

		//setting the path parameter
		given().pathParam("ref", var)

		//using the path parameter in get operation
		.when().get("http://localhost:8084/projects/{ref}")
		.then().assertThat().statusCode(200).log().all();




	}
}
