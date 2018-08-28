package alpha;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Flow3_Hash {

    @DataProvider
    public Object[][] ProvideData() throws Exception {
        Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\wi20022508\\Desktop\\Automation\\TestData.xls"));
        Sheet sheet = workbook.getSheet("Sheet2");
        int records = sheet.getRows() - 1;
        System.out.println("Body is : " + records + "\n");
        int currentPosition = 1;
        Object[][] values = new Object[records][5];
        for (int i = 0; i < records; i++, currentPosition++) {
            for (int j = 0; j < 5; j++) values[i][j] = sheet.getCell(j, currentPosition).getContents();
        }
        workbook.close();
        return values;
    }
    
	@SuppressWarnings("all")
    @Test(dataProvider = "ProvideData")
    public void test_steps(String Type, String Key1, String Value1, String Key2, String Value2) {
    	
		Map<String, Object> map = new HashMap<>();
		map.put("Type", Type);
		map.put("Authentication", Arrays.asList(new HashMap<String, Object>() {{
		    put("Key", Key1);
		    put("Value", Value1);
		}}, new HashMap<String, Object>() {{
		    put("Key", Key2);
		    put("Value", Value2);
		}}
		));
    	
		RequestSpecification req=RestAssured.given();
		req.header("Content-Type","application/json");
		req.body(map).when();
		Response resp = req.post("http://localhost:3000/posts");
    	
		int code = resp.getStatusCode();
		System.out.println("Status Code is : " + code + "\n");
		String body = resp.asString();
		System.out.println("Body is : " + body + "\n");
		Assert.assertEquals(code, 201);
		
        //Response res = RestAssured.given().when().get(URL);
        //Assert.assertEquals(Integer.toString(res.statusCode()), StatusCode);
    }
}