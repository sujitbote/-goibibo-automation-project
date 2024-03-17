package goibibo_test;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.Launch_Quit;
import source_pages.OneWay_Search;
import source_pages.Search_page;

//validate flight info, fare details, baggage rules, cancellation rules, sections has details in search result page

@Listeners(resources.Listeners.class)
public class Goibibo_testcase_09 extends Launch_Quit
{
	
	@Test(dataProvider="data", dataProviderClass=resources.Fetch_Excel_Data.class, groups={"smoke","regression"}, retryAnalyzer=resources.Retry_Analyzer.class)
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
		home.traveller_class_Done_pb();
		
		home.click_on_Search_Flight_pb();
		searchlist.wait_until_searchPage_load();
		
		searchlist.click_On_Flight_Details_Section();
		Assert.assertTrue("failed to detect flight info section", searchlist.verify_Flight_Info_Details());
		System.out.println("flight info section is present");
		
		searchlist.click_On_Fare_Details_Section();
		Assert.assertTrue("failed to detect Fare details section", searchlist.verify_Fair_Details_Section());
		System.out.println("Fare details section is present");
		
		searchlist.click_On_Baggage_Details_Section();
		Assert.assertTrue("failed to detect baggage details section", searchlist.verify_Baggage_Details_Section());
		System.out.println("baggage details section is present");
		
		searchlist.click_On_Cancellation_Details_Section();
		Assert.assertTrue("failed to detect cancellation details section", searchlist.verify_Cancellation_Details_Section());
		System.out.println("cancellation details section is present");
		

	}
	

}
