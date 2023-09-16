package pageObject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public By searchWidget = By.xpath("//aside[@id='search-2']");
	public By searchInput = By.xpath("//aside[@id='search-2']//input");
	public By searchButton = By.xpath("//aside[@id='search-2']//button");
	public By readMoreLink = By.xpath("//a[@class='post_readmore']");
	public By blogCategories = By.xpath("//section[@class='post_content']//a[@class='category_link']");
	
	
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
	
	public void searchWhyBlogJS() throws InterruptedException {
		MenuPage menu = new MenuPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(menu.blogLink));
		jse.executeScript("arguments[0].click()", driver.findElement(menu.blogSubMenuClassic));
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click()", driver.findElement(searchWidget));
		jse.executeScript("arguments[0].value='Why I won'", driver.findElement(searchInput));
		jse.executeScript("arguments[0].click()", driver.findElement(searchButton));
		jse.executeScript("arguments[0].click()", driver.findElement(readMoreLink));
		Thread.sleep(1000);
	}

	public String checkWhyBlogCategories() throws InterruptedException {
	List<WebElement> categories =  driver.findElements(blogCategories);
	String categoryNames="";
	for (int i=0; i<categories.size(); i++)
	   {categoryNames = categoryNames + categories.get(i).getText();
			if (i!=categories.size()-1) {
			categoryNames = categoryNames +  ", ";	
			}
		}
	return categoryNames;
	
	}
}

