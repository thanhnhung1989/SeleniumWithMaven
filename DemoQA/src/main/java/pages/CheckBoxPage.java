package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends Page{
	public By chkHome = By.xpath("//label[@for='tree-node-home']/span[@class='rct-checkbox']/*[name()='svg']"); // //span[@class='rct-checkbox']/*[name()='svg']
	public By textAfterCheckbox = By.xpath("//div[@id='result']");
	public By iconExpand = By.xpath("//span[text()='Home']/preceding::button[@title='Toggle'][1]");
	public By desktopCheckbox = By.xpath("//label[@for='tree-node-desktop']/span[@class='rct-checkbox']/*[name()='svg']");
	public By documentsCheckbox = By.xpath("//label[@for='tree-node-documents']/span[@class='rct-checkbox']/*[name()='svg']");
	public By downloadsCheckbox = By.xpath("//label[@for='tree-node-downloads']/span[@class='rct-checkbox']/*[name()='svg']");

	public CheckBoxPage(WebDriver driverWeb, String configFile) {
		super(driverWeb, configFile);
	}
	
	public void clickHomeCheckbox() {
		 dr.findElement(chkHome).click();
	}
	
	public String getTextAfterCheck() {
		return dr.findElement(textAfterCheckbox).getText();
	}
	public void clickIconExpand() {
		dr.findElement(iconExpand).click();

	}
	//checkbox is displayed or not displays
	public void verifyCheckboxIsDisplayed(By checkbox) {
		assertTrue(dr.findElement(checkbox).isDisplayed(), "Checkbox is not displayed.");

	}
	//checkbox is checked or not checked
	public void verifyCheckboxIsChecked(By checkbox) {
		String checkboxClass = dr.findElement(checkbox).getAttribute("class");
		assertTrue(checkboxClass.contains("rct-icon-check"));
	}

}
