package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Scrolling {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		Actions act = new Actions(driver);
// PAGE_DOWN & PAGE_UP --> For slightly scrolling on page
//		act.sendKeys(Keys.PAGE_DOWN).perform();  
//		Thread.sleep(1000);
//		act.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		act.sendKeys(Keys.PAGE_UP).perform();
		
// CONTROL or COMMAND + ARROW KEY DOWN --> For Complete Scrolling to Bottom or Top of the Page
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
//		Thread.sleep(1000);
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
//		Thread.sleep(1000);
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
//		Thread.sleep(1000);
		
// Scroll To Specific Element:
//		act.scrollToElement(driver.findElement(By.linkText("Help")))
//				.click(driver.findElement(By.linkText("Help")))
//					.build()
//						.perform();	
		
//		By helpLocator = By.linkText("Help");
//		doClickByScrollToElement(helpLocator);
		
// Refresh Page
		act.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).perform();
			
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClickByScrollToElement(By locator) {
		Actions act = new Actions(driver);
		act.scrollToElement(getElement(locator))
			.click(getElement(locator))
				.build()
					.perform();
		
	}

}
