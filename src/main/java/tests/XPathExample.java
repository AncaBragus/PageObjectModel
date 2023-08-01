package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BaseTest;
// xpath citest si in afara tagurilor
public class XPathExample extends BaseTest{
	@Test
	public void xpathExample1() {
		
		//<li class="menu_user_login">
		//--> li[class='menu-user-login']  ->css
		//-->  //*  toate nodurile   -- nu e bine
		//--> //li[@class='menu_user_login']   -> XPath
		
		driver.findElement(By.xpath("//li[@class='menu_user_login']")).click();
		driver.findElement(By.xpath("//input[@id='log' and @name='log']")).sendKeys("TestUser");
		driver.findElement(By.xpath("//input[@id='password' and @name='pwd']")).sendKeys("12345@67890");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//<a href="https://keybooks.ro/wp-admin/profile.php" class="icon icon-cog">Settings</a>	
		// text() --> citeste textul dintre tagurile html. pe elementul de mai sus, citeste Settings	
		
	}

}
