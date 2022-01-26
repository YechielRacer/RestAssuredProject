package bddRestAssuredTests;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class Demo6_BasicValidations_XML {
	
	@Test(priority=1)
	public void testSingleContent() {
		
		when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.log().all();
	
	}
	
	@Test(priority=2)
	public void testMultipleContents() {
		
		when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
			.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
			.body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
			.body("CUSTOMER.CITY", equalTo("Seattle"));
	
	}
	
	@Test(priority=3)
	public void testMultipleContentsInOneGo() {
		
		when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));
	
	}
	
	@Test(priority=4)
	public void testUsingXPath1() {
		
		when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));
	
	}
	
	@Test(priority=5)
	public void testUsingXPath2() {
		
		when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE")
		.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
			.log().all();
	
	}


}
