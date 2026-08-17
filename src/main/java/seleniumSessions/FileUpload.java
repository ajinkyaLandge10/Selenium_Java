package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
	
//	<tag type='file'> should be there
//	if not there: 3rd party libraries: AutoIT(windows - windows batch),Robot(windows),Sikuli(image based)

		WebDriver driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		String filePath = System.getProperty("user.dir") + "\\Files\\TestFile_1.txt";
		
		driver.findElement(By.name("upfile")).sendKeys(filePath);
	}

}
