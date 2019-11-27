package excelReaderPack;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import operations.AbstractClass;
import operations.ReadObject;
import operations.UIOperation;



public class ExcelDataProviderTest extends AbstractClass {
	
	private String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx";
    private String sheetName = "Data1";
    
    @Test(dataProvider = "FacebookData")
    public void UnderTest(String testcaseID, String testcaseName, String keyword, String objectName, String objectType, String data) throws Exception {
        
		ReadObject object = new ReadObject();
		Properties allObjects = object.getObjectRepository();
		UIOperation operation = new UIOperation(driver);   
		operation.KeyWordperform(allObjects, keyword, objectName, objectType, data);
		//logger.info("Perform success");
	     
	}
	
	
	@DataProvider(name="FacebookData")
	public Object[][] readExcel() throws IOException {
        return ExcelFileReader.readExcel(filePath, sheetName);
    }

}
