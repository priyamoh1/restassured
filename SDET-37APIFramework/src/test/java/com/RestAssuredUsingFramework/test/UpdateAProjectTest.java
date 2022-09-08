package com.RestAssuredUsingFramework.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.EndPoints;
import GenericLibrary.IConstants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateAProjectTest 
{
	@Test
public void updatteaproject()
{
	String pid="TY_PROJ_881";
	
	JSONObject js=new JSONObject();
	js.put("projectName", "killbill");
	js.put("createdBy", "katana");
	
	RestAssured.given().contentType(ContentType.JSON)
	.body(js)
	.pathParam("id", pid)
	.when().put(IConstants.basiuri+IConstants.portnum+EndPoints.updateproject+"/{id}")
	.then().assertThat().statusCode(200).contentType(ContentType.JSON)
	.log().all();
}
}
