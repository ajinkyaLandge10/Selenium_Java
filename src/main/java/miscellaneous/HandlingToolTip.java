package miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingToolTip {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/css/tryit.asp?filename=trycss_tooltip");

		driver.switchTo().frame("iframeResult");

		Actions act = new Actions(driver);
		WebElement hoverElement = driver.findElement(By.className("tooltip"));
		act.moveToElement(hoverElement).perform();

		WebElement toolTipElement = driver.findElement(By.className("tooltiptext"));
		String toolTipText = toolTipElement.getText();
		System.out.println(toolTipText);

		driver.quit();

	}
}
