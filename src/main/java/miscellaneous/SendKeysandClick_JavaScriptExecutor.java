package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysandClick_JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

//		1 - Without Using .SendKeys() pass The value to the input-box (name) -- By using JavaScriptExecutor
//		2 - Without Using .click() click on the radio button(male) -- By using JavaScriptExecutor		

		WebElement name = driver.findElement(By.id("name"));
		WebElement radioBtn = driver.findElement(By.id("male"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','Harry')", name);
		js.executeScript("arguments[0].click()", radioBtn);

		Thread.sleep(3000);
//		driver.quit();

	}

}
