package com.grandhi.banking.task1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
@Listeners(Reports.ExtentList.class)
public class T1TestCase2 {

	@Test
	public void get() {
		
		//RequestSpecification req= RestAssured.given();
		
		Response res = RestAssured.get("https://jsonplaceholder.typicode.com/users/2");
		
		
		System.out.println(res.getBody().asString());
		int code = res.getStatusCode();
		
		Assert.assertEquals(code, 200);
		
	}
}
