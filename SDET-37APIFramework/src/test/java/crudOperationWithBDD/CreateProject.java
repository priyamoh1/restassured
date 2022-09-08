package crudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProject 
{
	
	@Test
public void createaproject()
{
	JSONObject js=new JSONObject();
	js.put("created_by", "me");
	js.put("created_on", "10/10/21");
	js.put("project_name", "hello");
	js.put("status", "ongoing");
	js.put("team_size", 10);
	 given().contentType(ContentType.JSON)
	.body(js)
	.when().post("http://localhost:8084/addProject")
	.then().statusCode(201).and().contentType(ContentType.JSON).log().all();
}
}
