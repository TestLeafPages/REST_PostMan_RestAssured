package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncidentNumber {
	
	@Test
	public void getIncidentNumberFromSelenium() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev62749.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Move to the frame
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Tuna@123");
		driver.findElement(By.id("sysverb_login")).click();
		
		
		// Switch out of the frame
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
		
		// Move to the frame
		driver.switchTo().frame("gsft_main");
		String text = driver.findElement(By.xpath("(//td[@class='vt'])[1]")).getText();
		System.out.println(text);
		
		
		
		RestAssured.baseURI = "https://dev62749.service-now.com/api/now/v2/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		Response response = RestAssured
				.given()
				.param("number", text)
				.get();
		
		response.prettyPrint();
		
		
		
		// BeforeMethod: Create data using Rest Assured
		// @Test: Selenium
		
		
		
		
		
		
		
		
	}

}
