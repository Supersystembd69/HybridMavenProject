package webdriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToUseWebDriverManager {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		//WebDriverManager.chromedriver().version("75.0.3770.8").setup();
		//driver=new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		
		//WebDriverManager.edgedriver().setup();
		//driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		
	}
	@Test
	public void WebDriverManagerTest() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("firstname")).sendKeys("Hasina");
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}

}