package serializationDeserialization;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class VideoGameAPITestWithSerialization {
	
	@Test(priority=1)
	public void testVideoGameSerializationXML() {
		
		VideoGame myVideoGame = new VideoGame();
		
		myVideoGame.setId(28);
		myVideoGame.setName("xyz123");
		myVideoGame.setReleaseDate("2022-01-04");
		myVideoGame.setReviewScore(90);
		myVideoGame.setCategory("Driving");
		myVideoGame.setRating("Five");
		
		given()
			.contentType("application/xml")
			.body(myVideoGame)
		.when()
			.post("http://localhost:8080/app/videogames")
		.then()
			.log().all()
			.body(equalTo("{\"status\": \"Record Added Successfully\"}"));
		
	}
	
	@Test(priority=2)
	public void testVideoGameDeserializationXML() {
		
		VideoGame myVideoGame = get("http://localhost:8080/app/videogames/28").as(VideoGame.class);
		
		System.out.println(myVideoGame.toString());
		
	}

}
