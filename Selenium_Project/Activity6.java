package Project_CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize Fire fox driver
		driver = new FirefoxDriver();

		// Navigate to the CRM login page
		driver.get("http://alchemy.hguy.co/crm");

		// Log in using provided credentials
		WebElement username = driver.findElement(By.id("user_name"));
		WebElement password = driver.findElement(By.id("username_password"));
		WebElement loginButton = driver.findElement(By.id("bigbutton"));

		username.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		loginButton.click();
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

	@Test(priority=2)
	public void checkActivitiesMenuExistsAndClickable() {
		// Locate the “Activities” menu item
		WebElement activitiesMenu = driver.findElement(By.id("grouptab_3"));

		// Click the menu to ensure it's interactive
		activitiesMenu.click();

		// Optional debug/log output
		System.out.println("'Activities' menu is present and clickable.");
		// Assertion
		Assert.assertEquals(activitiesMenu ,"[[FirefoxDriver: firefox on windows (8ba9add9-4012-4505-b58c-77478244f551)] -> id: grouptab_3]");
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

}
