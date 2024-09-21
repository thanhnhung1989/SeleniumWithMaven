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
import pages.PraticeFormsPage;
import pages.TextBoxPage;

public class TextBoxTest extends TestCase {

	@Test
	public void SubmitSuccessfully() {

//		HomePage homePage = new HomePage(testBase.driver);
//		ElementsPage elementsPage = homePage.clickElements();
//		TextBoxPage textBoxPage = elementsPage.clickTextBox();
		TextBoxPage textBoxPage = new TextBoxPage(testBase.driver);
		textBoxPage.openCheckBoxPage();

		String expectedName = "Tran Thanh Nhung";
		String expectedEmail = "abc@gmail.com";
		String expectCurrentAddress = "My dinh 2";
		String expectPermanentAddress = "Nam Tu Liem, Ha Noi";
		
		textBoxPage.testBase.inputText(textBoxPage.txtName, expectedName);
		textBoxPage.testBase.inputText(textBoxPage.txtEmail, expectedEmail);
		textBoxPage.testBase.inputText(textBoxPage.txtcurrentAddress, expectCurrentAddress);
		textBoxPage.testBase.inputText(textBoxPage.txtPermanentAddress, expectPermanentAddress);
		
		String actualName = textBoxPage.getTextAfterSubmit(textBoxPage.txtName);
		assertEquals(actualName, expectedEmail);
		
		String actualEmail = textBoxPage.getTextAfterSubmit(textBoxPage.txtEmail);
		assertEquals(actualEmail, expectedEmail);

		String actualCurrentAddress = textBoxPage.getTextAfterSubmit(textBoxPage.txtcurrentAddress);
		assertEquals(actualCurrentAddress, expectCurrentAddress);
		
		String actualPermanentAddress = textBoxPage.getTextAfterSubmit(textBoxPage.txtPermanentAddress);
		assertEquals(actualPermanentAddress, expectPermanentAddress);
	}

	// @Test(groups = "validation case")
	public void validateEmailFormat() {

	}

}
