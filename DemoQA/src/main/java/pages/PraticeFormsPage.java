package pages;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.Duration;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.models.StudentRegister;

public class PraticeFormsPage extends Page {

	public By txtFirstName = By.id("firstName");
	public By txtLastName = By.id("lastName");
	public By txtEmail = By.id("userEmail");
	public String genderXpath = "//label[text()='{@param}']";
	public By txtMobilePhone = By.id("userNumber");
	public By DateDialogLocator = By.id("dateOfBirthInput");
	public By monthLocator = By.xpath("//*[@class='react-datepicker__month-select']");
	public By yearLocator = By.xpath("//*[@class='react-datepicker__year-select']");
	public By cbSubjects = By.id("subjectsInput");
	public String chkXpathHobbies = "//label[text()='{@param}']";
	public By uploadPicture = By.id("uploadPicture");
	public By txtCurrentAdress = By.id("currentAddress");
	public By chkXpathState = By.id("state");
	public By chkXpathCity = By.id("city");

	public String tableValueXpath = "//td[text()='{@param}']/following::td[1]";

	public PraticeFormsPage(WebDriver driverWeb) {
		super(driverWeb);
	}

	public void clickSubmit() {
		WebElement clickSubmit = dr.findElement(By.id("submit"));
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", clickSubmit);
		clickSubmit.click();
	}

	public void inputData(StudentRegister studentRegister) {
		testBase.inputText(txtFirstName, studentRegister.firstName);
		testBase.inputText(txtLastName, studentRegister.lastName);
		testBase.inputText(txtEmail, studentRegister.email);
		testBase.selectRadioButton(genderXpath, studentRegister.gender);
		testBase.inputText(txtMobilePhone, studentRegister.mobilePhone);
		testBase.inputDate(DateDialogLocator, monthLocator, yearLocator, studentRegister.dateOfBirth);
		testBase.inputValuesToCombobox(cbSubjects, studentRegister.subjects);
		testBase.selectCheckbox(chkXpathHobbies, studentRegister.hobbies);
		testBase.uploadPicture(studentRegister.uploadPicture);
		testBase.inputText(txtCurrentAdress, studentRegister.currentAddress);
		testBase.selectFromDropDown(chkXpathState, studentRegister.state);
		testBase.selectFromDropDown(chkXpathCity, studentRegister.city);
	}

	public String getTableValue(String xpath, String fieldName) {
		String newXpath = xpath.replace("{@param}", fieldName);
		WebElement e = dr.findElement(By.xpath(newXpath));
		return e.getText(); // Dùng getText() để lấy nội dung bên trong thẻ <td>
	}

	public String nomalizeString(String input) {
		if (input == null) {
			return "";
		}
		return input.replaceAll("\\s+", " ").toLowerCase();
	}

	public String[] splitValue(String combinedValue, String delimiter) {
		if (combinedValue == null || combinedValue.isEmpty()) {
			return new String[0];// Trả về mảng rỗng nếu chuỗi đầu vào null hoặc rỗng
		}
		return combinedValue.split(delimiter);
	}

	public String getCssValue(WebElement element, String cssProperty) {
		return element.getCssValue(cssProperty);
	}

	public boolean getCssBorderValue(By byLocator, String expectedColor) {
		WebElement elment = dr.findElement(byLocator);
		String cssColor = elment.getCssValue("border-color");
		// System.out.println("Màu viền thực tế: " + cssColor);
		String actualColor = Color.fromString(cssColor).asHex();
		// System.out.println("Màu viền thực tế (hex): " + actualColor);
		if (actualColor.equals(expectedColor)) {
			return true;
		}
		return false;
	}

	public StudentRegister fillFormFromCSV(String csvFile) {
		StudentRegister student = new StudentRegister(); // Khởi tạo đối tượng ở đầu
		try (
				// read file CSV
				Reader in = new FileReader(csvFile);
				CSVParser csvParser = CSVFormat.DEFAULT.builder()
						.setHeader("First Name", "Last Name", "Email", "Gender", "Mobile", "Date of Birth", "Subjects",
								"Hobbies", "Picture", "Current Address", "State", "City")
						.setSkipHeaderRecord(true) // Bỏ qua dòng tiêu đề nếu có trong file CSV
						.setDelimiter(',') // Sử dụng dấu phẩy làm dấu phân cách
						.build().parse(in)) {
			// Lặp qua từng dòng trong file CSV
			for (CSVRecord record : csvParser) {
				// Tạo đối tượng StudentRegister cho mỗi dòng dữ liệu
				// Gán các trường của file CSV cho từng thuộc tính của đối tượng
				student.firstName = record.get("First Name");
				student.lastName = record.get("Last Name");
				student.email = record.get("Email");
				student.gender = record.get("Gender");
				student.mobilePhone = record.get("Mobile");
				student.dateOfBirth = record.get("Date of Birth");
				student.subjects = record.get("Subjects");
				student.hobbies = record.get("Hobbies");
				student.uploadPicture = record.get("Picture");
				student.currentAddress = record.get("Current Address");
				student.state = record.get("State");
				student.city = record.get("City");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return student;
	}
	public String convertDate(String date) {
		String[] dates = date.split("/");
		String day= dates[0];
		int dayInt = Integer.valueOf(day);
		String newDate="";
		if(dayInt <10) {
			String newDay ="0"+ String.valueOf(dayInt);
			newDate = newDay +" " + dates[1] + "," + dates[2];
		} else {
			newDate = dates[0] +" " + dates[1] + "," + dates[2];
		}
		return newDate;
	}
}
