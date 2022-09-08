package com.restassuredvalidation.test;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StaticValidationReqresTest 
{
	@Test
public void staticvalidation()
{
	String actualdata="Tobias";
	
	 Response res = given().contentType(ContentType.JSON)
	.when().get("https://reqres.in/api/users?page=2");
	 
	 String resdata = res.jsonPath().get("[0].data[2].first_name");
	 Assert.assertEquals(actualdata, resdata);
	 System.out.println("validation is passed");
	 res.then().log().all();
	 
	 
	
}
}
