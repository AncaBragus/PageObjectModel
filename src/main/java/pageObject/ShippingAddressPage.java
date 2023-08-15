package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {
	public WebDriver driver;
	public ShippingAddressPage(WebDriver driver) {
		this.driver = driver;
	    }
	
	public By regionDropdown = By.xpath("//select[@name='shipping_country']");

	public By provinceDropdown = By.xpath("//select[@id='shipping_state']");
	
	public  void navigateToShippingAddressUrl() {
		driver.get("https://keybooks.ro/account/edit-address/shipping/");
	}
	
	public void selectRegionByIndex(int index) {
		WebElement element =driver.findElement(regionDropdown);
		Select regionDropdown= new Select(element);
		regionDropdown.selectByIndex(index);
		//41 Canada
	}
	public String getCurrentSelectedRegion() {
		WebElement element =driver.findElement(regionDropdown);
		Select regionDropdown= new Select(element);
		return regionDropdown.getFirstSelectedOption().getText();
	}
	public void selectProviceByValue(String value) {
		WebElement element =driver.findElement(provinceDropdown);
		Select proviceDropdown= new Select(element);
		proviceDropdown.selectByValue(value);
		//NL ->Newfoundland and Labrador
	}
	public String getCurrentSelectedProvince() {
		WebElement element =driver.findElement(provinceDropdown);
		Select provinceDropdown= new Select(element);
		return provinceDropdown.getFirstSelectedOption().getText();
	}
	
	
}
