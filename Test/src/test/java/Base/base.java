package Base;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Helper.helper;
import TestFiles.imbd_test;
import TestFiles.wiki_test;


public class base {
 protected WebDriver driver=null;
	
	@BeforeSuite
	public void startup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void closeBrowser(){
		driver.quit();
	}
}
