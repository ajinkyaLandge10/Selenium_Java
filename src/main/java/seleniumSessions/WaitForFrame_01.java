package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrame_01 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();// browser - chrome
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");// page

		By image = By.cssSelector("#imageTemplateContainer img");
		By frame = By.xpath("//iframe[contains(@id,'frame-one')]");
		By textBox = By.id("RESULT_TextField-1");
		By header = By.cssSelector("h3.details__form-preview-title");
		
		// Step-1: Click on image
		waitForVisibilityOfElement(image, 10).click(); 
		
		// Step-2: Wait for Frame to be available and switch
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame)); 
		
		//Step-3: Enter text in the text field
		waitForVisibilityOfElement(textBox, 5).sendKeys("Test Automation"); 
		
		// step-4: Switch back to parent page
		driver.switchTo().defaultContent(); 
		
		// step-5: Capture and print text from parent page
		String headerVal = waitForVisibilityOfElement(header, 5).getText(); 
		System.out.println(headerVal);
		
	}

	public static WebElement waitForVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
