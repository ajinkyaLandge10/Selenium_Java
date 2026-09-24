package myTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FlipkartTest extends BaseTest {


	@Test
	public void flipkartTitleTest() {
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertTrue(actTitle.contains("Online Shopping"));
	}
	
	@Test
	public void flipkartUrlTest() {
		String actUrl = driver.getCurrentUrl();
		System.out.println(actUrl);
		Assert.assertTrue(actUrl.contains("https://www.flipkart.com/"));
	}


}
