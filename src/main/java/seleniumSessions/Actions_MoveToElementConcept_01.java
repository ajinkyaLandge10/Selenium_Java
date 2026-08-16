package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// Normal Method : 
public class Actions_MoveToElementConcept_01 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
//	Actions class:-->User Actions:--> Mouse and Keyboard --> Purpose of Actions Class :User actions: w3c WebDriver standards/protocols
//	1.Actions (class) --> returns Self reference
//	2.Action (Interface) --> build() and perform() are from Action Interface & implementation is in Actions Class & both of these methods returns Action
		
		driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
			
		By parentMenu = By.xpath("//button[@id='developers-dd-toggle']");
		WebElement parentMenuElement = driver.findElement(parentMenu);
		
		Actions act = new Actions(driver);
		act.moveToElement(parentMenuElement).build().perform();
		
		driver.findElement(By.xpath("//a[contains(@data-title,'Support')]")).click();
		
/*
Note :  
		1. act.a1.perform();				--> Valid
  		2. act.a1.build().perform(); 		--> Valid		
  		3. act.a1.a2.a3.build().perform();	--> Valid
  		4. act.a1.build(); 					--> InValid
		5. act.a1							--> InValid
		6. act.a1.a2.a3.build();			--> Invalid  
 */
	}
	
}
