package step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Test_Steps {
	
	   private WebDriver driver;
	   String  Url="http://107.170.213.234/catalog/";
	
	@Given("^User is on Catalog homepage$")
	public void user_is_on_Catalog_homepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver =new ChromeDriver();
        driver.get(Url);

	}

	@Given("^click on log yourself in link$")
	public void click_on_log_yourself_in_link() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='bodyContent']/div/div[1]/a[1]/u")).click();
	}

	@When("^enter valid username and password$")
	public void enter_valid_username_and_password() throws Throwable {
		  driver.findElement(By.name("email_address")).sendKeys("jackma@test.com");
          driver.findElement(By.name("password")).sendKeys("test123");
        
	}

	@When("^click sign in button$")
	public void click_sign_in_button() throws Throwable {
		  driver.findElement(By.id("tdb5")).click();
	}

	@Then("^\"([^\"]*)\" message is displayed$")
	public void message_is_displayed(String arg1) throws Throwable {
	       String expectedText ="Welcome to iBusiness";
	        String actualText= driver.findElement(By.xpath("//*[contains(text(),'"+ expectedText.trim() +"')]")).getText();
	        Assert.assertEquals(expectedText, actualText);
	        driver.quit();
	}

}
