package Activites;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	//WebDriver declaration
			WebDriver driver;
		  //WebDriverWait declaration
			WebDriverWait wait;
			
	    @BeforeClass(alwaysRun = true)	
		public void setUp() {
			//Initialize driver
			 driver = new FirefoxDriver();
			//Initialize wait
			 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 
			 //open the page
			 driver.get("https://training-support.net/webelements/target-practice");
		}
	    
	    @Test(groups = {"HeaderTests", "ButtonTests"})
		public void pageTitleTest() {
			String title = driver.getTitle();
			System.out.println("Title is:" + title);
			Assert.assertEquals(title, "Selenium: Target Practice");
	    }
			
	    
	    @Test(dependsOnMethods = {"pageTitleTest"}, groups= {"HeaderTests"})
		public void HeaderTest1() {
	    	WebElement h3 =driver.findElement(By.xpath(("//h3[text() = 'Heading #3']")));
            Assert.assertEquals(h3.getText(), "Heading #3");
		}
	    
	   
	    @Test(dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
		public void HeaderTest2() {  
       	    Color h5 = Color.fromString(driver.findElement(By.xpath(("//h5[text() = 'Heading #5']"))).getCssValue("color"));
	        Assert.assertEquals(h5.asHex(),"#9333ea");
	    }
	    
		@Test(dependsOnMethods = {"pageTitleTest"}, groups= {"ButtonTests"})
		public void ButtonTest1(){
			WebElement button1 = driver.findElement(By.xpath("//button[contains(@class,'emerald')]"));
			Assert.assertEquals(button1.getText(), "Emerald");
			
		}
		
		@Test(dependsOnMethods = {"pageTitleTest"}, groups= {"ButtonTests"})
		public void ButtonTest2(){
			Color button2color = Color.fromString(driver.findElement(By.cssSelector("button.text-purple-900")).getCssValue("color"));
			Assert.assertEquals(button2color.asHex(), "#581c87");
		}
	    
	
	    @AfterClass(alwaysRun = true)
		public void tearDown() {
			//close the browser
			driver.quit();
		}

}
