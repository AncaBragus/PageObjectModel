package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import pageObject.MenuPage;
import pageObject.HomePage;
import utils.BaseTest;
import utils.DataProviderClass;
	
public class DataProviderHomeBooksRedirect extends BaseTest{
		
@Test(dataProviderClass=DataProviderClass.class	, dataProvider="homeBooksRedirectDataProvider")
public void checkBooksRedirect(String title, String bookURL) throws InterruptedException {
			
		MenuPage menu =  new MenuPage(driver);
		HomePage home =  new HomePage(driver);
		home.openBookPageByTitle(title);
		Thread.sleep(1000);
		assertEquals(driver.getCurrentUrl() , "https://keybooks.ro/" + bookURL);
		menu.navigateTo(menu.homeLink);
		}

	}