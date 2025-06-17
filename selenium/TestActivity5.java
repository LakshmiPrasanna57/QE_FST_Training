package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity5 {
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
		//Check if it is visible on the page.
		System.out.println(checkbox.isDisplayed());
		
		//Click the "Remove Checkbox" button.
		driver.findElement(By.cssSelector("button.svelte-sfj3o4")).click();
		//Check if it is visible again and print the result.
		System.out.println(checkbox.isDisplayed());
		
		//close the web browser.
		driver.quit();
	}

}
