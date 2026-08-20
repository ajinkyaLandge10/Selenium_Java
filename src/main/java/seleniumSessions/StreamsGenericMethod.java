package seleniumSessions;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StreamsGenericMethod {
	static WebDriver driver;
	
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		By headerList = By.xpath("//section[@id='details']//h3");
		
		//1.
		printListUsingStreams(headerList);
		//2.
		if(getListUsingStreams(headerList).contains("Documents")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		

	}
	
	public static void printListUsingStreams(By locator) {
		driver.findElements(locator)
			.stream()
				.forEach(e -> System.out.println(e.getText()));
	}	
	
	public static List<String> getListUsingStreams(By locator) {
		return driver.findElements(locator)
		.stream()
			.map(e -> e.getText())
				.collect(Collectors.toList());
	}

}
