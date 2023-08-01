package tests;

import org.testng.annotations.Test;
import pageObject.MenuPage;
import pageObject.LoginPage;
import utils.BaseTest;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
	 @Test(description = "positiveScenrio")
	 public void validLoginTest() {
		 MenuPage menu = new  MenuPage(driver);
		 menu.navigateTo(menu.loginLink);
		 LoginPage login = new LoginPage(driver);
		 login.loginInApp("TestUser","12345@67890");
		 assertTrue(login.loginMsgIsDisplayed(login.loginSuccessMessage));
	 }
	 
	 @Test(description = "negativeScenrio") /*(groups = "Smoke") */
	 public  void invalidLoginTest() {
		 MenuPage menu = new  MenuPage(driver);
		 menu.navigateTo(menu.loginLink);
		 LoginPage login = new LoginPage(driver);
		 login.loginInApp("TestUser","@67890");
		 assertTrue(login.loginMsgIsDisplayed(login.loginErrorMessage)); 	 
	 }
}
