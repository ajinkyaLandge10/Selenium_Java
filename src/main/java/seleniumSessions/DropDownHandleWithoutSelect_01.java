package seleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Select DropDown Value without using select class : Create Generic Method:
public class DropDownHandleWithoutSelect_01 {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");

//		By country = By.cssSelector("select#Form_getForm_Country > option");
		By country = By.xpath("//select[@id='Form_getForm_Country']/option");
		
		selectDropDownvalueWithoutSelect(country, "India");

	}

	public static void selectDropDownvalueWithoutSelect(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);
		for(WebElement e: optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
}
