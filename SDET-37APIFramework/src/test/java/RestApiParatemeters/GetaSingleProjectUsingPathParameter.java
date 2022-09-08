package RestApiParatemeters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetaSingleProjectUsingPathParameter 
{
	@Test
	public void getprojectusingpathparameter()
	{
		given().pathParam("id", "TY_PROJECT048")
		.contentType(ContentType.JSON)
		.when().get("http://localhost:8084/projects/{id}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
	}
}
