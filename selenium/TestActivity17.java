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

public class TestActivity17 {
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
	        Select multilist = new Select(driver.findElement(By.cssSelector("select.h-80")));
	        			
					
	        //Select the "HTML" option using the visible text.
			multilist.selectByVisibleText("HTML");
	
			//Select the 4th, 5th and 6th options using the index.
			for(int i=3; i<=5; i++) {
				multilist.selectByIndex(i);
			}			
	        //Select the "Node" option using the value.
			multilist.selectByValue("nodejs");
	        //Deselect the 5th option using index
			multilist.deselectByIndex(4);
			//print the selected options
			for(WebElement option: multilist.getAllSelectedOptions()) {
				System.out.println(option.getText());
			}
	        //Close the browser.
			driver.quit();
		}

}
