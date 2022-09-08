package com.restassuredvalidation.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StaticValidationRmgyantraTest 
{
	@Test
	public void staticvalidationrmgyantra()
	{
		//storing the actual data
		String actualdata="TY_PROJECT002";
		
		//pre condition
		 Response res = given().contentType(ContentType.JSON)
		.when().get("http://localhost:8084/projects");
		 
		 //storing the response
		 String resdata = res.jsonPath().get("[0].projectId");
		 
		 
		 //static validation
		 Assert.assertEquals(actualdata, resdata);
		 System.out.println("validation is passed");
		 
		 //printb all the information
		 res.then().log().all();
		 
		 
		
	}
}
