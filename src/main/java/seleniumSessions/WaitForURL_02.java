package seleniumSessions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Generic Method
public class WaitForURL_02 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By aboutUSLink = By.linkText("About Us");
		driver.findElement(aboutUSLink).click();

//		String urlContains = waitForURLContains("naveenautomationlabs", 5);
//		System.out.println(urlContains);
		
		String URLIs = waitForURLIs("https://naveenautomationlabs.com/opencart/index.php?route=information/information&information_id=4", 5);
		System.out.println(URLIs);
	

	}
	
	public static String waitForURLContains(String URLFractionValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.urlContains(URLFractionValue))) {
				return driver.getCurrentUrl();
			}
		} catch (TimeoutException e) {
			System.out.println(URLFractionValue + ": URL is Not Present...");
			e.printStackTrace();
		}
		return null;
	}
	public static String waitForURLIs(String URL, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.urlToBe(URL))) {
				return driver.getTitle();
			}
		} catch (TimeoutException e) {
			System.out.println(URL + ": URL is Not Present...");
			e.printStackTrace();
		}
		return null;
	}

}
