package miscellaneous;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QA_Playground_Tests {

	WebDriver driver;

	@BeforeClass
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://qaplayground.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void testLogo() {
		boolean logoStatus = driver.findElement(By.xpath("//img[@alt='QA Playground logo']")).isDisplayed();
		Assert.assertEquals(logoStatus, true);
	}

	@Test(priority = 2)
	public void testAppUrl() {
		String appUrl = driver.getCurrentUrl();
		Assert.assertEquals(appUrl, "https://qaplayground.com/");
	}

	@Test(priority = 3, dependsOnMethods = { "testAppUrl" })
	public void testHomePageTitle() {
		String appTitle = driver.getTitle();
		Assert.assertEquals(appTitle, "QA Playground — Practice Selenium, Playwright & Cypress");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
