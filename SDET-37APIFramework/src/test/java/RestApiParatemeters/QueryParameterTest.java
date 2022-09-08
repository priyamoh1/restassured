package RestApiParatemeters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class QueryParameterTest
{
	@Test
public void queryparameter()
{
	RestAssured.given().contentType(ContentType.JSON)
	.pathParam("path", "users")
	.queryParam("page", "2")
	.when().get("https://reqres.in/api/{path}")
	.then().statusCode(200).contentType(ContentType.JSON)
	.log().all();
}
}
