package RestApiParatemeters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.ValidatableResponse;

public class FormParameterTest 
{
	@Test
	public void formparameter()
	{
		 Headers str = given().contentType(ContentType.JSON )
		.queryParam("client_id", "c1d4f42534d290140ce0")
		//.formParam("redirect_uri", "https://github.com")
		//.formParam("login", "priyamoh1")
		//.formParam("scope", "repo")
		//.queryParam("state", " ")
		//.formParam("allow_signup", "false"
	
		.when().get("https://github.com/login/oauth/authorize").getHeaders();
		 System.out.println(str);
		
		
         
		
	
		
		
	
		
		

	}
}