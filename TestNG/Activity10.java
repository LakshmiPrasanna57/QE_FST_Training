package Activites;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity10 {
	// WebDriver declaration
	WebDriver driver;
	// WebDriverWait declaration
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize driver
		driver = new FirefoxDriver();
		// Initialize wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// open the page
		driver.get("https://training-support.net/webelements/simple-form");
	}

	public static List<List<String>> readExcel(String filePath) {
		// create the main dataset
		List<List<String>> data = new ArrayList<>();
		try {
			// open the .xlsx file for reading
			FileInputStream file = new FileInputStream(filePath);

			// create the workbook object
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// create the sheet object
			XSSFSheet sheet = workbook.getSheetAt(1);
			// or XSSFSheet sheet = workbook.getSheet(Sheet1);
			// Iterate through the rows
			for (Row cells : sheet) {
				// Temp list for inner rows
				List<String> rowData = new ArrayList<>();
				// Iterate through each cell in the row
				for (Cell cell : cells) {
					// Add cell data to temp list
					rowData.add(cell.getStringCellValue());
				}
				// Add rowData to data (Inner list is added to outer list)
				data.add(rowData);
			}
			// close the workbook
			workbook.close();
			// close the input stream
			file.close();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// Return data to dataProvidet
		return data;
	}

	@DataProvider(name = "Events")
	public static Object[][] signUpInfo() {
		// set the file path for the input file
		String filePath = "src/test/resources/LakshmiTestCaseTemplate.xlsx";
		// Get the data from the input file
		List<List<String>> data = readExcel(filePath);
		// Return data to the test function
		return new Object[][] { { data.get(1) }, { data.get(2) }, { data.get(3) }, { data.get(4) }

		};

	}

	@Test(dataProvider = "Events")
	public void registerTest(List<String> rows) throws InterruptedException {
		System.out.println();
		// wait for the form to load
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() ='Submit']")));
		// find the full name field and enter the input value
		driver.findElement(By.id("full-name")).clear();
		driver.findElement(By.id("full-name")).sendKeys(rows.get(0));
		// find the email field and enter the input value
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(rows.get(1));
		// find the event-date field and enter the input value
		driver.findElement(By.name("event-date")).clear();
		// by using rejax we will find the double"" and replace with it nothing
		driver.findElement(By.name("event-date")).sendKeys(rows.get(2).replaceAll("\"", ""));
		// find the field and enter the input value
		driver.findElement(By.id("additional-details")).clear();
		driver.findElement(By.id("additional-details")).sendKeys(rows.get(3));
		// find the submit button
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		// Assertion
		String message = driver.findElement(By.id("action-confirmation")).getText();
		assertEquals(message, "Your event has been scheduled!");
		// Refresh page
		driver.navigate().refresh();

	}

	@AfterClass
	public void tearDown() {
		// close the browser
		driver.quit();
	}

}
