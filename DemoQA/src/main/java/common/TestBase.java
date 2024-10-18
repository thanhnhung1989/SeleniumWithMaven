package common;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	public int timeout;
	public Configurations configs;

	public TestBase(String configFile) {
		Configurations configs = new Configurations(configFile);
		timeout = Integer.valueOf(configs.getConfigValueByKey("medium_time"));
    }

	public TestBase() {
	}

	public void openSingleBroswer(String url, String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			// Thiết lập ChromeOptions
			ChromeOptions chromeOptions = new ChromeOptions();
			String downloadPath = System.getProperty("user.dir") + "\\testdata\\";
			chromeOptions.setExperimentalOption("prefs", Map.of("download.default_directory", downloadPath,
					"download.prompt_for_download", false, "directory_upgrade", true));
			// WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			driver = new EdgeDriver(edgeOptions);

		} else if (browser.equalsIgnoreCase("safari")) {
			SafariOptions safariOptions = new SafariOptions();
			driver = new SafariDriver(safariOptions);
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOptions);
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
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

	public void inputDate(By openDateDialogLocator, By monthLocator, By yearLocator, String dateOfBirth) {
		String[] dates = dateOfBirth.split("/");
		WebElement eInputDate = driver.findElement(openDateDialogLocator);
		eInputDate.click();
		// Select year
		WebElement drYear = driver.findElement(yearLocator);
		Select drYearselect = new Select(drYear);
		drYearselect.selectByVisibleText(dates[2]);
		// Select month
		WebElement drMonth = driver.findElement(monthLocator);
		Select drMonthSelect = new Select(drMonth);
		drMonthSelect.selectByVisibleText(dates[1]);
		// Select day
		WebElement drDay = driver.findElement(By.xpath(
				"//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='"
						+ dates[0] + "']"));
		drDay.click();
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

	public boolean isRadioSelected(String radioXpath, String radioValue) {
		String newXpath = radioXpath.replace("{@param}", radioValue);
		WebElement radioButton = driver.findElement(By.xpath(newXpath));
		return radioButton.isSelected();
	}

	// Scroll to element
	public void scollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// getText
	public String getTextByLocator(By locator) {
		String result = "";
		result = driver.findElement(locator).getText();
		return result;
	}

	public void waitForElementToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
