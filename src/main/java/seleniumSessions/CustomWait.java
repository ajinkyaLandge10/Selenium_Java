package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWait {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		By forgotPwd = By.xpath("//p[text()='Forgot your pasword? ']");
		
//		retryingElement(forgotPwd, 10).click();
		retryingElement(forgotPwd, 10, 2000).click();

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	//Default Interval/Polling Time : 500 MiliSeconds
	public static WebElement retryingElement(By locator, int timeOut) {
		WebElement element = null;
		int attempt = 0;

		while (attempt < timeOut) {
			try {
				element = getElement(locator);
				System.out.println("Element is Found in : "+ attempt +" attempts");
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element is not Found in : " + attempt +" attempts");
				try {
					Thread.sleep(500);//Default Polling Time
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempt++;
		}
		if(element == null) {
			System.out.println("Element is Not Found...tried for " + timeOut + " times " + " With Interval of " + 500 + " Miliseconds");
			throw new AutomationException("No Such Element..");
		}
		return element;
	}
	
	//Overloaded Method with Interval/Polling Time parameter
	public static WebElement retryingElement(By locator, int timeOut, int intervalTime) {
		WebElement element = null;
		int attempt = 0;

		while (attempt < timeOut) {
			try {
				element = getElement(locator);
				System.out.println("Element is Found in : "+ attempt +" attempts");
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element is not Found in : " + attempt +" attempts");
				try {
					Thread.sleep(intervalTime);//Custom Polling Time
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempt++;
		}
		if(element == null) {
			System.out.println("Element is Not Found...tried for " + timeOut + " times " + " With Interval of " + intervalTime + " Miliseconds");
			throw new AutomationException("No Such Element..");
		}
		return element;
	}

}
