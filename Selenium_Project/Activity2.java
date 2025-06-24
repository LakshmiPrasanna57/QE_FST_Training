package Project_CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize Fire fox Driver
		driver = new FirefoxDriver();
		// Navigate to the CRM site
		driver.get("http://alchemy.hguy.co/crm");
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
	public void getHeaderImageURL() {
		// Locate the header image using xpath
		WebElement headerImage = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));

		// Get the URL of the header image
		String imageUrl = headerImage.getAttribute("src");

		// Print the URL to console
		Reporter.log("Header Image URL: " + imageUrl);
		// Assertion for the image file name
		Assert.assertEquals(imageUrl,"https://alchemy.hguy.co/crm/themes/default/images/company_logo.png?v=cK7kLsY0ftg72ZVHTYUT_g");
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

}
