package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	

@Given("^Open the Chrome and launch the application$")
public void open_the_Chrome_and_launch_the_application() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Automation\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.browserstack.com/guide/automation-using-cucumber-selenium");
	String val = driver.getTitle();
	System.out.println(val);
	driver.findElement(By.xpath("//span[contains(text(),'Tools & Frameworks')]")).click();
	 throw new PendingException();
}

@When("^Enter the Username and Password$")
public void enter_the_Username_and_Password() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Reset the credential$")
public void reset_the_credential() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}



}
