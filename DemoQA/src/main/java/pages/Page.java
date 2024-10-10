package pages;

import org.openqa.selenium.WebDriver;

import common.TestBase;

public class Page {
	public WebDriver dr;
	public TextBoxPage textBoxPage;
	public CheckBoxPage checkBoxPage;
	public PraticeFormsPage praticeForms;
	public BrowserWindowsPage browserWindows;
	public WebTablesPage webTables;
	public UploadAndDownloadPage uploadAndDownload;
	public TestBase testBase = new TestBase();

	public Page(WebDriver driverWeb) {
		testBase.driver = driverWeb;
		this.dr = testBase.driver;
	}

	public TextBoxPage openTextBoxPage() {

		dr.navigate().to("https://demoqa.com/text-box");
		textBoxPage = new TextBoxPage(dr);
		return textBoxPage;
	}

	public CheckBoxPage openCheckBoxPage() {

		dr.navigate().to("https://demoqa.com/checkbox");
		checkBoxPage = new CheckBoxPage(dr);
		return checkBoxPage;
	}

	public PraticeFormsPage openPraticeForms() {
		dr.navigate().to("https://demoqa.com/automation-practice-form");
		praticeForms = new PraticeFormsPage(dr);
		return praticeForms;

	}
	public BrowserWindowsPage openBrowserWindowsPage() {
		dr.navigate().to("https://demoqa.com/browser-windows");
		browserWindows = new BrowserWindowsPage(dr);
		return browserWindows;
	}
	public WebTablesPage openWebTablesPage() {
		dr.navigate().to("https://demoqa.com/webtables");
		webTables = new WebTablesPage(dr);
		return webTables;
	
	}
	public UploadAndDownloadPage openUploadAndDownloadPage() {
		dr.navigate().to("https://demoqa.com/upload-download");
		uploadAndDownload = new UploadAndDownloadPage(dr);
		return uploadAndDownload;
	
	}
}
