package Activites;

import static org.testng.Assert.assertEquals;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
 
	//WebDriver declaration
		WebDriver driver;
	  //WebDriverWait declaration
		WebDriverWait wait;
		
		@BeforeClass
		public void setUp() {
			//Initialize driver
			 driver = new FirefoxDriver();
			
			 Reporter.log("Starting Test |");		 
			 //open the page
			 driver.get("https://training-support.net/webelements/alerts");	
			 Reporter.log("Opened Browser |");
		}
		@BeforeMethod
		public void beforeMethod() {
			Reporter.log("Test case Setup Started |");
			//Make the selenium focus on the page
			driver.switchTo().defaultContent();
		}
		
		@Test(priority =1)
		public void simpleAlertTestCase() {
			Reporter.log("simpleAlertTestCase() Started |");
			//click the button to open simple alert
			driver.findElement(By.id("simple")).click();
			Reporter.log("simple Alert Opened |");
			
			//Switch to alert window
			Alert simpleAlert = driver.switchTo().alert();
			Reporter.log("Switched focus to alert |");
			
			//Get text in the alert box and print it
			String alertText = simpleAlert.getText();
			Reporter.log("Alert text is:" +alertText + "|");
			
			//Assertions
			Assert.assertEquals("You've just triggered a simple alert!", alertText);
			//close the simple
			simpleAlert.accept();
			Reporter.log("Alert closed");
			Reporter.log("Test case ended |");
		}
		
		@Test(priority =2)
		public void confirmationAlertTestCase() {
			Reporter.log("confirmationAlertTestCase() Started |");
			//click the button to open simple alert
			driver.findElement(By.id("confirmation")).click();
			Reporter.log("confirmation Alert Opened |");
			
			//Switch to alert window
			Alert confirmationAlert = driver.switchTo().alert();
			Reporter.log("Switched focus to alert |");
			
			//Get text in the alert box and print it
			String alertText = confirmationAlert.getText();
			Reporter.log("Alert text is:" +alertText + "|");
			
			//Assertions
			Assert.assertEquals("You've just triggered a confirmation alert!", alertText);
			//close the confirmation
			confirmationAlert.accept();
			Reporter.log("Alert closed");
			Reporter.log("Test case ended |");
		}
		
		@Test(priority = 3)
		public void promptAlertTestCase() {
			Reporter.log("promptAlertTestCase() Started |");
			//click the button to open simple alert
			driver.findElement(By.id("prompt")).click();
			Reporter.log("prompt Alert Opened |");
			
			//Switch to alert window
			Alert promptAlert = driver.switchTo().alert();
			Reporter.log("Switched focus to alert |");
			
			//Get text in the alert box and print it
			String alertText = promptAlert.getText();
			Reporter.log("Alert text is:" +alertText + "|");
			
			//Assertions
			Assert.assertEquals("I'm a Prompt! Type something into me!", alertText);
			//type some thing into the prompt
			promptAlert.sendKeys("Awesome");
			Reporter.log("Text entered in the prompt alert");
			//close the prompt
			promptAlert.accept();
			Reporter.log("Alert closed");
			Reporter.log("Test case ended |");
		}
					
		@AfterClass
		public void tearDown() {
			//close the browser
			driver.quit();
		}
	
}
