package common;

import org.openqa.selenium.WebDriver;
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
}
