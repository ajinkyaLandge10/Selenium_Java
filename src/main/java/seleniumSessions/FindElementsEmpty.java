package seleniumSessions;

//@formatter:off
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsEmpty {

	static WebDriver driver;

	public static void main(String[] args) {
			driver = new ChromeDriver();
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

/*
Note : 		1. When xpath syntax is correct but value is note Present : NoSuchElementException
				Ex: //input[@class='Test']
		 	2. when xpath syntax is wrong : InvalidSelectorException
				Ex: //input[@class..'Test']
*/		 
			 
//** FindElement:
			//driver.findElement(By.xpath("//input[@class='Test']")).sendKeys("Selenium");//NoSuchElementException
			
//** FindElements:			
			//List<WebElement> eles = driver.findElements(By.xpath("//input[@class='Test']"));
			//System.out.println(eles);//[]
			//System.out.println(eles.size());//0
			
			
			By logo = By.cssSelector(".img-responsive");
			if(checkElementPresent(logo)) {
				System.out.println("Pass.. Logo is Present");
			}else {
				System.out.println("Fail.. Logo is Absent");
			}
	}

	public static boolean checkElementPresent(By locator) {
		return driver.findElements(locator).size()==1 ? true : false;
	}
}
