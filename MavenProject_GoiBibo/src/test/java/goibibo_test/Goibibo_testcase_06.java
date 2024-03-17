package goibibo_test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.Launch_Quit;
import source_pages.OneWay_Search;
import source_pages.Search_page;
import source_pages.MultiCIty_Search;

//test for multicity flight search

@Listeners(resources.Listeners.class)
public class Goibibo_testcase_06 extends Launch_Quit
{
	
	@Test(dataProvider="data", dataProviderClass=resources.Fetch_Excel_Data.class, groups={"smoke","regression"}, retryAnalyzer=resources.Retry_Analyzer.class)
	public void testCase_01(String source1, String destiny1, String destiny2, String date1, String month1, String date2 ,String month2, String pincode)
	{
		
		OneWay_Search home = new OneWay_Search(driver);
		MultiCIty_Search multi_city = new MultiCIty_Search(driver);
		Search_page searchlist = new Search_page(driver);

		home.cancel_Signup_Popup();
		
		multi_city.click_On_Multi_City_RB();
		
		multi_city.click_On_From_City_TextBox();
		multi_city.enter_From_city_1(source1);
		multi_city.selectCity_from_SearchList();
		
		multi_city.enter_To_city_1(destiny1);
		multi_city.selectCity_from_SearchList();
		
		multi_city.select_expected_month(month1);
		multi_city.select_expected_date(date1);
		multi_city.date_Done_pb();
		
		multi_city.traveller_class_Done_pb();
		
		multi_city.click_On_To_City_2();
		multi_city.enter_To_city_2(destiny2);
		multi_city.selectCity_from_SearchList();

		multi_city.select_expected_month(month2);
		multi_city.select_expected_date(date2);
		multi_city.date_Done_pb();
		multi_city.date_Cancel_pb();
		
		multi_city.click_on_Search_Flight_pb();

		Assert.assertEquals(searchlist.getPageTitle(), "Book Cheap Flights, Air Tickets, Hotels, Bus & Holiday Package at Goibibo", "Page Title Mismatch");
		System.out.println("multicity flight is searched successfully");

	}
	

}
