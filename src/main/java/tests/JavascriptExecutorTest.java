package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JavascriptExecutorTest extends BaseTest{


	//@Test
	public void example1() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//driver.get("http://emag.ro");
		//driver.navigate().to("http://emag.ro");
		jse.executeScript("window.location='http://emag.ro'");

		//driver.navigate().back();
		jse.executeScript("window.history.go(-1)");

		//driver.navigate().forward();
		jse.executeScript("window.history.forward(-1)");

		//Refresh browser
		//1
		driver.navigate().refresh();
		//2
		jse.executeScript("window.history.go(0)");
		//3
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
		//4
		driver.get(driver.getCurrentUrl());

	}

	@Test
	public void example2() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//alternativa pentru click
	//	jse.executeScript("arguments[0].click()", app.returnWebElement(app.menu.iconSearch));
		//alternativa pentru sendKeys
	//	jse.executeScript("arguments[0].value='Cooking'", app.returnWebElement(app.menu.searchField));
		//alternativa pentru click
	//	jse.executeScript("arguments[0].click()", app.returnWebElement(app.menu.iconSearch));

/*		jse.executeScript(
				"arguments[0].click();arguments[1].value='Cooking';arguments[0].click();", 
				app.returnWebElement(app.menu.iconSearch),
				app.returnWebElement(app.menu.searchField)
				);
	*/	

		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");
		jse.executeScript("document.getElementsByClassName('search_field')[0].value='cooking'");
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");


		System.out.println(driver.getTitle());
		//alternativa pentru getTitle

		System.out.println("Title :" + jse.executeScript("return document.title"));
		Thread.sleep(3000);

		jse.executeScript("window.SchimbTitlul = function(){ document.title = 'Alt titlu'};"
				+ "window.SchimbTitlul.call()");

		System.out.println("Title schimbat :" + jse.executeScript("return document.title"));


		//alternativa la mouse hover
		String jsHover = "var obiect = document.createEvent('MouseEvent');"
				+ "obiect.initMouseEvent('mouseover', true); arguments[0].dispatchEvent(obiect);";

		jse.executeScript(jsHover, app.returnWebElement(app.menu.blogLink) );

	}


}