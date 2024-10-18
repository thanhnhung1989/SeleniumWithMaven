package tests.bookstore;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ProfilePage;
import pages.bookstore.LoginPage;
import tests.TestCase;

public class LoginTest extends TestCase {
	
	@Test(dataProvider = "LoginData")
	public void testlogin(String username, String password, String expectedErrorMessage) {
		LoginPage loginPage = new LoginPage(testBase.driver, CONFIG_FILE);
		loginPage.openLogin();
		
		WebDriver drLogin = loginPage.dr;// lấy webdriver từ loginPage
		loginPage.clickLogin(username, password);
		if (expectedErrorMessage.equalsIgnoreCase("")) {
			ProfilePage profilePage = new ProfilePage(drLogin, CONFIG_FILE);
			testBase.waitForElementToBeVisible(profilePage.lblUserNameValue);
			String actualUserNameValue = profilePage.testBase.getTextByLocator(profilePage.lblUserNameValue);
			assertEquals(actualUserNameValue, username);
			profilePage.logout();
		} else {
			testBase.waitForElementToBeVisible(loginPage.lblErrorMsg);
			String actualErrorMessage = loginPage.testBase.getTextByLocator(loginPage.lblErrorMsg);
			assertEquals(actualErrorMessage, expectedErrorMessage);
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getLoginData() {
		String[][] result = new String[3][3];
		result[0][0] = "NhungQA";
		result[0][1] = "Nhung@123456";
		result[0][2] = "";

		result[1][0] = "NhungQA";
		result[1][1] = "Nhung@1234567";
		result[1][2] = "Invalid username or password!";

		result[2][0] = "NhungQA1";
		result[2][1] = "Nhung@123456";
		result[2][2] = "Invalid username or password!";

		return result;

	}
}
