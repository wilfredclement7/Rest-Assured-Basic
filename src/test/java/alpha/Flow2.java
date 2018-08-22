package alpha;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;

public class Flow2 {

	@SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void TC_1() {

		Map<String, Object> map = new HashMap<>();
		map.put("Type", "Something");
		map.put("Authentication", asList(new HashMap<String, Object>() {{
		    put("Key", "key1");
		    put("Value", "value1");
		}}, new HashMap<String, Object>() {{
		    put("Key", "key2");
		    put("Value", "value2");
		}}, new HashMap<String, Object>() {{
		    put("Key", "key3");
		    put("Value", "value3");
		}}));		

		RequestSpecification req=RestAssured.given();
		req.header("Content-Type","application/json");
		//req.body(json).when();
		Response resp = req.post("http://localhost:3000/posts");
		
		int code = resp.getStatusCode();
		System.out.println("Status Code is : " + code + "\n");
		String body = resp.asString();
		System.out.println("Body is : " + body + "\n");
		Assert.assertEquals(code, 201);
		}
}