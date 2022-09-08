package com.posttechniques.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostUsingJsonObjectTest 
{
	@Test
public void createusingjsonobject()
{
	JSONObject obj=new JSONObject();
	obj.put("projectName", "hahaha");
	obj.put("teamSize", 4);
	obj.put("createdBy", "mememe");
	obj.put("createdOn", "12/05/11");
	obj.put("status", "created");
	
	RestAssured.given().contentType(ContentType.JSON)
	.body(obj)
	.when().post("http://localhost:8084/addProject")
	.then().assertThat().statusCode(201).contentType(ContentType.JSON)
	.log().all();
}
}
