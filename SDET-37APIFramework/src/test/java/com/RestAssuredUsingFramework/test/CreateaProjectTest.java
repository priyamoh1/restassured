package com.RestAssuredUsingFramework.test;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.EndPoints;
import GenericLibrary.IConstants;
import io.restassured.http.ContentType;
/**
 * 
 * @author -priyaranjan-
 *
 */
public class CreateaProjectTest 
{
	@Test
	public void createaproject()
	{
		//create json object for storing the data
		
		JSONObject js=new JSONObject();
		js.put("projectName", "pintulike");
		js.put("createdBy", "pintulike");
		js.put("createdOn", "10/04/21");
		js.put("status", "done");
		js.put("teamSize", 2);
		

		//precondition
		given().body(js).contentType(ContentType.JSON)

		//request
		.when().post(IConstants.basiuri+IConstants.portnum+EndPoints.createproject)

		//response validation
		.then().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
