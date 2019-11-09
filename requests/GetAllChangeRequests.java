package requests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllChangeRequests {
	
	@Test
	public void getAllIncidents() {
		
		RestAssured.baseURI = "https://dev62749.service-now.com/api/now/v2/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		Map<String, String > paramsMap = new HashMap<String, String >();
		paramsMap.put("sysparm_fields", "number,sys_id");
		paramsMap.put("category", "network");
		paramsMap.put("number", "CHG0000081");
		
		Response response = RestAssured
				.given()
				.params(paramsMap)
				.get();
		
		response.prettyPrint();
		
		List<String> allSys = response.jsonPath().getList("result.sys_id");
		int size = allSys.size();
		System.out.println(size);
		for (String eachSys : allSys) {
			System.out.println(eachSys);
		}
			
	}

}
