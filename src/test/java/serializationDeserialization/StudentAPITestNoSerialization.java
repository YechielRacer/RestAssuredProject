package serializationDeserialization;

import java.util.ArrayList;
import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class StudentAPITestNoSerialization {
	
	
	@Test(priority=1)
	public void createNewStudent() {
		
		HashMap map = new HashMap();
		
		map.put("id", 101);
		map.put("firstName", "Pavan");
		map.put("lastName", "Kumar");
		map.put("email", "pavan.kumar@example.com");
		map.put("programme", "Manger");
		
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		map.put("courses", coursesList);
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(201)
			.body("msg", equalTo("Student added"));
		
	}
	
	@Test(priority=2)
	public void getStudentRecord() {
		
		when()
			.get("http://localhost:8085/student/101")
		.then()
			.statusCode(200)
			.body("id", equalTo("101"))
			.log().all();
		
	}
	
}
