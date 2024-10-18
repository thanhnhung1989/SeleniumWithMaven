package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsPage extends Page {

	public FormsPage(WebDriver driverWeb, String configFile) {
		super(driverWeb, configFile);
	}
	public FormsPage clickPraticeForms() {
		WebElement praticeForms = dr.findElement(By.xpath("//span[text()='Practice Form']"));
		praticeForms.click();
		return new FormsPage(dr, configFile);
	}

}
