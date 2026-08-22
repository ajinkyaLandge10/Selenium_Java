package testngSessions;

//@formatter:off
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Priority - 1. If no Priority is given to any Test cases it will run based on alphabetical order
//			  2. If all the Test cases have Priority so it will pick from negative to positive 
//			  3. If 3 Test cases have Priority & 2 Test cases don't have priority
//			  	- Non priority(default value = 0 ) Test cases first based on alphabetical order & Then priority test cases based on number

public class OpenCartTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://naveenautomationlabs.com/opencart/");
	}

	@Test(priority = 3)
	public void isOpenCartLogoIsVisibleTest() {
		boolean flag = driver.findElement(By.xpath("//img[@title='naveenopencart']")).isDisplayed();
		Assert.assertEquals(flag, true);
	}

	@Test(priority = 2)
	public void isOpenCartTitleTest() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Your Store");
	}

	@Test(priority = 1)
	public void isOpenCartURLTest() {
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL);
		Assert.assertTrue(actualURL.contains("opencart1"));
	}

	@Test
	public void aTest() {
		System.out.println("A Test");
	}

	@Test
	public void bTest() {
		System.out.println("B Test");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
