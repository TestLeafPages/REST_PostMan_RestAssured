package jira.assignment;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIssue {
	
	@Test
	public void createIssue() {

		File jsonFile = new File("jira.json");
		
		RestAssured.baseURI = "https://novservices.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("testleaf0103@gmail.com", "5O9sT2adl0fnX8GUNODdEE45");
		Response response = RestAssured
			.given()
			.log()
			.all()
			.contentType(ContentType.JSON)
			.body(jsonFile)
			.post();
		//response.prettyPrint();
		
		JsonPath jsonPath = response.jsonPath();
		
		String number = jsonPath.get("id");
		System.out.println(number);
		
		
	}


}
