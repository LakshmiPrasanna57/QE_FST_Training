package Activities;

import java.util.stream.Collector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class TestActivity4 {
	public static void main(String[] args) {
		//Initialize driver
		
		 WebDriver driver = new FirefoxDriver();
		
		// open the browser page
		driver.get("https://training-support.net/webelements/target-practice");
		
		//page interactions
		// print the page title
		System.out.println(driver.getTitle());
		
		//the 3rd header on the page and print it's text to the console.
		String h3 =driver.findElement(By.xpath ("//h3[@class=\'text-3xl font-bold text-orange-600\']")).getText();
		                                     //("//h3[text() = 'Heading #3']")).
		System.out.println("text:" + h3);
		
		//the 5th header on the page and print it's color.
        String h5 =driver.findElement(By.xpath("//h5[@class=\'text-3xl font-bold text-purple-600\']")).getCssValue("color");
                                               //("//h5[text() = 'Heading #5']")).
        System.out.println("Color:" + h5);
        //Color headingColor = Color.fromString(driver.findElement(By.xpath("//h5[text()='Heading #5']")).getCssValue("color");
        //System.out.println("HexaDecimal Value of color=" + Color.asHex());
        
        //the purple button and print all it's classes.
        String Purple= driver.findElement(By.className("bg-purple-200")).getAttribute("class");
        System.out.println("Purple button:" +Purple);
        
        //the slate button and print it's text.
        String Slate = driver.findElement(By.className("bg-slate-200")).getText();
        System.out.println("Slate button text:" +Slate);
        
        //close the browser.
        driver.quit();
}
}
