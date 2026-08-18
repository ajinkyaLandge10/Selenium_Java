package seleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGGraphElements_02 {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map");
//		driver.manage().window().maximize();
		Thread.sleep(5000);

//		Browser --> Page --> i-frame --> SVG

		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]"));
		driver.switchTo().frame(frame);

		String stateXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='g' and @class='region']";

		List<WebElement> statesList = driver.findElements(By.xpath(stateXpath));
		System.out.println("Total Number Of States : " + statesList.size());

		Actions act = new Actions(driver);
		for (WebElement e : statesList) {
			act.moveToElement(e).perform();
			Thread.sleep(500);
			String idVal = e.getAttribute("id");
			System.out.println(idVal);
			if (idVal.contains("ohio")) {
				e.click();
				break;
			}
		}
	}

}
