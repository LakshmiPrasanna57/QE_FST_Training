package Activites;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;

public class TouchScreen {
	
	public static void main(String[] args) {
        // Initialize driver
        WebDriver driver = new FirefoxDriver();
        // Open page
        driver.get("https://training-support.net/webelements/infinite-scrolling");

        // Get page dimensions
        Dimension dims = driver.manage().window().getSize();
        Point scrollStart = new Point((int) (dims.width * .5), (int) (dims.height * .25));
        Point scrollEnd = new Point((int) (dims.width * .5), (int) (dims.height * .75));

        // Press down on the page and move the pointer
        new Actions(driver)
                .setActivePointer(PointerInput.Kind.TOUCH, "finger")
                .moveToLocation(scrollStart.getX(), scrollStart.getY())
                .clickAndHold()
                .moveToLocation(scrollEnd.getX(), scrollEnd.getY())
                .release()
                .pause(5000) // Just ot see the scroll
            .build().perform();

        // Close the browser
        driver.quit();
    }

}
