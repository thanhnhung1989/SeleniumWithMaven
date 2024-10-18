package pages.bookstore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.Page;

public class LoginPage extends Page{
	public By txtUser = By.id("userName");
	public By txtPass = By.id("password");
	public By btnLogin = By.id("login");
	public By lblErrorMsg = By.id("name");
	
	public LoginPage(WebDriver driverWeb, String configFile) {
		super(driverWeb, configFile);
	}
	
	public void clickLogin(String username, String password) {
		testBase.inputText(txtUser, username);
		testBase.inputText(txtPass, password);
		testBase.scollToElement(btnLogin);
		dr.findElement(btnLogin).click();
	}
}
