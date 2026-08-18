package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElementHandle {
	public static void main(String[] args) {
		
//  Pseudo Element - ::before , ::after  -->generally look like this in DOM --> Ex: Red asterisk symbol (mandatory field)
//				   - Can not be inspected
//				   - Pseudo element can not be handled by x-path, to handle them use cssSelector
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		String script = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"),'::before').getPropertyValue('content');";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String mandatory_text = js.executeScript(script).toString();
		System.out.println(mandatory_text);
		if(mandatory_text.contains("*")) {
			System.out.println("First Name is Mandatory");
		}
	}

}
// Write Generic Method