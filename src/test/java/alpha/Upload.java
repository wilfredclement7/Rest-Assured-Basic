package alpha;

import org.testng.annotations.Test;
//import org.junit.Test;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import alpha.BaseClass;
import alpha.ExtentTestManager;
import java.io.*;

public class Upload extends BaseClass {

    @Test
    public void TC_1() {
        String response = RestAssured.given().multiPart("file2", new File("C:\\Users\\wi20022508\\Desktop\\Test.json")).
        when().post("http://localhost:3000/posts").then().extract().asString();
        System.out.println("Response is : " + response);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Response is : " + response); 
        }
}