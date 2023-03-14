package httpRequests;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchRequest {
	
	@Test
	public void patchRequest1() {		
		//Create JSON format
		JSONObject jo2 = new JSONObject();
		jo2.put("name", "Kiran3");
		jo2.put("job", "IT Emp3");
		
		System.out.println("JSON Obj2: "+jo2.toString());
		
		baseURI = "https://reqres.in/";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(jo2).
		when().
			patch("/api/users/2").
		then().
		    assertThat().statusCode(200).
		    log().all();
	}
}
