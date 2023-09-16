package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pageObject.BlogClassicPage;
import pageObject.BookPage;
import utils.BaseTest;

public class TwoTestsOnBlogClassicAndCookBooks extends BaseTest  {

	@Test(priority = 1 , description = "firstTest")
	public void checkWhyBlogCategories() throws InterruptedException {
	
		//navigate to BlogClassic
		BlogClassicPage blog = new BlogClassicPage(driver);
		//search blog
		blog.searchWhyBlogJS();
		//check categories
		assertEquals(blog.checkWhyBlogCategories(),"Classic, News, Recommend");
	}
	
	@Test(priority = 2 , description = "secondTest")
	public void checkOnSaleCookBooks() throws InterruptedException {
		//navigate to BookPage/ShopPage
		BookPage shop = new BookPage(driver);
		shop.navigateToShopPageJS();
		//filter cook books
		shop.filterCookBooksJS();
		//check all books are on Sale - should be false as one book is not on Sale
		assertFalse(shop.checkAllBooksAreOnSale());
		//assertTrue(shop.checkAllBooksAreOnSale());
	}
}
