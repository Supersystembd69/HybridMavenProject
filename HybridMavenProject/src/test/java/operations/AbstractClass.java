package operations;

import java.io.File;

/**
 * 
 */

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractClass {
	
	protected static WebDriver driver;
	@BeforeTest
	public void SetUp() {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\geckodriver.exe");
		//driver=new FirefoxDriver();
		
		//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\MicrosoftWebDriver.exe");
		//driver=new EdgeDriver();
		
		//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\IEDriverServer.exe");
		//driver=new InternetExplorerDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	public void failed(String testName){
        File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\CaptureShot\\"+testName+".png"));
        }catch (Exception e){
            e.printStackTrace();

        }
    }
	
	
}
