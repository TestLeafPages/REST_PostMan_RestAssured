package requests;

import java.io.File;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncident_UsingFile {
	
	@DataProvider(name="files", parallel=true, indices= {1})
	public Object[][] getFiles(){
		Object[][] data = new Object[2][1];
		data[0][0] = "data1";
		data[1][0] = "data2";
		return data;
	}

	@Test(dataProvider="files")
	public void createIncident(String fileName) {

		RestAssured.baseURI = "https://dev62749.service-now.com/api/now/v2/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");

		File jsonFile = new File("./"+fileName+".json");
		
		Response response = RestAssured
		.given()
		.log()
		.all()
		.contentType(ContentType.JSON)
		.body(jsonFile)
		.post();
		response.prettyPrint();
		
		JsonPath jsonPath = response.jsonPath();
		
		
		
		String number = jsonPath.get("result.number");
		System.out.println(number);
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getStatusLine());
		
		
		
		

		
	}

}
