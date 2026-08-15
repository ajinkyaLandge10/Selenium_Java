package seleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Capture language link text below search bar : With generic method
public class GoogleLanguageLinks_2 {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		By langLinks = By.xpath("//div[@id='SIvCob']/a");
		clickOnElement(langLinks, "বাংলা");

	}

	public static void clickOnElement(By locator, String eleText) {
		List<WebElement> langLinks = driver.findElements(locator);
		System.out.println("Total Count : " + langLinks.size());

		int count = 1;
		for (WebElement e : langLinks) {
			String text = e.getText();
			System.out.println(count + " : " + text);
			count++;
			if (text.contains(eleText)) {
				e.click();
				break;
			}
		}
	}

}
