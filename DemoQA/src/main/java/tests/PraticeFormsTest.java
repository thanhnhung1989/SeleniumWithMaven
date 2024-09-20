package tests;

import org.testng.annotations.Test;

public class PraticeFormsTest extends TestCase {

	@Test
	public void testClickSubmit() {
		openPraticeForms();

		String expectedFirstName = "Nhung";
		String expectedLastName = "Tran ";
		String expectedEmail = "abc@gmail.com";
		String expectedPhone = "0789878987";
		String expectedSubjects = "Nhung test abc";
		String expectCurrentAddress = "My dinh 2, Nam Tu Liem, Ha Noi";
		
		praticeForms.enterFirstName(expectedFirstName);
		praticeForms.enterLastName(expectedLastName);
		praticeForms.enterEmail(expectedEmail);
		praticeForms.enterMobilePhone(expectedPhone);
		praticeForms.enterSubjects(expectedSubjects);
		praticeForms.enterCurrentAddress(expectCurrentAddress);
		
		praticeForms.clickSubmit();
		

	}
}
