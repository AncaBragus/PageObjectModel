package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorPage {
	public WebDriver driver;
	public AuthorPage(WebDriver driver) {
		this.driver = driver;
	    }
	
	public By skillsBar = By.cssSelector("div[class*='sc_skills_bar']");
	public By drama = By.cssSelector("div[class*='sc_skills_item'][class$='odd first inited'] div[class='sc_skills_total']");
	public By bigraphy= By.cssSelector("div[class*='sc_skills_item'][class$='even inited'] div[class='sc_skills_total']");
	public By cookbooks= By.cssSelector("div[class*='sc_skills_item'][class$='odd inited'] div[class='sc_skills_total']");
	
	public  void navigateToSkills() {
		driver.findElement(skillsBar).click();
	}
	
}
