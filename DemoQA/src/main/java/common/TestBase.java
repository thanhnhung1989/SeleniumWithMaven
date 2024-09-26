package common;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;

	public void openWeb() {
		// String projectPath = System.getProperty("user.dir");
		// System.setProperty("webdriver.chrome.driver", projectPath +
		// "\\driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
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
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", radioButton);
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

	public void uploadPicture(String link) {
		driver.findElement(By.id("uploadPicture")).sendKeys(System.getProperty("user.dir") + "\\" + link);
	}

	public String validateEmailFormat(By locator) {
		WebElement validateColor = driver.findElement(locator);
		// : Lấy giá trị thuộc tính CSS border-color của phần tử
		String cssBorderColor = validateColor.getCssValue("border-color");
		/// Chuyển đổi đối tượng màu thành chuỗi mã màu hex (ví dụ: #ff0000).
		return Color.fromString(cssBorderColor).asHex();

	}

//	public By getDayLocator(String day) {
//		return By.xpath("//div[contains(@class,'react-datepicker__day') and contains(text(),'"+day+"')]");
//	}

	public void inputDate(By openDateDialogLocator, By monthLocator, By yearLocator, String day, String month,
			String year) {
		WebElement eInputDate = driver.findElement(openDateDialogLocator);
		eInputDate.click();
		// Select date
		// By dayLocator = getDayLocator(day);
		WebElement drDay = driver.findElement(
				By.xpath("//div[contains(@class,'react-datepicker__day') and contains(text(),'" + day + "')]"));
		drDay.click();
		// Select month
		WebElement drMonth = driver.findElement(monthLocator);
		Select drMonthSelect = new Select(drMonth);
		drMonthSelect.selectByVisibleText(month);
		// Select year
		WebElement drYear = driver.findElement(yearLocator);
		Select drYearselect = new Select(drYear);
		drYearselect.selectByVisibleText(year);
	}
	public void selectFromDropDown(By dropdownLocator, String optionText) {
		// Tìm và click vào dropdown để mở
		WebElement dropdownElement = driver.findElement(dropdownLocator);
		dropdownElement.click();
		// Khởi tạo WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Chờ cho đến khi tùy chọn có thể nhìn thấy
		By optionLocator = By.xpath("//div[text()='" + optionText + "']");
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
		// Click vào tùy chọn
		option.click();
	}
// the: input, textarea, select, button
	public String getTextAfterSubmit(By locator) {
		WebElement e = driver.findElement(locator);
		return e.getAttribute("value");
	}

	public boolean isRadioSelected(String radioXpath, String radioValue) {
		String newXpath = radioXpath.replace("{@param}", radioValue);
		WebElement radioButton = driver.findElement(By.xpath(newXpath));
		return radioButton.isSelected();
	}

	public String getTextAfterSubmit2(By locator) {
		 WebElement e = driver.findElement(locator);
		return e.getText(); // Dùng getText() để lấy nội dung bên trong thẻ <td>
	}
	public String[] splitValue (String combinedValue) {
		return combinedValue.split(" ");
	}
	public String nomalizeString(String input) {
		if (input==null) {
			return null;
		}
		return input.replaceAll("\\s+", "").toLowerCase();
	}

}
