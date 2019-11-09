package jira.assignment;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIssue {
	
	@Test
	public void getAllIncidents() {
		
		RestAssured.baseURI = "https://novservices.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("testleaf0103@gmail.com", "5O9sT2adl0fnX8GUNODdEE45");
		
		Response response = RestAssured.delete("10004");
		
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		
	}

}
