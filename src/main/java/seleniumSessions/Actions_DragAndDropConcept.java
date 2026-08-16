package seleniumSessions;

//@formatter:off
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_DragAndDropConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement sourcEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		Thread.sleep(2000);
		Actions act = new Actions(driver);
//		act.clickAndHold(sourcEle)
//			.moveToElement(targetEle)
//				.release()
//					.build()
//						.perform();
		
		
		//Alternate in-built Method:
		act.dragAndDrop(sourcEle, targetEle).perform();
	}

}
