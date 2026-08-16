package seleniumSessions;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Select DropDown Options - with Generic Method :
public class SelectDropDownOptions_02 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		By country = By.id("Form_getForm_Country");

//	  1.Capture the count in the dropdown
		int dropDownOptionsCount = getDropDownOptionsCount(country);
		System.out.println(dropDownOptionsCount);

//    2.Print all the options
		List<String> dropDownOptions = getDropDownOptions(country);
		for (String e : dropDownOptions) {
			System.out.println(e);
		}
		// Check specific country is present in list
		if (getDropDownOptions(country).contains("Panama")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

//	  3.Select a specific option
		selectDropDownOptions(country, "Norway");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}

	public static List<String> getDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));

		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}

	public static void selectDropDownOptions(By locator, String dropDownValue) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}

	}

}
