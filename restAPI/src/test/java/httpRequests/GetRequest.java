package httpRequests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

//import static 

public class GetRequest {

	@Test
	public void getRequest1() {

		// Type 1: Get Request
//		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");

		// Type 2: Get Request(define base URI, base path, authentication)
		RestAssured.baseURI = "https://reqres.in";
//		RestAssured.port = 80;
		RestAssured.basePath = "/api";
//		RestAssured.authentication = basic("username", "password");
//		RestAssured.rootPath = "x.y.z";

		Response resp = RestAssured.get("/users?page=2");

		// Print status code
		System.out.println("Status Code: " + resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);

		// Print status line
		System.out.println("Status Line: " + resp.getStatusLine());

		// Print Body
		System.out.println("---------\nResponse Body:\n" + resp.body().asString() + "\n---------");

		// Print Response time
		System.out.println("Response Time: " + resp.getTime());

		// Print header
		System.out.println("Respose Headers:\n" + resp.getHeaders());

	}

	@Test
	public void getRequest2() {

		baseURI = "https://reqres.in";
		basePath = "/api";
		given().
		    get("/users?page=2").
	    then().
	        assertThat().statusCode(200).
	        assertThat().body("data[1].email", equalTo("lindsay.ferguson@reqres.in")).
	        assertThat().body("data[0].id", equalTo(7)).
	        assertThat().header("Content-Type", equalTo("application/json; charset=utf-8")).
	    and().
	        log().all();  //To print complete res on console

	}
//	 get("/lotto").then().assertThat().body("lotto.lottoId", equalTo(5));
}
