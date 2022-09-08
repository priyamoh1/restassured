package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetaSingleProjectTest 
{
	@Test
	public void getasingleproject()
	{
		RequestSpecification req = RestAssured.given();
		Response response = req.get("http://localhost:8084/projects/TY_PROJ_1002");
		ValidatableResponse val = response.then();
		val.assertThat().statusCode(200).and().contentType(ContentType.JSON).log().all();
	}
}
