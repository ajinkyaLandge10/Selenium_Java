package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();// Browser
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");// Page
		Thread.sleep(1000);

		//Switching to frames 3 ways :
			//1.By index
				// driver.switchTo().frame(2);
			//2.By Name/id :
				// driver.switchTo().frame("main");
			//3.By WebElement
				WebElement frame = driver.findElement(By.xpath("//frame[@name='main']"));
				driver.switchTo().frame(frame);

		String header = driver.findElement(By.xpath("//h2[text()='Title bar ']")).getText();
		System.out.println(header);
		
		//2 types of frames:
			//1. frame tag -- deprecated -- OLD -- not recommended by w3c
			//2. iFrame tag -- new -- w3c
	}

}
