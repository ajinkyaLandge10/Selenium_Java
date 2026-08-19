package seleniumSessions;

//@formatter:off
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Generic Method : 
public class ExplicitWaitConcept_02 {
	static WebDriver driver;
	
	public static void main(String[] args) {
/*
 Note : When We hit any URL 
 		- API request is send to Server & and server respond then DOM is loaded First & then Browser reads that DOM
 */
			
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginButton = By.xpath("//input[@value='Login']");
		By aboutUSLink = By.linkText("About Us");

		WebElement email_ele = waitForPresenceOfElement(emailId, 5);
		email_ele.sendKeys("Test@gmail.com");

		driver.findElement(password).sendKeys("Pass@123");
		driver.findElement(loginButton).click();
		
		//waitForPresenceOfElement(aboutUSLink, 5).click();
		waitForVisibilityOfElement(aboutUSLink, 5).click();
		
		
		
	}
	
	/**
	 * This Method Check Element is present inside DOM only
	 * @param locator
	 * @param timeout
	 * @return WebElement
	 */
	public static WebElement waitForPresenceOfElement(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	/**
	 * This Method is checking that there is at least one element present on a web page.
	 * @param locator
	 * @param timeout
	 * @return List<WebElement>
	 */
	public static List<WebElement> waitForPresenceOfAllElements(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	
	
	/**
	 * This Method Check Element is present inside DOM as well as on the Page
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeout
	 * @return WebElement
	 */
	public static WebElement waitForVisibilityOfElement(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	/**
	 * This Method is checking that all elements present on the web page that match the locator are visible.
	 * @param locator
	 * @param timeout
	 * @return List<WebElement>
	 */
	public static List<WebElement> waitForVisibilityOfAllElements(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public static void doClickWithWait(By locator, int timeOut) {
		waitForVisibilityOfElement(locator, timeOut).click();
	}
	public static void doSendKeysWithWait(By locator, String value, int timeOut) {
		waitForVisibilityOfElement(locator, timeOut).sendKeys(value);
	}
	
	
}
