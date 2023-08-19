package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PostFormatsPage {
	public WebDriver driver;
	public PostFormatsPage(WebDriver driver) {
		this.driver =driver;
	    }
	
	public By playButton=By.xpath("//div[@class='mejs-button mejs-playpause-button mejs-play']");  ////button[@title='Play']"
	public By pauseButton=By.xpath("//div[@class='mejs-button mejs-playpause-button mejs-pause']");
	public By playSlide=By.xpath("//span[@role='slider']");
	
	public By volumeButton=By.xpath("//button[@title='Mute']");
	public By volumeSlide=By.xpath("//div[@class='mejs-horizontal-volume-total']");
	
	public  void clickButton(By locator) {
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	public  void moveSlide(By locator, int x, int y) {
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		//action.dragAndDropBy (element, x, y).perform();
		action.moveToElement(element).clickAndHold(element).moveByOffset(x, y).release().perform();
	}
}
