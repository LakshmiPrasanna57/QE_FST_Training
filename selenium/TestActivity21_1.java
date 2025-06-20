package Activities;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity21_1 {
	public static void main(String[] args) {
		//Initialize driver
		
		 WebDriver driver = new FirefoxDriver();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// open the browser page
		driver.get("https://training-support.net/webelements/tabs");
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//page interactions
		// print the page title
		System.out.println(driver.getTitle());
		
		
		//Find the button to open a new tab and click it.
		driver.findElement(By.cssSelector("button.svelte-1bfwg86")).click();
		//Wait for the new tab to open. Once it opens, print all the handles.
		 for(String handle : driver.getWindowHandles()) {
			 driver.switchTo().window(handle);
		 }
		 System.out.println(driver.getWindowHandles());
		//Switch to the newly opened tab, print the new tab's title and message.
		 System.out.println(driver.getTitle());	
		 
		 //To find the release tab
		 
		 while(true) {
			 System.out.println("Currently open tabs:");
			 System.out.println(driver.getWindowHandles());
			 //To switch to latest tab
			 for(String handle : driver.getWindowHandles()) {
				 driver.switchTo().window(handle);
			 }
			 System.out.println("Currently active tab" +driver.getWindowHandle());
			 String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5"))).getText();
			 System.out.println("New page message:" +message);
			 if(message.contains("release")) {
				 System.out.println("Message is correct.");
				 break;
		     }
			 else {
				 System.out.println("Message is incorrect");
				 driver.findElement(By.xpath("//button[text()='Open Another One']")).click();
			 }
		 }
		 //close
		 driver.quit();
	}

}
