package alpha;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import alpha.BaseClass;
import alpha.ExtentTestManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Car_Serialize extends BaseClass {

	Car_Pojo myCar = new Car_Pojo("Maruti","DB10",2018);
	
    @Test
    public void Serialization()
	{
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type","application/json");
		req.body(myCar);
		
		Response resp = req.post("http://localhost:3000/posts");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is : " + resp);
		
		int code = resp.getStatusCode();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Status code is : " + code);
		Assert.assertEquals(code, 201);
	}
}