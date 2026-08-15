package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCartRegistrationAttributeTest {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By phone = By.id("input-telephone");
		By pwd = By.id("input-password");
		By confirmPwd = By.id("input-confirm");
		
		driver.findElement(firstName).sendKeys("Ajinkya");
		String fNameVal = driver.findElement(firstName).getAttribute("value");
		System.out.println(fNameVal);
		
		driver.findElement(lastName).sendKeys("Landge");
		String lNameVal = driver.findElement(lastName).getAttribute("value");
		System.out.println(lNameVal);
		
		driver.findElement(email).sendKeys("Test07@gmail.com");
		String emailVal =driver.findElement(email).getAttribute("value");
		System.out.println(emailVal);
		
		driver.findElement(phone).sendKeys("9874563214");
		String phoneVal = driver.findElement(phone).getAttribute("value");
		System.out.println(phoneVal);
		
		driver.findElement(pwd).sendKeys("Pass@123");
		String pwdValue = driver.findElement(pwd).getAttribute("value");
		System.out.println(pwdValue);
		
		driver.findElement(confirmPwd).sendKeys("Pass@123");
		String confirmPwdValue = driver.findElement(confirmPwd).getAttribute("value");
		System.out.println(confirmPwdValue);
		
	}

}
