package seleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Multi-Selection DropDown : Normal Method:
public class MultiSelectDropDownHandling_01 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");

		Select select = new Select(driver.findElement(By.xpath("//select[@multiple]")));
		if (select.isMultiple()) {
			System.out.println("Yes : It is multi-Select DropDown..");
			select.selectByVisibleText("American flamingo");
			select.selectByVisibleText("Chilean flamingo");
			select.selectByVisibleText("James's flamingo");
		}

		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		System.out.println(allSelectedOptions.size());

		Thread.sleep(1000);
		select.deselectByVisibleText("Chilean flamingo");
		Thread.sleep(1000);
		select.selectByVisibleText("Chilean flamingo");
		Thread.sleep(1000);
		select.deselectAll();

		System.out.println(select.getAllSelectedOptions().size());

	}

}
