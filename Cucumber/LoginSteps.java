package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {
	@Given("User is on the login page")
	public void loginPage() {
		// open the home page
		driver.get("https://training-support.net/webelements/login-form");
	}

	@When("they enter the username and password")
	public void loginDetails() {
		// find and enter the username in the username field
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("username");
		// find and enter the password in the password field
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
	}

	@When("they enter the {string} and {string}")
	public void enterCredsParam(String username, String password) {
		// find and enter the username in the username field
		driver.findElement(By.id("username")).sendKeys(username);
		// find and enter the password in the password field
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("clicks the submit button")
	public void clickSubmit() {
		// click on submit button
		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();

	}

	/*@Then("they should be able to see the success message")
	public void loginSucess() {
		// wait for the message to load
		String message = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.text-emerald-500"))).getText();
		// Assert the confirmation message
		assertEquals("Login Success!", message);

	}*/

	@Then("they should be able to see the failed message {string}")
	public void userloginFailed(String expectedMessage) {
		// wait for the message to load
		String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading"))).getText();
	
		// Assert the confirmation message
		assertEquals("Invalid credentials", actualMessage);

	}
}
