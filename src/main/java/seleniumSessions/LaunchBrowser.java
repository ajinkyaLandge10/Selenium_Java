package seleniumSessions;

//@formatter:off
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		// Windows--> Need to write --> \\ & .exe 
		// chrome:
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		// Edge
		System.setProperty("webdriver.edge.driver", "D:\\drivers\\msedgedriver.exe"); 
		WebDriver driver1 = new EdgeDriver();
		driver1.get("https://www.facebook.com");
		
		
		// Mac or linux --> No Need of writing .exe
		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Documents/AugDrivers/chromedriver");
		WebDriver driver2 = new ChromeDriver();
		
/*		
 		- Before selenium 4.6.0 we need to manually download .exe file
		- keep that files in local folder and write System.setProperty code and provide the path of exe
		- After selenium 4.6.0 selenium manager take care of .exe files
		- Browser 118 ---> 118.exe
		- Selenium manager check version of browser -->118--> it will check if u have 118.exe in your cache folder
		- if not it will download from ChromeForTesting CFT dash-board in your .cache folder and will start the server automatically	
*/		
	}

}
