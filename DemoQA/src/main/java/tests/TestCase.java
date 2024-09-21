package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import common.TestBase;
import pages.CheckBoxPage;
import pages.PraticeFormsPage;
import pages.TextBoxPage;

public class TestCase {
	public TestBase testBase = new TestBase();


	@BeforeClass
	public void setUp() {
		testBase.openWeb();
	}

	// @AfterClass
	public void tearDown() {
		// testBase.quit();
	}
	
	
}
