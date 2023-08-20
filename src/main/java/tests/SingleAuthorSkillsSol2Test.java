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

public class SingleAuthorSkillsSol2Test extends BaseTest {
	@Test
	public void checkSkillsTest() throws InterruptedException {
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.singleAuthorLink);
		AuthorPage skills = new AuthorPage(driver);
			
		skills.navigateToSkills(); // la mine nu functioneaza fara click pe skills din cauza driverului local
		
		assertEquals(skills.waitAndGetSkillTexT(skills.drama,"95%"), "95%");

		assertEquals(skills.waitAndGetSkillTexT(skills.bigraphy,"75%"), "75%");

		assertEquals(skills.waitAndGetSkillTexT(skills.cookbooks,"82%"), "82%");
	}
}
