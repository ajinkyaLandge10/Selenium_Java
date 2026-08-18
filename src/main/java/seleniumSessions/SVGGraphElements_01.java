package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGGraphElements_01 {
	public static void main(String[] args) throws InterruptedException {
/*	
	SVG element - Scalar Vector Graphics
				- Can not use CSS for SVG 
				- Only X-path is applicable : 
				- Normal x-path won't work need Special x-path syntax
*/		

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@name='q' and @type='text'])[1]")).sendKeys("Macbook");
		driver.findElement(By.xpath("//button[@type='submit']//*[local-name()='svg']")).click();
		
	}

}
