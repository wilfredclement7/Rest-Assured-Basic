package alpha;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import alpha.BaseClass;
import alpha.ExtentTestManager;

public class DeleteCall extends BaseClass 
{

@Test
public void TC_4()
	{
		RequestSpecification req = RestAssured.given();
		Response resp = req.delete("http://localhost:3000/posts/4");
	
		int code = resp.getStatusCode();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Status code is : " + code);
		Assert.assertEquals(code, 200);
	}
}