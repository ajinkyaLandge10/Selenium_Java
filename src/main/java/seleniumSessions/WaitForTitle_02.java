package seleniumSessions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Generic Method
public class WaitForTitle_02 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By aboutUSLink = By.linkText("About Us");
		driver.findElement(aboutUSLink).click();

		
//		String title = waitForTitleContains("Abot", 5);
//		System.out.println(title);
		
		String title1 = waitForTitleIs("About", 5);
		System.out.println(title1);

	}

	public static String waitForTitleContains(String titleFractionValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleContains(titleFractionValue))) {
				return driver.getTitle();
			}
		} catch (TimeoutException e) {
			System.out.println(titleFractionValue + ": Title is Not Present...");
			e.printStackTrace();
		}
		return null;
	}
	public static String waitForTitleIs(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleIs(title))) {
				return driver.getTitle();
			}
		} catch (TimeoutException e) {
			System.out.println(title + ": Title is Not Present...");
			e.printStackTrace();
		}
		return null;
	}

}
