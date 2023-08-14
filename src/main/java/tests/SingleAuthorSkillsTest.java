package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObject.MenuPage;
import pageObject.AuthorPage;
import utils.BaseTest;

public class SingleAuthorSkillsTest extends BaseTest {
	@Test
	public void checkSkillsTest() throws InterruptedException {
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.singleAuthorLink);
		//Thread.sleep(3000);
		AuthorPage skills = new AuthorPage(driver);
		
		skills.navigateToSkills();
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(skills.drama));
		WebElement s1 = driver.findElement(skills.drama);
		System.out.println(s1.getText());
		assertEquals(s1.getText(), "95%");
		
		skills.navigateToSkills();
		wait.until(ExpectedConditions.visibilityOfElementLocated(skills.bigraphy));
		WebElement s2 = driver.findElement(skills.bigraphy);
		System.out.println(s2.getText());
		assertEquals(s2.getText(), "75%");
		
		skills.navigateToSkills();
		wait.until(ExpectedConditions.visibilityOfElementLocated(skills.cookbooks));
		WebElement s3 = driver.findElement(skills.cookbooks);
		System.out.println(s3.getText());
		assertEquals(s3.getText(), "82%");
	}
}
