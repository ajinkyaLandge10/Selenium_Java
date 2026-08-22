package miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartSVGElement {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@role='button']")).click();

		driver.findElement(By.name("q")).sendKeys("macbook pro");
		driver.findElement(By.xpath("(//*[local-name()='svg' and @fill='none'])[3]")).click();
	}

}
