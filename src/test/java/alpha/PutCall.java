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

public class PutCall extends BaseClass 
{

@SuppressWarnings("unchecked")
@Test
public void TC_3()
	{
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type","application/json");
		
		JSONObject json=new JSONObject();
		json.put("title","Hello_6_changed_to_Hello_8");
		json.put("author","Automation_6_to_Automation_8");
		
		req.body(json.toJSONString());
		Response resp = req.put("http://localhost:3000/posts/6");
		
		int code = resp.getStatusCode();
		System.out.println("Status Code is : " + code);
		String body = resp.asString();
		System.out.println("Body is : " + body);
		Assert.assertEquals(code, 200);
	}
	
}