package goibibo_test;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.Launch_Quit;
import resources.Navigations;
import source_pages.OneWay_Search;
import source_pages.Search_page;

//validate search result for different classes like economy, business, first class

@Listeners(resources.Listeners.class)
public class Goibibo_testcase_05 extends Launch_Quit
{
	
	@Test(dataProvider="data", dataProviderClass=resources.Fetch_Excel_Data.class, groups={"smoke"}, retryAnalyzer=resources.Retry_Analyzer.class)
	public void testCase_01(String source1, String destiny1, String destiny2, String date1, String month1, String date2 ,String month2, String pincode)
	{
		
		OneWay_Search home = new OneWay_Search(driver);
		Search_page searchlist = new Search_page(driver);
		Navigations navigate = new Navigations(driver);
		
		home.cancel_Signup_Popup();
		
		home.click_on_source_City();
		home.enter_Source_City(source1);
		home.selectCity_from_SearchList();

		home.enter_Destination_City(destiny1);
		home.selectCity_from_SearchList();
		
		home.select_expected_month(month1);

		home.select_expected_date(date1);
		
		home.date_Done_pb();
		home.select_economy_travel_class();
		home.traveller_class_Done_pb();
		home.click_on_Search_Flight_pb();
		searchlist.wait_until_searchPage_load();
				
		Assert.assertTrue("Economy Class is not selected", searchlist.isEconomyTravelClassSelected());
		System.out.println("Economy Class is selected successfully");
		
		navigate.navigate_Back();
		home.click_On_Travel_Class_Option();
		home.select_Premium_Economy_Travel_Class();
		home.traveller_class_Done_pb();
		home.click_on_Search_Flight_pb();
		
		Assert.assertTrue("Premium Economy Class is not selected", searchlist.isPremiumEconomyTravelClassSelected());
		System.out.println("Premium Economy Class is selected successfully");
		
		navigate.navigate_Back();
		home.click_On_Travel_Class_Option();
		home.select_business_travel_class();
		home.traveller_class_Done_pb();
		home.click_on_Search_Flight_pb();
		
		Assert.assertTrue("Business Class is not selected", searchlist.isBusinessTravelClassSelected());
		System.out.println("Business Class is selected successfully");
	}
	

}
