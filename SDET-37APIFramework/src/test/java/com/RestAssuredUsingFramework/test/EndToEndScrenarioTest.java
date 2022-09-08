package com.RestAssuredUsingFramework.test;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.pojo.test.RandomNum;

import GenericLibrary.BaseClass;
import GenericLibrary.EndPoints;
import GenericLibrary.IConstants;
import GenericLibrary.JavaUtility;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.Icon;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import  io.restassured.response.Response;
/**
 * 
 * @author -priyaranjan-
 *
 */
public class EndToEndScrenarioTest 
{
	/**
	 * 
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	@Test
	public void enetoend() throws SQLException, InterruptedException
	{

		WebDriver driver=null;
		BaseClass bc = new BaseClass();

		JavaUtility num = new JavaUtility();
		int rannum = num.getRandomNumber();

		JSONObject js =new JSONObject();
		js.put("projectName", "neverending"+rannum);
		js.put("createdBy", "endtoend");
		js.put("createdOn", "10/04/20");
		js.put("status", "still going");
		js.put("teamSize", 5);


		Response res = given().body(js)
				.contentType(ContentType.JSON)
				.when().post(IConstants.basiuri+IConstants.portnum+EndPoints.createproject);

		String pid=res.jsonPath().get("projectId");

		res.then().assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();


		given().pathParam("id", pid)
		.get(IConstants.basiuri+IConstants.portnum+EndPoints.getsingleproject+"/{id}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();


		JSONObject js1=new JSONObject();
		js1.put("projectName", "irobot");
		js1.put("createdBy", "robots");


		given().body(js1).contentType(ContentType.JSON)
		.pathParam("new", pid)
		.when().put(IConstants.basiuri+IConstants.portnum+EndPoints.updateproject+"/{new}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();

		//opening the browser
		//bc.launchTheBrowser();
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		//maximize the browsers
		driver.manage().window().maximize();

		driver.get(IConstants.basiuri+IConstants.portnum);



		//enter the username and password
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(IConstants.rmgusername);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(IConstants.rmgpassword);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href=\"/dashboard/projects\"]")).click();

		//verify in rmgyantra GUI
		List<WebElement> list = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		for(WebElement ele:list)
		{
			String rid=ele.getText();
			if(rid.equalsIgnoreCase(pid))
			{
				System.out.println("project is present in(rmg check 1)");
				break;
			}

		}

		//close the browser
		driver.quit();


		//verify in database
		Driver dr=new Driver();
		DriverManager.registerDriver(dr);
		Connection con = DriverManager.getConnection(IConstants.DbUrl+IConstants.databasename,IConstants.DBUsername,IConstants.DBPassword);
		Statement st = con.createStatement();
		String query="select*from project";
		ResultSet result = st.executeQuery(query);

		while(result.next())
		{

			if(result.getString(1).contains(pid))
			{
				System.out.println("data is present(database check1)");
				break;
			}

		}

		//delete the project
		given().pathParam("did", pid)
		.when().delete(IConstants.basiuri+IConstants.portnum+EndPoints.deleteproject+"/{did}")
		.then().assertThat().statusCode(204)
		.log().all();

		//verify in GUI
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		//maximize the browser
		driver.manage().window().maximize();

		//enter the url
		driver.get(IConstants.basiuri+IConstants.portnum);


		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(IConstants.rmgusername);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(IConstants.rmgpassword);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href=\"/dashboard/projects\"]")).click();

		//verify in rmgyantra GUI
		List<WebElement> list1 = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		for(WebElement ele1:list1)
		{
			String rid1=ele1.getText();
			if(rid1.equalsIgnoreCase(pid))
			{
				System.out.println("project is present(rmg check 2)");
			}
			else
			{
				System.out.println("data is not present(rmg check 2)");
				break;
			}
		}

		//close the browser
		driver.quit();

		//verify in the database

		//Driver dr1=new Driver();
		DriverManager.registerDriver(dr);
		Connection con1 = DriverManager.getConnection(IConstants.DbUrl+IConstants.databasename,IConstants.DBUsername,IConstants.DBPassword);
		Statement st1 = con.createStatement();
		String query1="select*from projects";
		ResultSet result1 = st.executeQuery(query);

		while(result1.next())
		{

			if(result1.getString(1).contains(pid))
			{
				System.out.println("data is present(database check 2)");
			}
			else
			{
				System.out.println("data is not present(database check 2)");
				break;
			}
		}

		//close the database
		con1.close();
	}
}
