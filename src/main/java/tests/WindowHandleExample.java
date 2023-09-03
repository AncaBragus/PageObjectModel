package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class WindowHandleExample extends BaseTest{



	@Test
	public void windowHandleTest() throws InterruptedException {

		app.menu.navigateTo(app.menu.eventsLink);
		app.events.clickOnEvent(app.events.festivalOfOldFilmsLink);

		app.click(app.menu.eventsLink);
		app.click(app.events.festivalOfOldFilmsLink);


		Actions action =  new Actions(driver);
		action.scrollByAmount(0, 800).perform();

		System.out.println("Current window :" + driver.getWindowHandle());

		app.genericEvent.clickMap();
		Thread.sleep(3000);
		System.out.println("Current window 2 :" + driver.getWindowHandle());

		System.out.println("All windows :" + driver.getWindowHandles());

		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(browserTabs.get(1));

		driver.findElement(By.xpath("//span[contains(text(), 'Accept all')]")).click();

		System.out.println("Current window after switch:" + driver.getWindowHandle());
		Thread.sleep(3000);

		driver.close();//inchide tabul curent
		//driver.quit();--> inchide browserul indiferent de nr de ferestre deschide
		driver.switchTo().window(browserTabs.get(0));

		System.out.println("Current window after tab close:" + driver.getWindowHandle());



	}





}