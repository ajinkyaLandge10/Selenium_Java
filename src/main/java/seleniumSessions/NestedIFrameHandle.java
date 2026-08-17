package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIFrameHandle {
	public static void main(String[] args) throws InterruptedException {
/*
Note : 1.parentFrame() - For switching from child to immediate parent frame/context
	   2.defaultContent() - For switching to main page
 */
		WebDriver driver = new ChromeDriver();// browser - chrome
		driver.get("https://selectorshub.com/iframe-scenario/");// page
		Thread.sleep(1500);

		// Frame: 1
		driver.switchTo().frame("pact1");
		driver.findElement(By.id("inp_val")).sendKeys("First_Text");

		// Frame: 2
		driver.switchTo().frame("pact2");
		driver.findElement(By.id("jex")).sendKeys("Second_Text");

		// Frame: 3
		driver.switchTo().frame("pact3");
		driver.findElement(By.id("glaf")).sendKeys("Third_Text");

		// Frame: 3--->1 --> Not Valid
		// driver.switchTo().frame("pact1"); //NoSuchFrameException
		// driver.findElement(By.id("inp_val")).sendKeys(" : First_Text_2");

		// Frame: 3-->2-->1 --> Not Valid-->Backward Direction
		//driver.switchTo().frame("pact2");
		//driver.switchTo().frame("pact1");
		//driver.findElement(By.id("jex")).sendKeys(" : Second_Text_2");
		
		// Frame: 3-->2
		driver.switchTo().parentFrame();
		driver.findElement(By.id("jex")).sendKeys(" : Second_Text_2");
		
		// Frame: 2-->1
		driver.switchTo().parentFrame();
		driver.findElement(By.id("inp_val")).sendKeys(" : First_Text_2");
		
		// Frame: 2-->Main page
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		String header = driver.findElement(By.xpath("//h6[text()='iframe and nested iframes']")).getText();
		System.out.println(header);
		
	}

}
