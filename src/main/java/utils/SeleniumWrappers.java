package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers extends BaseTest {

	
	//webelement.click();
	
	public void click(By locator) {
		System.out.println("Called method<click> on  " + locator);
		try {
			//WebElement element = driver.findElement(locator);
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			returnWebElement(locator).click();
			
		}catch(StaleElementReferenceException e) {
	
			//WebElement element = driver.findElement(locator);
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.stalenessOf(returnWebElement(locator)));
			returnWebElement(locator).click();

		}catch(NoSuchElementException e) {
			System.out.println(e.getMessage());
	
		}
		
	}
	
	public void sendKeys(By locator, String text) {
		System.out.println("called method <sendKeys> on locator " + locator);
		try {
			//WebElement element = driver.findElement(locator);
			waitForElementToBeVisible(locator);
			returnWebElement(locator).clear();
			returnWebElement(locator).sendKeys(text);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		
	}
	
	
	public void waitForElementToBeVisible(By locator) {
		System.out.println("Called method <waitForElementToBeVisible> on locator :" + locator);
		try {
			//WebElement element = driver.findElement(locator);
			WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(returnWebElement(locator)));

		}catch(NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public WebElement returnWebElement(By locator) {
		return driver.findElement(locator);
	}
	
}
