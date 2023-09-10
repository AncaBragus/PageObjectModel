package tests;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;
import pageObject.PostFormatsPage;
import pageObject.GalleryFormatPage;

public class AddCommentOnGalleryFormatJSE extends BaseTest{

	@Test
	public void navigate() throws InterruptedException {
		
		PostFormatsPage postFormatsPg = new PostFormatsPage(driver);
		GalleryFormatPage galleryFormatPg = new GalleryFormatPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//hover  Blog Menu
		String jsHover = "var obiect = document.createEvent('MouseEvent');"
				+ "obiect.initMouseEvent('mouseover', true); arguments[0].dispatchEvent(obiect);";
		jse.executeScript(jsHover, app.returnWebElement(app.menu.blogLink) );
		Thread.sleep(1000);
		//click on PostFormat
		jse.executeScript("arguments[0].click()", app.returnWebElement(app.menu.blogPostFormats));
		Thread.sleep(1000);
		//Scroll to Gallery Format
		jse.executeScript("arguments[0].scrollIntoView()",  driver.findElement(postFormatsPg.galleryFormat));
		Thread.sleep(1000);
		//click on Gallery Format
		jse.executeScript("document.getElementsByClassName('post_title')[4].childNodes[0].click() ");
		Thread.sleep(1000);
		//scroll to comments
		jse.executeScript("arguments[0].scrollIntoView()",  driver.findElement(galleryFormatPg.commentsForm));
		Thread.sleep(1000);
		//Post Comment
		galleryFormatPg.postCommentJS();
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		System.out.println("URL :" + jse.executeScript("return document.URL"));

	}


}