package com.RestAssuredUsingFramework.test;

import org.testng.annotations.Test;

import GenericLibrary.EndPoints;
import GenericLibrary.IConstants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteAProjectTest 
{
	@Test
public void deleteaproject()
{
	String pid="TY_PROJ_882";
	RestAssured.given().contentType(ContentType.JSON)
	.pathParam("id", pid)
	.when().delete(IConstants.basiuri+IConstants.portnum+EndPoints.deleteproject+"/{id}")
	.then().assertThat().statusCode(204)
	.log().all();
}
}
