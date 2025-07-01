package Examples;

import static org.testng.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstTest {
	//GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
	@Test
	public void getRequestWithQueryParam() {
		//send request, save the response
		Response response = 
				RestAssured.given(). //reuest spec
				   baseUri("https://petstore.swagger.io/v2/pet").
				   header("Content-Type", "application/json").
				   queryParam("status", "sold"). 
				when().  //for readabilty its not manditory
				   get("/findByStatus");
		
		//print response status code
		System.out.println("Status code:" +response.statusLine());
		System.out.println("Status code:" +response.statusCode());
		//print response headers
		System.out.println("Response header" +response.getHeaders().asList());
		//print response body
		System.out.println("Response body" +response.getBody().asString());
		System.out.println("Response body" +response.getBody().asPrettyString());
		
		//Extract property from response body
		String petName =response.then().extract().path("[0].name");
		//Assertions
		assertEquals(petName, "Fido");
		
		//RESTAssured assertion
		response.then().
		statusCode(200).
		body("[0].name", Matchers.equalTo("Fido")).
		body("[0].status",Matchers.equalTo("sold"));
	}		
	
    // GET https://petstore.swagger.io/v2/pet/{petId}
	@Test
	public void getRequetWithParam() {
		//send request , get response, assert response
		RestAssured.given().
		   baseUri("https://petstore.swagger.io/v2/pet").
		   header("Content-Type", "application/json").
		   pathParam("petId", 12).
		   log().all().
		when().
		get("/{petId}").
		then().
		log().all().
		statusCode(200).
		body("name", Matchers.equalTo("Fido")).
		body("status",Matchers.equalTo("sold"));
		
	}
 
}
