package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
	public WebDriver driver;
	public MenuPage(WebDriver  driver) {
		this.driver=driver;
	}

	//menu
	//locators
	public By contactLink=By.linkText("CONTACTS");
	public By loginLink=By.cssSelector("li[class='mnu-user-login'");
	
public  void navigateTo	(By locator) {
	driver.findElement(locator).click();
}


}
