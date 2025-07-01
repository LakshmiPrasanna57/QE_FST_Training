package Activites;
import java.util.HashMap;
import java.util.Map;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class RestApiGit {
	RequestSpecification req;
	ResponseSpecification res;
	int keyId;
	@BeforeClass
	public void setUp() {
		req = new RequestSpecBuilder().setBaseUri("https://api.github.com/user/keys")
				.addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "token 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 ")
				.build();
		res = new ResponseSpecBuilder()
				. expectBody("title",Matchers.equalTo("TitleKey"))// Assertion for title
				. expectBody("key",Matchers.equalTo("ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDoaGdtSHYchDtC9ffl3t1x0jkGn0nXCvLnMxN/J9tY+VO1/H1w89Hhb0zyOTsvfNZ7jcd2WK6ZVSywoPzOg4JRCrY/Jte6eZQ0eBAe8eFoclcKcOdeoy4MPT+A8VeZiSshxTaIGr+ohWIXk+q6pZb2nvXiswEdC62Jrn/wMZ2V99AMkjLi4hTia5wCfv1way6ZyhXkPeUc1m7AP6yExsa1xC0fJJVZf0ni4ihLaYUT1AJfo4IXAOHB+XsHEk1hz0LXbVdUiLshDvHgI+ZAcqasIMj5kHJeybjiMLp6PNeI8Szi3G/bL6+HtC+79EYgrIpG6Fgnp09KeAUvEzeHVsLL"))// Assertion for key
				.expectResponseTime(Matchers.lessThan(5000L))
				.build();
	}
	@Test(priority = 1)
	public void postRequest() {
		Map<String, Object> key = new HashMap<>();
		key.put("title", "TitleKey");
		key.put("key","ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDoaGdtSHYchDtC9ffl3t1x0jkGn0nXCvLnMxN/J9tY+VO1/H1w89Hhb0zyOTsvfNZ7jcd2WK6ZVSywoPzOg4JRCrY/Jte6eZQ0eBAe8eFoclcKcOdeoy4MPT+A8VeZiSshxTaIGr+ohWIXk+q6pZb2nvXiswEdC62Jrn/wMZ2V99AMkjLi4hTia5wCfv1way6ZyhXkPeUc1m7AP6yExsa1xC0fJJVZf0ni4ihLaYUT1AJfo4IXAOHB+XsHEk1hz0LXbVdUiLshDvHgI+ZAcqasIMj5kHJeybjiMLp6PNeI8Szi3G/bL6+HtC+79EYgrIpG6Fgnp09KeAUvEzeHVsLL");
		Response response = RestAssured.given().
				spec(req).
				body(key).
				log().all().
		when().
			post();
		keyId = response.
					then().
					statusCode(201).
					body("title", Matchers.equalTo("TitleKey")).
					spec(res).
					log().all().
					extract().
					path("id");
		//response.then().statusCode(Matchers.anyOf(Matchers.equalTo(200), Matchers.equalTo(202)));
	}
	@Test(priority = 2)
	public void getRequest() {
		RestAssured.given().
			spec(req).
			pathParam("keyId", keyId).
			log().all().
		when().
			get("/{keyId}").
		then().
			statusCode(200).
			body("title", Matchers.equalTo("TitleKey")).
			spec(res).
			log().all();
	}
	@Test(priority = 3)
	public void deleteRequest() {
		RestAssured.given().
			spec(req).
			pathParam("keyId", keyId).
			log().all().
		when().
			delete("/{keyId}").
		then().
		statusCode(204).
		log().all();
	}
}