package httpRequests;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequest {
	
	@Test
	public void getRequest1() {
		//converting map into JSON format
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Ashok");
		map.put("job", "Share Market");
		
		JSONObject jo1 = new JSONObject(map); 
		System.out.println("JSON Obj1: "+jo1.toString());
		
		
		//Create JSON format
		JSONObject jo2 = new JSONObject();
		jo2.put("name", "Kiran");
		jo2.put("job", "IT Emp");
		
		System.out.println("JSON Obj2: "+jo2.toString());
		
		baseURI = "https://reqres.in/";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(jo2).
		when().
			post("/api/users").
		then().
		    assertThat().statusCode(201).
		    log().all();
	}
}
