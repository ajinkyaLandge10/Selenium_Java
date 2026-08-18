package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM_iframeInShadowDOM {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		String pizza_Script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement pizza = (WebElement) js.executeScript(pizza_Script);
		pizza.sendKeys("Veg Pizza");

	}
}

