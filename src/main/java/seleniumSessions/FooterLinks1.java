package seleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Capture Footer Links on the WebPage without using Generic function
public class FooterLinks1 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
//		1. / --> direct child
//		2. // -> for indirect child

		By footerLinks = By.xpath("//footer//a");

		List<WebElement> footerLinksList = driver.findElements(footerLinks);
		System.out.println("Total Footer Links : " + footerLinksList.size());

		int count = 1;
		for (WebElement e : footerLinksList) {
			String text = e.getText();
			System.out.println(count + " : " + text);
			count++;
		}
	}

}
