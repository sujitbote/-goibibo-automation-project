package goibibo_test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.Launch_Quit;
import source_pages.OneWay_Search;
import source_pages.Search_page;

//test the search functionality for one way flight
//home page title = Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off
//search page title = Book Cheap Flights, Air Tickets, Hotels, Bus & Holiday Package at Goibibo

@Listeners(resources.Listeners.class)
public class Goibibo_testcase_03 extends Launch_Quit
{
	
	@Test(dataProvider="data", dataProviderClass=resources.Fetch_Excel_Data.class, groups={"smoke","regression"}, retryAnalyzer=resources.Retry_Analyzer.class)
	public void testCase_01(String source1, String destiny1, String destiny2, String date1, String month1, String date2 ,String month2, String pincode)
	{
		
		OneWay_Search home = new OneWay_Search(driver);
		Search_page searchlist = new Search_page(driver);
		
		home.cancel_Signup_Popup();
		
		home.click_on_source_City();
		home.enter_Source_City(source1);
		home.selectCity_from_SearchList();

		home.enter_Destination_City(destiny1);
		home.selectCity_from_SearchList();
		
		home.select_expected_month(month1);

		home.select_expected_date(date1);
		
		home.date_Done_pb();
		home.traveller_class_Done_pb();
		
		home.click_on_Search_Flight_pb();
		searchlist.wait_until_searchPage_load();
		
		Assert.assertEquals(searchlist.getPageTitle(), "Book Cheap Flights, Air Tickets, Hotels, Bus & Holiday Package at Goibibo", "Page Title Mismatch");
		System.out.println("one way flight is searched successfully");

	}
	

}
