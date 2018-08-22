package alpha;

//import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import alpha.BaseClass;
import alpha.ExtentTestManager;
import java.io.*;

public class FetchFromFile extends BaseClass 
{

//@SuppressWarnings("unchecked")
@Test
public void TC_2()
	{
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type","application/json");
		
		File file = new File("C:\\Users\\wi20022508\\Desktop\\Test.json");
			
		req.body(file);
		Response resp = req.post("http://localhost:3000/posts");
		
		int code = resp.getStatusCode();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Status code is : " + code);
		String body = resp.asString();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response content is : " + body);
		Assert.assertEquals(code, 201);
	}
}