package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import pageObject.MenuPage;
import pageObject.HomePage;
import utils.BaseTest;


public class SocialMediaRedirectPageTest extends BaseTest{

	@Test
	public void checkRedirect() throws InterruptedException {
		
			HomePage home =  new HomePage(driver);
			List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
			home.openSocialMediaPage(home.facebookLink);

			home.switchAndCheckSocialMediaTab(browserTabs.get(0), "https://keybooks.ro/");
			home.openSocialMediaPage(home.twitterLink);

			home.switchAndCheckSocialMediaTab(browserTabs.get(0), "https://keybooks.ro/");
			home.openSocialMediaPage(home.instagramLink);

			browserTabs =  new ArrayList<String>(driver.getWindowHandles());
			home.switchAndCheckSocialMediaTab(browserTabs.get(1), "https://www.facebook.com/keytraining.ro");
			home.switchAndCheckSocialMediaTab(browserTabs.get(2), "https://twitter.com/");
			home.switchAndCheckSocialMediaTab(browserTabs.get(3), "https://www.instagram.com/");		
		}
}
