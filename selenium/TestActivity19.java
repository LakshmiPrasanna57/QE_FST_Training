package Activities;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity19 {
	public static void main(String[] args) {
		//Initialize driver
		WebDriver driver = new FirefoxDriver();
		
		// open the browser page
		driver.get("https://training-support.net/webelements/alerts");
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//page interactions
		// print the page title
		System.out.println(driver.getTitle());
		
		//find the print message
		System.out.println(driver.findElement(By.id("result")).getText());
		
		TestActivity19 obj = new TestActivity19();
		//Handle the alert
		obj.handleAlert(driver, "accept");
		System.out.println(driver.findElement(By.id("result")).getText());
		obj.handleAlert(driver, "dismiss");
		System.out.println(driver.findElement(By.id("result")).getText());
		
		//Close the browser.
				driver.quit();
		
       
}
	public void handleAlert(WebDriver driver, String closeType) {
		//Find the button to open a CONFIRM alert and click it.
		driver.findElement(By.id("confirmation")).click();
		//Switch the focus from the main window to the Alert box 
		Alert confirmationAlert = driver.switchTo().alert();
		//get the text in it and print it.
		System.out.println(confirmationAlert.getText());
		switch(closeType) {
		    case "accept":
		    	//Close the alert once with Ok 
		        confirmationAlert.accept();
		     break;
		    case "dismiss":
		        //and again with Cancel.
		        confirmationAlert.dismiss();
		    break;
		    default:
		    	System.out.println("Inavalid close type. cancelling by default");
		//Close the browser.
		driver.quit();
}
	}
}
