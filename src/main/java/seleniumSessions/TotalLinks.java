package seleniumSessions;
//@formatter:off
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {
	public static void main(String[] args) {
/*
	Get the total links on the page
	Get the text of each link but ignore the blank text links
	Get the 'href' value for each link
*/
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println("Total No of Links : " + linksList.size());

		// For Loop :
//		for (int i = 0; i < linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//			if (text.length() != 0) {
//				System.out.println(i+" : "+text);
//			}
//		}
		
		//For each Loop:
		for(WebElement e : linksList) {
			String text = e.getText();
			if (text.length() != 0) {
				String hrefVal = e.getAttribute("href");
				System.out.println(text+"    -->>    "+hrefVal);
			}
		}
		
		//WebScrapping --> capturing the data from Website
	}

}
