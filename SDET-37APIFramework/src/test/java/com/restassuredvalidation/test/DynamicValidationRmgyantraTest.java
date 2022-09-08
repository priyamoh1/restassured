package com.restassuredvalidation.test;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DynamicValidationRmgyantraTest 
{
	@Test
	public void dynamicvalidation()
	{
		//storing the actual data
		String actualdata="TY_PROJECT002";
		
		//pre condition
		 Response res = given().contentType(ContentType.JSON)
		.when().get("http://localhost:8084/projects");
		 
		 //validation
		boolean flag=false;
		
		List<String> allid = res.jsonPath().get("projectId");
		for(String data:allid)
		{
			if(data.equalsIgnoreCase(actualdata))
			{
				flag=true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("data is verified");
		
		
		//print all the information
		res.then().log().all();
		
	}
	
			 
}
