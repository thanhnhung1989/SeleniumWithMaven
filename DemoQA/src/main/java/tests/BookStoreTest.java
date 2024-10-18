package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import pages.bookstore.BookStorePage;

public class BookStoreTest extends TestCase {

	@Test
	public void sortNameVerify() {
		BookStorePage bookStorePage = new BookStorePage(testBase.driver, CONFIG_FILE);
		bookStorePage.openBookStore();
		testBase.waitForElementToBeVisible(bookStorePage.lblAuthor);
		testBase.scollToElement(bookStorePage.lblAuthor);
		// first click: asc
		bookStorePage.clickAuthor();
		List<String> authorNameAsc = bookStorePage.getAuthorNames();// get list authorName
		// check author sorted Asc or not?
		List<String> sortedAuthorAsc = new ArrayList<>(authorNameAsc);// create copy list from original list, avoid
																		// changing original list
		Collections.sort(sortedAuthorAsc);
		assertEquals(authorNameAsc, sortedAuthorAsc);

		// second click: dsc
		bookStorePage.clickAuthor();
		List<String> authorNameDsc = bookStorePage.getAuthorNames();// get list authorName
		// check author sorted Dsc or not?
		List<String> sortedNameDsc = new ArrayList<String>(authorNameDsc);
		Collections.sort(sortedNameDsc);
		assertEquals(authorNameDsc, sortedNameDsc);
	}

}
