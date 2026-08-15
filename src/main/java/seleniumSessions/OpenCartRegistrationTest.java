package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartRegistrationTest {
	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil brUtil = new BrowserUtil();
		
		WebDriver driver = brUtil.launchBrowser("Chrome");
		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		String title = brUtil.getPageTitle();
		
		By fName = By.id("input-firstname");
		By lName = By.id("input-lastname");
		By email = By.id("input-email");
		By phone = By.id("input-telephone");
		By pwd = By.id("input-password");
		By confirm_pwd = By.id("input-confirm");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(fName, "Jhon");
		eleUtil.doSendKeys(lName, "Doe");
		eleUtil.doSendKeys(email, "JhonDoe@gmail.com");
		eleUtil.doSendKeys(phone, "9874561231");
		eleUtil.doSendKeys(pwd, "Pass@123");
		eleUtil.doSendKeys(confirm_pwd, "Pass@123");
		
		Thread.sleep(5000);
		brUtil.closeBrowser();
		

	}

}
