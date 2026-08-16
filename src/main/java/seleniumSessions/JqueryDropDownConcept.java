package seleniumSessions;

//@formatter:off
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDownConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();

//Note: On this page total 3 DropDowns are available & each one have 15 span so total 45 span.
		//For first 15 span(1st DropDown):
		List<WebElement> choicesList = driver.findElements(By.cssSelector("span.comboTreeItemTitle"));

		//Iterate the list and click on specific option
//		for (WebElement e : choicesList) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.contains("2")) {
//				e.click();
//				break;
//			}
//		}

		//Iterate the list & click on all options
		for (WebElement e : choicesList) {
			try {
				e.click(); // ElementNotInteractableException --> After 15 elements
			} catch (ElementNotInteractableException ex) {
				System.out.println("DropDown Choices Are Over....");
				break;
			}
		}

	}
//NOTE: This x-path will give 1/15 --> Use this to avoid ElementNotInteractableException
	//h3[text()='Single Selection']//following-sibling::div//div[@class='comboTreeDropDownContainer']/ul//li
	
	
// Assignment : Create single,Multiple & All Selection generic method for this and add in Element Utils:

}