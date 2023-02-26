package TestFiles;

import java.util.HashMap;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.base;
import Helper.helper;

public class movieDataComparision extends base{
	
	@Test
	@Parameters("MovieName")
	public void MovieDetailComparision(String MovieName)
	{
		HashMap<String,String> imbd_output=new HashMap<String,String>();
		HashMap<String,String> wiki_output=new HashMap<String,String>();
		imbd_test it=new imbd_test();
		wiki_test wk=new wiki_test();
		imbd_output=it.imbd_Data(driver, MovieName, "https://www.imdb.com/");
		wiki_output=wk.wiki_Data(driver, MovieName, "https://www.wikipedia.org/");
		System.out.println("IMBD-"+imbd_output.toString());
		System.out.println("WIKI-"+wiki_output.toString());
		helper h=new helper();
		h.compareData(imbd_output, wiki_output);
		
	}

}
