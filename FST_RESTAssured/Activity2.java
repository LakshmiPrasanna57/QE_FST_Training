package Activites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Activity2 {

	//POST https://petstore.swagger.io/v2/user
		@Test(priority = 1)
		public void postRequestTest() throws IOException {
					
			//import jsonFile
			 FileInputStream inputJSON = new FileInputStream("src/test/resources/userInfo.json");
			
			//Send request, get response, assert response
			RestAssured.given().
			      baseUri("https://petstore.swagger.io/v2/user").
			      header("Content-Type", "application/json").
			      body(inputJSON).
			   when().
			        post().
			//Assertion
			    then().
			    	body("message", Matchers.equalTo("2628")).
			        body("code", Matchers.equalTo(200));
			//Close the file
			       inputJSON.close();
			
	}
		
		//GET https://petstore.swagger.io/v2/user/{username}
		@Test(priority = 2)
		public void getUserInfo() {
			
			//Import the json file to write it
			File outputJSON = new File("src/test/resources/userResponse.json");
			
			Response response = RestAssured.given()
	        						.baseUri("https://petstore.swagger.io/v2/user")
	        						.header("Content-Type", "application/json")
	        						.pathParam("username", "Lakshmi Prasanna").
	        					when().
	        					  	get("/{username}");
	        	   
			//Get response body
			String resBody = response.getBody().asPrettyString();
			
			try {
				
				//create JSON File
				outputJSON.createNewFile();
				
				//Write response body to external file
				FileWriter writer = new FileWriter(outputJSON.getPath());
				writer.write(resBody);
				writer.close();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
			
			//Assertions
			response.then()
					.body("id", Matchers.equalTo(2628))
					.body("username", Matchers.equalTo("Lakshmi Prasanna"))
					.body("firstName", Matchers.equalTo("Lp"))
					.body("lastName", Matchers.equalTo("Reddymalli"))
					.body("email", Matchers.equalTo("reddymalliprasanna@gmail.com"))
					.body("password", Matchers.equalTo("password@28"))
					.body("phone", Matchers.equalTo("9876543210"));
		}
		
		//DELETE https://petstore.swagger.io/v2/user/{username}
		@Test(priority = 3)
		public void deleteUser() {
			RestAssured.given().
	        			baseUri("https://petstore.swagger.io/v2/user/").
	        			header("Content-Type", "application/json").
	        			pathParam("username", "Lakshmi Prasanna").
	        		when().delete("/{username}").
	        		
	        //Assertions
	        		then().
	        			body("code", Matchers.equalTo(200)).
	        			body("message", Matchers.equalTo("Lakshmi Prasanna"));
	        	
		}
}
