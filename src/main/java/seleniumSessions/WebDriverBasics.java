package seleniumSessions;
//@formatter:off
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverBasics {

	static WebDriver driver;

	public static void main(String[] args) {
/*
	Scenario: 
		1. Open the browser: Chrome 
		2. Enter Url 
		3. Get the title 
		4. Verify the title: actual vs expected 
		5. Close the browser
*/
		// Automation Steps :
//		ChromeDriver driver = new ChromeDriver(); //Chrome
//		FirefoxDriver driver = new FirefoxDriver(); //Firefox
//		EdgeDriver driver = new EdgeDriver(); //Edge

		String browser = "Chrome";
		
		// Cross browser logic : With Top Casting : Parallel Testing
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please pass the right browser.....");
			break;
		}

		driver.get("https://www.google.com"); // Without https:// -> InvalidArgumentException & Without www. -> work
		
		String actualTitle = driver.getTitle();
		System.out.println("Title is : " + actualTitle);
		// Verification/Testing :
		if (actualTitle.equals("Google")) {
			System.out.println("Pass : Title is Correct");
		} else {
			System.out.println("Fail : Title is Not Correct");
		}
		
		String appUrl =driver.getCurrentUrl();
		System.out.println(appUrl);
		if(appUrl.contains("google")) {
			System.out.println("Pass : Url is Correct");
		}else {
			System.out.println("Fail : Url is not Correct");
		}
		
		String pageSource = driver.getPageSource();
		if(pageSource.contains("Google apps")) {
			System.out.println("Pass ");
		}else {
			System.out.println("Fail");
		}
		
		
		driver.quit();

	}

}
