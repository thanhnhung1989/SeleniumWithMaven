package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage extends Page {
	
	

	public ElementsPage(WebDriver driverWeb) {
		super(driverWeb);
		
	}

	public TextBoxPage clickTextBox() {
		WebElement elementsLink = dr.findElement(By.xpath("//span[text()= 'Text Box'"));
		elementsLink.click();
		return new TextBoxPage(dr);
	
	}
}
