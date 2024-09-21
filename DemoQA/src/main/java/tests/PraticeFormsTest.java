package tests;

import org.testng.annotations.Test;

import pages.PraticeFormsPage;

public class PraticeFormsTest extends TestCase {

	@Test
	public void testClickSubmit() {
		PraticeFormsPage praticeFormsPage = new PraticeFormsPage(testBase.driver);
		praticeFormsPage.openPraticeForms();

		String firstName = "Nhung";
		String lastName = "Tran ";
		String email = "abc@gmail.com";
		String gender = "Male";
		String mobilePhone = "0789878987";
		String subjects = "Maths, English";
		String hobbies = "Sports, Reading, Music";
		String uploadPicture = "DemoQA\\image\\anh1.png";
		String currentAddress = "My dinh 2, Nam Tu Liem, Ha Noi";
		String state = "NCR";
		String city = "Delhi";
		
		
		praticeFormsPage.testBase.inputText(praticeFormsPage.txtFirstName,firstName);
		praticeFormsPage.testBase.inputText(praticeFormsPage.txtLastName,lastName);
		praticeFormsPage.testBase.inputText(praticeFormsPage.txtEmail,email);
		praticeFormsPage.testBase.selectRadioButton(praticeFormsPage.genderXpath,gender);
		praticeFormsPage.testBase.inputText(praticeFormsPage.txtMobilePhone, mobilePhone);
		praticeFormsPage.testBase.inputValuesToCombobox(praticeFormsPage.cbSubjects,subjects);
		praticeFormsPage.testBase.selectCheckbox(praticeFormsPage.chkXpathHobbies,hobbies);
		
		praticeFormsPage.testBase.inputText(praticeFormsPage.txtCurrentAdress, currentAddress);
		praticeFormsPage.testBase.selectFromDropdown(praticeFormsPage.chkXpathState, state);
		praticeFormsPage.testBase.selectFromDropdown(praticeFormsPage.chkXpathCity, city);
		
		
	
//		praticeForms.clickSubmit();
	

	}
}
