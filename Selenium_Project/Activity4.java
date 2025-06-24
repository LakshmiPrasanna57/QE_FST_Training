package Project_CRM;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
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
	
	@Test(priority=1)
    public void verifyPageTitle() {
        // Get the actual title of the webpage
        String pageTitle = driver.getTitle();

        // Print the title to the console
        System.out.println("Page title is: " + pageTitle);

        // Assertion to verify the title matches "SuiteCRM"
        Assert.assertEquals(pageTitle, "SuiteCRM");
    }

	@Test(priority = 2)
	public void loginSucessTest() {
		// find username
		driver.findElement(By.id("user_name")).sendKeys("admin");
		// enter the password
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		// click on login in button
		driver.findElement(By.id("bigbutton")).click();
        // find and click the About Us button
		driver.findElement(By.id("bootstrap-container"));
		
		 //Assertion
		 String title = driver.getTitle();
		 Assert.assertTrue(title.contains("SuiteCRM"), "Page title doesn't indicate successful login");
	}
	

	@AfterClass
	public void tearDown() {
		// close the browser
		driver.quit();
	}

}
