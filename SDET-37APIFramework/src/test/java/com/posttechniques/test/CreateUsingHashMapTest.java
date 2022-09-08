package com.posttechniques.test;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUsingHashMapTest 
{
	@Test
public void createusinghashmap()
{
	HashMap has = new HashMap<>();
	has.put("projectName", "hahahalalaal");
	has.put("teamSize", 4);
	has.put("createdBy", "mememe");
	has.put("createdOn", "12/05/11");
	has.put("status", "created");
	
	RestAssured.given().body(has).contentType(ContentType.JSON)
	.when().post("http://localhost:8084/addProject")
	.then().assertThat().statusCode(201)
	.contentType(ContentType.JSON)
	.log().all();
}
}
