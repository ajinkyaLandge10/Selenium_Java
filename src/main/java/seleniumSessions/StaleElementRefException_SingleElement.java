package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefException_SingleElement {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
/*
 	Note:stale(Not fresh)
 		- Whenever we refresh the page the DOM also get refreshed,DOM is loaded first and after that Page gets loaded
 		- Browser reads the DOM and load the page according to that
 		- All the element's initialized before Refresh will go in stale state 
 		- To avoid StaleElementReferenceException:
 		 		1.Re-initialze the WebElement
 		 		2.Use By locator approach
 		 		3.Explicit wait with FluetWait --> ignore Exception - staleElementException
 		- Selenium maintains id for every WebElement so when we refresh page & never reinitialize WebElement id get expired &
 		  after that we try to perform anything with that id we get StaleElementReferenceException
 		- But when we reinitialize WebElement after refresh new id will be maintained and that's valid id.
 			
 */	
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		WebElement emailId =driver.findElement(By.id("input-email"));
		emailId.sendKeys("Selenium@gmail.com");
		
		driver.navigate().refresh();
		
//		emailId =driver.findElement(By.id("input-email"));
		emailId.sendKeys("Automation@gmail.com");//StaleElementReferenceException
	}

}
