package seleniumSessions;

//@formatter:off
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Actions_TabKeysConcept_02 {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		Actions act = new Actions(driver);
		
		Action searchAction =act.sendKeys(Keys.TAB)
			.sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB)
					.sendKeys(Keys.TAB)
						.sendKeys(Keys.TAB)
							.sendKeys("macbook")
								.sendKeys(Keys.ENTER)
									.build();
		
		searchAction.perform();
	
	}

}
