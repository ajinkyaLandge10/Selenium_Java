package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//driver.findElement(By.id("input-email123")).sendKeys("Test@gmail.com"); // NoSuchElementException:No such element:Unable to locate element.
		
		//Sendkeys Method only accept String ,so if you want to pass integer value in sendkeys method first convert it to string then pass
		//int totalBill = 123;
		//String totalBillAmount = String.valueOf(totalBill);
		//driver.findElement(By.id("input-email")).sendKeys(totalBillAmount);
		
		//driver.findElement(By.id("input-email")).sendKeys(null); // IllegalArgumentException
	
		//SendKeys Accept: String, StringBuilder, StringBuffer --> SendKeys accept CharSequence
		//CharSequence (I) <-- string, StringBuilder, StringBuffer
		
		StringBuilder sb = new StringBuilder("Test");
		//driver.findElement(By.id("input-email")).sendKeys(sb);
		driver.findElement(By.id("input-email")).sendKeys(sb+"@gmail.com");
	
	}

}
