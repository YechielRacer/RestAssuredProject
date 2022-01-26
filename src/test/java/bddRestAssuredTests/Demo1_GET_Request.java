package bddRestAssuredTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo1_GET_Request {

	@Test
	public void getWeatherDetails() {
		
		baseURI = "http://demoqa.com/utilities/weather/city";
		
		given()
		.when()
			.get("/Jerusalem")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("City", equalTo("Jerusalem"))
			.header("Content-Type", "application/json; charset=utf-8");		
		
	}
	
}
