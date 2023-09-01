package utils;

import org.openqa.selenium.WebDriver;

import pageObject.ContactPage;
import pageObject.EventsPage;
import pageObject.GenericEventPage;
import pageObject.LoginPage;
import pageObject.MenuPage;
import pageObject.ShopPage;

public class BasePage  extends SeleniumWrappers{
		
	public ContactPage contact =  new ContactPage(driver);
	public MenuPage menu =  new MenuPage(driver);
	public ShopPage shop = new ShopPage(driver);
	public LoginPage login =  new LoginPage(driver);
	public EventsPage events = new EventsPage(driver);
	public GenericEventPage genericEvent = new GenericEventPage(driver);
	
}