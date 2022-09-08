package com.RestAssuredUsingFramework.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import GenericLibrary.EndPoints;
import GenericLibrary.IConstants;
import io.restassured.http.ContentType;

public class GetaSingleProjectTest 
{
	@Test
public void getasingleproject()
{
	given().contentType(ContentType.JSON)
	.pathParam("id", "TY_PROJECT048")
	.when().get(IConstants.basiuri+IConstants.portnum+EndPoints.getsingleproject+"/{id}")
	.then().statusCode(200).contentType(ContentType.JSON)
	.log().all();
}
}
