package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest
{
	@Test
	public void updateaproject()
	{
		//json object
		JSONObject objj=new JSONObject();
		objj.putIfAbsent("createdBy", "mealso");
		objj.putIfAbsent("projectName", "meee");

		RequestSpecification res = RestAssured.given();
		res.body(objj);
		res.contentType(ContentType.JSON);

		Response response = res.put("http://localhost:8084/projects/TY_PROJ_887");

		ValidatableResponse val = response.then();
		val.assertThat().statusCode(200).and().contentType(ContentType.JSON);




	}
}
