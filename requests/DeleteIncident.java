package requests;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIncident {
	
	@Test
	public void getAllIncidents() {
		
		RestAssured.baseURI = "https://dev62749.service-now.com/api/now/v2/table/incident/";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		Response response = RestAssured.delete("9d385017c611228701d22104cc95c371");
		
		response.prettyPrint();
		
		System.out.println(response.getStatusCode());
		
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
