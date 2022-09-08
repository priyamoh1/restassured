package GenericLibrary;


import io.restassured.response.Response;
/**
 * 
 * @author -priyaranjan-
 *
 */
public class RestAssuredLibrary 
{
public  String getjasonData(Response response,String path)
{
	//storing the json path in a variable
	String jsondata=response.jsonPath().get(path);
	return jsondata;
	
}
}
