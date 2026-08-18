package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomInsideIFrame {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

//		Browser --> Page --> iFrame --> shadow DOM(open) --> e1

		driver.switchTo().frame("pact");

		String tea_Script = "return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement tea = (WebElement) js.executeScript(tea_Script);
		tea.sendKeys("Green Tea");

	}

}
