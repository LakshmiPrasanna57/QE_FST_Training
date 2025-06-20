package Activities;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_FileUpload {
public static void main(String[] args) {
			// TODO Auto-generated method stub

			WebDriver driver = new FirefoxDriver();
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

			// Open the browser or page
		    driver.get("https://training-support.net/webelements/file-upload");
		    driver.manage().window().maximize();

		    // print the page title
			System.out.println(driver.getTitle());

			//Enter the absolute file path
			File fileUpload = new File("src/test/resources/flower.jpg");

			//Upload the file
			driver.findElement(By.id("file")).sendKeys(fileUpload.getAbsolutePath());

			driver.findElement(By.cssSelector("button.svelte-m6d1rg")).click();

			//print the message after uploading file
			System.out.println(driver.findElement(By.id("result")).getText());
			
			//close the browser
			//driver.quit();

	}

}
