
package testCases;

import java.io.File; import java.io.FileInputStream; import
java.io.IOException; import java.util.Properties; import
org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook; import
org.apache.poi.xssf.usermodel.XSSFWorkbook; import
org.testng.annotations.DataProvider; import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import operations.AbstractClass; import operations.ReadObject; import
operations.UIOperation;

@Listeners(CustomScreenShot.class) 
public class HybridExceutTestCase extends AbstractClass{



	@Test(dataProvider="hybridData") 
	public void UnderTest(String testcaseID,String testcaseName, String keyword, String objectName, String objectType,String data) throws Exception {

		ReadObject object = new ReadObject();
		Properties allObjects =
				object.getObjectRepository(); 
		UIOperation operation = new
				UIOperation(driver); operation.KeyWordperform(allObjects, keyword,
						objectName, objectType, data); //logger.info("Perform success");

	} 
	@DataProvider(name="hybridData") 
	public Object[][] getDataFromDataprovider() throws IOException{
		Object[][] object = null;

	File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData","TestData.xlsx"); 
	//File file=new File("https://docs.google.com/spreadsheets/d/1HSvrZZN21zxMPhFBwKXv_Jk4EHEDoaO36KdLx5K_Icg/edit#gid=0"); 
	FileInputStream fis=new FileInputStream(file);

	Workbook wb = new XSSFWorkbook(fis); 
	Sheet ws = wb.getSheet("Data1");

	int rowCount = ws.getLastRowNum()- ws.getFirstRowNum(); 
	
	int colCount=ws.getRow(0).getLastCellNum();

	object = new Object[rowCount][colCount];

		for (int i = 0; i <rowCount; i++) {
	
			Row row = ws.getRow(i+1);
	
			for (int j = 0; j < row.getLastCellNum(); j++) {
	
				object[i][j] = row.getCell(j).toString(); 
			} 
		}

		return object;
	}

}
