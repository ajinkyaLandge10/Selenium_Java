package seleniumSessions;

//@formatter:off
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//Generic Method :
public class FlunetWaitConcept_02 {
	static WebDriver driver;

	public static void main(String[] args) {
		//wait(I) until(); <---- FluentWait (Class) until(){} + other methods<--WebDriverWait(class)
		// All the Methods Of Fluent wait inherited in WebDriverWait also
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By emailId = By.id("input-email");

//		waitForElementWithFluentWait(emailId, 10, 2).sendKeys("Test@gmail.com");
		waitWithWebDriverwaitHavingFluentFeatures(emailId, 10, 2).sendKeys("Test@gmail.com");
		
		
	}

	public static WebElement waitForElementWithFluentWait(By locator, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(timeOut))
									.pollingEvery(Duration.ofSeconds(intervalTime))
										.withMessage("TimeOut done..& Element Is Not Found...")
											.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
	}
	
	// WebDriver wait with Fluent wait features:
	public static WebElement waitWithWebDriverwaitHavingFluentFeatures(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					  wait.pollingEvery(Duration.ofSeconds(2))
					  		.withMessage("TimeOut done..& Element Is Not Found...")
					  			.ignoring(NoSuchElementException.class);
					  
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
