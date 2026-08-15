package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Capture language link text below search bar : With generic method from Element Utility:
public class GoogleLanguageLinks_3 {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		By langLinks = By.xpath("//div[@id='SIvCob']/a");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.clickOnElement(langLinks, "मराठी");

	}
}
