package alpha;

//import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.*;

public class Post_Hash {

	@SuppressWarnings("all")
    @Test
    public void TC_1() {

		Map<String, Object> map = new HashMap<>();
		map.put("Type", "Nothing");
		map.put("Authentication", Arrays.asList(new HashMap<String, Object>() {{
		    put("Key", "key1");
		    put("Value", "value1");
		}}, new HashMap<String, Object>() {{
		    put("Key", "key2");
		    put("Value", "value2");
		}}
		));
		
		RequestSpecification req=RestAssured.given();
		req.header("Content-Type","application/json");
		req.body(map).when();
		Response resp = req.post("http://localhost:3000/posts");
		
		int code = resp.getStatusCode();
		System.out.println("Status Code is : " + code + "\n");
		String body = resp.asString();
		System.out.println("Body is : " + body + "\n");
		Assert.assertEquals(code, 201);
		}
}