package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

import pageObject.BookPage;

public class BookDisplayedElementsTest extends BaseTest {
	
	@Test
	public void checkDisplayedElements() throws InterruptedException {
		BookPage book = new BookPage(driver);
		try {
		driver.findElement(book.shopLink).click();
		driver.findElement(book.healthyLifestyleBook).click();
		Thread.sleep(1000);
		assertTrue(driver.findElement(book.title).isDisplayed());
		assertTrue(driver.findElement(book.trigger).isDisplayed());
		assertTrue(driver.findElement(book.price).isDisplayed());
		assertTrue(driver.findElement(book.productSummary).isDisplayed());
		assertTrue(driver.findElement(book.categories).isDisplayed());
		assertTrue(driver.findElement(book.qty).isDisplayed());
		assertTrue(driver.findElement(book.addToCart).isDisplayed());
		
		assertTrue(book.elementNotFound(book.rating));
		System.out.println("Rating - NotFound:" + book.elementNotFound(book.rating));
		
		/*System.out.println("Title - displayed:" + driver.findElement(book.title).isDisplayed());
		System.out.println("Galery - displayed:" + driver.findElement(book.trigger).isDisplayed());
		System.out.println("Price - displayed:" + driver.findElement(book.price).isDisplayed());
		System.out.println("Summary - displayed:" + driver.findElement(book.productSummary).isDisplayed());
		System.out.println("Category - displayed:" + driver.findElement(book.categories).isDisplayed());
		System.out.println("Quantity - displayed:" + driver.findElement(book.qty).isDisplayed());
		System.out.println("Add To Cart - displayed:" + driver.findElement(book.addToCart).isDisplayed());
		//System.out.println("Rating - displayed:" + driver.findElement(book.rating).isDisplayed());
		*/	
		}
		catch (NoSuchElementException e){
			System.out.println(e);	
		}
	}
}
