package seleniumSessions;

//@formatter:off
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcept {
	public static void main(String[] args) throws MalformedURLException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle()); //Facebook
		
		driver.navigate().to("https://www.google.com/");
		System.out.println(driver.getTitle()); //Google
		
		driver.navigate().back();
		System.out.println(driver.getTitle()); //Facebook
		
		driver.navigate().forward();
		System.out.println(driver.getTitle()); //Google
		
		driver.navigate().back();
		System.out.println(driver.getTitle()); //Facebook
		
		driver.navigate().refresh();// Refresh the page
		
		
//		2 ways of launching 
		driver.navigate().to("https://www.google.com/");
		driver.navigate().to(new URL("https://www.facebook.com/"));
		
/*		get() vs navigate.to()
		- Both are synonym to each we can use any of them
		- The only difference is navigate.to() method is overloaded
			1.String type of parameter
			2.URL type of parameter
*/


	}
}
