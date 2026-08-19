package seleniumSessions;

//@formatter:off
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

//Normal Method :
public class FlunetWaitConcept_01 {
	static WebDriver driver;

	public static void main(String[] args) {
//		 wait(I) until(); <---- FluentWait (Class) until(){} + other methods<--WebDriverWait(class)
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By emailId = By.id("input-email");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(10))
									.pollingEvery(Duration.ofSeconds(2))
										.withMessage("TimeOut done..& Element Is Not Found...")
											.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailId)).sendKeys("Test@gmail.com");
		
	}

}
