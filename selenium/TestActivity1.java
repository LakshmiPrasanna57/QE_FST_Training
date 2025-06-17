package Activities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestActivity1 {
		public static void main(String[] args) {
			//Initialize driver
			WebDriver driver = new ChromeDriver();
			// WebDriver driver = new FireFoxDriver();
			//   WebDRiver driver = new EdgeDriver();
			// open the browser page
			driver.get("https:training-support.net");
			
			//page interactions
			// print the page title
			System.out.println(driver.getTitle());
			
			// close the browser
			//driver.close();  // closes only the active page in the browser
			driver.quit();  //closes all the tabs that are opened in the browser
		}

	}
