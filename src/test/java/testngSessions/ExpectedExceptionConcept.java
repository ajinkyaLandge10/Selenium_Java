package testngSessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	String name;
	
	@Test(expectedExceptions = ArithmeticException.class) 
	public void loginTest1() {
		System.out.println("Login Steps..");
		
		int i = 9/0;
		
		System.out.println("End");
	}
	
	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void loginTest2() {
		System.out.println("Login Steps..");
		
		ExpectedExceptionConcept obj = null;
		System.out.println(obj.name);
		
		System.out.println("End");
	}
}
