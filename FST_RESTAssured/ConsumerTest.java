package Activites;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.RestAssured;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
	//Create a headers map
	Map<String, String> headers= new HashMap<>();
	
	//create the contract
	@Pact(consumer = "userconsumer", provider = "userprovider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		//set header values
		headers.put("Content-Type", "application/json");
		
		//create JSON body
		DslPart reqResBody = new PactDslJsonBody(). 
				numberType("id", 57). 
				stringType("firstName", "Lakshmi").
				stringType("lastName","Reddymalli").
				stringType("email", "lp@example.com");
		
		//Build the Fragment(interaction)
		return builder.
				//Fragment start
				given("POST request").
				uponReceiving("Upon a requesting to create a user").
				  method("POST").
				  path("/api/users").
				  headers(headers).
				  body(reqResBody).
				willRespondWith().
				   status(201).
				   body(reqResBody).
			//End of fragment   
				 toPact();
	}
	
	@Test
	@PactTestFor(providerName = "userprovider", port= "8587") //Create the mock server at the local host:8587
	public void postRequestTest() {
		//Create request body
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 57);
		reqBody.put("firstName","Lakshmi");
		reqBody.put("lastName","Reddymalli");
		reqBody.put("email","lp@example.com");
		
		//send request, get response, log response
		RestAssured.given().
		    baseUri("http://localhost:8587/api/users").
		    headers(headers).
		    body(reqBody).
		    log().all().
		    when().post().
		    then().
		     statusCode(201).
		     body("firstName", Matchers.equalTo("Lakshmi"));		
	}

}
