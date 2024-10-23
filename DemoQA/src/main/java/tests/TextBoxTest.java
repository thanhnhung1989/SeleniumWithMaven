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
		TextBoxPage textBoxPage = new TextBoxPage(testBase.driver, CONFIG_FILE);
		textBoxPage.openTextBoxPage();

		String expectedName = "Tran Thanh Nhung";
		String expectedEmail = "abc@gmail.com";
		String expectCurrentAddress = "My dinh 2";
		String expectPermanentAddress = "Nam Tu Liem, Ha Noi";
		String expectColor = "#ced4da";
		
		textBoxPage.testBase.inputText(textBoxPage.txtName, expectedName);
		textBoxPage.testBase.inputText(textBoxPage.txtEmail, expectedEmail);
		textBoxPage.testBase.inputText(textBoxPage.txtcurrentAddress, expectCurrentAddress);
		textBoxPage.testBase.inputText(textBoxPage.txtPermanentAddress, expectPermanentAddress);
		textBoxPage.clickSubmit();
		
		String actualName = textBoxPage.getTextAfterSubmit(textBoxPage.outputName);
		assertEquals(actualName, expectedName);
		
		String actualEmail = textBoxPage.getTextAfterSubmit(textBoxPage.outputEmail);
		assertEquals(actualEmail, expectedEmail);

		String actualCurrentAddress = textBoxPage.getTextAfterSubmit(textBoxPage.outputCurrAdd);
		assertEquals(actualCurrentAddress, expectCurrentAddress);
		
		String actualPermanentAddress = textBoxPage.getTextAfterSubmit(textBoxPage.outputPerAdd);
		assertEquals(actualPermanentAddress, expectPermanentAddress);
		
		String actualColor = textBoxPage.testBase.validateEmailFormat(textBoxPage.color);
		assertEquals(actualColor, expectColor);
		}

}
