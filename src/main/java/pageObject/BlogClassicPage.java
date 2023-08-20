package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogClassicPage {
	public WebDriver driver;
	public BlogClassicPage(WebDriver driver) {
		this.driver = driver;
	    }
	
	public By firstBlog = By.xpath("//h4/a[contains(text(), '15 Amazing Things')]");
	public By commentTextArea = By.xpath("//textarea[@id='comment']");
	public By commentAuthor = By.xpath("//input[@id='author']");
	public By commentEmail = By.xpath("//input[@id='email']");
	public By commentUrl = By.xpath("//input[@id='url']");
	public By postButton = By.xpath("//input[@id='send_comment']");
	public By commentNotApprovedMessage = By.xpath("//div[@class='comment_not_approved']");
	
	public  void navigateTo(By locator) {
		driver.findElement(locator).click();
	}
	
	public void postBlogComment() throws InterruptedException {
		driver.findElement(commentTextArea).click();
		driver.findElement(commentTextArea).sendKeys("My comment for 15 Amazing...2");
		driver.findElement(commentAuthor).sendKeys("My Name is");
		driver.findElement(commentEmail).sendKeys("my_email@yahoo.com");
		driver.findElement(commentUrl).sendKeys("yahoo.com");
		driver.findElement(postButton).click();
	}
	
	public String waitAndGetMessageText(By locator) {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator).getText();
	}
	
}
