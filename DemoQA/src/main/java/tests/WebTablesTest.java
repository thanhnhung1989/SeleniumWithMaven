package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.WebTablesPage;

public class WebTablesTest extends TestCase {

	@Test
	public void searchTextIsFound() {
		WebTablesPage webTable = new WebTablesPage(testBase.driver, CONFIG_FILE);
		webTable.openWebTablesPage();
		boolean isFound = webTable.searchAndValidateTable("en");
		assertTrue(isFound, "Kết quả không khớp");

	}

	@Test
	public void searchTextNotFound() {
		WebTablesPage webTable = new WebTablesPage(testBase.driver, CONFIG_FILE);
		webTable.openWebTablesPage();
		boolean isFound = webTable.searchAndValidateTable("lpp");
		assertFalse(isFound, "\"Kết quả tìm kiếm không chính xác. Từ khóa không tồn tại nhưng lại được tìm thấy \"");

	}
}
