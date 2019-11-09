package jira.assignment;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetIssues {
	
	@Test
	public void getIssues() {
		
		RestAssured.baseURI = "https://novservices.atlassian.net/rest/api/2/search";
		RestAssured.authentication = RestAssured.preemptive().basic("testleaf0103@gmail.com", "5O9sT2adl0fnX8GUNODdEE45");
	
		Response response = RestAssured
				.given()
				.param("jql", "project=\"NOV\"")
				.get();
		
		response.prettyPrint();
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		// How many incidents are available in the response
		JsonPath jsonPath = response.jsonPath();
		
		List<String> list = jsonPath.getList("issues.id");
		System.out.println("Count of incidents "+list.size());
		
		// Print all incident numbers
		for (String eachNumber : list) {
			System.out.println(eachNumber);
		}
		
		
		
		
		
		
		
		
		
		
	}

}
