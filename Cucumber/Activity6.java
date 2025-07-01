package stepDefinitions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity6  extends BaseClass{
	@Given("user is on the To-Do list page")
	public void openToDoListPage() {
		driver.get("https://training-support.net/webelements/todo-list/");
	}

     @When("user adds the following tasks")
     	public void inputTasks(DataTable inputTasks) throws InterruptedException{
 		//take the list of tasks and convert it into a List<String>
		List<String> tasks = inputTasks.asList();
		System.out.println(tasks);
    	//add the tasks to the page
		for(String task: tasks) {
			//find the text field and type the task description
			driver.findElement(By.id("todo-input")).sendKeys(task);
			//find and click add button
			driver.findElement(By.id("todo-add")).click();
			Thread.sleep(2000);//pause to see the output
		}
	}
	@Then("they can see the task added to the list")
	public void verifyTasks() {
		//Assertions
		List<WebElement> tasksAdded = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//ul/li//h3"), 3));
		assertEquals(5,tasksAdded.size());
	}
}