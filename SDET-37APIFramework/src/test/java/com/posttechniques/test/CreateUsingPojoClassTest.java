package com.posttechniques.test;

import org.testng.annotations.Test;

import com.pojo.test.PojoClassTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUsingPojoClassTest
{
	@Test
public void createusingpojoclass()
{
	PojoClassTest pojo = new PojoClassTest("kakaka", "mememeememem", "12/05/20", "created", 5);
	
	RestAssured.given().body(pojo)
	.contentType(ContentType.JSON)
	.when().post("http://localhost:8084/addProject")
	.then().assertThat().statusCode(201)
	.contentType(ContentType.JSON)
	.log().all();
}
}
