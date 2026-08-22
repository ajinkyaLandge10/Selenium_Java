package testngSessions;

//@formatter:off
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestingConcept {

/*
Unit Testing Frameworks:
		1. Java - TestNG/JUnit
		2. Python - PyTest/UnitTest    
		3. JavaScript - Mocha/Jasmine
		4. .Net	- NUnit
Note:	
		1. Test Coverage : Number Of Test Cases written against feature
		2. Code Coverage : 
	Tools : SOnarQube, Jacoco, Cobertura
*/	
	
	// White Box Testing : Static Analysis
	//Feature : Method : API : WebService
	private int sum(int a, int b) {
		return a+b;
	}
	
	
	//User consume this method  : Functional Testing - QA 
	public void calSum(int a, int b) {
		sum(a, b);
	}
	
	// Unit Test + Assertions : Development Team
	@Test
	public void test1() {
		//sum(10, 20);
		Assert.assertEquals(sum(10, 20), 30);
	}
	@Test
	public void test2() {
		Assert.assertEquals(sum(0, 20), 20);
	}
	@Test
	public void test3() {
		Assert.assertEquals(sum(-15, -15), -30);
	}
	@Test
	public void test4() {
		Assert.assertEquals(sum(-10, 20), 10);
	}
	
}
