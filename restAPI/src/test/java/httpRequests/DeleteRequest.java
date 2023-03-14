package httpRequests;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteRequest {
	
	@Test
	public void deleteRequest1() {		
		baseURI = "https://reqres.in/";
		when().
			delete("/api/users/2").
		then().
		    assertThat().statusCode(204).
		    log().all();
	}
}
