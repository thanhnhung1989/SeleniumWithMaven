package pages;

import org.openqa.selenium.WebDriver;

import common.Configurations;
import common.TestBase;
import pages.bookstore.BookStorePage;
import pages.bookstore.LoginPage;

public class Page {
	public WebDriver dr;
	public TextBoxPage textBoxPage;
	public CheckBoxPage checkBoxPage;
	public PraticeFormsPage praticeForms;
	public BrowserWindowsPage browserWindows;
	public WebTablesPage webTables;
	public UploadAndDownloadPage uploadAndDownload;
	public LoginPage loginPage;
	public BookStorePage bookStore;
	public String configFile;
	public Configurations configs;
	public TestBase testBase = new TestBase();

	public Page(WebDriver driverWeb, String config) {
		testBase.driver = driverWeb;
		//this.dr = testBase.driver;
		this.dr = testBase.driver;
		configFile = config;
		configs = new Configurations(configFile);
	}

	public TextBoxPage openTextBoxPage() {

		dr.navigate().to(configs.getConfigValueByKey("url") + configs.getConfigValueByKey("text_box_page"));
		textBoxPage = new TextBoxPage(dr, configFile);
		return textBoxPage;
	}

	public CheckBoxPage openCheckBoxPage() {
		dr.navigate().to(configs.getConfigValueByKey("url") + configs.getConfigValueByKey("check_box_page"));
		checkBoxPage = new CheckBoxPage(dr, configFile);
		return checkBoxPage;
	}

	public PraticeFormsPage openPraticeForms() {
		dr.navigate().to(configs.getConfigValueByKey("url") + configs.getConfigValueByKey("pratice_form_page"));
		praticeForms = new PraticeFormsPage(dr, configFile);
		return praticeForms;
	}

	public BrowserWindowsPage openBrowserWindowsPage() {
		dr.navigate().to(configs.getConfigValueByKey("url") + configs.getConfigValueByKey("browser_window_page"));
		browserWindows = new BrowserWindowsPage(dr, configFile);
		return browserWindows;
	}

	public WebTablesPage openWebTablesPage() {
		dr.navigate().to(configs.getConfigValueByKey("url") + configs.getConfigValueByKey("web_table_page"));
		webTables = new WebTablesPage(dr, configFile);
		return webTables;
	}

	public UploadAndDownloadPage openUploadAndDownloadPage() {
		dr.navigate().to(configs.getConfigValueByKey("url") + configs.getConfigValueByKey("upload_download_page"));
		uploadAndDownload = new UploadAndDownloadPage(dr, configFile);
		return uploadAndDownload;
	}

	public LoginPage openLogin() {
		dr.navigate().to(configs.getConfigValueByKey("url") + configs.getConfigValueByKey("login_page"));
		loginPage = new LoginPage(dr, configFile);
		return loginPage;
	}
	public BookStorePage openBookStore() {
		dr.navigate().to(configs.getConfigValueByKey("url")+ configs.getConfigValueByKey("book_store_page"));
		bookStore = new BookStorePage(dr, configFile);
		return bookStore;
		
	}
}
