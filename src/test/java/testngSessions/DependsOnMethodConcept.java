package testngSessions;
//@formatter:off
import org.testng.annotations.Test;

public class DependsOnMethodConcept {

/*
 	AAA Rule In Unit Testing : 
 		- Common Unit Testing pattern
 		- Way to arrange Test Code to make unit test clear & Understandable & Consist of Separating each unit test in 3 Section:
 			1. Arrange
 			2. Act
 			3. Assert
 		- Test Cases/Methods should be Independent
 		- No Dependency --> It will create Deadlock condition in parallel testing
 		- No Priority  --> From User POV User --> User can pick any feature any time & also in MultiThreading Environment it doesn't make any sense
 		
 				@Test
				public void searchTest() {
					login(Username,Password) --> Arrage
					search(Macbok Pro)		 --> Act/Perform 
					Assertion				 --> For one Test One Assertion(recommended)
				}
 */
	
	@Test
	public void loginTest() {
		System.out.println("Login To Application");
		int i =9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void searchHomePageTest() {
		System.out.println("Search Test");
	}
		
	@Test(dependsOnMethods = "searchHomePageTest")
	public void addToCartTest() {
		System.out.println("Add To Cart Test");
	}

}
