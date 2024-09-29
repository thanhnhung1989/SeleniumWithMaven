package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		testBase.inputDate(DateDialogLocator, monthLocator, yearLocator, studentRegister.dayOfBirthday,
				studentRegister.monthOfBirthday, studentRegister.yearOfBirthday);
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
		return input.replaceAll("\\s+", "").toLowerCase();
	}

	public String[] splitValue(String combinedValue, String delimiter) {
		if (combinedValue == null || combinedValue.isEmpty()) {
			return new String[0];// Trả về mảng rỗng nếu chuỗi đầu vào null hoặc rỗng
		}
		return combinedValue.split(delimiter);
	}
}
