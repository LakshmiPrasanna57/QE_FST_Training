package Activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestActivity8 {
	public static void main(String[] args) {
		//Initialize Driver
		
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		// open the browser page
		driver.get("https://training-support.net/webelements/mouse-events");
		driver.manage().window().maximize();
		
		//page interactions
		// print the page title
		System.out.println(driver.getTitle());
		//find all the elemenets
		
		WebElement cargolock = driver.findElement(By.xpath("//h1[text()= 'Cargo.lock']"));
		WebElement cargoToml = driver.findElement(By.xpath("//h1[text()= 'Cargo.toml']"));
		WebElement srcFile = driver.findElement(By.xpath("//h1[text()= 'src']"));
		WebElement targetFile = driver.findElement(By.xpath("//h1[text()= 'target']"));
					
		//Left click on the Cargo.lock button, move the cursor to the Cargo.toml button and then click it.
		builder.click(cargolock).pause(5000).click(cargoToml).build().perform();
		//Print the confirmation text at the end of the sequence.
		System.out.println(driver.findElement(By.id("result")).getText());
		//Double click on the src button.Then right click on the target button 
		builder.doubleClick(srcFile).pause(5000).contextClick(targetFile).perform();
		// select open. 
		builder.click(driver.findElement(By.cssSelector("span.ml-3"))).pause(5000).build().perform();
		//Print the confirmation text at the end of the sequence.
		System.out.println(driver.findElement(By.id("result")).getText());
		//close the browser
		driver.quit();
}
}