package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JS_PageScrollTest {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
			
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//		Thread.sleep(2000);
//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
//		Thread.sleep(2000);
//		jsUtil.scrollMiddlePage();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
//		Thread.sleep(2000);
//		jsUtil.zoomChromeEdgeSafari(80);
		
		WebElement pop = driver.findElement(By.id("mousehover"));
		jsUtil.scrollIntoView(pop);
		jsUtil.drawBorder(pop);
	
	}

}
