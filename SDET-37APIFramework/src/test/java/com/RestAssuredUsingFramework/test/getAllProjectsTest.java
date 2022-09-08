package com.RestAssuredUsingFramework.test;

import org.testng.annotations.Test;

import GenericLibrary.EndPoints;
import GenericLibrary.IConstants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class getAllProjectsTest 
{
	@Test
	public void getallprojects()
	{
		RestAssured.given().contentType(ContentType.JSON)
		.get(IConstants.basiuri+IConstants.portnum+EndPoints.getAllprojects)
		.then().assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
