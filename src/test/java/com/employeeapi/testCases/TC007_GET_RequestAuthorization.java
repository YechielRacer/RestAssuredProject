package com.employeeapi.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.*;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TC007_GET_RequestAuthorization {

	@Test
	public void authorizationTest() {
		
		baseURI = "http://demoqa.com/authentication/CheckForAuthentication";
				
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("AutomationQA");
		authScheme.setPassword("password");
		
		authentication = authScheme;
		
		Response response = given().request(Method.GET, "/");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		
		
		given().
			get("/").
		then().
			statusCode(200).
			statusLine("HTTP/1.1 200 OK");
	
	
	}
	
}
