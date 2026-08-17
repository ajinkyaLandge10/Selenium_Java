package seleniumSessions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

		driver.findElement(By.cssSelector("#imageTemplateContainer")).click();
		Thread.sleep(3000);

		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]"));
		driver.switchTo().frame(frame);

		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("Selenium");

		// defaultContent : Used to switch driver focus back to main(parent)page
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		String header = driver.findElement(By.xpath("//h1[text()='Vehicle Registration Form Template']")).getText();
		System.out.println(header);

	}

}
