package Activities;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity15 {
	public static void main(String[] args) {
		//Initialize Driver
		
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		// open the browser page
		driver.get("https://training-support.net/webelements/dynamic-attributes");
		driver.manage().window().maximize();
		
		//page interactions
		// print the page title
		System.out.println(driver.getTitle());
		
		//Find the input fields and type in the required data in the fields.
		driver.findElement(By.xpath("//input[starts-with(@id,'full-name-')]")).sendKeys("Lakshmi");
		driver.findElement(By.xpath("//input[contains(@id,'-email')]")).sendKeys("lakshmi@gmail.com");
		driver.findElement(By.xpath("//input[contains(@name,'-event-date-')]")).sendKeys("2001-07-28");
		driver.findElement(By.xpath("//textarea[contains(@id,'-additional-details-')]")).sendKeys("I am very Loyal");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//driver.findElement(By.tagName("placeholder = Full name").id("full-name"));
		
		//driver.findElement(By.asaas'asatagName(placeholder ="").id("full-name"));
		
		//Wait for success message to appear and print it to the console.
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText();
		System.out.println(message);
		//Close the browser.
		driver.quit();
	}
}
