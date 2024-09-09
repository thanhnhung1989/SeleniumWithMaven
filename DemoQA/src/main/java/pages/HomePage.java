package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {
	

	public HomePage(WebDriver driverWeb) {
		super(driverWeb);
		
	}

	public ElementsPage clickElements() {
		WebElement elementsLink = dr.findElement(By.xpath("//h5[text()= 'Elemants'"));
		elementsLink.click();
		return new ElementsPage(dr);//// truyền đi dr, giữ dr ko null

	}
	
}
