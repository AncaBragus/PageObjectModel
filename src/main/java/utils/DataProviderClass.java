package utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name="bookNameDataProvider")
	public  Object [][] bookNameDataProvider(){
		Object[][] data =new Object[5][2];
		
		data[0][0] ="The forest"
		data[0][1] ="book2.jpg"
		data[1][0] ="Life in the garden"
		data[1][1] ="book2.jpg"
		
		data[2][0] ="The forest"
		data[2][1] ="book2.jpg"
		
		data[0][0] =
		data[0][1] =
	}
	
	
}
