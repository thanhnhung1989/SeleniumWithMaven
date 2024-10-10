package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UploadAndDownloadPage extends Page {
	
	public By btnDownload = By.id("downloadButton");

	public UploadAndDownloadPage(WebDriver driverWeb) {
		super(driverWeb);
	}
	public void clickDownload() {
		
		WebElement downloadBtn = dr.findElement(btnDownload);
		downloadBtn.click();
	}

}
