package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;
// xpath citest si in afara tagurilor
public class XPathExample extends BaseTest{
	@Test(priority = 1)
	public void xpathExample1() {
		
		//<li class="menu_user_login">
		//--> li[class='menu-user-login']  ->css
		//-->  //*  toate nodurile   -- nu e bine
		//--> //li[@class='menu_user_login']   -> XPath
		
		driver.findElement(By.xpath("//li[@class='menu_user_login']")).click();
		//OR
		driver.findElement(By.xpath("//input[@id='log' or @name='log']")).sendKeys("TestUser");
		//AND
		driver.findElement(By.xpath("//input[@id='password' and @name='pwd']")).sendKeys("12345@67890");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	}
	
	@Test(priority=2)
	public void xpathExample2() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='user_name']")).click();
		Thread.sleep(1000);
		//<a href="https://keybooks.ro/wp-admin/profile.php" class="icon icon-cog">Settings</a>	
		// text() --> citeste textul dintre tagurile html. pe elementul de mai sus, citeste Settings
		driver.findElement(By.xpath("//a[text() = 'Settings']")).click();
		Thread.sleep(3000);
		
		//xpath --> //a[contains (text(), 'orders')]  --contine substring
		driver.findElement(By.xpath("//a[contains (text() = 'Orders')]")).click();
		//xpath --> //a[text()= 'recent orders')]  -- exact match
		driver.findElement(By.xpath("//a[text()='recent orders']")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//th[contains(@class, 'woocommerce-orders-table__header')]/span[contains(text(),'Order')]
		//th[class*='woocommerce-orders-table__header']
		WebElement  orderTableHeader = driver.findElement(By.xpath("//span[contains(text(),'Order')]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red')", orderTableHeader);
		//index based
		WebElement  statusTableHeader = driver.findElement(By.xpath("(//th[contains(@class, 'woocommerce-orders-table__header')]/span)[3]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red')", statusTableHeader);
		
		//(//th[contains(@class, 'woocommerce-orders-table')]/span)[3]
		WebElement  order1721 = driver.findElement
				(By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(), '1721')]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:blue; border:5px solid red')", order1721);
		
		WebElement  orders = driver.findElement
						(By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[not(contains(text(), '1721'))]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:red; border:5px solid red')", orders);
		
	}
	
	

}
