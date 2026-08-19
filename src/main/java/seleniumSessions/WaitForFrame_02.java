package seleniumSessions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrame_02 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();// browser - chrome
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");// page

		By image = By.cssSelector("#imageTemplateContainer img");
		By frame = By.xpath("//iframe[contains(@id,'frame-one')]");
		By textBox = By.id("RESULT_TextField-1");
		By header = By.cssSelector("h3.details__form-preview-title");

		waitForVisibilityOfElement(image, 10).click();
		waitForFrameByLocator(frame, 5);
		waitForVisibilityOfElement(textBox, 5).sendKeys("Test Automation");
		driver.switchTo().defaultContent();
		String headerVal = waitForVisibilityOfElement(header, 5).getText();
		System.out.println(headerVal);

	}

	public static void waitForFrameByLocator(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	public static void waitForFrameByIndex(int index, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	public static void waitForFrameByNameOrId(String NameOrID, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(NameOrID));
	}
	public static void waitForFrameByElement(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	public static WebElement waitForVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
