package seleniumSessions;

//@formatter:off
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class RelativeLocatorConcept {
	public static void main(String[] args) throws InterruptedException {
/*	
 					  selenium4.x: Relative Locators
	
		  						 E4(above)
		  						 	 |
		  							 |
					E2(left)------Element------E1(right)
		  							 |
		  							 |
		  						 E3(below)
		  						 
		E5(near): 50px (It should be within 100px)
*/		
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/in/real-time-most-polluted-city-ranking");
		Thread.sleep(3000);
		
		WebElement baseElement = driver.findElement(By.xpath("//span[normalize-space()='Aksu, Xinjiang, China']"));
		
		//Right of Element:
		String rightElement = driver.findElement(with(By.tagName("p")).toRightOf(baseElement)).getText();
		System.out.println("Right : " + rightElement);
		
		//Left of Element:
		String leftElement = driver.findElement(with(By.tagName("p")).toLeftOf(baseElement)).getText();
		System.out.println("Left : " + leftElement);

		//Above of Element:
		String aboveElement = driver.findElement(with(By.tagName("span")).above(baseElement)).getText();
		System.out.println("Above : " + aboveElement);

		//Below of Element:
		String belowElement = driver.findElement(with(By.tagName("span")).below(baseElement)).getText();
		System.out.println("Below : " + belowElement);
		
		//Near of Element
		String nearElement = driver.findElement(with(By.tagName("p")).near(baseElement)).getText();
		System.out.println("Near : " + nearElement);
			
		
		System.out.println("---------");
		
		List<WebElement> belowEles = driver.findElements(with(By.xpath("//p[@class='name']")).below(baseElement));
		System.out.println(belowEles.size());
		
		for(WebElement e: belowEles) {
			String text = e.getText();
			System.out.println(text);
		}
	}

}
