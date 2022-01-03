package com.employeeapi.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TC001_GET_Request {

	@Test
	void getWeatherDeatails() {
		
		baseURI = "http://demoqa.com/utilities/weather/city";
				
		Response response = given().request(Method.GET, "/Jerusalem");
		
		System.out.println("Response body is: " + response.getBody().asString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		
		given().
			get(baseURI+"/Jerusalem").
		then().
			statusCode(200).
			statusLine("HTTP/1.1 200 OK");
	
	
	}
	
}
