package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Create a Method for selecting user in WebTable --> This method is application Specific ( only works for SelectorsHub)
public class WebTableHandlingConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(4000);

		selectUser("Joe.Root");
		selectUser("Garry.White");
		selectUser("John.Smith");
		selectUser("Kevin.Mathews");
		
		List<String> joeDetails = getUserInfo("Joe.Root");
		System.out.println(joeDetails);
		if(joeDetails.contains("ESS")) {
			System.out.println("Pass..");
		}else {
			System.out.println("Fail..");
		}

	}

	public static void selectUser(String userName) {
		driver.findElement(By.xpath("// a[text()='" + userName + "']/parent::td/preceding-sibling::td/child::input[@type='checkbox']"))
				.click();
	}
	
	public static List<String> getUserInfo(String userName) {
		List<WebElement> colEles = driver.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td"));
		List<String> colValueList = new ArrayList<String>();
		
		for(WebElement e : colEles) {
			String text = e.getText();
			colValueList.add(text);
		}
		return colValueList;
	}
}
