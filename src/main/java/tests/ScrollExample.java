package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ScrollExample extends BaseTest{


	//@Test
	public void scrollExample() throws InterruptedException {

		//JS executor scroll
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0, -1000)");

		//action class scroll
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 1000).perform();
		Thread.sleep(2000);
		action.scrollByAmount(0, -1000).perform();

	}

	//@Test
	public void scrollToElement() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);

		WebElement signUpBitton = driver.findElement(By.cssSelector("input[value='Sign up']"));

		//scroll to element with JS
		jse.executeScript("arguments[0].scrollIntoView()", signUpBitton);

		//scroll to element with Actions
		action.moveToElement(signUpBitton).perform();
		action.scrollToElement(signUpBitton).perform();

	}

	@Test
	public void scrollTopAndBottom() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);

		//scroll down
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		//scroll top
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

		Thread.sleep(3000);

		//scroll down
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		//scroll top
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();


	}


}