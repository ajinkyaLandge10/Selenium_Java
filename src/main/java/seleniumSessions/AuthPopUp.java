package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopUp {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		String userName = "admin";
		String password = "admin";
		driver.get("https://"+userName+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		String text = driver.findElement(By.tagName("p")).getText();
		if(text.contains("Congratulations")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
	}

}
