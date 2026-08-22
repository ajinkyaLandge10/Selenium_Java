package miscellaneous;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Number Of Links : " + links.size());
		
		List<String> urlList = new ArrayList<String>();
		for(WebElement e: links) {
			String url = e.getAttribute("href");
			urlList.add(url);
		}
		
		urlList.parallelStream().forEach(e -> checkBrokenLinks(e));
		
		driver.quit();
	}
	
	public static void checkBrokenLinks(String linkUrl) {
		
		try {
			
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(7000);
			httpURLConnection.connect();
			
				if(httpURLConnection.getResponseCode() >=400) {
					System.out.println(linkUrl + " ----> " + httpURLConnection.getResponseMessage() + " is a Broken Link" );
				}else {
					System.out.println(linkUrl + " ----> " + httpURLConnection.getResponseMessage());
				}
			} catch (Exception e) {
				System.out.println(e);
			}		

	}

}
