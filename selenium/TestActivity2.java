package Activities;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity2 {
	public static void main(String[] args) {
		//Initialize driver
		
		 WebDriver driver = new FirefoxDriver();
		
		// open the browser page
		driver.get("https://training-support.net/webelements/login-form/");
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//page interactions
		// print the page title
		System.out.println(driver.getTitle());
		
		//find the username and password fields
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		
		// find the success message
		String message = driver.findElement(By.tagName("h1")).getText();
		System.out.println(message);
		System.out.println(message.equals("Login Success!"));
		
		driver.quit();  //closes all the tabs that are opened in the browser
	}

}
