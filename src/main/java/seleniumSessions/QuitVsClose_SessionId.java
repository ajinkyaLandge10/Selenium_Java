package seleniumSessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose_SessionId {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();//sessionId-b450832
		driver.get("https://www.google.com");//sessionId-b450832
		
		String actTitle = driver.getTitle();//sessionId-b450832
		System.out.println("Title : " + actTitle); //Google
		driver.quit(); // quit the browser , //sessionId-b450832  -->
//	  	sessionId = null
		
//		driver.getTitle();  
		
		driver = new ChromeDriver();//sessionId-null
		driver.get("https://www.google.com");//sessionId-6e0ed73
		System.out.println(driver.getTitle());//sessionId-6e0ed73
				
/*
 	1. driver.quit() 
 			- Only browser gets close but the server is still running in background 
 			- Session Id will become null
 			- if we try to do some operation after quit()-NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
 	2. driver.close()
 			- Session ID remains Same but it is invalid so after launching again new id will be generated
 			- if we try to do some operation after close()-NoSuchSessionException:invalid session id
 */			
	}

}
