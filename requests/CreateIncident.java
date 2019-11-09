package requests;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncident {

	@Test
	public void createIncident() {

		RestAssured.baseURI = "https://dev62749.service-now.com/api/now/v2/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");

		Response response = RestAssured
		.given()
		.log()
		.all()
		.contentType(ContentType.JSON)
		.body("{\"short_description\" : \"Rest Assured\"}")
		.post();
		response.prettyPrint();
		
		JsonPath jsonPath = response.jsonPath();
		
		
		
		String number = jsonPath.get("result.number");
		System.out.println(number);
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getStatusLine());
		
		
		
		

		
	}

}
