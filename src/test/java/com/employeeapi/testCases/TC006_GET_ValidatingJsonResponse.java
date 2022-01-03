package com.employeeapi.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC006_GET_ValidatingJsonResponse {

	@Test
	public void getWeatherDetals() {
		
		baseURI = "http://demoqa.com/utilities/weather/city";
				
		Response response = given().request(Method.GET, "/Jerusalem");
		
		JsonPath jsonPath = response.jsonPath();
		
//		System.out.println(jsonPath.get("City"));
//		System.out.println(jsonPath.get("Temperature"));
//		System.out.println(jsonPath.get("Humidity"));
//		System.out.println(jsonPath.get("'Weather Description'"));
//		System.out.println(jsonPath.get("'Wind Speed'"));
//		System.out.println(jsonPath.get("'Wind Direction degree'"));
		
		Assert.assertEquals(jsonPath.get("City"), "Jerusalem");
		
		
		given().
			get("/Jerusalem").
		then().
			statusCode(200).
			statusLine("HTTP/1.1 200 OK");
	
	
	}
	
}
