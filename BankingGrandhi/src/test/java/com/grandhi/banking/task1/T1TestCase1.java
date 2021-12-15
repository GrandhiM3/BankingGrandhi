package com.grandhi.banking.task1;


import org.json.simple.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
@Listeners(Reports.ExtentList.class)
public class T1TestCase1 {
	
	
		@Test
		public void post() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "Appilication/json");
		
		JSONObject json = new JSONObject();
		json.put("userId", 15);
		json.put("id", 3);
		json.put("title", "Grandhi");
		json.put("completed", "true");
		
		Response res = given().header("Content-Type", "application/json").body(json).when().post("users");

		res.then().assertThat().statusCode(201);
		System.out.println(res.then().extract().response().asString());
		System.out.println(json);
		
		
	}

	
}

