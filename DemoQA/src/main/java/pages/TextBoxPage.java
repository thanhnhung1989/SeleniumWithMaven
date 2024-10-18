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

	public TextBoxPage(WebDriver driverWeb, String configFile) {
		super(driverWeb, configFile);
	}

	public void clickSubmit() {
		WebElement clickSubmit = dr.findElement(By.id("submit"));
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", clickSubmit);
		clickSubmit.click();
	}
	public String getTextAfterSubmit(By locator) {
		WebElement e = dr.findElement(locator);
		String fullText = e.getText();
		int indexOfColon = fullText.indexOf(":");// tìm vị trí cua dau : tu chuoi
		String expetedResult = fullText.substring(indexOfColon + 1);
		return expetedResult;

	}
}
