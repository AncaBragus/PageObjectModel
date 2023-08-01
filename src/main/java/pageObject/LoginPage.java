package pageObject;

import org.openqa.selenium.By;
import utils.BaseTest;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseTest{
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
	this.driver =driver;
    }
	//locatori
	public By usernameField = By.id("log");
	public By passwordField = By.id("password");
	public By submit_button = By.cssSelector("input[class='submit_button']");
	public By loginSuccessMessage = By.cssSelector("div[class*='sc_infobox_style_success']");
	public By loginErrorMessage = By.cssSelector("div[class*='sc_infobox_style_error']");
	
	// metode
	public void loginInApp(String user, String pass) {
		driver.findElement(usernameField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(submit_button).click();
	}
	
	public boolean  loginMsgIsDisplayed (By mess){
		return true;
			}
}