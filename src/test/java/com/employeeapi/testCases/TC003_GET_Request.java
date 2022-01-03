package com.employeeapi.testCases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import io.restassured.response.Response;

public class TC003_GET_Request {
	
	@Test
	void googleMapTest() {
		
		baseURI = "https://maps.googleapis.com";
				
		Response response = given().request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		System.out.println("Response body is: " + response.getBody().asString());
		
		Assert.assertEquals(response.header("Content-Type"), "application/xml; charset=UTF-8");
		
		Assert.assertEquals(response.header("Content-Encoding"), "gzip");
		
		given().
			get(baseURI+"/Jerusalem").
		then().
			statusCode(200).
			contentType("application/xml; charset=UTF-8");
		
	}

}
