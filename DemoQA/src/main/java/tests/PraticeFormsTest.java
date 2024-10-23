package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import common.TestBase;
import pages.PraticeFormsPage;
import tests.models.StudentRegister;

public class PraticeFormsTest extends TestCase {

	@Test(groups = "happy case")
	public void testClickSubmit() throws InterruptedException {
		PraticeFormsPage praticeFormsPage = new PraticeFormsPage(testBase.driver, CONFIG_FILE);
		praticeFormsPage.openPraticeForms();

		// Đọc dữ liệu từ file CSV
		String csvFilePath = configurations.getConfigValueByKey("csvFilePath");
		List<HashMap<String, String>> data = TestBase.getTestDataFromCSV(csvFilePath);

		// Kiểm tra dữ liệu đã được đọc từ CSV hay không
		if (data.isEmpty()) {
			System.err.println("No data found in the CSV file.");
			return; // Nếu không có dữ liệu, thoát khỏi hàm
		}

		// Lặp qua từng dòng trong file CSV
		for (HashMap<String, String> rowData : data) {

			// Khởi tạo đối tượng StudentRegister từ dữ liệu CSV
			StudentRegister studentRegister = new StudentRegister();

			// Sử dụng dữ liệu từ CSV (HashMap) để điền vào đối tượng StudentRegister
			studentRegister.firstName = rowData.get("First Name"); // Ánh xạ từ cột "FirstName" trong CSV
			studentRegister.lastName = rowData.get("Last Name"); // Ánh xạ từ cột "LastName"
			studentRegister.email = rowData.get("Email"); // Ánh xạ từ cột "Email"
			studentRegister.gender = rowData.get("Gender"); // Ánh xạ từ cột "Gender"
			studentRegister.mobilePhone = rowData.get("Mobile"); // Ánh xạ từ cột "MobilePhone"
			studentRegister.dateOfBirth = rowData.get("Date of Birth"); // Ánh xạ từ cột "DateOfBirth"
			studentRegister.subjects = rowData.get("Subjects"); // Ánh xạ từ cột "Subjects"
			studentRegister.hobbies = rowData.get("Hobbies"); // Ánh xạ từ cột "Hobbies"
			studentRegister.uploadPicture = rowData.get("Picture"); // Ánh xạ từ cột "UploadPicture"
			studentRegister.currentAddress = rowData.get("Current Address"); // Ánh xạ từ cột "CurrentAddress"
			studentRegister.state = rowData.get("State"); // Ánh xạ từ cột "State"
			studentRegister.city = rowData.get("City"); // Ánh xạ từ cột "City"

			// khởi tạo đối tượng
			// StudentRegister studentRegister = new StudentRegister();
			// Đọc dữ liệu từ file CSV và lưu trữ thông tin vào đối tượng StudentRegister.
			// StudentRegister studentRegister =
			// praticeFormsPage.fillFormFromCSV("testdata\\PraticeForm_InvalidData.csv");
			// List<HashMap<String, String>> data =
			// testBase.getTestDataFromCSV("testdata\\PraticeForm_InvalidData.csv");

//		studentRegister.firstName = "Nhung";
//		studentRegister.lastName = "Tran";
//		studentRegister.email = "abc@gmail.com";
//		studentRegister.gender = "Male";
//		studentRegister.mobilePhone = "0789878987";
//		studentRegister.dateOfBirth = "1/January/1989";
//		studentRegister.subjects = "Maths, English";
//		studentRegister.hobbies = "Sports, Reading, Music";
//		studentRegister.uploadPicture = "testdata\\anh1.png";
//		studentRegister.currentAddress = "My dinh 2, Nam Tu Liem, Ha Noi";
//		studentRegister.state = "NCR";
//		studentRegister.city = "Delhi";

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

			String actualDateOfBirth = praticeFormsPage.getTableValue(praticeFormsPage.tableValueXpath,
					"Date of Birth");
			String expectedDateOfBirth = praticeFormsPage.convertDate(studentRegister.dateOfBirth).replace(", ", ",");
			assertEquals(actualDateOfBirth, expectedDateOfBirth);

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
			
			 Thread.sleep(10000);
			praticeFormsPage.openPraticeForms();

		}
	}

	@Test(groups = "Validation Test")
	public void submitDataUnsuccessfully() throws InterruptedException {
		PraticeFormsPage praticeFormsPage = new PraticeFormsPage(testBase.driver, CONFIG_FILE);
		praticeFormsPage.openPraticeForms();
		praticeFormsPage.clickSubmit();
		Thread.sleep(2000);
		assertTrue(praticeFormsPage.getCssBorderValue(praticeFormsPage.txtFirstName, "#dc3545"));

	}
}
