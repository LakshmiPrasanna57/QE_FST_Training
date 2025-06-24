package Project_CRM;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Activity9 {
	WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to your WebDriver executable
 
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    
    @Test(priority=1)
    public void verifyPageTitle() {
        // Get the actual title of the webpage
        String pageTitle = driver.getTitle();

        // Print the title to the console
        System.out.println("Page title is: " + pageTitle);

        // Assertion to verify the title matches "SuiteCRM"
        Assert.assertEquals(pageTitle, "SuiteCRM");
    }


    @Test(priority=2)
    public void extractLeads() throws InterruptedException {
        driver.get("http://alchemy.hguy.co/crm");

        // Perform login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click(); // Replace with actual login button selector

        // Wait and navigate to Sales → Leads
        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.xpath("//a[@id='moduleTab_9_Leads']")).click();

        // Locate the table and extract Name and User columns
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
        int count = Math.min(10, rows.size());

        System.out.println("First 10 Leads (Name | User):");
        for(int i =0; i < Math.min (10, rows.size()); i++) {
       
            String name = rows.get(i).findElement(By.xpath("./td[3]/b/a")).getText();// Adjust index as per actual table structure
            String user = rows.get(i).findElement(By.xpath("./td[8]")).getText();
            System.out.println((i + 1) + ". " + name + " | " + user);
        }
        //Assertions
        Assert.assertTrue(rows.size() <= 10, "Fewer than 10 leads available.");
     

    }

   @AfterClass
   public void tearDown() {
       driver.quit();
    
}

}
