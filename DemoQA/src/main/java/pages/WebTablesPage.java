package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablesPage extends Page {
	public By searchBoxLocator = By.id("searchBox");
	public By searchBtnLocator = By.id("basic-addon2");

	public WebTablesPage(WebDriver driverWeb) {
		super(driverWeb);
	}

	public boolean searchAndValidateTable(String searchText) {
		WebElement searchBox = dr.findElement(searchBoxLocator);
		searchBox.sendKeys(searchText);
		WebElement searchBtn = dr.findElement(searchBtnLocator);
		searchBtn.click();

		// Lấy tất cả các hàng từ bảng
		List<WebElement> rows = dr
				.findElements(By.xpath("//div[@class='ReactTable -striped -highlight']//div[@class='rt-tr-group']"));

		boolean isFound = false;
		boolean rowMatch = false;

		for (WebElement row : rows) {
			List<WebElement> columns = row.findElements(By.xpath(".//div[@class='rt-td']"));

			// Kiểm tra nếu hàng rỗng: tất cả các ô trong hàng đều trống
			boolean isRowEmpty = columns.stream().allMatch(column -> column.getText().trim().isEmpty());

			if (!isRowEmpty) {
				rowMatch = columns.stream().anyMatch(column -> column.getText().contains(searchText));
				if (rowMatch) {
					isFound = true;
					 System.out.println("Kết quả tìm thấy tại hàng: " + row.getText());
				}
			}

		}
		return isFound;
	}

}
