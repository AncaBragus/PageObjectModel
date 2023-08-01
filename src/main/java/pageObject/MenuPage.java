package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
	public WebDriver driver;
	public MenuPage(WebDriver  driver) {
		this.driver=driver;
	}

	//MenuPage menu = new MenuPage(driver);
	//locators
	//driver.findElement(By.cssSelector ("...."))
	public By contactLink=By.linkText("CONTACTS");
	public By loginLink=By.cssSelector("li[class='menu_user_login']");
	
public  void navigateTo	(By locator) {
	driver.findElement(locator).click();
}

	//MenuPage menu = new MenuPage(driver);
	//menu.navigateTo(menu.loginLink);
	//menu.navigateTo(menu.conatctsLink);
}
