package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pageObject.MenuPage;
import pageObject.PostFormatsPage;
import utils.BaseTest;

public class PostFormatsAudioDragAndDropTest extends BaseTest{
	
	@Test
	public void audioPostDragAndDropTest() throws InterruptedException{
		
	MenuPage menu = new MenuPage(driver);
	menu.navigateTo(menu.blogLink);
	menu.navigateTo(menu.blogPostFormats);
	
	PostFormatsPage audio = new PostFormatsPage(driver);
	audio.clickButton(audio.playButton);
	audio.moveSlide(audio.playSlide, 200,0);
	
	audio.clickButton(audio.pauseButton);
	audio.moveSlide(audio.volumeSlide, -50,0);
	
	audio.clickButton(audio.playButton);
	Thread.sleep(2000);
	}
}
