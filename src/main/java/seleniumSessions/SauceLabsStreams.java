package seleniumSessions;

//@formatter:off
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceLabsStreams {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> pricesList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		System.out.println("Total Products : " + pricesList.size());
		
//1.Capture Prices & Print
//		pricesList.stream().forEach(e -> System.out.println(e.getText()));

		
//2.Capture all prices - $29.99 -> Remove $ and convert string to actual numeric value & sort in Ascending order ($29.99 --> "29.99" --> 29.99).
//		List<Double> sorted_prices_asc = pricesList.stream()
//									.map(e -> Double.parseDouble(e.getText().substring(1)))
//										.sorted()
//											.collect(Collectors.toList());
//		System.out.println("Ascending order");
//		System.out.println(sorted_prices_asc);
		
		
//3.Capture all prices - $29.99 -> Remove $ and convert string to actual numeric value & sort in Descending order
//		List<Double> sorted_prices_desc = pricesList.stream()
//											.map(e -> Double.parseDouble(e.getText().substring(1)))
//												.sorted(Comparator.reverseOrder())
//													.collect(Collectors.toList());
//		System.out.println("Descending order");
//		System.out.println(sorted_prices_desc);
		
//4.Capture first price		
//		Double firstPrice = pricesList.stream()
//					.map(e -> Double.parseDouble(e.getText().substring(1)))
//						.findFirst().get();
//		
//		System.out.println(firstPrice);
		
//5.Capture last price		
//		Double lastPrice = pricesList.stream()
//				.map(e -> Double.parseDouble(e.getText().substring(1)))
//					.reduce((first , second) -> second ).get();
//	
//		System.out.println(lastPrice);
	
//6.Capture Maximum price	
//		Double maximumPrice = pricesList.stream()
//				.map(e -> Double.parseDouble(e.getText().substring(1)))
//					.max(Double::compareTo).get();
//		
//		System.out.println(maximumPrice);
		
//7.Capture Minimum price	
		Double minimumPrice = pricesList.stream()
				.map(e -> Double.parseDouble(e.getText().substring(1)))
					.min(Double::compareTo).get();
				
		System.out.println(minimumPrice);		
			
	}

}
