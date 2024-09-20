package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import common.TestBase;
import pages.CheckBoxPage;
import pages.PraticeFormsPage;
import pages.TextBoxPage;

public class TestCase {
	public TestBase testBase = new TestBase();
	public TextBoxPage textBoxPage;
	public CheckBoxPage checkBoxPage;
	public PraticeFormsPage praticeForms;

	@BeforeClass
	public void setUp() {
		testBase.openWeb();
	}

	// @AfterClass
	public void tearDown() {
		// testBase.quit();
	}
	
	public TextBoxPage openTextBoxPage() {
		
		testBase.driver.navigate().to("https://demoqa.com/text-box");
		 textBoxPage = new TextBoxPage(testBase.driver);
		 return textBoxPage;
	}
	public CheckBoxPage openCheckBoxPage() {

		testBase.driver.navigate().to("https://demoqa.com/checkbox");
		checkBoxPage = new CheckBoxPage(testBase.driver);
		return checkBoxPage; 
	}
	public PraticeFormsPage openPraticeForms() {
		testBase.driver.navigate().to("https://demoqa.com/automation-practice-form");
		praticeForms = new PraticeFormsPage(testBase.driver);
		return praticeForms;

	}
}
