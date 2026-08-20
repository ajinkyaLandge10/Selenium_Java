package seleniumSessions;

//@formatter:off
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassicCRMStreams {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");

//1. Capture all the text from all paragraphs and combine & Separate with new line	
//		List<WebElement> paragraphs = driver.findElements(By.xpath("//section[@id='details']//p"));
//		String allParagraphs = paragraphs.stream()
//								.map(e -> e.getText())
//									.collect(Collectors.joining("\n"));
//		
//		System.out.println(allParagraphs);
		
		
//2. Capture all the header & combine & Separate with new line		
		List<WebElement> header = driver.findElements(By.xpath("//section[@id='details']//h3"));
		
		//1st Way
//		String allHeaders = header.stream()
//								.map(e -> e.getText())
//									.collect(Collectors.joining("\n"));
//				
//		System.out.println(allHeaders);		
		
		//2nd Way
//		header.stream().forEach(e -> System.out.println(e.getText()));
		
		//3rd Way
		driver.findElements(By.xpath("//section[@id='details']//h3"))
			.stream()
				.forEach(e -> System.out.println(e.getText()));
		
	}

}
