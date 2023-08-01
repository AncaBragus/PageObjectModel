package tests;

import org.testng.annotations.Test;
import pageObject.MenuPage;
import utils.BaseTest;
import org.openqa.selenium.WebDriver;

public class LoginTest {
	 @Test
	 public void validLoginTest() {
		 MenuPage menu = new  MenuPage(driver);
		 menu.navigateTo(menu.loginLink);
		 LoginPage login = new LoginPage(driver);
		 login.logInApp("TestUser","12345@67890");
		 assertTrue(login.loginMsgIsDisplayed(login.loginSuccessMsg));
	 }
	 
	 @Test(description = "negativeScenrio") /*(groups = "Smoke") */
	 public  void invalidLoginTest() {
		 MenuPage menu = new  MenuPage(driver);
		 menu.navigateTo(menu.loginLink);
		 LoginPage login = new LoginPage(driver);
		 login.logInApp("TestUserinvalid","12345@67890");
		 assertTrue(login.loginMsgIsDisplayed(login.loginErrorMsg)); 	 
	 }
}
