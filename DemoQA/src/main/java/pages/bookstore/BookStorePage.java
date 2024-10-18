package pages.bookstore;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.Page;


public class BookStorePage extends Page {
	// public By lblAuthor = By.xpath("//div[contains(@class, 'rt-th
	// rt-resizable-header') and .//div[text()='Author']]");
	public By lblAuthor = By.xpath("//div[@class='rt-resizable-header-content' and text()='Author']");
	public By rowsLocator = By.cssSelector(".rt-tr-group .rt-tr");
	public By columnLocator = By.cssSelector(".rt-td:nth-child(3)");

	public BookStorePage(WebDriver driverWeb, String config) {
		super(driverWeb, config);
	}

	public void clickAuthor() {
		dr.findElement(lblAuthor).click();
	}
	
	public List<String> getAuthorNames(){
		List<String> authorNames = new ArrayList<>();
		// get all row in table
		List<WebElement> rows = dr.findElements(rowsLocator);
		for(WebElement row : rows) {
			// find column 3
			WebElement authorColumn = dr.findElement(columnLocator);
			authorNames.add(authorColumn.getText());// add authorNames to list
		}
		
		return authorNames;
	}
}
