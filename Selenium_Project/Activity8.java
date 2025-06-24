package Project_CRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {
	// WebDriver declaration
	WebDriver driver;

	// WebDriver wait declaration
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/crm");

		// Login to CRM
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
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
	public void printOddNumberedAccountNames() throws InterruptedException {
		// Navigate to Sales -> Accounts
		driver.findElement(By.id("grouptab_0")).click(); // Sales tab
		driver.findElement(By.xpath("//a[@id='moduleTab_9_Accounts']")).click(); // Accounts

		// Wait for the page to load
		Thread.sleep(3000);

		// Locate the table rows
		List<WebElement> oddRows = driver
				.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr[position() mod 2 = 1]"));

		// Print the first 5 odd-numbered rows' names
		System.out.println("First 5 odd-numbered Account names:");
		for (int i = 0; i < Math.min(5, oddRows.size()); i++) {
			String name = oddRows.get(i).findElement(By.xpath("./td[3]/b/a")).getText();
			System.out.println((i + 1) + ". " + name);
		}
		
		// Assertion
		Assert.assertTrue(oddRows.size() >= 5, "Less than 5 odd-numbered rows found");

	
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
