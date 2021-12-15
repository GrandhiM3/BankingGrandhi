package com.grandhi.banking.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
@Listeners(Reports.ExtentList.class)
public class T1TestCase3 {

	@Test
	public void get() throws IOException {
		{
			 RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
			 RequestSpecification httpRequest = RestAssured.given();
			 Response response = httpRequest.get("users");
			 
			ResponseBody body =response.getBody();
			 
			
			 System.out.println(body.asString());
			 
			 String s =body.asString();
			 Assert.assertEquals(body.asString().contains("Leanne Graham"), true);
			 Assert.assertEquals(body.asString().contains("Ervin Howell"), true);
			 Assert.assertEquals(body.asString().contains("Clementine Bauch"), true);
			 Assert.assertEquals(body.asString().contains("Patricia Lebsack"), true);
			 Assert.assertEquals(body.asString().contains("Chelsey Dietrich"), true);
			 Assert.assertEquals(body.asString().contains("Dennis Schulist"), true);
			 Assert.assertEquals(body.asString().contains("Kurtis Weissnat"), true);
			 Assert.assertEquals(body.asString().contains("Nicholas Runolfsdottir V"), true);
			 Assert.assertEquals(body.asString().contains("Glenna Reichert"), true);
			 Assert.assertEquals(body.asString().contains("Clementina DuBuque"), true);
			 
	}
}
}
