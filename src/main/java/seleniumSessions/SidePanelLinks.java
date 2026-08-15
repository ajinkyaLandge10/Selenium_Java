package seleniumSessions;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SidePanelLinks {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By sidePanelLinks = By.xpath("//a[@class='list-group-item']");
		
		ElementUtil eleUtils = new ElementUtil(driver);
		int count = eleUtils.getElementsCount(sidePanelLinks);
		System.out.println("Total SidePanel Links : " + count);
		
		List<String> actSidePanelList = eleUtils.getElementTextList(sidePanelLinks);
		List<String> expSidePanelList = Arrays.asList("Login", "Register", "Forgotten Password", "My Account", "Transactions");
		
		if(actSidePanelList.containsAll(expSidePanelList)) {
			System.out.println("Pass : Important Links present");
		}else {
			System.out.println("Fail : Important Links Absent");
		}
	}

}
