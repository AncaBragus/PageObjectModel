package tests;
import utils.BaseTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import tests.LoginTest;
import pageObject.LoginPage;
import pageObject.MenuPage;
import pageObject.ShippingAddressPage;

public class ShippingAddressTest extends BaseTest {

	@Test
	 public void editShippingAddress() throws InterruptedException {
		//LoginTest login = new LoginTest();
		//login.validLoginTest();
		MenuPage menu = new  MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		LoginPage login = new LoginPage(driver);
		login.loginInApp("TestUser","12345@67890");
		assertTrue(login.loginMsgIsDisplayed(login.loginSuccessMessage));
		 
		ShippingAddressPage address = new ShippingAddressPage(driver);
		address.navigateToShippingAddressUrl();
		
		address.selectRegionByIndex(41);
		assertEquals(address.getCurrentSelectedRegion(),"Canada");
		
		address.selectProviceByValue("NL");
		assertEquals(address.getCurrentSelectedProvince(),"Newfoundland and Labrador");
	}
}


