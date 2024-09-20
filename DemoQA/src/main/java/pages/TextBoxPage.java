package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends Page {
	
	public By lblName = By.id("name");
	public By lblEmail = By.id("email");
	public By lblcurrentAddress= By.xpath("//p[@id='currentAddress']");
	
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
