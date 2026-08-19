package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackgroundColor {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		WebElement element = driver.findElement(By.xpath("//input[@value='Login']"));
		
		//For Fetching background Color of element
		String bgColor = element.getCssValue("backgroundColor");
		System.out.println(bgColor);
		
		//For Fetching Height & Width of element
		Rectangle rect = element.getRect();
		System.out.println(rect.height);
		System.out.println(rect.width);
		
		//For Fetching Co-ordinates of element on the page
		System.out.println(rect.getX());
		System.out.println(rect.getY());
					//Or//
		//For Fetching Co-ordinates of element on the page
		int x = element.getLocation().x;
		int y = element.getLocation().y;
		System.out.println(x);
		System.out.println(y);
	}

}
