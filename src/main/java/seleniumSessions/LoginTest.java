package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		String email_Id = "input-email";
		String password_Id = "input-password";
		String loginBtn_xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input";
		String register_linkText = "Register";

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", email_Id, "Test@gmail.com");
		eleUtil.doSendKeys("id", password_Id, "Test@123");
		eleUtil.doClick("xpath", loginBtn_xpath);

		String registerValue = eleUtil.doElementGetText("linktext", register_linkText);
		System.out.println(registerValue);

	}

}
