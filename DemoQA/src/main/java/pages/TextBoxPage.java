package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends Page {
	
	public By txtName = By.id("name");
	public By txtEmail = By.id("email");
	public By txtcurrentAddress= By.xpath("//p[@id='currentAddress']");
	public By txtPermanentAddress = By.id("permanentAddress");
	
	public TextBoxPage(WebDriver driverWeb) {
		super(driverWeb);
	}
	
	public void clickSubmit() {
		WebElement clickSubmit = dr.findElement(By.id("submit"));
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", clickSubmit);
		clickSubmit.click();
		
	}
	
	//get text after submit
	public String getTextAfterSubmit(By locator) {
		WebElement e = dr.findElement(locator);
		String fullText = e.getText();
		int indexOfColon = fullText.indexOf(":");// lay index cua dau : tu chuoi
		String expectedResult = fullText.substring(indexOfColon+1);
		return expectedResult;

	}
	
	
	
}
