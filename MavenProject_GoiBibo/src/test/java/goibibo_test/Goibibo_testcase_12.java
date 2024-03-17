package goibibo_test;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.Launch_Quit;
import source_pages.OneWay_Search;
import source_pages.Search_page;
import source_pages.Booking_Summary_Page;

//check if user able to apply coupon code while ordering product

@Listeners(resources.Listeners.class)
public class Goibibo_testcase_12 extends Launch_Quit
{
	
	@Test(dataProvider="data", dataProviderClass=resources.Fetch_Excel_Data.class, groups={"smoke","regression"}, retryAnalyzer=resources.Retry_Analyzer.class)
	public void testCase_01(String source1, String destiny1, String destiny2, String date1, String month1, String date2 ,String month2, String pincode) throws InterruptedException
	{
		
		OneWay_Search home = new OneWay_Search(driver);
		Search_page searchlist = new Search_page(driver);
		Booking_Summary_Page summary = new Booking_Summary_Page(driver);
		
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
		
		searchlist.click_On_View_Fares_PB();
		searchlist.click_Book_Flight_PB();
		
		summary.wait_Until_Page_Load();
		summary.switch_Control_To_ChildTab();

		summary.enter_PromoCode();
		summary.click_Apply_PromoCode();
		
		Assert.assertTrue("promo code is not accepted", summary.isPromoCodeAccepted());
		System.out.println("promo code is accepted successfully");
		
		summary.click_Ok_On_PromoCode_Popup();
		
	}
	

}
