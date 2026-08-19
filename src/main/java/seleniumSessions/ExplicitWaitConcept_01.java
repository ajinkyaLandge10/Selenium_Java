package seleniumSessions;

//@formatter:off
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Normal Method : 
public class ExplicitWaitConcept_01 {
	public static void main(String[] args) {
/*		
	ExplicitWait:
		- Concept of dynamic wait for the specific element/Non WebElement
		- On the basis of some expected conditions	
		
	- If even after given time element is not present:
		 1.ImplicitlyWait - will give --> NoSuchElementException
		 2.ExplicitWait - will give --> TimeOutException + NoSuchElementException
*/
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginButton = By.xpath("//input[@value='Login']");
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement email_ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
		email_ele.sendKeys("Test@gmail.com");
	
		driver.findElement(password).sendKeys("Pass@123");
		driver.findElement(loginButton).click();
	}
}
