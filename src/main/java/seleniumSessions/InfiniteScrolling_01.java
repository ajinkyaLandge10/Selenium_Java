package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Infinite Scrolling
public class InfiniteScrolling_01 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://scrollmagic.io/examples/advanced/infinite_scrolling.html");

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

			while (true) {
				// Scroll down to bottom of the page
				js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
				Thread.sleep(2000);

				// calculate new scroll height & Compare with last scroll height
				long newHeight = (long) js.executeScript("return document.body.scrollHeight");
				if (newHeight == lastHeight) {
					// Break the loop if the bottom of the page is reached
					break;
				}
				lastHeight = newHeight;
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
