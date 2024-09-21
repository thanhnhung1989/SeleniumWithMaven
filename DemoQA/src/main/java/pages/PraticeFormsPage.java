package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PraticeFormsPage extends Page {

	public By txtFirstName = By.id("firstName");
	public By txtLastName = By.id("lastName");
	public By txtEmail = By.id("userEmail");
	public String genderXpath = "//label[text()='{@param}']";
	public By txtMobilePhone = By.id("userNumber");
	public By cbSubjects = By.id("subjectsContainer");
	public String chkXpathHobbies = "//label[text()='{@param}']";
	public By txtCurrentAdress = By.id("currentAddress");
	public By chkXpathState = By.id("state");
	public By chkXpathCity =  By.id("city");
	public By uploadPicture = By.id("uploadPicture");
	public PraticeFormsPage(WebDriver driverWeb) {
		super(driverWeb);
	}


	public void enterDateofBirth() {
		// TODO Auto-generated method stub

	}

	public void clickSubmit() {
		WebElement clickSubmit = dr.findElement(By.id("submit"));
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", clickSubmit);
		clickSubmit.click();

	}

}
