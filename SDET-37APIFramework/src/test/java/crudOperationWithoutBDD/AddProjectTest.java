package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest {
	@Test
	public void create()
	{
		//json body
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "pintu");
		obj.put("projectName", "restassuredwBDD1");
		obj.put("status", "created");
		obj.put("teamSize", 10);

		//Request
		RequestSpecification res = RestAssured.given();
		res.body(obj);
		res.contentType(ContentType.JSON);

		//Action
		Response response = res.post("http://localhost:8084/addProject");
		ValidatableResponse validate = response.then();
		//validate.assertThat().contentType(ContentType.JSON);
		//validate.assertThat().statusCode(201);
		//validate.log().all();

		//OR
		validate.assertThat().contentType(ContentType.JSON).and().statusCode(201).and().log().all();







	}

}
