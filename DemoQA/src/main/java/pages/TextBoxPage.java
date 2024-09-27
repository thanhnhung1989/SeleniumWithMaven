package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends Page {

	public By txtName = By.id("userName");
	public By txtEmail = By.id("userEmail");
	public By txtcurrentAddress = By.id("currentAddress");
	public By txtPermanentAddress = By.id("permanentAddress");
	public By color = By.id("userEmail");

	public TextBoxPage(WebDriver driverWeb) {
		super(driverWeb);
	}

	public void clickSubmit() {
		WebElement clickSubmit = dr.findElement(By.id("submit"));
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", clickSubmit);
		clickSubmit.click();
	}
}
