package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Actions_Signature {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://cocosign.com/signature-generator/draw/");
		Thread.sleep(3000);
		
		WebElement canvas = driver.findElement(By.xpath("//canvas[@id='signature-pad']"));
		
		Actions act = new Actions(driver);
		
		Action signature = act.click(canvas)
						   .moveToElement(canvas, 30, 25)
						   .clickAndHold(canvas)
						   .moveToElement(canvas, -120, 150)
						   .moveByOffset(150, -75)
						   .moveByOffset(-19, 56)
						   .moveByOffset(76, -32)
						   .moveByOffset(150, -75)
						   .moveByOffset(-19, 56)
						   .moveByOffset(76, -32)
						   .release(canvas)
						   .build();
						
		signature.perform();

	}

}
