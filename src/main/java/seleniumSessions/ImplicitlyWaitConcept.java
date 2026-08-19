package seleniumSessions;

//@formatter:off
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcept {
	public static void main(String[] args) {
/*
 Note : ImplicitlyWait : 
  		- Global wait --> Applied for all the WebElements (Only WebElements)
  		- Applied after the driver initialization
  		- Once implicitlyWait is declared after that it will applicable for all the elements in the script.
  		- Can be Override with different Timeouts like 10,20,5 etc.
  		- Ex: If timeout is 10 sec it will wait for element to be load & even after that if element is not loaded - NoSuchElementException
  		- If We have given TimeOut - 0 secs this is called as Nullification of ImplicitlyWait
  		
  		Drawbacks 1. Ex: if 3 web elements loaded together it will wait 10 sec for each element
  					 emailId: 10 secs: 2 secs: 8 secs will be ignored
					 password: 10 secs: 0 secs: 10 secs will be ignored 
					 loginBtn: 10 secs: 0 secs: 10 secs will be ignored 
					 
					 To optimize the wait: Explicit wait: for the specific element
					 emailId: 10 secs: 2 secs: 8 secs will be ignored
					 password: no wait applied
					 login button: no wait applied
					 
  		          2. ImplicitlyWait can not be used with non web elements (alerts, title, url)
					 Explicit wait can be used for non web elements
 */
		
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); -- Deprecated - Selenium 3x
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Selenium 4x
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys("Test@gmail.com");
		
		
	}

}
