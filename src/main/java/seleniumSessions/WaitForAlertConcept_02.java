package seleniumSessions;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Generic Method :
public class WaitForAlertConcept_02 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//
//		System.out.println(alert.getText());
//		alert.accept();
		
//		acceptJSAlert(5);
//		dismissJSAlert(5);
		String jsAlertText = getJsAlertText(2);
		System.out.println(jsAlertText);
		enterValueOnJsAlert("Hello",2);
		acceptJSAlert(2);
	}

	public static Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void acceptJSAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();
	}
	public static void dismissJSAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();
	}
	public static String getJsAlertText(int timeOut) {
		return waitForJSAlert(timeOut).getText();
	}
	public static void enterValueOnJsAlert(String value,int timeOut) {
		waitForJSAlert(timeOut).sendKeys(value);
	}

}
