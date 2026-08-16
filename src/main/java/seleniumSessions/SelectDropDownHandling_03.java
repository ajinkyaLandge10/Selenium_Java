package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Handle (Select)drop-down with Generic method From ElementUtils:
public class SelectDropDownHandling_03 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		driver.manage().window().maximize();

		By country = By.id("Form_getForm_Country");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSelectDropDownByIndex(country, 7);
		Thread.sleep(1000);
		eleUtil.doSelectDropDownByVisibleText(country, "Belgium");
		Thread.sleep(1000);
		eleUtil.doSelectDropDownByValue(country, "Denmark");
	}
}
