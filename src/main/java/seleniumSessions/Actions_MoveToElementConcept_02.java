package seleniumSessions;
//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Generic Method : 
public class Actions_MoveToElementConcept_02 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().window().maximize();
		
		By parentMenuLocator = By.xpath("//button[@id='developers-dd-toggle']");
		By childMenuLocator = By.xpath("//a[contains(@data-title,'Support')]");
		
		twoLevelMenuHandle(parentMenuLocator, childMenuLocator);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void twoLevelMenuHandle(By parentMenuLocator, By childMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator))
			.build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(childMenuLocator).click();
	}

}
