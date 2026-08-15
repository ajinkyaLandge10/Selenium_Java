package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 	Locators --> All of this are present in By class
 	1. id
 	2. name
 	3. className
 	4. x-path
 	5. CSS
 	6. linkText
 	7. partialLinkText
 	8. tagName
 	In DOM to check uniqueness of class and Id 
 			-	id --> #
		    - 	class--> .
 */
public class LocatorsConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//1. id: is an attribute: It is always unique --> 1st Preference
		//driver.findElement(By.id("input-email")).sendKeys("Test@gmail.com");
		
		//2. name: is an attribute: Can be duplicate --> 2nd Preference
		//driver.findElement(By.name("email")).sendKeys("Test@gmail.com");
		
		//3. className: is an attribute :Most of the time Duplicate --> 3rd Preference
		//driver.findElement(By.className("form-control")).sendKeys("Test@gmail.com");
		
		//4. X-path: Not an attribute. This is the address of the element in the HTML DOM.
		//Copied directly from DOM by right clicking
		//driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("Test@gmail.com");
		//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("Test@123");
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();	
		
		//OR
		
		//By eId = By.id("input-email");
		//By pwd = By.id("input-password");
		//By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
		//doSendKeys(eId, "Test@gmail.com");
		//doSendKeys(pwd, "Test@123");
		//doClick(loginBtn);		
		
		//5. cssSelector: not an attribute.
		//Copied directly from DOM by right clicking
		//driver.findElement(By.cssSelector("#input-email")).sendKeys("Test@gmail.com");
		//driver.findElement(By.cssSelector("#input-password")).sendKeys("Test@123");
		//driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
		
		//OR
		
		//By emailId = By.cssSelector("#input-email");
		//By pwd = By.cssSelector("#input-password");
		//By loginBtn = By.cssSelector("#content > div > div:nth-child(2) > div > form > input");
		//doSendKeys(emailId, "Test@gmail.com");
		//doSendKeys(pwd, "Test@123");
		//doClick(loginBtn);
			
		//6. linkText: Only applicable for links. Link text is not an attribute, This is the text of the link
		//HTML tag: <a> anchor tag
		//link text: can be duplicate
		//driver.findElement(By.linkText("Register")).click();
		
		//OR
		
		//By registerLink = By.linkText("Register");
		//doClick(registerLink);
			
		//7. partialLinkText: Only applicable for links.Just provide partial part
		//HTML tag: <a> anchor tag
		//driver.findElement(By.partialLinkText("Forgot")).click();
		
		//8. tagName: HTML tag
		//String header = driver.findElement(By.tagName("h2")).getText();
		//System.out.println(header);
		//OR
		By header = By.tagName("h2");
		String headerValue = doElementGetText(header);
		if(headerValue.equals("New Customer")) {
			System.out.println("Pass..");
		}else {
			System.out.println("Fail..");
		}
	
	}

	public static String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
