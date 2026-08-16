package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Select DropDown Value without using select class : Use generic Method From Elements Util:
public class DropDownHandleWithoutSelect_02 {

	static WebDriver driver;
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		By country = By.xpath("//select[@id='Form_getForm_Country']/option");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.selectDropDownvalueWithoutSelect(country, "India");

	}

}
