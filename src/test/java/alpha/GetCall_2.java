package alpha;

import org.testng.annotations.Test;
//import org.junit.Test;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import alpha.BaseClass;
import alpha.ExtentTestManager;

public class GetCall_2 extends BaseClass {

    @Test
    public void TC_2() {
    	String response = RestAssured.get("http://127.0.0.1:3000/posts/2").then().extract().asString();
    	ExtentTestManager.getTest().log(LogStatus.INFO, "Response is : " + response); 
}
}