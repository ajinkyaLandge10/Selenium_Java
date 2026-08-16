package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Select DropDown Options - with Generic Method from Element utility class : 
public class SelectDropDownOptions_03 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		
		By country = By.id("Form_getForm_Country");
		ElementUtil eleUtil = new ElementUtil(driver);
		
		//Count
		int dropDownOptionsCount = eleUtil.getDropDownOptionsCount(country);
		System.out.println(dropDownOptionsCount);
		
		//Verify 'India' is Present 
		List<String> dropDownOptions = eleUtil.getDropDownOptions(country);
		if(dropDownOptions.contains("India")) {
			System.out.println("Pass..");
		}else {
			System.out.println("Fail..");
		}
		
		//Select specific option:
		eleUtil.selectDropDownOptions(country, "Panama");
	}

}
