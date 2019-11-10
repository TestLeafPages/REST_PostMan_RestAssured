package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CreateIncident {
	
	public static RequestSpecification rSpec;

	@Given("Setup the endpoint in SN")
	public void setupEndpoint() {
		RestAssured.baseURI = "https://dev62749.service-now.com/api/now/v2/table/incident";
	}

	@Given("Authorize")
	public void authorize() {
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
	}

	@And("Enable Logs")
	public void enableLogs() {
		rSpec = RestAssured.given().log().all();
	}
	@And("Set Content Type")
	public void setContentType() {
		rSpec.contentType(ContentType.JSON);
	}
	@And("Set the body contents")
	public void setBodyContents() {
		rSpec.body("{\"short_description\" : \"Rest Assured\"}");
	}
	@Then("Post the request")
	public void post() {
		rSpec.post();
	}

	


}
