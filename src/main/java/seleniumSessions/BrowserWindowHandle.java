package seleniumSessions;

//@formatter:off
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandle {
	public static void main(String[] args) throws InterruptedException {
		
/*
	Note: -If a Link is having attribute target="_blank" : it will always open in new window/tab
		  1.getWindowHandle()  --> 1.Return single/current window id 
		  						 2.Returns String
		  2.getWindowHandles() --> 1.Returns all window id's
		  						 2.Returns Set<String>
		  -Id's should be unique thats why they are maintained with set collection
		  
*/	
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();

		// 1.Fetch window ID's:
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String parentWindowId = it.next();
		System.out.println("Parent Window Id : " + parentWindowId);
		String childWindowId = it.next();
		System.out.println("Child Window Id : " + childWindowId);
		
		Thread.sleep(3000);
		
		// 2.Switching to Child:
		driver.switchTo().window(childWindowId);
		System.out.println("Child Window URL : " + driver.getCurrentUrl());
		System.out.println("Child Window Title : " + driver.getTitle());
		driver.close();
		
		Thread.sleep(3000);
		
		// 3.Switching Back to Parent:
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent Window URL : " + driver.getCurrentUrl());
		System.out.println("Parent Window Title : " + driver.getTitle());
		driver.quit();
		
	}

}
