package seleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {
	public static void main(String[] args) {

//	findElement: find the single element + perform action
//	findElements: find the multiple elements and store in the List + No Action

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		// Find size of Total Number of Fields in Registration form & fetch their names 
		List<WebElement> textFIeldList = driver.findElements(By.className("form-control"));
		
		//size
		System.out.println("Total no of Text Fileds : " + textFIeldList.size());
		// fetching all field names
		for (WebElement e : textFIeldList) {
			System.out.println(e.getAttribute("name"));
		}

	}

}
