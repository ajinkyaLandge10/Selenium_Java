package seleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Capture Suggestion list from Google -> Without generic method
public class SuggestionList1 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium Automation");

		Thread.sleep(3000);

		List<WebElement> suggestionList = driver.findElements(By.xpath("//div[@class='wM6W7d']/span"));
		System.out.println(suggestionList.size());

		for (WebElement e : suggestionList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains("interview questions")) {
				e.click();
				break;
			}
		}
	}
	
}
