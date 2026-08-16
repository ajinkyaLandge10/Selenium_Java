package seleniumSessions;

//@formatter:off
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJSPopUpHandling {

	public static void main(String[] args) throws InterruptedException {
/*
alert : JS pop up//modal dialog pop ups --> Cannot be inspected as they are not WebElement
		1. alert
		2. prompt
		3. confirm
 Generate alert : On Browser
 				1.Open Chrome-Dev Tool
 				- In Console - Clear
 					1 - alert('Hello')
 					2 - prompt('Enter Name')
 					3 - confirm('are you sure you want to delete this user?')
 	Exceptions : 
			- NoAlertPresentException: If not switched to alert or alert is not there..
 */		
		
		WebDriver driver = new ChromeDriver();// Browser
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");// driver is on Page
		driver.manage().window().maximize();

		
//1 : 	simple alertJS Pop-Up:
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();	
		
		Alert alert1 = driver.switchTo().alert();// driver is on alert
		String text = alert1.getText();
		System.out.println(text);
		Thread.sleep(2000);
		alert1.accept();//accept the alert

//2 : 	confirm pop up:
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		Thread.sleep(2000);
		alert2.dismiss();//cancel the alert
		
//3 : 	Prompt pop up:
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Alert alert3 = driver.switchTo().alert();
		System.out.println(alert3.getText());
		alert3.sendKeys("Selenium_Alert_Handling");
		Thread.sleep(2000);
		alert3.accept();
		
		driver.close();
	}

}
