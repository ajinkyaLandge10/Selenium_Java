package miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownDefaultOption {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");

		By country = By.id("Form_getForm_Country");
		By employee = By.id("Form_getForm_NoOfEmployees");

//		WebElement countryEle = driver.findElement(country);
//		
//		Select selectCountry = new Select(countryEle);
//		
//		String defaultValue = selectCountry.getFirstSelectedOption().getText();
//		System.out.println(defaultValue);

		if (getDropDownFirstSelectValue(country).contains("Country")) {
			System.out.println("Pass");
		}

		if (getDropDownFirstSelectValue(employee).contains("Number of Employees")) {
			System.out.println("Pass");
		}

	}

	public static String getDropDownFirstSelectValue(By locator) {
		Select select = new Select(getElement(locator));
		return select.getFirstSelectedOption().getText();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
