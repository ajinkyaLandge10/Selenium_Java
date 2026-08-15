package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTableConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();

		// WebTable Traversing:

		// table[@id='customers']/tbody/tr[2]/td[1]
		// table[@id='customers']/tbody/tr[3]/td[1]
		// table[@id='customers']/tbody/tr[4]/td[1]
		// table[@id='customers']/tbody/tr[5]/td[1]
		// table[@id='customers']/tbody/tr[6]/td[1]
		// table[@id='customers']/tbody/tr[7]/td[1]

		String companyBeforeXpath = "//table[@id='customers']/tbody/tr[";
		String companyAfterXpath = "]/td[1]";

		for (int row = 2; row <= rowCount; row++) {
			String companyActXpath = companyBeforeXpath + row + companyAfterXpath;
			String companyName = driver.findElement(By.xpath(companyActXpath)).getText();
			System.out.println(companyName);
		}
		
		System.out.println("---------");
		
		String contactBeforeXpath = "//table[@id='customers']/tbody/tr[";
		String contactAfterXpath = "]/td[2]";
		
		for (int row = 2; row <= rowCount; row++) {
			String contactActXpath = contactBeforeXpath + row + contactAfterXpath;
			String contact = driver.findElement(By.xpath(contactActXpath)).getText();
			System.out.println(contact);
		}
		
		System.out.println("---------");
		
		String countryBeforeXpath = "//table[@id='customers']/tbody/tr[";
		String countryAfterXpath = "]/td[3]";
		
		for (int row = 2; row <= rowCount; row++) {
			String countryActXpath = countryBeforeXpath + row + countryAfterXpath;
			String country = driver.findElement(By.xpath(countryActXpath)).getText();
			System.out.println(country);
		}
	}

}
