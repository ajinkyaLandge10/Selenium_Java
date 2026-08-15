package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttributeConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		// webelement + perform action(getAttribute)

		By emailId = By.id("input-email");
		By pwdId = By.id("input-password");
		By registerLink = By.linkText("Register");

//		String emailPlaceholderVal = driver.findElement(emailId).getAttribute("placeholder");
//		System.out.println(emailPlaceholderVal);
//
//		String pwdPlaceholderVal = driver.findElement(pwdId).getAttribute("placeholder");
//		System.out.println(pwdPlaceholderVal);
//
//		String hrefVal = driver.findElement(registerLink).getAttribute("href");
//		System.out.println(hrefVal);
//
//		String className = driver.findElement(registerLink).getAttribute("class");
//		System.out.println(className);

		// Capture entered text normally
//		driver.findElement(emailId).sendKeys("Test@gmail.com");
//		String emailVal = driver.findElement(emailId).getAttribute("value");
//		System.out.println(emailVal);
//
//		driver.findElement(pwdId).sendKeys("Test@123");
//		String pwdVal = driver.findElement(pwdId).getAttribute("value");
//		System.out.println(pwdVal);

		// Capture entered text with generic method
		String emailPlaceholderVal = doGetElementAttribute(emailId, "placeholder");
		System.out.println(emailPlaceholderVal);

		String emailVal = doGetElementAttribute(emailId, "value");
		System.out.println(emailVal); // no value is passed so blank output

		String pwdPlaceholderVal = doGetElementAttribute(pwdId, "placeholder");
		System.out.println(pwdPlaceholderVal);

		String hrefVal = doGetElementAttribute(registerLink, "href");
		System.out.println(hrefVal);

	}

	public static String doGetElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
