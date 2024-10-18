package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage extends Page {

	public ElementsPage(WebDriver driverWeb, String configFile) {
		super(driverWeb, configFile);
	}

	public TextBoxPage clickTextBox() {

		WebElement textBox = dr.findElement(By.xpath("//span[text()='Text Box']"));
		textBox.click();
		return new TextBoxPage(dr, configFile);
	}
}
