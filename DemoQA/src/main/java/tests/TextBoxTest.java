package tests;

import org.testng.annotations.Test;

import common.TestBase;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {
	
	@Test
	public void SubmitSuccessfully() {
		openWeb();
		HomePage homePage = new HomePage(driver);
		ElementsPage elementsPage = homePage.clickElements();
		TextBoxPage textBoxPage = elementsPage.clickTextBox();
		
		textBoxPage.enterName("Tran Thanh Nhung");
		textBoxPage.enterEmail("abc@gmail.com");
		textBoxPage.enterCurrentAddress("My dinh 2, Nam Tu Liem, Ha Noi");
		
		textBoxPage.clickSubmit();
	}

}
