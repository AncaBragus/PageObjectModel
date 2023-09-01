package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.MenuPage;
import pageObject.LoginPage;
import utils.BaseTest;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
	 @Parameters({"user", "pass"})
	 @Test(description = "positiveScenrio")
	 public void validLoginTest(String username, String password) {
		 MenuPage menu = new  MenuPage(driver);
		 menu.navigateTo(menu.loginLink);
		 LoginPage login = new LoginPage(driver);
		 //login.loginInApp("TestUser","12345@67890");
		 login.loginInApp(username, password);
		 assertTrue(login.loginMsgIsDisplayed(login.loginSuccessMessage));
	 }
	 
	 @Test(description = "negativeScenrio") /*(groups = "Smoke") */
	 public void invalidUsernameLoginTest() {
			
			MenuPage menu =  new MenuPage(driver);
			menu.navigateTo(menu.loginLink);
			LoginPage login = new LoginPage(driver);
			login.loginInApp("TestUser123", "12345@67890");
			assertTrue(login.loginMsgIsDisplayed(login.loginErrorMessage));
			login.closePopUp();	 
	 }
	 @Test(description = "negativeScenario")
		public void invalidPasswordLoginTest() {
			
			MenuPage menu =  new MenuPage(driver);
			menu.navigateTo(menu.loginLink);
			LoginPage login = new LoginPage(driver);
			login.loginInApp("TestUser", "@67890");
			
			assertTrue(login.loginMsgIsDisplayed(login.loginErrorMessage));
			
			login.closePopUp();
			
		}
}
