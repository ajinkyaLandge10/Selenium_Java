package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		//WebElement:
		//Create the WebElement + Perform an action(click, sendKeys, getText, isDisplayed)
		
		driver = new ChromeDriver();// 123
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//DOM:Document Object Model: HTML Code
		// multiple ways:
		
//1st : Without storing WeElement Direct action
		//driver.findElement(By.id("input-email")).sendKeys("Test@gmail.com");
		//driver.findElement(By.id("input-password")).sendKeys("Test@123");
		
		
//2nd : Store WebElement in variable + Action
		//WebElement emailId = driver.findElement(By.id("input-email"));
		//WebElement password = driver.findElement(By.id("input-password"));
		
		
//3rd : By Locator --> create By locator and when needed create WebElement from them & use (also called as Object repository).In this no unnecessary server hitting just store variable
		//By eId = By.id("input-email");
		//By pwd = By.id("input-password");
		
		//WebElement emailId = driver.findElement(eId);
		//WebElement password = driver.findElement(pwd);
		
		//emailId.sendKeys("Test@gmail.com");
		//password.sendKeys("Test@123");
		
		
//4th : By locator + Generic method for element
		//By eId = By.id("input-email");
		//By pwd = By.id("input-password");
		
		//getElement(eId).sendKeys("Test@gmail.com");
		//getElement(pwd).sendKeys("Test@123");
		
		
//5th : By locator + Generic method for element and action
		//By eId = By.id("input-email");
		//By pwd = By.id("input-password");
		
		//doSendKeys(eId, "Test@gmail.com");
		//doSendKeys(pwd, "Test@123");
		
		
//6th : By locator + Generic method for element and action in other element utility class. 
		//By eId = By.id("input-email");
		//By pwd = By.id("input-password");
		
		//ElementUtil eleUtil = new ElementUtil(driver);
		//eleUtil.doSendKeys(eId, "Test@gmail.com");
		//eleUtil.doSendKeys(pwd, "Test@123");
		
		
//7th : BrowserUtil + ElementUtil (Recommended)
		// Refer OpenCartLoginTest class this approach is used over there
				
//8th : By locators --> String locators
		// Refer getBy Generic Method in ElementUtil class & doSendKeys(3 param) method..
		// In this approach we are maintaining String type of locator not By type of locator
		
		String email_id = "input-email";
		String pwd_id ="input-password";
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", email_id, "Test@gmail.com");
		eleUtil.doSendKeys("id", pwd_id, "Test@123");
			
//9th : POM + framework
			
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	

}
