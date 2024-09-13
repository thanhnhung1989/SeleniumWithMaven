package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {

	public HomePage(WebDriver driverWeb) {
		super(driverWeb);

	}

	public ElementsPage clickElements() {

		WebElement elementsLink = dr.findElement(By.xpath("//h5[text()='Elements']"));

		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true);", elementsLink);

		elementsLink.click();

		return new ElementsPage(dr);//// truyền đi dr, giữ dr ko null

	}

}
