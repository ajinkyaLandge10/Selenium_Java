package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JS_PageContentTest {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String allText = js.executeScript("return document.documentElement.innerText").toString();
		
//		System.out.println(allText);
		
		if (allText.contains("Pumpkin")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
}
