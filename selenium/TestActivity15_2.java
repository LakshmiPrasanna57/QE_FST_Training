package Activities;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class TestActivity15_2 {
		private static final String WebElement = null;

		public static void main(String[] args) {
			//Initialize Driver
			
	        WebDriver driver = new FirefoxDriver();
	        Actions builder = new Actions(driver);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			// open the browser page
			driver.get("https://training-support.net/webelements/sliders");
			driver.manage().window().maximize();
			
			//page interactions
			// print the page title
			System.out.println(driver.getTitle());
			
			//find and print intial value
			WebElement volumeValue= driver.findElement(By.cssSelector("h1.text-5xl.font-extrabold"));
			System.out.println(volumeValue.getText());
			//find the slide
			WebElement slider = driver.findElement(By.id("volume"));
			//move the cursor to 25%
			builder.moveToElement(slider).clickAndHold(slider).moveByOffset(-120, 0).release().pause(3000).build().perform();
			//print the new value
			System.out.println(volumeValue.getText());
			//move it to 75%
			builder.moveToElement(slider).clickAndHold(slider).moveByOffset(120, 0).release().pause(3000).build().perform();
			//print the new value
			System.out.println(volumeValue.getText());
			//close the browser
			driver.quit();
			
		}

}
