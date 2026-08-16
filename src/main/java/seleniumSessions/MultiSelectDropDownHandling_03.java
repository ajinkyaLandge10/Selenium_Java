package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiSelectDropDownHandling_03 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		By dropDownLocator = By.xpath("//select[@multiple]");
		By optionLocator = By.xpath("//select[@multiple]/option");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		//For Single value Selection
		eleUtil.selectDropDownMultipleValues(dropDownLocator, optionLocator, "American flamingo");
		
		//For Multiple value Selection
		eleUtil.selectDropDownMultipleValues(dropDownLocator, optionLocator, "American flamingo","Chilean flamingo","James's flamingo");
		
		//For All value Selection
		eleUtil.selectDropDownMultipleValues(dropDownLocator, optionLocator, "SelectAll");
	}

}
