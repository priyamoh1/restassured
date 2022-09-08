package crm.reqrescrud.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SingleResourceNotFoundTest 
{
	@Test
	public void singleresourcenotfound()
	{
		
			//pre condition
			RestAssured.given().contentType(ContentType.JSON)

			//request
			.when().get("https://reqres.in/api/unknown/23")

			//response validation
			.then().assertThat().statusCode(404)
			.contentType(ContentType.JSON)

			//print all the information
			.log().all();
		}
	}

