package alpha;

import org.testng.annotations.Test;
//import org.junit.Test;
//import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import alpha.BaseClass;
//import alpha.ExtentTestManager;

public class GetCall extends BaseClass {

    @Test
    public void TC_1() {
        RestAssured.baseURI = "http://127.0.0.1:3000/posts/50";
        String response = RestAssured.given().
        when().get().then().extract().asString();
        System.out.println("Body is : " + response);
        //ExtentTestManager.getTest().log(LogStatus.INFO, "Response is : " + response); 
        }
}