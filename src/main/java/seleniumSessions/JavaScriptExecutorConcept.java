package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
//@formatter:off
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {
	public static void main(String[] args) throws InterruptedException {
/*
 Note : JavascriptExecutor(Interface) -
  		RemoteWebDriver class implements JavascriptExecutor
		JavascriptExecutor --> executeScript(script)
		script --> executeScript(script) --> it will be executed on the browser - Page
 		
 		JavaScript code On Browser
 			- 1. Open ChromeDev Tool
 			- 2. On Console
 					document.title  --> title of the page
 					document.URL    --> URL Of the Page
 					alert('Hello World') --> Generate simple alert
 					confirm('Hello World') --> Generate confirm alert
 					prompt('Hello World') --> Generate prompt alert
 					history.go(0); --> Refresh the page
 					history.go(-1); --> Navigate to back
 					history.go(1); --> Navigate to forward
 					document.documentElement.innerText --> Return all the text(Strings) from WebPage --> Content Testing
 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		String title = js.executeScript("return document.title").toString();
//		System.out.println(title);
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		String title = jsUtil.getTitleByUsingJs();
		System.out.println(title);
		
		jsUtil.generateJSAlert("Hello");
		jsUtil.generateJSConfirm("Welcome");
		jsUtil.generateJSPrompt("Enter Password", "Pass@123");
		
	}

}
