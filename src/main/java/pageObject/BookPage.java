package pageObject;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookPage {
	public WebDriver driver;
	public BookPage(WebDriver driver) {
		this.driver = driver;
	    }
	
	public By shopLink=By.xpath("//div[@class='menu_main_wrap']//ul/li/a[@href='https://keybooks.ro/shop/']");
	public By healthyLifestyleBook=By.xpath("//h2/a[@href='https://keybooks.ro/shop/healthy-lifestyle/']");
	
	public By title=By.xpath("//h1[starts-with(@class,'product_title')]");
	public By trigger=By.xpath("//a[@class='woocommerce-product-gallery__trigger']");
	public By price=By.xpath("//p/ins/span[starts-with(@class,'woocommerce-Price')]");
	public By productSummary=By.xpath("//div[starts-with(@class,'woocommerce-product')]/p");
	public By categories=By.xpath("//span[@class='posted_in']");
	public By qty=By.xpath("//input[@name='quantity']");
	public By addToCart=By.xpath("//button[@name='add-to-cart']");
	public By rating =By.xpath("//div[@class='woocommerce-product-rating']/div[contains(@class,'star-rating')]");  //not displayed for this book!
	
	public By cookBooksCategory=By.xpath("//a[@href='https://keybooks.ro/product-category/cookbooks/']"); 
	public By cookBooks=By.xpath("//ul/li/div[@class='post_item_wrap']");
	public By onSale=By.xpath("//span[@class='onsale']"); 
	
	public boolean elementFound(By locator)
	{
	    return !driver.findElements(locator).isEmpty();
	}
	public boolean elementNotFound(By locator)
	{
	    return driver.findElements(locator).isEmpty();
	}
	
	public void navigateToShopPageJS() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(shopLink));
		Thread.sleep(1000);
	}
	public void filterCookBooksJS() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(cookBooksCategory));
		Thread.sleep(1000);
	}
	
	public boolean checkAllBooksAreOnSale() {	
		
		List<WebElement> books =  driver.findElements(cookBooks);
		//List<WebElement> booksOnSale = driver.findElements(onSale);
		//if (books.size() != booksOnSale.size()) {return false; }
		//OR
		for (int i=0; i<books.size(); i++) {
			if (books.get(i).getText() != "Sale!") {
				return false;
				}
			}
		return true;	
	}
}
