package tests;

import org.testng.annotations.Test;

import pages.UploadAndDownloadPage;

public class UploadAndDownloadTest extends TestCase {
@Test
	public void downloadFile() {
		UploadAndDownloadPage upAndDownloadPage = new UploadAndDownloadPage(testBase.driver);
		upAndDownloadPage.openUploadAndDownloadPage();
		upAndDownloadPage.clickDownload();
	
	}
}
