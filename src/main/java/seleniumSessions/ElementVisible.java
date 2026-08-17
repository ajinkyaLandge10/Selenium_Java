package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisible {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/register/");

		WebElement logo = driver.findElement(By.cssSelector(".img-responsive"));
		System.out.println("Logo Displayed : " + logo.isDisplayed());
		System.out.println("Logo Enabled : " + logo.isEnabled());
		
		System.out.println("---------");
		
		WebElement submitBtn = driver.findElement(By.id("submitButton"));
		System.out.println("SubmitBtn Displayed : " + submitBtn.isDisplayed());
		System.out.println("SubmitBtn Enabled : " + submitBtn.isEnabled());
		
		WebElement agreeCheckbox = driver.findElement(By.name("agreeTerms"));
		System.out.println("Checkbox selected : " + agreeCheckbox.isSelected());
		agreeCheckbox.click();
		System.out.println("Checkbox selected : " + agreeCheckbox.isSelected());
		
		System.out.println("SubmitBtn Displayed : " + submitBtn.isDisplayed());
		System.out.println("SubmitBtn Enabled : " + submitBtn.isEnabled());
	}

}
