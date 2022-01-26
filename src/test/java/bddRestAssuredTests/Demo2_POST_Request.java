package bddRestAssuredTests;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import utils.RestUtils;
import java.util.HashMap;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Demo2_POST_Request {
	
	public static HashMap map = new HashMap();
	
	String employeeName = RestUtils.employeeName();
	String employeeSalary = RestUtils.employeeSalary();
	String employeeAge = RestUtils.employeeAge();
	
	@BeforeMethod
	public void postData() {
		
//		RestUtils restUtils = new RestUtils();
//		
//		String firstName = restUtils.firstName();
//		String lastName = restUtils.lastName();
//		String userName = firstName + "." + lastName;
//		String email = userName + "@example.com";
//		String password = restUtils.password();
//		
//		map.put("FirstName", firstName);
//		map.put("LastName", lastName);
//		map.put("UserName", userName);
//		map.put("Email", email);
//		map.put("Password", password);
//				
//		baseURI = "http://demoqa.com/customer";
//		basePath = "/register";
		
		map.put("name", employeeName);
		map.put("salary", employeeSalary);
		map.put("age", employeeAge);
		
		baseURI = "http://dummy.restapiexample.com/api/v1";
		basePath = "/create";
		
	}
	
	@Test
	public void testPost() {
		
		Response response =
		
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(200)
			.body("status", equalTo("success"))
			.body("message", equalTo("Successfully! Record has been added."))
			.body("data.name", equalTo(employeeName))
			.body("data.salary", equalTo(employeeSalary))
			.body("data.age", equalTo(employeeAge))
			.log().all()
			.extract().response();
		
		Assert.assertTrue(response.jsonPath().get("data.id").toString().matches("\\d{4}"));		
	
	}
		

}
