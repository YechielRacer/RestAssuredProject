package com.employeeapi.testCases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TC002_POST_Request {
	
	@Test
	void registerUser() {
		
		baseURI = "http://demoqa.com/customer";
				
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("FirstName", "Yechiel");
		requestParams.put("LastName", "Racer");
		requestParams.put("UserName", "yechielr");
		requestParams.put("Password", "password");
		requestParams.put("Email", "yechielr@perion.com");
		
		given().header("Content-Type", "application/json");
		
		given().body(requestParams.toJSONString());
		
		Response response = given().request(Method.POST, "/register");
		
		System.out.println("Response body is: " + response.getBody().asString());
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
		Assert.assertEquals(response.jsonPath().get("SuccessCode"), "OPERATION_SUCCESS");
		
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			body(requestParams.toJSONString()).
		when().
			post("/register").
		then().
			statusCode(201);
		
	}

}
