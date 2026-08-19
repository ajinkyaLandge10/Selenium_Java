package seleniumSessions;

//@formatter:off
public class WaitConcept {

/*
 		Selenium script ----> Browser -- Application
		synchronization between Script and Application
			
				waits: 
					1. Static wait: Thread.sleep(10000): -Constant wait/Dead Wait - Pause the script for 10 sec.
					2. Dynamic wait: wait(10 sec) --> element found within 2 sec, then 8 sec will be canceled.
						2.a: Implicitly Wait:
						2.b: Explicit Wait:
							2.b.1: WebDriver Wait
							2.b.2: Fluent Wait
							
												Wait (Interface)  --> until() --> Abstract
												 |
												 |
												 |
											FluentWait (Class) --> until() implementation + Other Methods	 
 												 |
 												 |
 												 |(child)
 											WebDriverWait (Class)
 */

}
