package bddRestAssuredTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.RestUtils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

public class Demo3_PUT_Request {
	
	public static HashMap map = new HashMap();
	
	int employeeId = 24;
	String employeeName = RestUtils.employeeName();
	String employeeSalary = RestUtils.employeeSalary();
	String employeeAge = RestUtils.employeeAge();

	@BeforeClass
	public void putData() throws InterruptedException {
				
		map.put("name", employeeName);
		map.put("salary", employeeSalary);
		map.put("age", employeeAge);
		
		baseURI = "http://dummy.restapiexample.com/api/v1";
		basePath = "/update/"+employeeId;

	}

	@Test
	public void testPut() {

		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.body("status", equalTo("success"))
			.body("message", equalTo("Successfully! Record has been updated."))
			.body("data.name", equalTo(employeeName))
			.body("data.salary", equalTo(employeeSalary))
			.body("data.age", equalTo(employeeAge))
			.log().all();

	}


}
