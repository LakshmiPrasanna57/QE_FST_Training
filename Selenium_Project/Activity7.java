package Project_CRM;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Activity7 {
	// WebDriver declaration
	WebDriver driver;
	// WebDriverWait declaration
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize driver
		driver = new FirefoxDriver();
		// Initialize wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Navigating to the page
		driver.get("https://alchemy.hguy.co/crm");
	}

	@Test(priority = 1)
	public void loginSucessTest() {
		// find username and password
		driver.findElement(By.id("user_name"));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		// enter the password
		driver.findElement(By.id("username_password"));
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		// click on login in button
		driver.findElement(By.id("bigbutton")).click();
	}

	@Test(priority = 2)
	public void verifySalesDropDown() {
		// to find the sales button in the navigation bar
		driver.findElement(By.id("grouptab_0")).click();
		// finding the Leads and clicking on it
		driver.findElement(By.id("moduleTab_9_Leads")).click();
		// finding the additional icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adspan_a251ee8d-56cf-7682-a093-5f4c12b1cbff")))
				.click();

		// Find and assert the phone number
		String phoneText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.phone")))
				.getText();
		System.out.println("Phone: " + phoneText);
		// Assertion
		Assert.assertEquals("9000001234", phoneText );
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
