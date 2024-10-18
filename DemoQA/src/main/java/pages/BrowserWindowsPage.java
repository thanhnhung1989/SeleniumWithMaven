package pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserWindowsPage extends Page {
	public By btnNewTab = By.id("tabButton");
	public By btnNewWindow = By.id("windowButton");
	public By btnNewWindowMessage = By.id("messageWindowButton");
	public By messageLocator = By.tagName("body");

	public BrowserWindowsPage(WebDriver driverWeb, String configFile) {
		super(driverWeb, configFile);
	}

	public void openNewTab() {
		String originalTab = dr.getWindowHandle();
		dr.findElement(btnNewTab).click();
		Set<String> windowHandles = dr.getWindowHandles();
		for (String windowhandle : windowHandles) {
			if (!windowhandle.equals(originalTab)) {
				dr.switchTo().window(windowhandle);
				dr.manage().window().maximize();
				break;
			}
		}
	}
	// System.out.println("Đang ở cửa sổ mới: " + dr.getTitle());
	// dr.switchTo().window(originalTab);

	public void openNewWindow() {
		dr.findElement(btnNewWindow).click();
		// Lưu lại handle của cửa sổ gốc
		String originalWindow = dr.getWindowHandle();
		// Lấy tất cả các handle cửa sổ
		Set<String> allWindows = dr.getWindowHandles();
		// Chuyển sang cửa sổ mới
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				dr.switchTo().window(windowHandle); // Chuyển sang cửa sổ mới
				break;
			}
		}
	}

//	public String openNewWindowMessage() {
//		String message = "";
//		WebElement button = dr.findElement(btnNewWindowMessage);
//		// chỉ cần cho trường hợp có iframe
//		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", button);
//		button.click();
//	//	dr.findElement(btnNewWindowMessage).click();
//		String originalWindow = dr.getWindowHandle();
//		Set<String> allWindows = dr.getWindowHandles();
//		for (String windowHandle : allWindows) {
//			if (!windowHandle.equals(originalWindow)) {
//				dr.switchTo().window(windowHandle);
//				WebElement bodyText = dr.findElement(messageLocator);
//				message = bodyText.getText();
//				break;
//			}
//		}
//
//		return message;
//	}
	public String openNewWindowMessage() {
	    String message = "";
	    WebElement button = dr.findElement(btnNewWindowMessage);
	    // Scroll để nút vào tầm nhìn, chỉ cần cho trường hợp có iframe
	    ((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", button);
	    button.click();

	    String originalWindow = dr.getWindowHandle();
	    Set<String> allWindows = dr.getWindowHandles();
	    
	    for (String windowHandle : allWindows) {
	        if (!windowHandle.equals(originalWindow)) {
	            dr.switchTo().window(windowHandle);

	            // Chờ đợi phần tử xuất hiện
	            WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.presenceOfElementLocated(messageLocator));

	            WebElement bodyText = dr.findElement(messageLocator);
	            message = bodyText.getText();

	            // Đóng cửa sổ mới nếu cần
	            dr.close();
	            break;
	        }
	    }

	    // Quay lại cửa sổ ban đầu
	    dr.switchTo().window(originalWindow);
	    return message;
	}

}
