package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Normal Method:
public class Actions_BigBasketMenuHandle_01 {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(2000);
		
		By shopByMenu = By.xpath("(//span[text()='Shop by'])[2]");
		By beveragesMenu = By.linkText("Beverages");
		By teaMenu = By.linkText("Tea");
		By greenTeaMenu = By.linkText("Green Tea");
		
		Actions act = new Actions(driver);
		driver.findElement(shopByMenu).click();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(beveragesMenu)).build().perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(teaMenu)).build().perform();
		Thread.sleep(1000);
		driver.findElement(greenTeaMenu).click();

	}

}
