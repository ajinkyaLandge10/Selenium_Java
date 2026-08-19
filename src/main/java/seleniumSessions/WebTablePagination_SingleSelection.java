package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePagination_SingleSelection {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		jsUtil.scrollMiddlePage();
		Thread.sleep(3000);

		
		// Single Selection:
		while(true) {
			//If the Element is present on the first page itself
			if(driver.findElements(By.xpath("//td[text()='Ukraine']")).size()>0) {
				selectCountry("Ukraine");
				break;
			}else {
				//pagination logic: click on next(>):
				WebElement next = driver.findElement(By.xpath("//button[@type='button' and @aria-label='Next']"));
					if(next.getAttribute("class").contains("disabled")) {
						System.out.println("Pagination is over..Country is Not Found");
						break;
					}
				next.click();
				Thread.sleep(1000);
			}
		}
	}
	
	public static void selectCountry(String countryName) {
		driver.findElement(By.xpath("//td[text()='"+countryName+"']//preceding-sibling::td/input[@type='checkbox']")).click();
	}

}
