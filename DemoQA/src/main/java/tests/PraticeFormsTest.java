package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.PraticeFormsPage;

public class PraticeFormsTest extends TestCase {

	@Test
	public void testClickSubmit() {
		PraticeFormsPage praticeFormsPage = new PraticeFormsPage(testBase.driver);
		praticeFormsPage.openPraticeForms();

		String firstName = "Nhung  Thanh";
		String lastName = "Tran ";
		String email = "abc@gmail.com";
		String gender = "Male";
		String mobilePhone = "0789878987";
//		String dayOfBirthday = "1";
//		String monthOfBirthday = "January";
//		String yearOfBirthday = "1989";
		String subjects = "Maths, English  ";
		String hobbies = "Sports, Reading, Music";
		String uploadPicture = "image\\anh1.png";
		String currentAddress = "My dinh 2, Nam Tu Liem, Ha Noi";
		String state = "NCR";
		String city = "Delhi";

		praticeFormsPage.testBase.inputText(praticeFormsPage.txtFirstName, firstName);
		praticeFormsPage.testBase.inputText(praticeFormsPage.txtLastName, lastName);
		praticeFormsPage.testBase.inputText(praticeFormsPage.txtEmail, email);
		praticeFormsPage.testBase.selectRadioButton(praticeFormsPage.genderXpath, gender);
		praticeFormsPage.testBase.inputText(praticeFormsPage.txtMobilePhone, mobilePhone);
//		praticeFormsPage.testBase.inputDate(praticeFormsPage.DateDialogLocator, praticeFormsPage.monthLocator, praticeFormsPage.yearLocator, dayOfBirthday, monthOfBirthday, yearOfBirthday);
		praticeFormsPage.testBase.inputValuesToCombobox(praticeFormsPage.cbSubjects, subjects);
		praticeFormsPage.testBase.selectCheckbox(praticeFormsPage.chkXpathHobbies, hobbies);
		praticeFormsPage.testBase.uploadPicture(uploadPicture);
		praticeFormsPage.testBase.inputText(praticeFormsPage.txtCurrentAdress, currentAddress);
		praticeFormsPage.testBase.selectFromDropDown(praticeFormsPage.chkXpathState, state);
		praticeFormsPage.testBase.selectFromDropDown(praticeFormsPage.chkXpathCity, city);

		praticeFormsPage.clickSubmit();
		String expectedName = firstName+ " "+ lastName;
		String actualName = praticeFormsPage.testBase.getTextAfterSubmit2(praticeFormsPage.nameAfterSubmit).trim();
		assertEquals(praticeFormsPage.testBase.nomalizeString(actualName), praticeFormsPage.testBase.nomalizeString(expectedName));

		String actualEmail = praticeFormsPage.testBase.getTextAfterSubmit2(praticeFormsPage.emailAfterSubmit);
		assertEquals(actualEmail, email);

		String actualCbSubjects = praticeFormsPage.testBase.getTextAfterSubmit2(praticeFormsPage.cbSubjectAfterSubmit);
		assertEquals(praticeFormsPage.testBase.nomalizeString(actualCbSubjects), praticeFormsPage.testBase.nomalizeString(subjects));

		String actualChkHobbies = praticeFormsPage.testBase.getTextAfterSubmit2(praticeFormsPage.chkHobbiesAfterSubmit);
		assertEquals(actualChkHobbies,hobbies);

		String actualGender = praticeFormsPage.testBase.getTextAfterSubmit2(praticeFormsPage.genderAfterSubmit);
		assertEquals(actualGender, gender);

		String actualMobilePhone = praticeFormsPage.testBase.getTextAfterSubmit2(praticeFormsPage.mobilePhoneAfterSubmit);
		assertEquals(actualMobilePhone, mobilePhone);
		
		String expectedNameImage = "anh1.png";
		String actualImage = praticeFormsPage.testBase.getTextAfterSubmit2(praticeFormsPage.nameImageAterSubmit);
		System.out.println(actualImage);
		assertEquals(actualImage, expectedNameImage);

		String actualCurrentAddress = praticeFormsPage.testBase.getTextAfterSubmit2(praticeFormsPage.currentAdressAterSubmit);
		assertEquals(actualCurrentAddress, currentAddress);
		
		// có thể làm tương tự như so sánh Name ở trên.
		String combinedStateandCity = praticeFormsPage.testBase.getTextAfterSubmit2(praticeFormsPage.chkStateAndCityAterSubmit);
		String[] actualStateandCity = praticeFormsPage.testBase.splitValue(combinedStateandCity);
		assertEquals(actualStateandCity[0], state);
		assertEquals(actualStateandCity[1], city);
		
	}
}
