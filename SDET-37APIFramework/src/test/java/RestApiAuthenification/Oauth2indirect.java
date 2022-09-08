package RestApiAuthenification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Oauth2indirect 
{
	@Test
	public void indirect()
	{
		given().contentType(ContentType.JSON );
		
	}
	
}
