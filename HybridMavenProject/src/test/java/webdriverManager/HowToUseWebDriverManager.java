package webdriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToUseWebDriverManager {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().version("75.0.3770.8").setup();
		driver=new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();
		//WebDriverManager.iedriver().setup();
		//driver=new InternetExplorerDriver();
		
		//WebDriverManager.edgedriver().setup();
		//driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		
		//implicitly wait one time it will work for every steps
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Page loadTimeOut will for every page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		//Sets the amount of time to wait for an synchronous script to finish execution before throwing an error. 
		//If the timeout is negative, then the script will be allowed to run indefinitely
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		 
		
	}
	@Test
	public void WebDriverManagerTest() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("firstname")).sendKeys("Hasina");
		//Explicit wait at specific step
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"u_0_1b\"]")));
		
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}

}