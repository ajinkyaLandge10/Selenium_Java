package seleniumSessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author AjinkyaL.. BrowserUtil is having multiple generic methods to handle
 *         the various browser actions
 */
public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to launch the browser on the basis of given BrowserName
	 * 
	 * @param browserName
	 * @return driver instance
	 */
	public WebDriver launchBrowser(String browserName) {
		System.out.println("Browser Name : " + browserName);
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please pass the right browser...");
			throw new AutomationException("Invalid Browser : " + browserName);
		}
		return driver;
	}

	/**
	 * This method is used to launch the Url.
	 * @param url
	 */
	public void launchURL(String url) {
		if (url == null) {
			System.out.println("Url Is Null");
			throw new AutomationException("NULL Url...");
		}
		// http://www.google.com
		if (url.indexOf("http") == 0) {
			driver.get(url);
		} else {
			throw new AutomationException("HTTP is Missing...");
		}
	}
	
	public void launchURL(URL url) {
		if (url == null) {
			System.out.println("URL IS NULL");
			throw new AutomationException("NULL URL");
		}
		driver.navigate().to(url);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("Page Title is : " + title);
		return title;
	}

	public String getPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Page url is : " + url);
		return url;
	}

	public boolean getPageSource(String value) {
		String pageSource = driver.getPageSource();
		if (pageSource.contains(value)) {
			return true;
		}
		return false;
	}

	public void closeBrowser() {
		driver.close();
		System.out.println("Browser is closed...");
	}

	public void quitBrowser() {
		driver.quit();
		System.out.println("Browser is closed...");
	}

}
