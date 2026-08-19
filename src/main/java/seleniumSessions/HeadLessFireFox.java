package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadLessFireFox {
	public static void main(String[] args) {

		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");

		WebDriver driver = new FirefoxDriver(fo);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
