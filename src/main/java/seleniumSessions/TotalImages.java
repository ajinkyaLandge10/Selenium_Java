package seleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://4kwallpapers.com/");

		List<WebElement> totalImages = driver.findElements(By.tagName("img"));
		System.out.println("Total No of Images : " + totalImages.size());

		// Iteration :
		for (WebElement e : totalImages) {
			String alt = e.getAttribute("alt");
			String src = e.getAttribute("src");
			if (alt.length() != 0 && src.length() != 0) {
				System.out.println("alt ==> " + alt + "\n" + "src ==> " + src);
			}
		}
	}

}
