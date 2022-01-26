package bddRestAssuredTests;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class Demo5_BasicValidations_JSON {
	
	@Test(priority=1)
	public void testStatusCode() {
		
		when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=2)
	public void testLogging() {
		
		when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=3)
	public void testSingleContent() {
		
		when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(200)
			.body("RestResponse.result.name", equalTo("India"));
	}
	
	@Test(priority=4)
	public void testMultipleContents() {
		
		when()
			.get("http://services.groupkt.com/country/get/all")
		.then()
			.statusCode(200)
			.body("RestResponse.result.name", hasItems("India","Israel","New Zealand"));
	}
	
	@Test(priority=5)
	public void testParamsAndHeaders() {
		
		given()
			.param("MyName", "Yechiel")
			.header("MyHeader", "Israeli")
		.when()
			.get("http://services.groupkt.com/country/get/all")
		.then()
			.statusCode(200)
			.log().all();
	}
	

}
