package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Generic Code : 
public class CalendarHandling_02 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();

//		selectFutureDate("October 2027", 12);
//		selectFutureDate("October 2027", 35);
//		selectFutureDate("October 2027", 0);
//		selectFutureDate("February 2027",28);
		
		


	}

	public static void selectDate(int day) {
		driver.findElement(By.xpath("//a[text()='" + day + "']")).click();
	}

	public static void selectFutureDate(String expectedMonthYear, int day) {		
		String[] dateParts = expectedMonthYear.split(" ");
	    String month = dateParts[0];
	    int year = Integer.parseInt(dateParts[1]);
	    int maxDays;

	    // February Leap Year Check
	    if (month.equalsIgnoreCase("February")) {
	        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
	            maxDays = 29;  // Leap year
	        } else {
	            maxDays = 28;  // Non-leap year
	        }
	    }
	    // 30 Days Months Check
	    else if (month.equalsIgnoreCase("April") 
	    		|| month.equalsIgnoreCase("June")
	            || month.equalsIgnoreCase("September")
	            || month.equalsIgnoreCase("November")) {
	        maxDays = 30;
	    }else {
	        maxDays = 31;
	    }

	    // Validate day : 1-31 Check
	    if (day < 1 || day > maxDays) {
	        System.out.println("Wrong Date..." + expectedMonthYear +" has only " + maxDays + " days."
	        );
	        return;
	    }
		
		String currentMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		while (!currentMonthYear.equalsIgnoreCase(expectedMonthYear)) {		
			driver.findElement(By.xpath("//span[text()='Next']")).click();// Click on Next Symbol (>)
			currentMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		}
		selectDate(day);
	}

	
	public static void selectPastDate(String expectedMonthYear, int day) {
		String[] dateParts = expectedMonthYear.split(" ");
	    String month = dateParts[0];
	    int year = Integer.parseInt(dateParts[1]);
	    int maxDays;

	    // February Leap Year Check
	    if (month.equalsIgnoreCase("February")) {
	        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
	            maxDays = 29;  // Leap year
	        } else {
	            maxDays = 28;  // Non-leap year
	        }
	    }
	    // 30 Days Months Check
	    else if (month.equalsIgnoreCase("April") 
	    		|| month.equalsIgnoreCase("June")
	            || month.equalsIgnoreCase("September")
	            || month.equalsIgnoreCase("November")) {
	        maxDays = 30;
	    }else {
	        maxDays = 31;
	    }

	    // Validate day : 1-31 Check
	    if (day < 1 || day > maxDays) {
	        System.out.println("Wrong Date..." + expectedMonthYear +" has only " + maxDays + " days."
	        );
	        return;
	    }
	    
		String currentMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		while (!currentMonthYear.equalsIgnoreCase(expectedMonthYear)) {
			// Click on Next Symbol (>)
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			currentMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		}
		selectDate(day);
	}

}
