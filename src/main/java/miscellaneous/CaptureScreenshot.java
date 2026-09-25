package miscellaneous;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshot {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@role='button']")).click();
		Thread.sleep(3000);

//Full Page ScreenShot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefIle1 = ts.getScreenshotAs(OutputType.FILE);
		File targetfile1 = new File(System.getProperty("user.dir") + "\\screenshots\\Fullpage.png");
		sourcefIle1.renameTo(targetfile1);
		
		driver.quit();
	}
}
