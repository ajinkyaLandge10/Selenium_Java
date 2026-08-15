package seleniumSessions;

//@formatter:off
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCSSSelector {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		
/*
		CSS selector - Cascading Style Sheet : locator approach
		1. id --> #id
		2. class --> .class
		
		For id:
			#id --> #input-firstname --> Ex:By.cssSelector("#input-firstname");	
			tagName#id -->input#input-firstname --> Ex:By.cssSelector("input#input-firstname");
					
		For Class:	
			.class --> .form-control --> Ex:By.cssSelector("#input-firstname");
			tagName.class -->input.form-control --> Ex:By.cssSelector("input.form-control");
					
		For Class & id together
			#id.class --> #input-firstname.form-control --> Ex:By.cssSelector("#input-firstname.form-control");	
			.class#id --> .form-control#input-firstname --> Ex:By.cssSelector(".form-control#input-firstname");
				
		For Multiple classes & Id together
			.class1.class2.class3.classN -->
			 			.form-control.input-lg --> Ex:By.cssSelector(".form-control.input-lg");
			 			.form-control.private-form__control.login-email
						.form-control.private-form__control.login-email#username
						#username.form-control.private-form__control.login-email
				
				
		Other Attributes : 
			Formula: CSS	--> htmltag[attr='value']
			Formula: X-path	--> //htmltag[@attr='value']
			
			1.Single Attribute:
				 input[name='email']
				 	By.cssSelector("input[name='email']");
				 input[id='input-email']
			
			2.Multiple Attribute:
				 htmltag[attr1='value'][attr2='value'][attr3='value']
				 input[name='email'][placeholder='E-Mail Address'][type='text']
				 input[name][placeholder][type]
			
			3.Combined Attribute:
				 input[name='email']#input-email
				 input#input-email[name='email']
				 
				 				 
Note : 		With By.className multiple classes are not allowed -->InvalidSelectorException: Compound class names not permitted	
			 
			driver.findElement(By.className("form-control private-form__control login-email")).sendKeys("Test@gmail.com");//Invalid
			driver.findElement(By.className("private-form__control login-email")).sendKeys("Test@gmail.com");//Invalid
			driver.findElement(By.className("login-email")).sendKeys("Test@gmail.com"); //valid
			driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']")).sendKeys("Test@gmail.com");//valid 
			driver.findElement(By.cssSelector("input.form-control.private-form__control.login-email")).sendKeys("Test@gmail.com");//valid		
			driver.findElement(By.xpath("//input[@@@id,'username']")).sendKeys("test");//InvalidSelectorException: invalid selector
			
			
		-->	text() in CSS: Not available --> There are no Functions in CSS like X-path text(),contains(),starts-with() etc..
		
			htmltag[attr*='value'] -- contains
			input[placeholder*= 'E-Mail'] -- contains
			input[placeholder^='E-Mail'] -- startswith
			input[placeholder$='Address'] -- endswith
			
			
		-->	Parent to Child:
			
			//select[@id='Form_getForm_Country']/option -- X-path
			select[id='Form_getForm_Country'] > option -- CSS --> Direct child element : parent > child
			
			div[id='content'] > input
			or
			div#content > input
			div#content input  --> Direct+indirect child elements
			
Note: In CSS For -Direct child use '>' greater than symbol
				 -Indirect Child use ' ' single or multiple space symbol
				 
		-->	child to parent: not allowed -- backward traversing is not allowed in CSS
			child to ancestor: not allowed
			preceding sibling: not allowed	 
				 
			sibling in Css:
			label[for='input-email']+input --> immediate sibling
			label[for='input-email']~input --- all siblings	 
				 
Note: In CSS For -Immediate	following sibling use '+' symbol
			 	 -All Following sibling '~' Symbol
			 	 
			 	 
		-->	comma in CSS: it will combine different locators together at the same time (usecase : just to check size)
			input#username,input#password,button#loginBtn,input#remember	 
			
			int loginEles = driver.findElements(By.cssSelector("input#username,input#password,button#loginBtn,input#remember")).size();
			System.out.println(loginEles);
				if(loginEles == 4) {
					System.out.println("All imp elements are present on login page");
				}else {
					System.out.println("All imp elements are present on login page");
				}
			 
		-->	not in css: for excluding specific element by mentioning specific property 
			div[class='form-group'] > input:not(#input-password)
			div[class='form-group'] > input:not(input[type='password'])
			div[class='form-group'] > input:not(input[type='password'], #input-email)
			
			
		-->	indexing in css:
			select[id='Form_getForm_Country'] > option:nth-of-type(15)
			select[id='Form_getForm_Country'] > option:nth-of-type(n) -- all
			
			select#Form_getForm_Country option:first-child
			select#Form_getForm_Country option:last-child
			select#Form_getForm_Country option:nth-child(5)
			select#Form_getForm_Country option:nth-last-child(2)
			select#Form_getForm_Country option:nth-child(odd)
			select#Form_getForm_Country option:nth-child(even)
			select#Form_getForm_Country option:nth-child(n+4) --> starts from 4
			select#Form_getForm_Country option:nth-child(4n) --> table 4 --> 4,8,12....
			
*/
	}

}
