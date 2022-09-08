package RestApiAuthenification;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Oauth2DirectTest 
{
	public void oauth2direct()
	{
		 given().contentType(ContentType.JSON )
		.auth().oauth2("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")
		.when().get("http://api.github.com/user/repos")
		.then().statusCode(200).contentType(ContentType.JSON)
		.log().all();

	}
}
