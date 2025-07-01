package Examples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationsTest {
	
	//Declare request and response specification objects;
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int petId;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		//Build requestSpec
		requestSpec = new RequestSpecBuilder(). 
			setBaseUri("https://petstore.swagger.io/v2/pet"). 
			addHeader("Content-Type", "application/json").//setContentType(ContentType.json)
			addHeader("Accept", "application/json").
			//addHeader("Authorization", token ghp_OU!H#UIPLKJHGiknykjh49185")
	    build();
		
		//Build ResponseSpec
        URL jsonSchema = new URL("https://petstore.swagger.io/v2/swagger.json");
		responseSpec = new ResponseSpecBuilder(). 
			expectStatusCode(200).
			expectBody(JsonSchemaValidator.matchesJsonSchema(jsonSchema)).
			expectBody("status", Matchers.equalTo("alive")).
			expectResponseTime(Matchers.lessThanOrEqualTo(5000L)).			           
		build();
	}
	
    //POST https://petstore.swagger.io/v2/pet
	@Test(priority=1)
	public void postRequestTest(){
		//create the request body
		HashMap<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 34521);
		reqBody.put("name","Retriver");
		reqBody.put("status","alive");
		
		//send the request, get response, assert response
		Response response =RestAssured.given().
		  spec(requestSpec).
		  body(reqBody).
		  when().post();
		 // Extracting the petId value
		 petId = response.then().extract().path("id");
		 //Assertion
		 response.then().
		  spec(responseSpec);
	}
	
	 //GET https://petstore.swagger.io/v2/pet/{petId}
	
	@Test(priority=2)
	public void getRequetWithParam() {
		//send request , get response, assert response
		RestAssured.given().
		   spec(requestSpec).
		   pathParam("petId", petId).
	    when().
		  get("/{petId}").
		then().
		spec(responseSpec);		
	}
	
	//DELETE https://petstore.swagger.io/v2/pet/{petId}
	
	@Test(priority=3)
	public void deleteRequetTest() {
	//send request , get response, assert response
		RestAssured.given().
			spec(requestSpec).
			pathParam("petId", petId).
		when().
			delete("/{petId}").
		then().			 	
			statusCode(200).
			body("message", Matchers.equalTo(""+petId));
	}
}
