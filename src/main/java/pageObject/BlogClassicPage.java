package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	
}
