package Activities;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.interactions.Actions;

public class TestActivity15_1 {
		public static void main(String[] args) {
			//Initialize Driver
			
	        WebDriver driver = new FirefoxDriver();
	        Actions builder = new Actions(driver);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			// open the browser page
			driver.get("https://training-support.net/webelements/tables");
			driver.manage().window().maximize();
			
			//page interactions
			// print the page title
			System.out.println(driver.getTitle());
			
			//Find the number of rows and columns in the table and print them.
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			System.out.println("Number of rows:" +rows.size());
			List<WebElement> col = driver.findElements(By.xpath("//table/thead/tr/th"));
			System.out.println("Number of columns:" +col.size());
			//click the  Add row button to add another row.
			driver.findElement(By.xpath("//button[contains(text(),'Add Row')]")).click();
			//Find and edit the newly add row
			String[] dataToAdd = {"10", "Hover car Racer", "Matthew Reilly", "08745672", "$9.57"};
			for(int i=0; i<dataToAdd.length; i++) {
				By lastRowCells = By.xpath("//table/tbody/tr[last()]/td["+(i+1)+"]");
				driver.findElement(lastRowCells).clear();
			    driver.findElement(lastRowCells).sendKeys(dataToAdd[i]);
			    builder.pause(3000);
			}
			
			System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]")).getText());
			
	          //closing the browser
			driver.quit();
			}
}