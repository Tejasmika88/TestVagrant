package TestFiles;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import Pages.wiki;

public class wiki_test {
	
	public HashMap<String,String> wiki_Data(WebDriver driver,String moviename,String url)
	{
		HashMap<String,String> wiki_data=new HashMap<String,String>();
		wiki w=new wiki(driver);
		w.OpenWebsite(url);
		w.search(moviename);
		//w.clicksearch();
		//w.selectMovies(moviename);
		String release=w.getReleaseDate();
		String country=w.getCountyofOrigin();
		wiki_data.put("Release", release);
		wiki_data.put("Country", country);
		
		return wiki_data;
		
	}

}
