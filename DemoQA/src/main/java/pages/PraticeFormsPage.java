package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	
	public By nameAfterSubmit = By.xpath("//td[text()='Student Name']/following::td[1]");
	public By emailAfterSubmit = By.xpath("//td[text()='Student Email']/following::td[1]");
	public By genderAfterSubmit = By.xpath("//td[text()='Gender']/following::td[1]");
	public By mobilePhoneAfterSubmit = By.xpath("//td[text()='Mobile']/following::td[1]");
	public By dateOfBirhAfterSubmit = By.xpath("//td[text()='Date of Birth']/following::td[1]");
	public By cbSubjectAfterSubmit = By.xpath("//td[text()='Subjects']/following::td[1]");
	public By chkHobbiesAfterSubmit = By.xpath("//td[text()='Hobbies']/following::td[1]");
	public By nameImageAterSubmit = By.xpath("//td[text()='Picture']/following::td[1]");
	public By currentAdressAterSubmit = By.xpath("//td[text()='Address']/following::td[1]");
	public By chkStateAndCityAterSubmit = By.xpath("//td[text()='State and City']/following::td[1]");
	
	public PraticeFormsPage(WebDriver driverWeb) {
		super(driverWeb);
	}

	public void clickSubmit() {
		WebElement clickSubmit = dr.findElement(By.id("submit"));
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", clickSubmit);
		clickSubmit.click();
	}
}
