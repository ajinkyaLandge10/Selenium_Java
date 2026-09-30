package miscellaneous;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncognitoMode {
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito"); // Run test in incognito mode

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		String act_Title = driver.getTitle();

		if (act_Title.equals("OrangeHRM")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		Thread.sleep(2000);
		driver.quit();

	}
}
