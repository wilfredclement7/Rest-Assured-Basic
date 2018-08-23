package alpha;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DataDrivenTC {

    @DataProvider
    public Object[][] ProvideData() throws Exception {
        //open excel file
        Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\wi20022508\\Desktop\\Automation\\TestData.xls"));
        //the required sheet
        Sheet sheet = workbook.getSheet("Sheet1");
        //return number of rows(records)
        int records = sheet.getRows() - 1;
        System.out.println("Body is : " + records + "\n");
        int currentPosition = 1;
        Object[][] values = new Object[records][3];
        for (int i = 0; i < records; i++, currentPosition++) {
            //loop over the rows
            for (int j = 0; j < 3; j++) values[i][j] = sheet.getCell(j, currentPosition).getContents();
        }
        workbook.close();
        return values;
    }

    @Test(dataProvider = "ProvideData")
    public void test_steps(String URL, String reguestMethod, String StatusCode) {
        Response res = null;
        res = RestAssured.given().when().get(URL);
        Assert.assertEquals(Integer.toString(res.statusCode()), StatusCode);

    }

}