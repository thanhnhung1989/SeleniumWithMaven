package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.BrowserWindowsPage;

public class BrowserWindowTest extends TestCase {
	@Test
	public void testOpenTab() {
		BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(testBase.driver);
		browserWindowsPage.openBrowserWindowsPage();
		 browserWindowsPage.openNewTab();
	

	}
	
	@Test
	public void testOpenWindow() {
		BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(testBase.driver);
		browserWindowsPage.openBrowserWindowsPage();
		browserWindowsPage.openNewWindow();

	}
	
	@Test
	public void testOpenWindowMessage() {
		String expectMes = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
		BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(testBase.driver);
		browserWindowsPage.openBrowserWindowsPage();
		String actualMes = browserWindowsPage.openNewWindowMessage();
		assertEquals(actualMes.trim(),expectMes.trim());

	}

}
