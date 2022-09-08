package com.restapirequestchaining.test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAndUpdateTest 
{
	@Test
public void getanddelete()
{
		
		//storing
	Response res = given().contentType(ContentType.JSON)
	.when().get("http://localhost:8084/projects");
	String var = res.jsonPath().get("[0].projectId");
	res.then().assertThat().statusCode(200).log().all();
	
	
	
	JSONObject obj = new JSONObject();
	obj.put("projectName", "hellooww");
	obj.put("createdBy", "tiger");
	
	
	given().pathParam("id", var).contentType(ContentType.JSON)
	.body(obj)
	.when().put("http://localhost:8084/projects/{id}")
	.then().assertThat().statusCode(200).assertThat()
	.time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS).contentType(ContentType.JSON)
	.log().all();
	
}
}
