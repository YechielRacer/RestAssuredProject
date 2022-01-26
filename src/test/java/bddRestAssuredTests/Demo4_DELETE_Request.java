package bddRestAssuredTests;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Demo4_DELETE_Request {
	
	int employeeId = 24;

	@BeforeClass
	public void deleteData() throws InterruptedException {

		baseURI = "http://dummy.restapiexample.com/api/v1";
		basePath = "/delete/"+employeeId;

	}

	@Test
	public void testDelete() {
		
		Response response =

		given()
		.when()
			.delete()
		.then()
			.statusCode(200)
			.body("status", equalTo("success"))
			.body("data", equalTo(employeeId))
			.body("message", equalTo("Successfully! Record has been deleted"))
			.log().all()
			.extract().response();
		
		String jsonString = response.asString();
		Assert.assertTrue(jsonString.contains("Successfully! Record has been deleted"));

	}


}
