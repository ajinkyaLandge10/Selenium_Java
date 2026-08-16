package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_TabKeysConcept_01 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		Actions act = new Actions(driver);
		act.sendKeys(firstName, "Jhon")
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys("Doe")
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys("Test@gmail.com")
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys("9876543215")
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys("Pass@123")
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys("Pass@123")
					.sendKeys(Keys.TAB)
					.pause(500)
						.perform();
					
	}

}
