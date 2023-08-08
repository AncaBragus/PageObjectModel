package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;
public class XPathExample2 extends BaseTest{

	@Test
	public void xpathExample2() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//in DOM avem: <a href='#popup_login' class='popup_link popup_login_link icon-user inited' title=''>Login</a>"));
		// --> //a[contains(text(), 'Login' )]
		//a[contains(@class, 'popup_login_link' )]/parent::li[@class='menu_user_login']
		// -->//a[contains(@class, 'popup_login_link' )]
		
		WebElement  loginPopup = driver.findElement
				(By.xpath("//a[contains(@class, 'popup_login_link' )]"));
		loginPopup.click();
			
		//https://github.com/bonigarcia/webdrivermanager
		
		//ul[@id='menu_user']//input[@name='log']
		//ul[@id='menu_user']/descendant::input[@name='log']
		//ul[@id='menu_user']/descendant::form[contains(@class, 'login_form')]/child::div[contains(@class, 'login_field')]/child::input[@name='log']
		WebElement  userField = driver.findElement
				(By.xpath("//ul[@id='menu_user']/descendant::form[contains(@class, 'login_form')]/child::div[contains(@class, 'login_field')]/child::input[@name='log']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:red; border:5px solid red')", userField);
		userField.click();
		
		WebElement  passField = driver.findElement
				(By.xpath("//ul[@id='menu_user']/descendant::form[contains(@class, 'login_form')]/child::div[contains(@class, 'password_field')]/child::input[@name='pwd']"));
		//ul[@id='menu_user']/descendant::input[@name='pwd']
		jse.executeScript("arguments[0].setAttribute('style', 'background:red; border:5px solid red')", passField);
		passField.click();
		
		//div[contains(@class, 'login_field' )]/following-sibling::div[contains(@class, 'remember_field')]/input
		//ul//div[contains(@class, 'login_field' )]/following-sibling::div[contains(@class, 'remember_field')]/input
	
		//rememberMe.isSelected()--> metoda isSelected() se aplica doar pe elemente de tip
				//checkbox sau radio-button adica are atribut type="checkbox"
		
		// preceding - traverseaza DOM in sus fara relatie de rudenie
		// following - traverseaza DOM in jos fara relatie de rudenie
		WebElement  submitButton = driver.findElement
				(By.xpath("//div[@class='top_panel_middle']/preceding::input[@class='submit_button']"));
		submitButton.click();
	}
}
