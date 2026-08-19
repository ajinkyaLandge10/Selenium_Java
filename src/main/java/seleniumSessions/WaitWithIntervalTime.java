package seleniumSessions;

//@formatter:off
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWithIntervalTime {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//1st constructor of WebDriverWait
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));//2nd constructor of WebDriverWait
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emailId)).sendKeys("Test@gmail.com");

/*
Note: Polling/Interval/Sleep : 
		- Suppose Duration of Timeout - 10 sec & Duration of sleep - 2 sec
		- Then it will attempt to check Element is visible or not after every 2 sec till it is visible
		- First attempt is immediately at 0 sec then 2,4,6,8,10.
		- The difference between this time i.e, 2 sec in our case is called as polling/Interval/sleep	
		- Default polling time is 500 miliSeconds=0.5 seconds.	
 */		
	}

}
