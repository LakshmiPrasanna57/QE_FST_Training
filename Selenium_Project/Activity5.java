package Project_CRM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	// WebDriver declaration and WebDriverWait declaration
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize driver and Initialize wait
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Open the browser
		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void loginSuccessTest() {
	      // Get the actual title of the webpage
          String pageTitle = driver.getTitle();
            
          // Print the title to the console
          System.out.println("Page title is: " + pageTitle);

         // Assertion to verify the title matches "SuiteCRM"
         Assert.assertEquals(pageTitle, "SuiteCRM");
		// Find the enter username
		driver.findElement(By.id("user_name")).sendKeys("admin");
		// Find the enter password
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		// Find and click the submit button
		driver.findElement(By.id("bigbutton")).click();
	}

	@Test(priority = 2)
	public void getNavigationMenuColor() {
		// Get the color of the navigation menu
		WebElement navigator = driver.findElement(By.cssSelector("nav.navbar"));
		String bgcolor = navigator.getCssValue("background-color");
		// Print it to the console
		System.out.println("Bg color is : " + bgcolor);
		// Assertion
		Assert.assertEquals(bgcolor, "rgb(83, 77, 100)");
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

}
