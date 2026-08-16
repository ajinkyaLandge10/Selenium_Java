package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Multi-Selection DropDown : Generic Method:
public class MultiSelectDropDownHandling_02 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		By dropDownLocator = By.xpath("//select[@multiple]");
		By optionLocator = By.xpath("//select[@multiple]/option");

//TC-1 :For Multiple value Selection
		//selectDropDownMultipleValues(dropDownLocator,optionLocator, "American flamingo", "Chilean flamingo", "James's flamingo");

//TC-2 :For Single value Selection
		//selectDropDownMultipleValues(dropDownLocator,optionLocator, "American flamingo");

//TC-3 :For All value Selection
		selectDropDownMultipleValues(dropDownLocator,optionLocator, "SelectAll");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static boolean isDropDownMultiple(By locator) {
		Select select = new Select(getElement(locator));
		return select.isMultiple() ? true : false;
	}

	/**
	 * This method is used to select values from DropDown. It can Select:
	 * 1. Single Selection
	 * 2. Multiple Selection
	 * 3. All Selection :- Please Pass "SelectAll" as value Parameter, to select all values from DropDown.
	 * @param locator
	 * @param values
	 */
	public static void selectDropDownMultipleValues(By locator,By optionsLocator, String... values) {
		Select select = new Select(getElement(locator));

		if (isDropDownMultiple(locator)) {
			if (values[0].equalsIgnoreCase("SelectAll")) {
				List<WebElement> optionsList = driver.findElements(optionsLocator);
				for (WebElement e : optionsList) {
					e.click();
				}
			}else {
				for (String value : values) {
					select.selectByVisibleText(value);
				}
			}

		}
	}

}
