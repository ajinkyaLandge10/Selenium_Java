package seleniumSessions;
//@formatter:off
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePagination_MultipleSelection {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		jsUtil.scrollMiddlePage();
		Thread.sleep(3000);

		// Multiple selection:
		while (true) {
			// If the Element is present on the first page itself
			if (driver.findElements(By.xpath("//td[text()='India']")).size() > 0) {
				selectCountryMiltipleTime("India");
			}
			// pagination logic: click on next(>):
			WebElement next = driver.findElement(By.xpath("//button[@type='button' and @aria-label='Next']"));
			if (next.getAttribute("class").contains("disabled")) {
				System.out.println("Pagination is Over");
				break;
			}
			next.click();
			Thread.sleep(1000);

		}
		driver.quit();
	}

	public static void selectCountryMiltipleTime(String countryName) throws InterruptedException {
		List<WebElement> eles = driver.findElements(By.xpath("//td[text()='" + countryName + "']/preceding-sibling::td/input[@type='checkbox']"));
		for (WebElement e : eles) {
			e.click();
			Thread.sleep(150);
		}
	}

}
