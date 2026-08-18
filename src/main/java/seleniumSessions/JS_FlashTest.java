package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JS_FlashTest {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		
		WebElement userName = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.id("input-password"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		jsUtil.flash(userName);
		userName.sendKeys("Test@gmail.com");
		jsUtil.flash(password);
		password.sendKeys("Pass123");
		jsUtil.clickElementByJS(loginBtn);
		
	}

}
