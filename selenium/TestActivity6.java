package Activities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity6 {
	public static void main(String[] args) {
		//Initialize Driver
		
        WebDriver driver = new FirefoxDriver();
		
		// open the browser page
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		//page interactions
		// print the page title
		System.out.println(driver.getTitle());
		
		//Find the checkbox input element.
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		//Check if the checkbox is selected and print the result.
		System.out.println(checkbox.isSelected());
		
		//Click the checkbox to select it.
		checkbox.click();
		//Check if the checkbox is selected again and print the result.
		System.out.println(checkbox.isSelected());
		
		//close the web browser.
		driver.quit();
	}
	
}
