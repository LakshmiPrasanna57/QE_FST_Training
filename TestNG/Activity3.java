package Activites;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	  //WebDriver declaration
		WebDriver driver;
	  //WebDriverWait declaration
		WebDriverWait wait;
		
    @BeforeClass		
	public void setUp() {
		//Initialize driver
		 driver = new FirefoxDriver();
		//Initialize wait
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
		 //open the page
		 driver.get("https://training-support.net/webelements/login-form/");
	}
	
    @Test(priority = 1)
	public void verifyPageTitle() { 
		//assert the page title
		assertEquals(driver.getTitle(), "Selenium: Login Form");
	}
	@Test(priority =2)
	public void loginFailTest() {
		//find username and password
		driver.findElement(By.id("username")).sendKeys("admin");
		//enter the password
		driver.findElement(By.id("password")).sendKeys("wrongPassword");
		// click on submit button
		 driver.findElement(By.xpath("//button[text()= 'submit']")).click();
		 //find and print error message
		 String message = driver.findElement(By.id("subheading")).getText();
		 //assertions
		assertEquals(message, "Invalid credentials");
	}
	
	@Test(priority =3)
	public void loginSucessPage () { 
		//find and enter the username
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");
		//enter the password
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("password");
		// click on submit button
		 driver.findElement(By.xpath("//button[text()= 'Submit']")).click();
		 //find and print the success message
		 String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.text-emerald-500"))).getText();
		 //assertions
		assertEquals(message, "Login Success!");
		
	}
	
	
	@AfterClass
	public void tearDown() {
		//close the browser
		driver.quit();
	}
}
