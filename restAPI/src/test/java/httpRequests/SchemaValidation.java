package httpRequests;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class SchemaValidation {
	
	@Test
	public void validateJSON() {
		baseURI = "https://reqres.in/";
		given().
			get("/api/users?page=2").
		then().
		    body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/schema.json.txt"))).
		    statusCode(200).
		    log().all();
	}
}
