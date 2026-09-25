package miscellaneous;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleLink {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		WebElement footer = driver.findElement(By.cssSelector("#gf-BIG"));
		List<WebElement> li = footer.findElements(By.tagName("a"));
		String parent = driver.getWindowHandle();
		String keys = Keys.chord(Keys.CONTROL, Keys.ENTER);

		for (int i = 0; i < li.size(); i++) {
			li.get(i).sendKeys(keys);
			Set<String> hs = driver.getWindowHandles();
			Iterator<String> it = hs.iterator();

			while (it.hasNext()) {
				String childWindow = it.next();
				if (!parent.equals(childWindow)) {
					driver.switchTo().window(childWindow);
					String title = driver.getTitle();
					System.out.println(title);
					driver.close();
					driver.switchTo().window(parent);
				}
			}
		}
		driver.quit();

	}

}
