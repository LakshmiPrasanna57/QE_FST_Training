package Activities;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity18 {
	public static void main(String[] args) {
		//Initialize driver
		
		 WebDriver driver = new FirefoxDriver();
		
		// open the browser page
		driver.get("https://training-support.net/webelements/alerts");
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//page interactions
		// print the page title
		System.out.println(driver.getTitle());
		
		//Find the button to open a SIMPLE alert and click it.
		driver.findElement(By.id("simple")).click();
		//Switch the focus from the main window to the Alert box
		Alert simpleAlert = driver.switchTo().alert();
		// get the text in it and print it.
		System.out.println(simpleAlert.getText());
		//Close the alert once with OK.
		simpleAlert.accept();
		//find and print the message.
		System.out.println(driver.findElement(By.id("result")).getText());
		//Close the browser.
		driver.quit();
	}

}
