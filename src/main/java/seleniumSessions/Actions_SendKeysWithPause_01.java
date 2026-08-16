package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Normal Method:
public class Actions_SendKeysWithPause_01 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement userName = driver.findElement(By.id("input-email"));
		
		Actions act = new Actions(driver);
		String value = "Test@gmail.com";
		char val[] = value.toCharArray();
		
		for(char c : val) {
			act.sendKeys(userName, String.valueOf(c))
				.pause(500)
					.build()
						.perform();
		}

	}

}
