package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteProjectTest
{
	@Test
	public void deleteaproject()
	{
		RequestSpecification re = RestAssured.given();
		Response response = re.delete("http://localhost:8084/projects/TY_PROJ_885");
		ValidatableResponse val = response.then();
		val.assertThat().statusCode(204).and().contentType(ContentType.JSON).log().all();

	}
}
