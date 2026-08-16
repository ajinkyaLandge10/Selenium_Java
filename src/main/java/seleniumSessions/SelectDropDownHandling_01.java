package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

// Handle (Select)drop-down normal method:
public class SelectDropDownHandling_01 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

// 	Drop down -- htmltag: <select> --> child tag--> <option>
//	Use Select class
//		-single selection
//		-Multi-selection		

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		driver.manage().window().maximize();

		By country = By.id("Form_getForm_Country");
		WebElement country_ele = driver.findElement(country);
		
		Select select = new Select(country_ele);
		select.selectByIndex(7); //recommended --> in Month drop-down (static data)
		Thread.sleep(1000);
		select.selectByVisibleText("Belgium");//recommended
		Thread.sleep(1000);
		select.selectByValue("Denmark");
			
	}

}
