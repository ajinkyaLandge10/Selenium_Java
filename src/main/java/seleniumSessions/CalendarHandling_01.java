package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Normal Code:
public class CalendarHandling_01 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();

		String currentMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//		System.out.println(actMonthYear);

		while (!currentMonthYear.equalsIgnoreCase("January 2027")) {
			// Click on Next Symbol (>)
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			currentMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		}
		selectDate("26");

	}

	public static void selectDate(String day) {
		driver.findElement(By.xpath("//a[text()='" + day + "']")).click();
	}

}
