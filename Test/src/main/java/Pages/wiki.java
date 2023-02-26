package Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class wiki {

	protected WebDriver driver;

	@FindBy(xpath = "//input[@id='searchInput']")
	private WebElement searchBox;

	@FindBy(xpath = "//i[contains(text(),'Search')]")
	private WebElement searchButton;

	@FindBy(xpath = "//table[@class='infobox vevent']/tbody/tr/th/div[contains(text(),'Release date')]//parent::th/following-sibling::td/div/ul/li")
	private WebElement RelaseDate;

	@FindBy(xpath = "//table[@class='infobox vevent']//th[contains(text(),\"Country\")]/following-sibling::td")
	private WebElement Countryoforigin;

	public wiki(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void selectMovies(String name) {
		List<WebElement> movieName = driver.findElements(
				By.xpath("//ul[contains(@class,'ipc-metadata-list ipc-metadata')]//following-sibling::div/div/a"));
		movieName.get(0).click();
	}

	public String getReleaseDate() {
		return RelaseDate.getText();
	}

	public String getCountyofOrigin() {
		return Countryoforigin.getText();
	}

	public void search(String searchKeyword) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(searchKeyword);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> suggestions=driver.findElements(By.xpath("//div[@id='typeahead-suggestions']/div/a"));
		suggestions.get(0).click();
	}

	public void clicksearch() {
		searchButton.click();
	}

	public void OpenWebsite(String url) {
		driver.get(url);
	}

}
