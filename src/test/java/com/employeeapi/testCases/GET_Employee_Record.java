package com.employeeapi.testCases;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.http.Method;

import static io.restassured.RestAssured.*;

public class GET_Employee_Record extends TestBase {

	@BeforeClass
	void getEmployeeData() throws InterruptedException {
				
		baseURI = "http://dummy.restapiexample.com/api/v1";
		response = given().request(Method.GET, "/employee/"+employeeId);
		
		Thread.sleep(3);
	}
	
	@Test
	void checkResponseBody() {
				
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertTrue(responseBody.contains(employeeId));
		
	}
	
	@Test
	void checkStatusCode() {
				
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	void checkResponseTime() {
				
		long responseTime = response.getTime();
		
		if (responseTime > 3000)
			logger.warn("Response time is greater than 3000");
		
		Assert.assertTrue(responseTime <= 3000);
		
	}
	
	@Test
	void checkStatusLine() {
				
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	void checkContentType() {
				
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json");
		
	}
	
	@Test
	void checkServerType() {
				
		String serverType = response.header("Server");
		Assert.assertEquals(serverType, "nginx");
		
	}
	
//	@Test
//	void checkContentEncoding() {
//				
//		String contentEncoding = response.header("Content-Encoding");
//		Assert.assertEquals(contentEncoding, "gzip");
//		
//	}
	
	@Test
	void checkContentLength() {
				
		String contentLength = response.header("Content-Length");
		
		if (Integer.parseInt(contentLength) < 50)
			logger.warn("Content length is less than 50");
		
		Assert.assertTrue(Integer.parseInt(contentLength) >= 50);
		
	}	
	
	@AfterClass
	void tearDown() {
		
		logger.info("********Finished GET_All_Employees********");
		
	}
	
	
}
