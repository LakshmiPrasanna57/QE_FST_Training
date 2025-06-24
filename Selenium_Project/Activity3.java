package Project_CRM;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
//	public class FirstTest {
	// In TestNG we never create main function
	// @Test - The annotated method is a test case
	// @BeforeClass - The annotated method will run once before each class.
	// @AfterClass - The annotated method will run once after each class.
	// WebDriver Declaration
	WebDriver driver;
	// WebDriverWait declaration
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		// Initialize the driver
		driver = new FirefoxDriver();
		// Initialize wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		// open the page
		driver.get("http://alchemy.hguy.co/crm");
	}

	@Test(priority = 1)
	// run/debug
	public void verifyPageTitle() {
		assertEquals(driver.getTitle(), "SuiteCRM");
	}

	@Test(priority = 2)
	// run/debug
	public void firstCopyRightText() {
		// Find the first copyright text in the footer
		WebElement footer = driver.findElement(By.id("admin_options"));
		String footerText = footer.getText();
		// Print to console
		Reporter.log(footer.getText());
		// Assertions
		Assert.assertEquals(footerText, "© Supercharged by SuiteCRM");
	}

	@AfterClass
	public void testDown() {
		driver.quit();
	}
}
