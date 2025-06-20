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

public class TestActivity22 {
	public static void main(String[] args) {
		//Initialize driver
		
		 WebDriver driver = new FirefoxDriver();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// open the browser page
		driver.get("https://training-support.net/webelements/popups");
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//page interactions
		// print the page title
		System.out.println(driver.getTitle());
		
		//Find the button on the page and click it to launch the popup.
		driver.findElement(By.cssSelector("button.svelte-7fx7bp")).click();
		//Wait for the popup to appear and then enter the credentials:
		  
		//username: admin
		driver.findElement(By.id("username")).sendKeys("admin");
		//password: password
		driver.findElement(By.id("password")).sendKeys("password");
		//Click submit 
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		//print the message on the page after logging in.
		System.out.println(driver.findElement(By.cssSelector("h1.text-center")).getText());
				
		//Finally, close the browser.
		driver.quit();
	}

}
