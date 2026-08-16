package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Generic Method :
public class Actions_BigBasketMenuHandle_02 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);

		By shopByMenu = By.xpath("(//span[text()='Shop by'])[2]");
		By beveragesMenu = By.linkText("Beverages");
		By teaMenu = By.linkText("Tea");
		By greenTeaMenu = By.linkText("Green Tea");

		fourLevelMenuHandle(shopByMenu, beveragesMenu, teaMenu, greenTeaMenu);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void fourLevelMenuHandle(By parentMenuLocator, By firstChildMenuLocator, By secondChildMenuLocator,
			By thirdChildMenuLocator) throws InterruptedException {

		Actions act = new Actions(driver);
		driver.findElement(parentMenuLocator).click();
		Thread.sleep(1000);
		act.moveToElement(getElement(firstChildMenuLocator)).build().perform();
		Thread.sleep(1000);
		act.moveToElement(getElement(secondChildMenuLocator)).build().perform();
		Thread.sleep(1000);
		driver.findElement(thirdChildMenuLocator).click();
	}

}
