package seleniumSessions;

//@formatter:off
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Streams_Concept {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://woocommerce.com/");
		Thread.sleep(5000);
		
		//Streams -- Adeed in JDK 8
		//Just like loops Streams are used to iterate
		//lambda :  ->
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
//1.Print Text of all Links including empty
		
		//allLinks
		//	.stream()
		//		.forEach(e -> System.out.println(e.getText())); 
	
		
//2.Print Text of all Links & Exclude Empty text links
		
		//allLinks
		//	.stream()
		//		.filter(e -> !e.getText().isEmpty())
		//			.forEach(e -> System.out.println(e.getText()));
	
		
//3.Print Text of all Links & Exclude Empty text links & also capture those contains 'WooCommerce'
		
		//allLinks
		//	.stream()
		//		.filter(e -> !e.getText().isEmpty())
		//			.filter(e -> e.getText().contains("WooCommerce"))
		//				.forEach(e -> System.out.println(e.getText()));
		
		
//4.Collect all Links & Exclude Empty text links & also capture those contains 'WooCommerce' in Collection. 		
		
		List<WebElement> WooCommerceLinks = allLinks
											.stream()
												.filter(e -> !e.getText().isEmpty())
													.filter(e -> e.getText().contains("WooCommerce"))
														.collect(Collectors.toList());
				
		List<String> WooCommerceText = WooCommerceLinks.stream().map(e -> e.getText()).collect(Collectors.toList());
		System.out.println(WooCommerceText.size());
		System.out.println(WooCommerceText);
			
		
	}

}
