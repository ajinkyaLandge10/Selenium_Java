package seleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Capture language link text below search bar : Without generic method Normally
public class GoogleLanguageLinks_1 {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		List<WebElement> langLinks = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		System.out.println("Total Count : " + langLinks.size());
		
		int count = 1;
		for(WebElement e:langLinks) {
			String text = e.getText();
			System.out.println(count+" : "+text);
			count++;
				if(text.equals("मराठी")) {
					e.click();
					break;
				}
		}
	}

}
