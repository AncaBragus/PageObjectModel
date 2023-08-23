package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {
	public WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver =driver;
	    }
	
public By nameField = By.name("your-name");

public By zoomIn = By.cssSelector("button[title='Zoom in']");
public By zoomOut = By.cssSelector("button[title='Zoom in']");
public By losAnglesMapFrame = By.xpath("//iframe[contains(@src, 'Los+Angeles')]");


public void zoomMap(By locator) {
	WebElement mapFrame = driver.findElement(losAnglesMapFrame);
	//driver.switchTo().frame(driver.findElement(losAnglesMapFrame));
	driver.switchTo().frame(mapFrame);

	driver.findElement(locator).click();
	//click(locator)
}

/*
 *  public void click(By locator){
 *  	Log.info......
 *  	try{
 *  	WEbdriverWait wait = new WebDriverWait(driver, 10);
 *  	wait.until(ExpectedCondition.elementToBeClickable(locator))
 *  	WebElement element = driver.findElement(locator);				
 *  	element.click()
 *  	}catch(StaleElementExcception){
 *  	element.click()
 *  	}catch(NoSuchElementException ){
 *  	.......
 *  }
 *  
 *  
 *  }
 * 
 * 
 * 
 * 
 */

}
