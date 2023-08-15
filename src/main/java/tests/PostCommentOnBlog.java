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

public class PostCommentOnBlog extends BaseTest  {

	@Test
	public void postcommentTest() throws InterruptedException {
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.blogLink);
		menu.navigateTo(menu.blogSubMenuClassic);
		
		BlogClassicPage blog = new BlogClassicPage(driver);
		
		blog.navigateTo(blog.firstBlog);
		Thread.sleep(1000);
		driver.findElement(blog.commentTextArea).click();
		Thread.sleep(1000);
		driver.findElement(blog.commentTextArea).sendKeys("My comment for 15 Amazing...");
		driver.findElement(blog.commentAuthor).sendKeys("My Name is");
		driver.findElement(blog.commentEmail).sendKeys("my_email@yahoo.com");
		driver.findElement(blog.commentUrl).sendKeys("yahoo.com");
		Thread.sleep(1000);
		driver.findElement(blog.postButton).click();
		//Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(blog.commentNotApprovedMessage));
		
		assertEquals(driver.findElement(blog.commentNotApprovedMessage).getText(),"Your comment is awaiting moderation.");
	}
}
