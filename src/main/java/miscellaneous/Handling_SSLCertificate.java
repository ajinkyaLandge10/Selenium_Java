package miscellaneous;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Handling_SSLCertificate {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true); // Accept SSL (Secure Socket Layer) Certificate

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();

		String Title = driver.getTitle();
		System.out.println(Title);

		Thread.sleep(2000);
		driver.quit();

	}

}
