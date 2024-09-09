package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends Page {
	

	public TextBoxPage(WebDriver driverWeb) {
		super(driverWeb);
	}
	
	
	public void enterName(String name) {
		WebElement elementName = dr.findElement(By.id("userName"));// tìm username
		elementName.sendKeys(name);// nhap name vào trường ElementName

	}
	
	public void enterEmail(String email) {
		WebElement elementEmail = dr.findElement(By.id("userEmail"));
		elementEmail.sendKeys(email);

	}
	
	public void enterCurrentAddress(String address) {
		WebElement elementAddress = dr.findElement(By.id("currentAddress"));
		elementAddress.sendKeys(address);
	}
	
	public void clickSubmit() {
		WebElement clickSubmit = dr.findElement(By.id("submit"));
		clickSubmit.click();

	}
	
}
