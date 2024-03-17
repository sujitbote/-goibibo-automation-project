package goibibo_test;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.Launch_Quit;
import source_pages.OneWay_Search;
import source_pages.Search_page;
import source_pages.LogOut_Page;

//login>search flight>logout

@Listeners(resources.Listeners.class)
public class Goibibo_testcase_11 extends Launch_Quit
{
	
	@Test(dataProvider="data", dataProviderClass=resources.Fetch_Excel_Data.class, groups={"smoke","regression"}, retryAnalyzer=resources.Retry_Analyzer.class)
	public void testCase_01(String source1, String destiny1, String destiny2, String date1, String month1, String date2 ,String month2, String pincode)
	{
		
		OneWay_Search home = new OneWay_Search(driver);
		Search_page searchlist = new Search_page(driver);
		LogOut_Page logout = new LogOut_Page(driver);
		
		home.enter_Mobile_No();
		home.wait_Until_HomePage_Load();
		
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
		
		logout.hover_Over_account_section_menu();
		logout.select_profile_from_AccountSection_menu();
		logout.click_On_Logout_PB();
		logout.click_Logout_Confirmation_PB();
		
		Assert.assertTrue("logout is failed", logout.isLoggedOutSuccessfull());
		System.out.println("user is logged out successfully");
		
	}
	

}
