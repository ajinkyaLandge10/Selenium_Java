package seleniumSessions;

//@formatter:off
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeWindow {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize(); 	//-->Maximizes the current window
//		driver.manage().window().fullscreen();	//-->FullScreen the current window
		driver.manage().window().minimize();	//-->Minimizes the current window
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());

	}

}
