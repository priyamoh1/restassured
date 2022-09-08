package com.restassuredvalidation.test;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.hamcrest.core.StringContains;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TimeValidationTest 
{
	@Test
	public void timevalidation()
	{
		//pre condition
		RestAssured.given().contentType(ContentType.JSON)

		//request
		.when().get("https://reqres.in/api/users?page=2")

		//response validation
		.then().assertThat().statusCode(200)
		//.contentType(ContentType.JSON)

		//time validation
		.assertThat().time(Matchers.lessThan(3550L), TimeUnit.MILLISECONDS)
		//.assertThat().contentType(Matchers.equalTo(ContentType.JSON))
		
		

		//print all the information
		.log().all();	
	}

}
