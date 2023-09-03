package pageObject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	    }
	
	/*public By theForestTitle=By.xpath("(//a[@href='the-forest'])[1]");
	public By theSonTitle=By.xpath("(//a[@href='the-son'])[1]");
	public By lifeInTheGardenTitle=By.xpath("(//a[@href='life-in-the-garden'])[1]");
	public By theLongRoadTitle=By.xpath("(//a[@href='the-long-road-to-the-deep-silence'])[1]");
	public By strangeStoryTitle=By.xpath("(//a[@href='its-a-really-strange-story'])[1]");
	public By stormTitle=By.xpath("(//a[@href='storm'])[1]");
	*/
	
	public By facebookLink=By.xpath("(//a[@href='https://www.facebook.com/keytraining.ro'])[1]");
	public By twitterLink=By.xpath("(//a[@href='https://twitter.com/'])[1]");
	public By instagramLink=By.xpath("(//a[@href='https://www.instagram.com'])[1]");
	
	
	public void openBookPageByTitle(String title)	{
		String xPathTitle = "(//a[contains(text(),'" + title + "')])[1]";
		driver.findElement(By.xpath(xPathTitle)).click();
	}
	
	public void openSocialMediaPage(By element)	{
		driver.findElement(element).click();
	}
	
	public void switchAndCheckSocialMediaTab(String tab, String tabUrl )	{
		driver.switchTo().window(tab);
		assertEquals(driver.getCurrentUrl() , tabUrl );
	}
	
	
}
