package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public WebDriver driver;

	public void openWeb() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
	}

	public void inputText(By txtInput, String value) {
		WebElement inputName = driver.findElement(txtInput);
		inputName.sendKeys(value);
	}

	public void selectRadioButton(String radioXpath, String radioValue) {
		// Kiểm tra radioValue có không rỗng và không phải khoảng trắng
		if (!radioValue.isEmpty() || !radioValue.isBlank()) {
			// Tạo một XPath mới từ radioXpath bằng cách thay thế "{@param}" bằng giá trị
			// radioValue
			String newXpath = radioXpath.replace("{@param}", radioValue);
			// Tìm phần tử radio button trên trang bằng cách sử dụng XPath đã thay thế
			WebElement radioButton = driver.findElement(By.xpath(newXpath));
			radioButton.click();
		}
	}

	public void inputValuesToCombobox(By comboLocator, String comboValue) {
		if (!comboValue.isEmpty() || !comboValue.isBlank()) {
			// Tách các giá trị trong comboValue thành mảng các chuỗi, dựa trên dấu phẩy
			String[] subjects = comboValue.split(",");
			WebElement subjectField = driver.findElement(comboLocator);
			subjectField.click();
			for (String input : subjects) {
				// Xóa khoảng trắng hai đầu của mỗi subject và nhập nó vào combobox
				subjectField.sendKeys(input.trim());
				subjectField.sendKeys(Keys.ENTER);
			}
		}

	}

	public void selectCheckbox(String chkXpath, String chkValue) {
		if (!chkValue.isEmpty() || !chkValue.isBlank()) {
			String[] chkValues = chkValue.split(",");
			for (String input : chkValues) {
				String newXpath = chkXpath.replace("{@param}", input.trim());
				WebElement chkButton = driver.findElement(By.xpath(newXpath));
				chkButton.click();
			}

		}
	}
	
	public void selectFromDropdown(By comboLocator, String comboValue) {
		if(!comboValue.isEmpty()||!comboValue.isBlank()) {
			WebElement dropdownFile = driver.findElement(comboLocator);
			dropdownFile.click();// Nhấn vào combobox để mở danh sách
			dropdownFile.sendKeys(comboValue);// Nhập giá trị cần tìm trong combobox
			dropdownFile.sendKeys(Keys.ENTER); // Nhấn ENTER để chọn giá trị
		}

	}
	
	  public void uploadPicture(String link) {
	        driver.findElement(By.id("uploadPicture")).sendKeys(System.getProperty("user.dir") + link);
	    }
}
