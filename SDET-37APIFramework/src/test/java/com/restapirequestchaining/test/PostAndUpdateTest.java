package com.restapirequestchaining.test;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.pojo.test.PojoClassTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAndUpdateTest 
{
	@Test
	public void postandupdate()
	{
		//creating variable of pojo class
		PojoClassTest pojo = new PojoClassTest("gameon5", "jiraw5", "10/1/12", "creted", 10);

		Response res = given().body(pojo).contentType(ContentType.JSON)
				.when().post("http://localhost:8084/addProject");

		//getting the data from response
		String var = res.jsonPath().get("projectId");

		res.then().assertThat().statusCode(201).log().all();
		
		//creating data for updating
		JSONObject obj=new JSONObject();
		obj.put("projectName", "hellooww");
		obj.put("createdBy", "tiger");

		//setting the path parameter
		given().pathParam("ref", var)
		.contentType(ContentType.JSON)
		.body(obj)

		//using the path parameter in get operation
		.when().put("http://localhost:8084/projects/{ref}")
		.then().assertThat().statusCode(200).log().all();
	}
}
