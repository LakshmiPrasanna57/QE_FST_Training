package Activites;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RequestTest {
	//POST https://petstore.swagger.io/v2/pet
	@Test(priority=1)
	public void postRequestTest(){
		//create the request body
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 34521);
		reqBody.put("name","Retriver");
		reqBody.put("status","alive");
		//send the request, get response, assert response
		RestAssured.given().
		  baseUri("https://petstore.swagger.io/v2/pet").
		  header("Content-Type", "application/json").
		  body(reqBody).
		  when().
		    post().
		  then().
		     statusCode(200).
		     body("name", Matchers.equalTo("Retriver")).
		     body("status", Matchers.equalTo("alive"));
	}
	
	//PUT https://petstore.swagger.io/v2/pet
	@Test(priority=2)
	public void putRequestTest(){
		//create the request body
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 34521);
		reqBody.put("name","puppy");
		reqBody.put("status","alive");
		//send the request, get response, assert response
		RestAssured.given().
		  baseUri("https://petstore.swagger.io/v2/pet").
		  header("Content-Type", "application/json").
		  body(reqBody).
		  when().
		    put().
		  then().
		     statusCode(200).
		     body("name", Matchers.equalTo("puppy")).
		     body("status", Matchers.equalTo("alive"));
	}
	
	//GET https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority=3)
	public void getRequetWithParam() {
		//send request , get response, assert response
		RestAssured.given().
		   baseUri("https://petstore.swagger.io/v2/pet").
		   header("Content-Type", "application/json").
		   pathParam("petId", 34521).
		   log().all().
		when().
		get("/{petId}").
		then().
		log().all().
		statusCode(200).
		body("name", Matchers.equalTo("puppy")).
		body("status",Matchers.equalTo("alive"));
		
	}
	//DELETE https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority=4)
	public void deleteRequetTest() {
	//send request , get response, assert response
			RestAssured.given().
			   baseUri("https://petstore.swagger.io/v2/pet").
			   header("Content-Type", "application/json").
			   pathParam("petId", 34521).
			   log().all().
			when().
			delete("/{petId}").
			then().
			log().all().
			statusCode(200).
			body("message", Matchers.equalTo("34521"));
			
	}
}
