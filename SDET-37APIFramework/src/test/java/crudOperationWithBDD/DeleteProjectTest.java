package crudOperationWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteProjectTest 
{
	@Test
public void deleteproject()
{
	given().contentType(ContentType.JSON)
	.when().delete("http://localhost:8084/projects/TY_PROJ_883")
	.then().statusCode(204).contentType(ContentType.JSON)
	.log().all();
}
}
