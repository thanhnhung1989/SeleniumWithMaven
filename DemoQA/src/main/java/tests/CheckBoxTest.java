package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckBoxTest extends TestCase {

	@Test
	public void verifyCheckBox() {
		openCheckBoxPage();
		String actualClass = testBase.driver.findElement(checkBoxPage.chkHome).getAttribute("class");
		assertTrue(actualClass.contains("uncheck"));// giá trị của thuộc tính class của phần tử có chứa chuỗi "uncheck"

		checkBoxPage.clickHomeCheckbox();

		String actualText = checkBoxPage.getTextAfterCheck();
		assertTrue(actualText.contains("You have selected"));
		
		checkBoxPage.clickIconExpand();
		
		checkBoxPage.verifyCheckboxIsDisplayed(checkBoxPage.desktopCheckbox);
		checkBoxPage.verifyCheckboxIsDisplayed(checkBoxPage.documentsCheckbox);
		checkBoxPage.verifyCheckboxIsDisplayed(checkBoxPage.downloadsCheckbox);
		
		checkBoxPage.verifyCheckboxIsChecked(checkBoxPage.desktopCheckbox);
		checkBoxPage.verifyCheckboxIsChecked(checkBoxPage.documentsCheckbox);
		checkBoxPage.verifyCheckboxIsChecked(checkBoxPage.downloadsCheckbox);
	
	}


}
