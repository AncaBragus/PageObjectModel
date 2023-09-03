package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericEventPage {
	
	
	public WebDriver driver;
	
	public GenericEventPage(WebDriver driver) {
		this.driver = driver;
	}

	public By mapLink = By.partialLinkText("map");
	public By iframe = By.tagName("iframe");
	
	public void clickMap() throws InterruptedException {
		WebElement element =  driver.findElement(iframe);
		driver.switchTo().frame(element);
		Thread.sleep(3000);
		driver.findElement(mapLink).click();
	}
	
	
}