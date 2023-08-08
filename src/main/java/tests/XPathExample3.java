package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XPathExample3 extends BaseTest{

	@Test
	public void xpathExample3() {

		driver.findElement(By.linkText("BOOKS")).click();
		
		//span[bdi='$14.99']
		
		//bdi[contains(text(), '14.99')]/../../following-sibling::a
		
		//!!!!
		//*[self::span or self::a][contains(@class, 'page-numbers') and not(contains(text(), '1') or contains(text(), '2'))]
}
}