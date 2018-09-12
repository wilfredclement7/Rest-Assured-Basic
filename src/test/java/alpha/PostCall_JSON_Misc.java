package alpha;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class PostCall_JSON_Misc {

@SuppressWarnings("unchecked")
@Test
public void TC_2()
	{
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type","application/json");
		
        JSONObject requestparams = new JSONObject();
        JSONArray authArray = new JSONArray();
        JSONObject authparam = new JSONObject();

            requestparams.put("Type", "Nothing");

            authparam.put("Value", "value1");
            authparam.put("Key", "key1");
	    authparam.put("Value", "value2");
            authparam.put("Key", "key2");
            authArray.add(authparam);

            requestparams.put("Authentication", authparam);
		
		req.body(requestparams.toJSONString());
		Response resp = req.post("http://localhost:3000/posts");
		
		int code = resp.getStatusCode();
		System.out.println("Status Code is : " + resp);
		String body = resp.asString();
		System.out.println("Body is : " + body);
		Assert.assertEquals(code, 201);
	}
}
