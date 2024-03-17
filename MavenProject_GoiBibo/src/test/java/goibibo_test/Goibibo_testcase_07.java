package goibibo_test;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.Launch_Quit;
import source_pages.OneWay_Search;
import source_pages.Search_page;

//validate that user presented with additional options like luggage, extra legroom, food/beverage, etc 
//and selecting same results in additional cost with booking amount

@Listeners(resources.Listeners.class)
public class Goibibo_testcase_07 extends Launch_Quit
{
	
	@Test(dataProvider="data", dataProviderClass=resources.Fetch_Excel_Data.class, groups={"regression"}, retryAnalyzer=resources.Retry_Analyzer.class)
	public void testCase_01(String source1, String destiny1, String destiny2, String date1, String month1, String date2 ,String month2, String pincode) throws InterruptedException
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
		home.select_Premium_Economy_Travel_Class();
		home.traveller_class_Done_pb();
		
		home.click_on_Search_Flight_pb();
		searchlist.wait_until_searchPage_load();
		
		searchlist.click_On_View_Fares_PB();
		
		Assert.assertTrue("luggage space is not available", searchlist.isLuggageSpaceAvaiable());
		System.out.println("luggage space is available");
		
		Assert.assertTrue("extra legroom is not available", searchlist.isPremiumSeatAvaiable());
		System.out.println("extra legroom is available");
		
		Assert.assertTrue("free food/beverage is not available", searchlist.isFreeMealAvaiable());
		System.out.println("free food/beverage is available");
	}
	

}
