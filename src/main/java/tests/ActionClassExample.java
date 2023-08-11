package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.MenuPage;
import pageObject.ShopPage;
import pageObject.ContactPage;
import utils.BaseTest;
import org.openqa.selenium.interactions.Actions;

public class ActionClassExample extends BaseTest{
	
	@Test
	public void hoverTest() throws InterruptedException{
		MenuPage menu = new MenuPage(driver);
		menu.hoverElement(menu.blogLink);
		Thread.sleep(3000);
		menu.hoverElement(menu.aboutLink);
		Thread.sleep(3000);
		menu.hoverElement(menu.blogLink);
		menu.hoverElement(menu.blogSubMenuMasonry);
		Thread.sleep(3000);
		menu.navigateTo(menu.blogSubMenuMasonry);
	}
	
	@Test
	public void dragAndDropTest() throws InterruptedException{
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		ShopPage shop = new ShopPage(driver);
		shop.dragAndDrop(shop.priceSliderInitialPosition, 100,0);
		shop.dragAndDrop(shop.priceSliderFinalPosition, -100,0);
	}

	@Test
	public void sendKeysExample() throws InterruptedException{
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.contactLink);
		ContactPage contacts = new ContactPage(driver);
		WebElement element = driver.findElement(contacts.nameField);
		Actions action = new Actions(driver);
		action.
		moveToElement(element)
		.sendKeys(element,"Name")
		.sendKeys(Keys.TAB,"email@email.ro")
		.sendKeys(Keys.TAB,Keys.ENTER)
		.perform();
	}
}
