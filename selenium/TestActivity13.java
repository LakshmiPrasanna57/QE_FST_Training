package Activities;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestActivity13 {
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
		//Find and print all the cell values in the third row of the table.
		List<WebElement> thirdRow = driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
		/*for (WebElement cell: thirdRow) {
			System.out.println(cell.getText());
		}*/
		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[3]")).getText());
		//Find and print the cell value at the second row second column.
		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText());
		//Close the browser.
		driver.quit();
	}

}
