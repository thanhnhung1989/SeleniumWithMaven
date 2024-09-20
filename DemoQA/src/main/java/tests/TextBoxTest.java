package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.TestBase;
import dev.failsafe.internal.util.Assert;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest extends TestCase {

	@Test
	public void SubmitSuccessfully() {

//		HomePage homePage = new HomePage(testBase.driver);
//		ElementsPage elementsPage = homePage.clickElements();
//		TextBoxPage textBoxPage = elementsPage.clickTextBox();
		
		openTextBoxPage();

		String expectedName = "Tran Thanh Nhung";
		String expectedEmail = "abc@gmail.com";
		String expectCurrentAddress = "My dinh 2, Nam Tu Liem, Ha Noi";

		textBoxPage.enterName(expectedName);
		textBoxPage.enterEmail(expectedEmail);
		textBoxPage.enterCurrentAddress(expectCurrentAddress);

		textBoxPage.clickSubmit();
		String actualName = textBoxPage.getTextAfterSubmit(textBoxPage.lblName);
		assertEquals(actualName,expectedName);

		String actualEmail = textBoxPage.getTextAfterSubmit(textBoxPage.lblEmail);
		assertEquals(actualEmail, expectedEmail);

		String actualCurrentAddress = textBoxPage.getTextAfterSubmit(textBoxPage.lblcurrentAddress);
		assertEquals(actualCurrentAddress, expectCurrentAddress);
	}

	// @Test(groups = "validation case")
	public void validateEmailFormat() {

	}

}
