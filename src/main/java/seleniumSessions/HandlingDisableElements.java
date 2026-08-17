package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingDisableElements {
	public static void main(String[] args) throws InterruptedException {

/*	
 	 Exception: 1.For Disabled Buttons : ElementClickInterceptedException
  			    2.For Disabled TextFields : ElementNotInteractableException
  	 - When We Use Actions class - No Exception
  	 - But for Normal Selenium click & Sendkeys We Will get Exception
 */
				
		WebDriver driver = new ChromeDriver();
//		driver.get("https://classic.freecrm.com/register/");
//		Thread.sleep(3000);
//		
//		WebElement submit = driver.findElement(By.id("submitButton"));
//		submit.click();//ElementClickInterceptedException
//
//		Actions act = new Actions(driver);
//		act.click(submit).perform();//No exception
		
		driver.get("http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		WebElement password = driver.findElement(By.id("pass"));
		//password.sendKeys("Pass@123");//ElementNotInteractableException
		
		Actions act = new Actions(driver);
		act.sendKeys(password, "Pass@123");
	}

}
