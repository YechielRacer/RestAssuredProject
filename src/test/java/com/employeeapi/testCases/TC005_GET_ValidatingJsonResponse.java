package com.employeeapi.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TC005_GET_ValidatingJsonResponse {

	@Test
	public void getWeatherDetals() {
		
		baseURI = "http://demoqa.com/utilities/weather/city";
				
		Response response = given().request(Method.GET, "/Jerusalem");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: "+responseBody);
		
		Assert.assertTrue(responseBody.contains("Jerusalem"));
		
		
		given().
			get(baseURI+"/Jerusalem").
		then().
			statusCode(200).
			statusLine("HTTP/1.1 200 OK");
	
	
	}
	
}
