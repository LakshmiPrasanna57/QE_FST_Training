package Activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestActivity10 {
	public static void main(String[] args) {
		//Initialize Driver
		
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		// open the browser page
		driver.get("https://training-support.net/webelements/drag-drop");
		driver.manage().window().maximize();
		
		//page interactions
		// print the page title
		System.out.println(driver.getTitle());
		
		//Find the ball  
		WebElement ball = driver.findElement(By.id("ball"));
		WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
		WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
		//simulate a click and drag to move it into "Dropzone 1".
		builder.dragAndDrop(ball,dropzone1).pause(3000).build().perform();
		//Verify that the ball has entered Dropzone 1.
		System.out.println(dropzone1.getText());
		//System.out.println(dropzone1.findElement(By.className("dropzone-text")).getText());
		//Once verified, move the ball into "Dropzone 2".
		builder.clickAndHold(ball).moveToElement(dropzone2).release().build().perform();
		//Verify that the ball has entered Dropzone 2.
		System.out.println(dropzone2.getText());
		//Close the browser.
         driver.quit();

}
}