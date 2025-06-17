package Activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestActivity9 {
	public static void main(String[] args) {
		//Initialize Driver
		
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		// open the browser page
		driver.get("https://training-support.net/webelements/keyboard-events");
		driver.manage().window().maximize();
		
		//page interactions
		// print the page title
		System.out.println(driver.getTitle());
		
		//Type some Text
		builder.sendKeys("Selenium Script").build().perform();
		
		
		//Print the message to the console.
		System.out.println(driver.findElement(By.cssSelector("h1.mt-3")).getText());
		//Close the browser.
		driver.quit();
	}

}
