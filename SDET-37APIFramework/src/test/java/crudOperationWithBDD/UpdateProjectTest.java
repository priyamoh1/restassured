package crudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class UpdateProjectTest
{
	@Test
	public void updateproject()
	{
		JSONObject js=new JSONObject();
		js.put("created_by", "me");
		js.put("created_on", "10/10/21");
		js.put("project_name", "hello");

		given().contentType(ContentType.JSON)
		.body(js)
		.when().put("http://localhost:8084/projects/TY_PROJ_883")
		.then().statusCode(200).contentType(ContentType.JSON)
		.log().all();
	}
}
