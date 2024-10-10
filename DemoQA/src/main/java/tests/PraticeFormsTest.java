package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.PraticeFormsPage;
import tests.models.StudentRegister;

public class PraticeFormsTest extends TestCase {

	@Test(groups = "happy case")
	public void testClickSubmit() {
		PraticeFormsPage praticeFormsPage = new PraticeFormsPage(testBase.driver);
		praticeFormsPage.openPraticeForms();
		// khởi tạo đối tượng
		StudentRegister studentRegister = new StudentRegister();
		//Đọc dữ liệu từ file CSV và lưu trữ thông tin vào đối tượng StudentRegister.
		//StudentRegister studentRegister = praticeFormsPage.fillFormFromCSV("testdata\\PraticeForm_InvalidData.csv");

		studentRegister.firstName = "Nhung";
		studentRegister.lastName = "Tran";
		studentRegister.email = "abc@gmail.com";
		studentRegister.gender = "Male";
		studentRegister.mobilePhone = "0789878987";
		studentRegister.dateOfBirth = "1/January/1989";
		studentRegister.subjects = "Maths, English";
		studentRegister.hobbies = "Sports, Reading, Music";
		studentRegister.uploadPicture = "testdata\\anh1.png";
		studentRegister.currentAddress = "My dinh 2, Nam Tu Liem, Ha Noi";
		studentRegister.state = "NCR";
		studentRegister.city = "Delhi";

		// truyền đối tượng studentRegister vào hàm inputData
		praticeFormsPage.inputData(studentRegister);

		praticeFormsPage.clickSubmit();

		String expectedName = studentRegister.firstName + " " + studentRegister.lastName;
		String actualName = praticeFormsPage.getTableValue(praticeFormsPage.tableValueXpath, "Student Name");
		assertEquals(praticeFormsPage.nomalizeString(actualName), praticeFormsPage.nomalizeString(expectedName));

		String actualEmail = praticeFormsPage.getTableValue(praticeFormsPage.tableValueXpath, "Student Email");
		assertEquals(actualEmail, studentRegister.email);

		String actualGender = praticeFormsPage.getTableValue(praticeFormsPage.tableValueXpath, "Gender");
		assertEquals(actualGender, studentRegister.gender);

		String actualMobilePhone = praticeFormsPage.getTableValue(praticeFormsPage.tableValueXpath, "Mobile");
		assertEquals(actualMobilePhone, studentRegister.mobilePhone);

		String actualDateOfBirth = praticeFormsPage.getTableValue(praticeFormsPage.tableValueXpath,  "Date of Birth");
//		int index = studentRegister.dateOfBirth.lastIndexOf(" ");
////		String expectedDateOfBirth = studentRegister.dateOfBirth.substring(0, index) + "," + studentRegister.dateOfBirth.substring(index + 1);
//
		String expectedDateOfBirth = praticeFormsPage.convertDate(studentRegister.dateOfBirth);
		assertEquals (actualDateOfBirth,expectedDateOfBirth );
				
		String actualCbSubjects = praticeFormsPage.getTableValue(praticeFormsPage.tableValueXpath, "Subjects");
		assertEquals(praticeFormsPage.nomalizeString(actualCbSubjects),
				praticeFormsPage.nomalizeString(studentRegister.subjects));

		String actualChkHobbies = praticeFormsPage.getTableValue(praticeFormsPage.tableValueXpath, "Hobbies");
		assertEquals(actualChkHobbies, studentRegister.hobbies);
		
		int indexImage = studentRegister.uploadPicture.lastIndexOf("\\");
		String expectedFileName = studentRegister.uploadPicture.substring(indexImage + 1);
		String actualUploadImage = praticeFormsPage.getTableValue(praticeFormsPage.tableValueXpath, "Picture");
		assertEquals(actualUploadImage, expectedFileName);

		String actualCurrentAddress = praticeFormsPage.getTableValue(praticeFormsPage.tableValueXpath, "Address");
		assertEquals(actualCurrentAddress, studentRegister.currentAddress);

		String combinedStateandCity = praticeFormsPage.getTableValue(praticeFormsPage.tableValueXpath,
				"State and City");
		String[] actualStateandCity = praticeFormsPage.splitValue(combinedStateandCity, " ");
		assertEquals(actualStateandCity[0], studentRegister.state);
		assertEquals(actualStateandCity[1], studentRegister.city);

	}
	@Test(groups = "Validation Test")
	public void submitDataUnsuccessfully() throws InterruptedException {
		PraticeFormsPage praticeFormsPage = new PraticeFormsPage(testBase.driver);
		praticeFormsPage.openPraticeForms();
		praticeFormsPage.clickSubmit();
		Thread.sleep(2000);
		assertTrue(praticeFormsPage.getCssBorderValue(praticeFormsPage.txtFirstName, "#dc3545"));

	}
}
