package miscellaneous;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* AJAX 
  	- Asynchronous JavaScript & XML
	- It allows Web-site to Update partial content on the WebPage without reloading the entire page
	- It's Collection of technologies that make web application more responsive to user interaction
*/

public class HandleAJAXCall {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
		driver.findElement(By.id("loadContent")).click();

		By ajaxContent = By.xpath("//div[@id='ajaxContent']/h2");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement loadedText = wait.until(ExpectedConditions.visibilityOfElementLocated(ajaxContent));

		System.out.println(loadedText.getText());

	}

}
