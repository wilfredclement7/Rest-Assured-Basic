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

public class Multiple_Post extends BaseClass 
{

@SuppressWarnings("unchecked")
@Test
public void TC_2()
	{
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type","application/json");
		
		JSONObject json=new JSONObject();
		json.put("id","3000");
		json.put("title","Hello_3000");
		json.put("author","Automation_3000");
		
		req.body(json.toJSONString());
		Response resp = req.post("http://localhost:3000/posts");
		
		int code = resp.getStatusCode();
		System.out.println("Status Code is : " + code);
		String body = resp.asString();
		System.out.println("Body is : " + body);
		Assert.assertEquals(code, 201);
		
		RequestSpecification requ = RestAssured.given();
		requ.header("Content-Type","application/json");
		
		JSONObject jsona=new JSONObject();
		jsona.put("id","4000");
		jsona.put("title","Hello_4000");
		jsona.put("author","Automation_4000");
		
		requ.body(jsona.toJSONString());
		Response respa = requ.post("http://localhost:3000/posts");
		
		int codea = respa.getStatusCode();
		System.out.println("Status Code is : " + codea);
		String bodya = respa.asString();
		System.out.println("Body is : " + bodya);
		Assert.assertEquals(codea, 201);
	}
	
}