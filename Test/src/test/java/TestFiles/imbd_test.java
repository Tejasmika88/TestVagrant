package TestFiles;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.imbd;

public class imbd_test {
WebDriver driver;
	
	@Test
	public HashMap<String,String> imbd_Data(WebDriver driver,String moviename,String url)
	{
		HashMap<String,String> imbd_data=new HashMap<String,String>();
		imbd i=new imbd(driver);
		i.OpenWebsite(url);
		i.search(moviename);
		i.clicksearch();
		i.selectMovies(moviename);
		String release=i.getReleaseDate();
		String country=i.getCountyofOrigin();
		imbd_data.put("Release", release);
		imbd_data.put("Country", country);
		
		return imbd_data;
		
	}
}
