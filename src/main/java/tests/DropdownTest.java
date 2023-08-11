package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObject.MenuPage;
import pageObject.ShopPage;

import utils.BaseTest;

public class DropdownTest extends BaseTest	 {
	@Test(priority=1)
	public void selectByValue() {
		
		MenuPage menu =new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		ShopPage shop =new ShopPage(driver);
		shop.filterByValue("rating");
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/?orderby=rating");
		
		assertEquals(shop.getCurrentSelectedOption(),"Sort by average rating");
		
	}

	@Test(priority=2)
	public void selectByVisibleText() {
		MenuPage menu =new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		ShopPage shop =new ShopPage(driver);
		shop.filterByVisibleText("Sort by popularity");
		assertEquals(shop.getCurrentSelectedOption(),"Sort by popularity");
	}

	@Test(priority=3)
	public void selectByIndex() {
		MenuPage menu =new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		ShopPage shop =new ShopPage(driver);
		shop.filterByIndex(3);
		assertEquals(shop.getCurrentSelectedOption(),"Sort by latest");
	}
	
	@Test(priority = 4)
	public void example() throws InterruptedException {
		MenuPage menu =  new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		//incarc in mem un webelem  pe sessiune curenta session id
		WebElement dropdown =  driver.findElement(By.xpath("//select[@class='orderby']"));	
		Select select =  new Select(dropdown);//primeste web element sis e foloseste de el
		select.selectByIndex(2);// se foloseste de dropdown pt a selecta o optiune
		//cand face selectie din dropdown, browserul face refresh la pagina
		// cand face refresh, selenium citeste alt session id
		Thread.sleep(3000);	
		select.selectByValue("rating");// identifica elementul pe alt session id decat cel curent si arunca faild element exception
		
	}
}
