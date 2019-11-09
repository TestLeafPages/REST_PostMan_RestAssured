package requests;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAll_Incidents_Xml {
	
	@Test
	public void getAllIncidents() {
		
		RestAssured.baseURI = "https://dev62749.service-now.com/api/now/v2/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.XML)
				.get();
		
		response.prettyPrint();
		
		XmlPath xmlPath = response.xmlPath();
		
		List<String> list = xmlPath.getList("response.result.sys_id");
		System.out.println(list.size());
		
		
		
		
		
		
		
		
	}

}
