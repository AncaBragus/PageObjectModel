package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GalleryFormatPage {

	public WebDriver driver;
	public GalleryFormatPage(WebDriver driver) {
		this.driver =driver;
	    }
	
	public By commentsForm = By.xpath("//div[@class='comments_form']");
	public By commentTextArea = By.id("comment");
	public By commentAuthor = By.xpath("//input[@id='author']");
	public By commentEmail = By.xpath("//input[@id='email']");
	public By commentUrl = By.xpath("//input[@id='url']");
	public By postButton = By.xpath("//input[@id='send_comment']");

	public void postCommentJS() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(commentTextArea));
		jse.executeScript("arguments[0].value='My JS comment ....'", driver.findElement(commentTextArea));
		jse.executeScript("arguments[0].value='My Name is'", driver.findElement(commentAuthor));
		jse.executeScript("arguments[0].value='my_email@yahoo.com'", driver.findElement(commentEmail));
		jse.executeScript("arguments[0].value='yahoo.com'", driver.findElement(commentUrl));
		jse.executeScript("arguments[0].click()", driver.findElement(postButton));
		Thread.sleep(1000);
	}
	
	

}
