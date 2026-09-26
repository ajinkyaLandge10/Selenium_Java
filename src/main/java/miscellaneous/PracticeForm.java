package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeForm {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
//		1 - Without Using .SendKeys() pass The value to the input-box (name) -- By using JavaScriptExecutor
//		2 - Without Using .click() click on the radio button(male) -- By using JavaScriptExecutor		
		
		WebElement name = driver.findElement(By.id("name"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement phone = driver.findElement(By.id("phone"));
		WebElement address = driver.findElement(By.id("textarea"));
		WebElement genderRadioBtn = driver.findElement(By.id("male"));
		WebElement daysRadioBtn = driver.findElement(By.xpath("//input[@id='wednesday' and @type='checkbox']"));
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','Harry')", name);
		js.executeScript("arguments[0].setAttribute('value','test@gmail.com')", email);
		js.executeScript("arguments[0].setAttribute('value','9876543211')", phone);
		js.executeScript("arguments[0].value='Pune,Maharashtra'", address);
		js.executeScript("arguments[0].click()", genderRadioBtn);
		js.executeScript("arguments[0].click()", daysRadioBtn);
		
		Thread.sleep(3000);
//		driver.quit();

	}

}
