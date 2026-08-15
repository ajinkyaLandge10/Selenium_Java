package seleniumSessions;
//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartLoginTest {

	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		By eId = By.id("input-email");
		By pwd = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(eId, "Test@gmail.com");
		eleUtil.doSendKeys(pwd, "Test@123");
		
		brUtil.closeBrowser();

	}

}
