package Project_CRM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	    //WebDriver declaration
		WebDriver driver;
	    //WebDriverWait declaration
		WebDriverWait wait;
         
        @BeforeClass
		public void setUp() {
			//Initialize driver
			 driver = new FirefoxDriver();
			 //Initialize wait
			 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 //Navigating to the page
			 driver.get("https://alchemy.hguy.co/crm");
}
        @Test
        public void verifyPageTitle() {
            // Get the actual title of the webpage
            String pageTitle = driver.getTitle();

            // Print the title to the console
            System.out.println("Page title is: " + pageTitle);

            // Assertion to verify the title matches "SuiteCRM"
            Assert.assertEquals(pageTitle, "SuiteCRM");
        }

        @AfterClass
        public void tearDown() {
            // Close the browser
            driver.quit();
        }
   
}


