package miscellaneous;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart_DataScrapping {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com");
			try {
				WebElement closeButton = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@role='button']")));
				closeButton.click();
			} catch (Exception e) {
				System.out.println("Login popup not displayed.");
			}

//Search product
			WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
			searchBox.sendKeys("iphone 18");
			searchBox.submit();
//Wait for search results
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'/p/')]")));
//Pagination
			int pageNumber = 1;
			while (true) {
				System.out.println("==============================");
				System.out.println("PAGE : " + pageNumber);
//Print products on current page & Find Next Button
				printProducts(driver);
				List<WebElement> nextButtons = driver.findElements(By.xpath("(//span[normalize-space()='Next'])[1]"));
//Next button not found
				if (nextButtons.isEmpty()) {
					System.out.println("Next button not found. Scraping completed.");
					break;
				}
				WebElement nextButton = nextButtons.get(0);
//Check visibility
				if (!nextButton.isDisplayed()) {
					System.out.println("Next button is not visible. Scraping completed.");
					break;
				}
//current URL
				String oldUrl = driver.getCurrentUrl();
// Scroll to Next button & Click
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
						nextButton);
				wait.until(ExpectedConditions.elementToBeClickable(nextButton));
				nextButton.click();
//Wait for URL to change
				try {
					wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));
				} catch (Exception e) {
					System.out.println("URL did not change after clicking Next.");
					break;
				}
//Wait for products on new page
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'/p/')]")));
				pageNumber++;
			}
		} finally {
			driver.quit();
		}
	}

//Print Products : 
	public static void printProducts(WebDriver driver) {
		List<WebElement> products = driver.findElements(By.xpath("//a[contains(@href,'/p/')]"));
		int count = 0;
		for (WebElement product : products) {
			try {
				String text = product.getText().trim();
				if (text.isEmpty()) {
					continue;
				}
				if (text.contains("₹")) {
					System.out.println(text.replace("\n", " ---> "));
					count++;
				}
			} catch (Exception e) {

			}
		}
		System.out.println("Products captured : " + count);
	}
}
