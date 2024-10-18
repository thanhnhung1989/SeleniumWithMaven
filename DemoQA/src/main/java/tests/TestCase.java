package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import common.Configurations;
import common.TestBase;
import pages.CheckBoxPage;
import pages.PraticeFormsPage;
import pages.TextBoxPage;

public class TestCase {
	
	public final String CONFIG_FILE = System.getProperty("user.dir") + "\\src\\main\\resources\\Config.properties";
	public Configurations configurations = new Configurations(CONFIG_FILE);
	public TestBase testBase = new TestBase(CONFIG_FILE);

	@BeforeClass
	public void setUp() {
		testBase.openSingleBroswer(configurations.getConfigValueByKey("url"), "chrome");
	}

	// @AfterClass
	public void tearDown() {
		// testBase.quit();
	}
}
