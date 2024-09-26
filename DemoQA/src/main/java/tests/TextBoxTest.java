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
		textBoxPage.openTextBoxPage();

		String expectedName = "Tran Thanh Nhung";
		String expectedEmail = "abcgmail.com";
		String expectCurrentAddress = "My dinh 2";
		String expectPermanentAddress = "Nam Tu Liem, Ha Noi";
		String expectColor = "#ced4da";
		
		textBoxPage.testBase.inputText(textBoxPage.txtName, expectedName);
		textBoxPage.testBase.inputText(textBoxPage.txtEmail, expectedEmail);
		textBoxPage.testBase.inputText(textBoxPage.txtcurrentAddress, expectCurrentAddress);
		textBoxPage.testBase.inputText(textBoxPage.txtPermanentAddress, expectPermanentAddress);
		textBoxPage.clickSubmit();
		
		String actualName = textBoxPage.testBase.getTextAfterSubmit(textBoxPage.txtName);
		assertEquals(actualName, expectedName);
		
		String actualEmail = textBoxPage.testBase.getTextAfterSubmit(textBoxPage.txtEmail);
		assertEquals(actualEmail, expectedEmail);

		String actualCurrentAddress = textBoxPage.testBase.getTextAfterSubmit(textBoxPage.txtcurrentAddress);
		assertEquals(actualCurrentAddress, expectCurrentAddress);
		
		String actualPermanentAddress = textBoxPage.testBase.getTextAfterSubmit(textBoxPage.txtPermanentAddress);
		assertEquals(actualPermanentAddress, expectPermanentAddress);
		
		String actualColor = textBoxPage.testBase.validateEmailFormat(textBoxPage.color);
		assertEquals(actualColor, expectColor);
		}

}
