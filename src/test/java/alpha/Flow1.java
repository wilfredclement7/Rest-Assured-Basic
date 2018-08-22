package alpha;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Flow1 {

	@SuppressWarnings("unchecked")
    @Test(priority = 0)
    public void TC_1() {
    	RestAssured.given().when().get("http://localhost:3000/posts/3504").then().statusCode(404);
    	System.out.println("\n" + "Input data not found" + "\n");

		JSONObject json=new JSONObject();
		json.put("id","3504");
		json.put("title","Hello_3504");
		json.put("author","Automation_3504");
		
		RequestSpecification req=RestAssured.given();
		req.header("Content-Type","application/json");
		req.body(json).when();
		Response resp = req.post("http://localhost:3000/posts");
		
		int code = resp.getStatusCode();
		System.out.println("Status Code is : " + code + "\n");
		String body = resp.asString();
		System.out.println("Body is : " + body + "\n");
		Assert.assertEquals(code, 201);
		}
	
	@Test(priority = 1)
	public void TC_2() {
	   	RestAssured.given().when().get("http://localhost:3000/posts/3504").then().statusCode(200);
    	System.out.println("Input data found" + "\n");
	}
}