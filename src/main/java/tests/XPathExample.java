package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import utils.BaseTest;

public class XPathExample extends BaseText{
	@Test
	public void xpathExample() {
		
		//<li class="menu_user_login">
		//--> li[class='menu-user-login']  ->css
		//-->  //*  toate nodurile   -- nu e bine
		//--> //li[@class='menu_user_login']   -> XPath
		
		driver.findElement(By.xpath("//li[@class='menu_user_login']")).click();
	}

}
