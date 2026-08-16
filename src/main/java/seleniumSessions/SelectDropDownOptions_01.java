package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Select DropDown Options - Normal Method : 
public class SelectDropDownOptions_01 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");

		By country = By.id("Form_getForm_Country");
		WebElement country_ele = driver.findElement(country);
		Select select = new Select(country_ele);

		List<WebElement> countryList = select.getOptions(); // Returns all the Options(Only select based DD)
		System.out.println(countryList.size());

		// Print all countries on console:
		for (WebElement e : countryList) {
			String text = e.getText();
			System.out.println(text);
		}
		System.out.println("-------------------");
		
		
		// Print 'value' attribute of all countries on console:
		for (WebElement e : countryList) {
			String attributeValue = e.getAttribute("value");
			System.out.println(attributeValue);
		}
		System.out.println("-------------------");

		
		// Iterate & Select specific country without inbuilt method
		for (WebElement e : countryList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("Belgium")) {
				e.click();
				break;
			}
		}
	}
}
