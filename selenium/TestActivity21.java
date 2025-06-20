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

public class TestActivity21 {
	public static void main(String[] args) {
		// Initialize driver

		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// open the browser page
		driver.get("https://training-support.net/webelements/tabs");
		// Implicit Wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// page interactions
		// print the page title
		System.out.println(driver.getTitle());

		// Find the button to open a new tab and click it.
		driver.findElement(By.cssSelector("button.svelte-1bfwg86")).click();
		// Wait for the new tab to open. Once it opens, print all the handles.
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		System.out.println(driver.getWindowHandles());
		// Switch to the newly opened tab, print the new tab's title and message.
		System.out.println(driver.getTitle());

		// Repeat the steps by clicking the button in the new tab page.
		driver.findElement(By.cssSelector("button.svelte-ov8nwn")).click();
		// wait for the 3 tabs
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		// print all open tabs
		System.out.println("Currently open tabs:");
		System.out.println(driver.getWindowHandles());
		// To switch to latest tabs
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		// print the current tab
		System.out.println("Currently active tab" + driver.getWindowHandle());
		System.out.println("New page Title" + driver.getTitle());
		System.out.println("New page Message" + driver.findElement(By.cssSelector("button.svelte-ov8nwn")).getText());

		// Close the browser.
		driver.quit();
	}

}
