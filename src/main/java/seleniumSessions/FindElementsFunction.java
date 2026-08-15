package seleniumSessions;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsFunction {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://4kwallpapers.com/");

		By links = By.tagName("a");
		By images = By.tagName("img");

		int linksCount = getElementsCount(links);
		System.out.println("Total Links Count : " + linksCount);

		int imagesCount = getElementsCount(images);
		System.out.println("Total Images Count : " + imagesCount);
		
		List<String> actualLinksTextList = getElementTextList(links);
		System.out.println(actualLinksTextList);
		
		//Validations
		if(actualLinksTextList.contains("Copyright")) {
			System.out.println("Copyright is Present : Pass");
		}
		if(actualLinksTextList.contains("Contact Us")) {
			System.out.println("Contact Us is Present : Pass");
		}
		
		List<String> hrefList = getElementsAttributeList(links, "href");
		for( String e : hrefList) {
			System.out.println(e);
		}
		
	}

//WAF :- Capture the text of all the page links and store in ArrayList return List<String>.
//Here getElements() return list of WebElements, so we have to create empty list of string and add WebElements 1 by 1 
	public static List<String> getElementTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}
	
//WAF:- Capture specific attribute from the list:
	public static List<String> getElementsAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>();
		
		for(WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			eleAttrList.add(attrValue);
		}
		return eleAttrList;
	}
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}
