package jira.assignment;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateIssue {

	@Test
	public void createIncident() {

		RestAssured.baseURI = "https://novservices.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("testleaf0103@gmail.com", "5O9sT2adl0fnX8GUNODdEE45");
	
		Response response = RestAssured
		.given()
		.log()
		.all()
		.contentType(ContentType.JSON)
		.body("{ \"fields\": {\"summary\": \"Updated Defect Information\"}}")
		.put("10027");
		
		response.prettyPrint();
		System.out.println(response.getStatusCode());		
	}

}
