package testCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class windowhandle {
	WebDriver driver;
	
	@Test
	public void WindowTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\All Driver\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
		driver.get("file:///E:/WebSite/SuperTech.html");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("Social Media"))).build().perform();
		driver.findElement(By.linkText("Google")).click();
		
		ArrayList<String>newTab = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(newTab.get(1));
	    driver.findElement(By.name("q")).sendKeys("Bangladesh");
	    //driver.close();
	    driver.switchTo().window(newTab.get(0));
	    driver.findElement(By.xpath("//*[@id=\"btnConfirm\"]")).click();
	}

}
