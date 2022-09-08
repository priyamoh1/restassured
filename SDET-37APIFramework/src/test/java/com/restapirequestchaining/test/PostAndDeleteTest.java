package com.restapirequestchaining.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.pojo.test.PojoClassTest;
import com.pojo.test.RandomNum;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAndDeleteTest
{
	@Test
	public void postanddelete()
	{
		RandomNum ran = new RandomNum();
		int rann = ran.randomnum();
		
		//creating variable of pojo class
		PojoClassTest pojo = new PojoClassTest("gameon5", "jiraw5"+rann, "10/1/12", "creted", 10);

		Response res = given().body(pojo).contentType(ContentType.JSON)
				.when().post("http://localhost:8084/addProject");

		//getting the data from response
		String var = res.jsonPath().get("projectId");

		res.then().assertThat().statusCode(201).log().all();

		//setting the path parameter
		given().pathParam("ref", var)
		.contentType(ContentType.JSON)


		.when().delete("http://localhost:8084/projects/{ref}")
		.then().assertThat().statusCode(204).log().all();

	}
}
