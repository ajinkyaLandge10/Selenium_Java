package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_ClickAndSendKeys {
	static WebDriver driver;
	
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

// Normal Method:
//		Actions act = new Actions(driver);
//		act.sendKeys(driver.findElement(By.id("input-email")), "Test@gmail.com").perform();
//		act.sendKeys(driver.findElement(By.id("input-password")), "Test@123.com").perform();
//		act.click(driver.findElement(By.xpath("//input[@value='Login']"))).perform();

/*
 Note : Actions click:Clicks in the middle of the given element.Equivalent to:Actions.moveToElement(onElement).click()
		- When we try click normally like driver.findElement("").click();
		- Sometime the login button is overlapped by some chat-bot pop-up in some application in that case Actions click works
		- ElementNotInteractable Exception might come.
*/	
		
// With Generic Methods:
		By email = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
		doActionsSendKeys(email, "Test@gmail.com");
		doActionsSendKeys(password, "Test@123.com");
		doActionsClick(loginBtn);
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator,String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator),value).perform();
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
}
