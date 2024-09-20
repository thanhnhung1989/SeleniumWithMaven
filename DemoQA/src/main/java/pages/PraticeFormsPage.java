package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PraticeFormsPage extends Page {

	public PraticeFormsPage(WebDriver driverWeb) {
		super(driverWeb);
	}
	public void enterFirstName(String firstname) {
		WebElement elementFirstName = dr.findElement(By.id("firstName"));
		elementFirstName.sendKeys(firstname);
	}
	public void enterLastName(String lastname) {
		WebElement elementLastName = dr.findElement(By.id("lastName"));
		elementLastName.sendKeys(lastname);
	}
	public void enterEmail(String email) {
		WebElement elementEmail = dr.findElement(By.xpath("//input[@id='userEmail']"));
		elementEmail.sendKeys(email);

	}
	public void chooseGender() {
		// TODO Auto-generated method stub

	}
	public void enterMobilePhone(String phone) {
		WebElement elementPhone = dr.findElement(By.xpath("//input[@id='userNumber']"));
		elementPhone.sendKeys(phone);

	}
	public void enterDateofBirth() {
		// TODO Auto-generated method stub

	}
	public void enterSubjects(String subjects) {
		WebElement elementSubjects = dr.findElement(By.id("subjectsContainer"));
		elementSubjects.sendKeys(subjects);
	}
	public void chooseHobbies() {
		// TODO Auto-generated method stub

	}
	public void selectPicture() {
		// TODO Auto-generated method stub

	}
	public void enterCurrentAddress(String address) {
		WebElement elementAddress = dr.findElement(By.xpath("//textarea[@id='currentAddress']"));
		elementAddress.sendKeys(address);

	}
	public void selectState() {
		// TODO Auto-generated method stub

	}
	public void selectCity() {
		// TODO Auto-generated method stub

	}
	
	public void clickSubmit() {
		WebElement clickSubmit = dr.findElement(By.id("submit"));
		
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", clickSubmit);
		
		clickSubmit.click();
		
	}

}
