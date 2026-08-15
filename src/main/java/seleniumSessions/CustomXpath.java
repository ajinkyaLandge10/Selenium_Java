package seleniumSessions;

//@formatter:off
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);

/*
X-path: address of the element in HTML DOM
		1. Absolute xPath: /html/body/div[2]/div/div/div[2]/div[2]/div/div[2]/h4/a
		2. Relative xPath: using element attributes with x-path functions
		
Formula: 	//htmltag[@attrName='value']		
			//input[@name='search']
			//input[@placeholder='Search']
			//input[@id='input-email']
			
			//htmltag[@attr1='value' and @attr2='value']
			//input[@type='text' and @name='search']
			 
			//htmltag[@attr1='value' and @attr2='value' and @attr3='value']
		
			--> and operator : all attribute should be present & correct otherwise it will not locate
			//input[@type='text' and @name='search' and @placeholder='Search']
			/// 
			--> or operator : any one of them should be present, it will locate
			//input[@type='text' or @type='email' or @type='password']
			 
			//input[@id]--> Return elements having id attribute --> 6 --> Use FindElements
			//a -- 81 --> FindElements
			 
			int count = driver.findElements(By.xpath("//a")).size();
			System.out.println("Total No of Links : " +count);
			
			--> Only with attribute without values
			//input[@id and @type]

			//a[@class='list-group-item'] -- 13 -- FEs
			//driver.findElements(By.className("list-group-item"));			

			List<WebElement> linksList = driver.findElements(By.xpath("//a[@class='list-group-item']"));
			System.out.println(linksList.size());
			
			for(WebElement e : linksList) {
				String text = e.getText();
				System.out.println(text);
			}
			
			//*[@attrName='value'] --> To check total number of elements on the page
			//htmltag[@attrName='value']
			
			322 elements
			//*[@class='form-control'] -- 6 out of 322 (Poor Performance)
			//input[@class='form-control'] -- 6 out of 14 (Recommended)
		
			// on login page 2 header: This will print -> New Customer 
			String header = driver.findElement(By.tagName("h2")).getText();
			System.out.println(header);
				
			
		--> text() in x-path: --> headers,links,spans,paragraphs
Formula :- 	//htmltag[text()='value']
			//h2[text()='Returning Customer']
			//h2[text()='New Customer']
			//a[text()='Recurring payments']
			//a[text()='Forgotten Password']
			
			text() with single & Multiple attribute:
			//htmltag[text()='value' and @attrName='value']
			//a[text()='My Account' and @class='list-group-item']
			//a[@class='list-group-item' and text()='My Account']
			//a[@class='list-group-item' and text()='Forgotten Password']
			//a[text()='Desktops' and @class = 'dropdown-toggle' and @data-toggle='dropdown']
		
		--> contains() in xpath: -->paragraph	
		1)	contains() with attribute:
Formula :- 	//htmltag[contains(@attrName, 'value')]
			//input[contains(@placeholder, 'E-Mail')]
			//input[contains(@placeholder, 'Address')]
			//input[contains(@id, 'email')]
			//input[contains(@id, 'email') and @type='text' and contains(@placeholder,'E-Mail')]
			
			//input[contains(@id, 'email')] --> With Contains
			//input[@id='input-email'] --> Without Contains
			
			When to use Contains():
			1.Long Text:
		2)	contains() with text():
			//htmltag[contains(text(),'value')]
			//h2[contains(text(),'Returning')]
			//p[contains(text(),'By creating an account')]

		3)	contains() with text() & attribute :	
			//htmltag[contains(text(),'value') and contains(@attrName,'value')]
			//a[contains(text(),'Password') and contains(@class,'list-group-item')]
			
			2.Dynamic Attributes: Means Value changes after DOM Refresh
			//dynamic id:
			//<input id = firstname_123>
			//<input id = firstname_125>
			//<input id = firstname_126>
			driver.findElement(By.id("firstname_123")).sendKeys("test");//---invalid
			//input[contains(@id,'firstname_')]
		
		
		--> starts-with() in xpath:
			//htmltag[starts-with(text(),'value')]
			//p[starts-with(text(),'By creating an account')]
			
			//htmltag[starts-with(@attrName,'value')]
			//input[starts-with(@id,'firstname')]
			
		--> ends-with() in xpath: deprecated -- not valid now
	
			
 										******************* Day-2 *******************:
			
		--> space with text:
			//label[normalize-space()='Yes']
			
		--> index:
			(//input[@class='form-control'])[1]
			(//input[@class='form-control'])[position()=1]
			(//input[@class='form-control'])[last()]
			(//input[@class='form-control'])[last()-1]
			(//label[@class='radio-inline'])[1]/input[@type='radio']
			driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("Test");


Interview Question:
Amazon home page -->1.In footer section multiple footer links are present
					2.Use index location Strategy and verify that 'Help' link is the last link in footer section
					
			String text = driver.findElement(By.xpath("((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]")).getText();
			System.out.println(text);
			if(text.equals("Help")) {
				System.out.println("Pass..");
			}else {
				System.out.println("Fail..");
			}	
			
// Traverse: ************************ X-path Axes ************************

		1.	Parent to Child : 
			1.Direct child  : /
			2.Indirect +Direct Child: //
			//form[@id='form-currency']//ul[@class='dropdown-menu']//button
			
		2.	Child to Parent
			1.immediate parent : /..
			//input[@name='email']/..
			
			Child-->Parent-->Child
			//input[@name='email']/../label[@for='input-email']
			//input[@id='input-firstname']/../../label[@for='input-firstname']
			
			Parent & Child Keyword:
			//input[@id='input-email']/parent::div/label[@for='input-email']
			//input[@id='input-email']/parent::div/child::label[@for='input-email']
			//input[@name='firstname']/parent::div/parent::div/child::label[@for='input-firstname'] -- Parent->Parent->child
			
			Ancestor Keyword : --> Direct jump to top parent, specify attribute of expected parent
			//input[@name='firstname']/ancestor::div[@class='form-group required']/child::label[@for='input-firstname']
			
			Preceding Sibling : Used for previous(Before) sibling
			//input[@name='firstname']/parent::div/preceding-sibling::label[@for='input-firstname']
			//input[@name='email']/preceding-sibling::label
			
			Following Sibling : Used for Following(After) sibling
			//label[@for='input-email']/following-sibling::input
			//label[text()='Password']/following-sibling::input[@id='input-password']
	
		
		
		--> Odd/Even in x-path:
			Number % 2 == 0
			(//select[@id='Form_getForm_Country']/option)[position() mod 2 = 0] -- even
			(//select[@id='Form_getForm_Country']/option)[position() mod 2 = 1] -- odd
*/
		
		
		
	}

}
