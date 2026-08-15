package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Capture Suggestion list from Google -> With generic method from Element Utils
public class SuggestionList3 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		By searchField = By.name("q");
		By suggestions = By.xpath("//div[@class='wM6W7d']/span");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.searchAndCLick(searchField, suggestions, "Automation Testing", "jobs");

	}

}
