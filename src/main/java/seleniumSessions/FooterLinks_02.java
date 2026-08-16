package seleniumSessions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Capture Footer Links on the WebPage. Create Generic function
public class FooterLinks_02 {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		By footerLinks = By.xpath("//footer//a");
		
		ElementUtil eleUtils = new ElementUtil(driver);
		int count = eleUtils.getElementsCount(footerLinks);
		System.out.println("Total Links : " + count);
		
		List<String> actFooterList = eleUtils.getElementTextList(footerLinks);
		List<String> expFooterList = Arrays.asList("About Us", "Returns", "Specials", "Wish List");
		
		if(actFooterList.containsAll(expFooterList)) {
			System.out.println("Pass : Important Links present");
		}else {
			System.out.println("Fail : Important Links Absent");
		}

	}

}
