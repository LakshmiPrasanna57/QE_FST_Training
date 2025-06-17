package Activities;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity11 {
	public static void main(String[] args) {
		//Initialize Driver
		
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		// open the browser page
		driver.get("https://training-support.net/webelements/dynamic-controls");
		driver.manage().window().maximize();
		
		//pag e interactions
		// print the page title
		System.out.println(driver.getTitle());
	
	  //Find the checkbox on the page.
		WebElement checkBox = driver.findElement(By.id("checkbox"));
	  //Click the "Toggle Checkbox" button to remove the checkbox.
		driver.findElement(By.cssSelector("button.svelte-sfj3o4")).click();
	  //Wait for the checkbox to disappear.
		wait.until(ExpectedConditions.invisibilityOf(checkBox));
	  //Toggle the checkbox again.
		driver.findElement(By.cssSelector("button.svelte-sfj3o4")).click();
	  //Wait for it appear and then select it.
		wait.until(ExpectedConditions.visibilityOf(checkBox));
	  //Close the browser.
		driver.quit();
}
}
