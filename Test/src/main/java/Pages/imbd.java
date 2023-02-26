package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class imbd{
	
	protected WebDriver driver;
	
	@FindBy(xpath="//input[contains(@class,'search__input')]")
	private WebElement searchBox; 
	
	@FindBy(xpath="//button[@id='suggestion-search-button']")
	private WebElement searchButton; 
	
	@FindBy(xpath="//section[@data-testid='Details']//following-sibling::div/ul/li/a[contains(text(),'Release date')]")
	private WebElement RelaseDate; 
	
	@FindBy(xpath="//section[@data-testid='Details']//following-sibling::div/ul/li/a[contains(text(),'Country of origin')]")
	private WebElement Countryoforigin;
	
	@FindBy(xpath="//li[@data-testid=\"title-details-releasedate\"]/a/following-sibling::div/ul/li")
	private WebElement release;
	
	@FindBy(xpath="//li[@data-testid=\"title-details-origin\"]//following-sibling::div/ul/li/a")
	private WebElement country;
	
	
	
	public imbd(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void selectMovies(String name)
	{
		List<WebElement> movieName=driver.findElements(By.xpath("//ul[contains(@class,'ipc-metadata-list ipc-metadata')]//following-sibling::div/div/a"));
			movieName.get(0).click();	
	}
	
	public String getReleaseDate()
	{
		return release.getText();
	}
	
	public String getCountyofOrigin()
	{
		return country.getText();
	}
	
	public void search(String searchKeyword)
	{
		searchBox.sendKeys(searchKeyword);
	}
	
	public void clicksearch()
	{
		searchButton.click();
	}
	
	public void OpenWebsite(String url)
	{
		driver.get(url);
	}


}
