package alpha;

import java.io.File;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import alpha.Input;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Flow4 {

    @DataProvider
    public Object[][] ProvideData() throws Exception {
        Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\wi20022508\\eclipse-workspace\\Rest-Assured\\Automation\\TestData.xls"));
        Sheet sheet = workbook.getSheet("Sheet3");
        int records = sheet.getRows() - 1;
        System.out.println("Body is : " + records + "\n");
        int currentPosition = 1;
        Object[][] values = new Object[records][11];
        for (int i = 0; i < records; i++, currentPosition++) {
            for (int j = 0; j < 11; j++) values[i][j] = sheet.getCell(j, currentPosition).getContents();
        }
        workbook.close();
        return values;
    }
      
	@SuppressWarnings("all")
    @Test(dataProvider = "ProvideData")
    public void test_steps(String ID, String Type, String Name, String Batter1I, String Batter1T, String Batter2I, String Batter2T, String Topping1I, String Topping1T, String Topping2I, String Topping2T) throws Exception {
    	
	    Input user = new Input();
	    user.setId(ID);
	    user.setType(Type);
	    user.setName(Name);
	    user.setPpu(0.55);

	    Batter batter1 = new Batter();
	    batter1.setId(Batter1I);
	    batter1.setType(Batter1T);

	    Batter batter2 = new Batter();
	    batter2.setId(Batter2I);
	    batter2.setType(Batter2T);

	    Batters batters = new Batters();
	    batters.setBatter(Arrays.asList(batter1, batter2));
	    user.setBatters(batters);
	    
	    Topping topping1 = new Topping();
	    topping1.setId(Topping1I);
	    topping1.setType(Topping1T);

	    Topping topping2 = new Topping();
	    topping2.setId(Topping2I);
	    topping2.setType(Topping2T);

	    user.setTopping(Arrays.asList(topping1, topping2));

	    ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);

	    String json = mapper.writeValueAsString(user);
	      	
		RequestSpecification req=RestAssured.given();
		req.header("Content-Type","application/json");
		req.body(json).when();
		Response resp = req.post("http://localhost:3000/posts");
    	
		int code = resp.getStatusCode();
		System.out.println("Status Code is : " + code + "\n");
		String body = resp.asString();
		System.out.println("Body is : " + body + "\n");
		Assert.assertEquals(code, 201);
    }
}