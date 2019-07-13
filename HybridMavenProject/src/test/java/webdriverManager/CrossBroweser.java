package webdriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBroweser {
	WebDriver driver;
	@Parameters("browserName")
	@BeforeTest
	public void CrossBrowserTest(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
			
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\drivers\\MicrosoftWebDriver.exe");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("IE")) {
			//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\drivers\\IEDriverServer.exe");
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
	}
	@Test
	public void OurWebsiteTest() {
		driver.get("file:///C:/Users/A%20R%20Tarafder/OneDrive/Requirement/Dynamic/OurWebSite.html");
		driver.findElement(By.id("FN")).sendKeys("Ataur");
		driver.findElement(By.id("LN")).sendKeys("Tarafder");
		driver.findElement(By.id("EM")).sendKeys("Ataur@yahoo.com");
		driver.findElement(By.id("AGE")).sendKeys("Ataur@yahoo.com");
		driver.findElement(By.xpath("//*[@id='PW']")).sendKeys("Ataur@yahoo.com");
		
	}
	//@AfterTest
	public void teardown() {
		driver.close();
	}


}
