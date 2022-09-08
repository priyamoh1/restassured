package crudOperationWithBDD;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import io.restassured.http.ContentType;

public class GetAllProjectsTest 
{ 
@Test
public void getallprojects()
{
given().contentType(ContentType.JSON)
.when().get("http://localhost:8084/projects")
.then().statusCode(200)
.contentType(ContentType.JSON);
}
}
