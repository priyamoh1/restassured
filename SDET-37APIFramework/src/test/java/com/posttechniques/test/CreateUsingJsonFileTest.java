package com.posttechniques.test;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUsingJsonFileTest 
{
	@Test
public void createusingjsonfile()
{
	File file = new File("C:\\Users\\-hp-\\Desktop\\ECLIPSE RESTASSURED\\SDET-37APIFramework\\src\\test\\resources\\data.json");
	
	RestAssured.given()
	.body(file).contentType(ContentType.JSON)
	.when().post("http://localhost:8084/addProject")
	.then().statusCode(201).contentType(ContentType.JSON)
	.log().all();
}
}
