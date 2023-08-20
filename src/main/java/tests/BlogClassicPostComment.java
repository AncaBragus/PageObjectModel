package tests;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObject.MenuPage;
import pageObject.BlogClassicPage;
import utils.BaseTest;

public class BlogClassicPostComment extends BaseTest  {

	@Test
	public void postcommentTest() throws InterruptedException {
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.blogLink);
		menu.navigateTo(menu.blogSubMenuClassic);
		
		BlogClassicPage blog = new BlogClassicPage(driver);
		blog.navigateTo(blog.firstBlog);
		blog.postBlogComment();
		
		assertEquals(blog.waitAndGetMessageText(blog.commentNotApprovedMessage),"Your comment is awaiting moderation.");
	}
}
