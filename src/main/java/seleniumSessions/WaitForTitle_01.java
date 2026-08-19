package seleniumSessions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Normal Method
public class WaitForTitle_01 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By aboutUSLink = By.linkText("About Us");
		driver.findElement(aboutUSLink).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		if (wait.until(ExpectedConditions.titleContains("About"))) {
			System.out.println(driver.getTitle());
		} else {
			System.out.println("Title value is not Present....");
		}

	}
}
