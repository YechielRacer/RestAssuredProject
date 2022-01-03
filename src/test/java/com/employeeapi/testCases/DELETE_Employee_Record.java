package com.employeeapi.testCases;

import com.employeeapi.base.TestBase;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.RestUtils;

import static io.restassured.RestAssured.*;

public class DELETE_Employee_Record extends TestBase {

	RequestSpecification httpRequest;
	Response response;

	@BeforeClass
	void deleteEmployee() throws InterruptedException {

		logger.info("********Started Delete_Employee_Record********");

		baseURI = "http://dummy.restapiexample.com/api/v1";
		
		given().header("Content-Type", "application/json");
				
		response = given().request(Method.DELETE, "/delete/"+employeeId);

		System.out.println(response);

		Thread.sleep(5000);

	}

	@Test
	void checkResponseBody() {

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		JsonPath jsonPath = response.jsonPath();
		
		Assert.assertEquals(jsonPath.get("status"), "success");
		Assert.assertEquals(jsonPath.get("message"), "Successfully! Record has been deleted");

	}
	
	@Test
	void checkResponseTime() {

		long responseTime = response.getTime();

		if (responseTime > 5000)
			logger.warn("Response time is greater than 3000");

		Assert.assertTrue(responseTime <= 5000);

	}

	@Test
	void checkStatusCode() {

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

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

		logger.info("********Finished Delete_Employee_Record********");

	}


}
