package alpha;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
//import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import alpha.BaseClass;
//import alpha.ExtentTestManager;

public class PostCall extends BaseClass 
{

@SuppressWarnings("unchecked")
@Test
public void TC_2()
	{
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type","application/json");
		
		JSONObject json=new JSONObject();
		json.put("id","102");
		json.put("title","Hello_102");
		json.put("author","Automation_102");
		
		req.body(json.toJSONString());
		Response resp = req.post("http://localhost:3000/posts");
		
		int code = resp.getStatusCode();
		System.out.println("Status Code is : " + resp);
		String body = resp.asString();
		System.out.println("Body is : " + body);
		Assert.assertEquals(code, 201);
	}
	
}