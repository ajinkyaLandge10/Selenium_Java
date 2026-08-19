package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//@formatter:off
public class HeadLessChrome {
	public static void main(String[] args) {
/*		
	Headless Browser Testing:
	- No active browser window
	- No active UI
	- Testing is happening behind the scene
	- Faster than UI mode
	- But might not interact with some complex applications
	- When to use: -CI CD - Cloud - AWS - Linux - Jenkins
*/
		
		ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		co.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
	
	}

}
