package requests;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAll_Incidents_NumberOnly {
	
	@Test
	public void getAllIncidents() {
		
		RestAssured.baseURI = "https://dev62749.service-now.com/api/now/v2/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		Response response = RestAssured
				.given()
				.param("sysparm_fields", "number,sys_id")
				.get();
		
		response.prettyPrint();
		
		/*int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		// How many incidents are available in the response
		JsonPath jsonPath = response.jsonPath();
		
		List<String> list = jsonPath.getList("result.number");
		System.out.println("Count of incidents "+list.size());
		
		// Print all incident numbers
		for (String eachNumber : list) {
			System.out.println(eachNumber);
		}*/
		
		
		
		
		
		
		
		
		
		
	}

}
