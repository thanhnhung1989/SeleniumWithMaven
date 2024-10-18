package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends Page {

	public ProfilePage(WebDriver driverWeb, String configFile) {
		super(driverWeb, configFile);
	}
	
	public By lblUserNameValue = By.id("userName-value");
	public By btnLogout = By.id("submit");
	
	public void logout() {
	WebElement eLogout = dr.findElement(btnLogout);
	eLogout.click();
	}
	

}
