package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetAllProjectTest 
{
	@Test
	public void getallprojects()
	{
		RequestSpecification reqs = RestAssured.given();
		Response response = reqs.get("http://localhost:8084/projects");
		ValidatableResponse val = response.then();
		val.statusCode(200).and().contentType(ContentType.JSON).log().all();
		//String str=val.extract().asString();
		//JsonPath js=new JsonPath(str);
		//Object ff = js.get("projectName[0]");
		//System.out.println(ff);
		



	}
}
