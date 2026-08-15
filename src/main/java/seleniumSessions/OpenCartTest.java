package seleniumSessions;

public class OpenCartTest {
	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		
		brUtil.launchBrowser("Firefox");
		brUtil.launchURL("https://naveenautomationlabs.com/opencart/");

		String actTitle = brUtil.getPageTitle();
		if (actTitle.equals("Your Store")) {
			System.out.println("Title is correct :- Pass");
		} else {
			System.out.println("Title is incorrect :- Fail");
		}

		String actUrl = brUtil.getPageURL();
		if (actUrl.contains("opencart")) {
			System.out.println("Url is correct :- Pass");
		} else {
			System.out.println("Url is incorrect :- Fail");
		}

		brUtil.closeBrowser();

	}
}
