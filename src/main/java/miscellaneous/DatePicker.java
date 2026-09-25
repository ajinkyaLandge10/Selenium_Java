package miscellaneous;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);

//		Method 1 -  Using SendKey()
//		driver.findElement(By.id("datepicker")).sendKeys("06/18/2026");

//		Method 2 -  Using Datepicker
		// Expected Data
		String exp_year = "2032";
		String exp_month = "May";
		String exp_date = "2";

		driver.findElement(By.id("datepicker")).click();

		// Select Month and Year
		while (true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currentMonth.equals(exp_month) && currentYear.equals(exp_year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Next Button
		}

		// Select Date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for (WebElement dt : allDates) {
			if (dt.getText().equals(exp_date)) {
				dt.click();
				break;
			}
		}
	}

}
