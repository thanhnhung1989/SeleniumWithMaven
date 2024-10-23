package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import common.Configurations;
import common.TestBase;
import pages.CheckBoxPage;
import pages.PraticeFormsPage;
import pages.TextBoxPage;

public class TestCase {
	
	public final String CONFIG_FILE = System.getProperty("user.dir") + "\\src\\main\\resources\\Config.properties";
	public Configurations configurations = new Configurations(CONFIG_FILE);
	public TestBase testBase = new TestBase(CONFIG_FILE);

	@Parameters("browser")
	@BeforeClass
	public void setUp(String brower) {
		testBase.openSingleBroswer(configurations.getConfigValueByKey("url"), brower);
	}

	// @AfterClass
	public void tearDown() {
		// testBase.quit();
	}
}
