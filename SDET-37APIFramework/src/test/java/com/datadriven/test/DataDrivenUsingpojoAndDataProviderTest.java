package com.datadriven.test;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pojo.test.PojoClassTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DataDrivenUsingpojoAndDataProviderTest 
{
	@Test(dataProvider="createdata")
	public void datadriven(String projectName,String createdBy,String createdOn,String status,int teamSize )
	{
		Random ran = new Random();
		int num = ran.nextInt(100);
		PojoClassTest pojo = new PojoClassTest("apple22"+num, "hehe1", "12/01/14", "created", 7);

		RestAssured.given().contentType(ContentType.JSON)
		.body(pojo)
		.when().post("http://localhost:8084/addProject")
		.then().assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();

	}
	@DataProvider(name="createdata")
	public Object[][] data()
	{
		Object[][] obj = new Object[4][5];
		obj[0][0]="jhkjhfd";
		obj[0][1]="dsfskjs";
		obj[0][2]="12/11/10";
		obj[0][3]="done";
		obj[0][4]=10;

		obj[1][0]="ijwi";
		obj[1][1]="dihs";
		obj[1][2]="12/11/10";
		obj[1][3]="eaih";
		obj[1][4]=5;

		obj[2][0]="wziodio";
		obj[2][1]="dokskei";
		obj[2][2]="12/11/10";
		obj[2][3]="done";
		obj[2][4]=7;

		obj[3][0]="kjeoma";
		obj[3][1]="lkodk";
		obj[3][2]="12/11/10";
		obj[3][3]="done";
		obj[3][4]=8;


		return obj;
	}
}
