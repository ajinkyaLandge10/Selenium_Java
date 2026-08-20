package seleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Streams_ParallelStreams {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://woocommerce.com/");
		Thread.sleep(5000);
		
//		driver.findElements(By.tagName("a"))
////			.stream()
//			.parallelStream()
//				.filter(e -> !e.getText().isEmpty())
//					.forEach(e -> System.out.println(e.getText()));
		
/*Note : 
		Difference between Stream & parallelStream
		- suppose we apply stream on list 1 by 1 element will be stored on stream
		- But in parallel stream from each element 1 specific stream will be there
		- So parallel Streams are not synchronous.(Asynchronous)
		- Parallel streams are faster than stream
		- in Parallel streams No order is maintained.
*/	
		System.out.println("-------------");
		
		// Blank ArrayList
		List<String> linksList = new ArrayList<String>(); 
		
		//Collecting all links WebElement
		List<WebElement> linkAllList = driver.findElements(By.tagName("a")) 
		        						.stream()
		        								.filter(e -> !e.getText().isEmpty())
		        									.collect(Collectors.toList());
		
		//Inserting all WebElement's Text in ArrayList
		linkAllList.forEach(e -> linksList.add(e.getText()));
		
		// Printing ArrayList
		System.out.println(linksList);
		
		
	}

}
