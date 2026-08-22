package testngSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotations {

	// 1
	@BeforeSuite
	public void connectWithDB() {
		System.out.println("BS --> Connect with DB");
	}
	// 2
	@BeforeTest
	public void createUser() {
		System.out.println("BT --> Create User");
	}
	// 3
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC --> Launch Browser");
	}
	// 4 //7 //10
	@BeforeMethod
	public void loginToApp() {
		System.out.println("BM --> Login To Application");
	}

	// 11
	@Test
	public void searchTest() {
		System.out.println("Search Test");
	}
	// 5
	@Test
	public void addToCartTest() {
		System.out.println("Add To Cart Test");
	}
	// 8
	@Test
	public void checkOutTest() {
		System.out.println("CheckOut Test");
	}

	// 6 //9 //12
	@AfterMethod
	public void logout() {
		System.out.println("AM --> Logut From Application");
	}
	// 13
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC --> Close Browser");
	}
	// 14
	@AfterTest
	public void deleteUser() {
		System.out.println("AT --> Delete User");
	}
	// 15
	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("AS --> Disconnect With DB");
	}

}
