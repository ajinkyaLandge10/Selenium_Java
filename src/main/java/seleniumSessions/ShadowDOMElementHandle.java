package seleniumSessions;

//@formatter:off
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMElementHandle {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("chrome://settings/");
		driver.manage().window().maximize();
		Thread.sleep(4000);

//		driver.findElement(By.id("searchInput")).sendKeys("notification");  --> normal way won't work

//Note :- Copy js Path of element & return --> 
//		- This will give us HTML Element, We have to TypeCast HTML Element to WebElement

		String searchScript = "return document.querySelector(\"body > settings-ui\")"
				+ ".shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")";

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// TypeCast : HTML ele to WebElement
		WebElement search = (WebElement)js.executeScript(searchScript);
		search.sendKeys("notification");
	}

}
