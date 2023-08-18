package tests;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.DataProviderClass;
public class DataProviderBooksSearchTest extends BaseTest{
	
	@Test(dataProviderClass=DataProviderClass.class	, dataProvider="bookNameDataProvider")
	public void searchBooks() {
		
	//	button[class*='search_submit']
	}

}
