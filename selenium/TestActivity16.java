package Activities;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class TestActivity16 {
		private static final String WebElement = null;

		public static void main(String[] args) {
			//Initialize Driver
			
	        WebDriver driver = new FirefoxDriver();
	        Actions builder = new Actions(driver);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        			
	        // open the browser page
	        driver.get("https://training-support.net/webelements/selects");
			driver.manage().window().maximize();
			
			//page interactions
			// print the page title
			System.out.println(driver.getTitle());
			
			//find the select element and create the select object 
	        Select dropdown = new Select(driver.findElement(By.cssSelector("select.h-10")));
	        			
			//Select the second option using the visible text.
			dropdown.selectByVisibleText("One");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			//Select the third option using the index.
			dropdown.selectByIndex(2);
			System.out.println(dropdown.getFirstSelectedOption().getText());
			//Select the fourth option using the value.
			dropdown.selectByValue("three");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			//Get all the options and print them to the console.
			System.out.println("All available options:");
			for(WebElement option: dropdown.getOptions()) {
				System.out.println(option.getText());
			}
			//Close the browser.
			driver.quit();
		}

}
