package Global;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class RestAPI_Graph  {
	
	@Test//(description = "", priority = 0)
    public void verifyUser() {
		RestAssured.baseURI = "https://api.spacex.land";
		String requestBody = "{\"query\":\"{\\n launchesPast(limit: 8) {\\n mission_name\\n launch_date_local\\n launch_site {\\n site_name_long\\n }\\n links {\\n article_link\\n video_link\\n }\\n rocket {\\n rocket_name\\n first_stage {\\n cores {\\n flight\\n core {\\n reuse_count\\n status\\n }\\n }\\n }\\n second_stage {\\n payloads {\\n payload_type\\n payload_mass_kg\\n payload_mass_lbs\\n }\\n }\\n }\\n ships {\\n name\\n home_port\\n image\\n }\\n }\\n}\",\"variables\":null}";	
		// Given
		Response firstresp = given()
		.contentType("application/json")
		.body(requestBody)
	// When
		.when()
		.post("/graphql")
	// Then
		.then()
		.extract().response();
		String bodyAsString = firstresp.asString();
		System.out.println("Response is " +firstresp.statusCode());
		System.out.println("Response is" +firstresp.jsonPath().getString("data.launchesPast"));
		Assert.assertEquals(200, firstresp.statusCode());
		Assert.assertEquals(bodyAsString.contains("Starlink-15"),true);
		Assert.assertNotNull(firstresp.jsonPath().getString("data.launchesPast.mission_name"));
//		Assert.assertNotNull(firstresp.jsonPath().getString("data.launchesPast"));
		List<String> NumLaunches = firstresp.jsonPath().getList("data.launchesPast.rocket");
		Assert.assertTrue(NumLaunches.size() > 0);
		List<String> NumShips = firstresp.jsonPath().getList("data.launchesPast.ships");
		Assert.assertTrue(NumShips.size() > 0);
		System.out.println("Launches "+NumLaunches.size());
		System.out.println("Ships : "+NumShips.size());
		Assert.assertNotNull(firstresp.jsonPath().getList("data.launchesPast.rocket.first_stage"));
		System.out.println("First stage : "+ firstresp.jsonPath().getList("data.launchesPast.rocket.first_stage"));
		
		Assert.assertNotNull(firstresp.jsonPath().getList("data.launchesPast.rocket.second_stage"));
		System.out.println("Second stage : "+ firstresp.jsonPath().getList("data.launchesPast.rocket.second_stage"));
		
    }
	
	//String bodyAsString = commonactions. firstresp.asString();

//	@Test
//	public void getResponsebody() {
//		Response reqres = (Response) given().
//		body("{\r\n" + 
//				"	\"query\": \"{\\n  launchesPast(limit: 1) {\\n    mission_name\\n    launch_date_local\\n    launch_site {\\n      site_name_long\\n    }\\n    links {\\n      article_link\\n      video_link\\n    }\\n    rocket {\\n      rocket_name\\n      first_stage {\\n        cores {\\n          flight\\n          core {\\n            reuse_count\\n            status\\n          }\\n        }\\n      }\\n      second_stage {\\n        payloads {\\n          payload_type\\n          payload_mass_kg\\n          payload_mass_lbs\\n        }\\n      }\\n    }\\n    ships {\\n      name\\n      home_port\\n      image\\n    }\\n  }\\n}\",\r\n" + 
//				"	\"variables\": null\r\n" + 
//				"}").
//		when().
//		post("https://api.spacex.land/graphql").
//		then();
//		System.out.println("Response is "+reqres.body());
//		System.out.println("Execution closed");
//}
}
