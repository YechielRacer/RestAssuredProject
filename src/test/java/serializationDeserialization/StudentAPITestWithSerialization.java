package serializationDeserialization;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class StudentAPITestWithSerialization {	
	
	@Test(priority=1)
	public void createNewStudent() {
		
		ArrayList<String> coursesList = new ArrayList<String>();	
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		Student student = new Student();
		student.setSID(101);
		student.setFirstName("John");
		student.setLastName("Doe");
		student.setEmail("john.doe@example.com");
		student.setProgramme("Computer Science");
		student.setCourses(coursesList);
		
		given()
			.contentType(ContentType.JSON)
			.body(student)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(201)
			.body("msg", equalTo("Student added"));
			
		}
	
	@Test(priority=2)
	public void getStudentRecord() {
		
		Student student = get("http://localhost:8085/student/101").as(Student.class);
		System.out.println(student.getStudentRecord());
		Assert.assertEquals(student.getSID(), 101);
	
	}

}
