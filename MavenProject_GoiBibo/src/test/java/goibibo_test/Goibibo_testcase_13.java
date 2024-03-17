package goibibo_test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.Launch_Quit;
import source_pages.Booking_Summary_Page;
import source_pages.OneWay_Search;
import source_pages.Payment_page;
import source_pages.Search_page;

//reach till payment page & select credit card option>enter card number

@Listeners(resources.Listeners.class)
public class Goibibo_testcase_13 extends Launch_Quit
{
	
	@Test(dataProvider="data", dataProviderClass=resources.Fetch_Excel_Data.class, groups={"regression"}, retryAnalyzer=resources.Retry_Analyzer.class)
	public void testCase_01(String source1, String destiny1, String destiny2, String date1, String month1, String date2 ,String month2, String pincode) throws InterruptedException
	{
		
		OneWay_Search home = new OneWay_Search(driver);
		Search_page searchlist = new Search_page(driver);
		Booking_Summary_Page summary = new Booking_Summary_Page(driver);
		Payment_page payment = new Payment_page(driver);
		
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
		summary.enter_Billing_Address(source1);
		summary.enter_Pincode(pincode);
		summary.select_State_From_DD();
		summary.confirm_Billing_Details_Checkbox();
		summary.select_Gender_DD();
		summary.enter_first_name();
		summary.enter_email_id();
//		summary.enter_mobile_no();
		summary.click_Submit_PB();
		summary.submit_Added_Details();
		summary.skip_To_Payment_Page();
		payment.wait_Until_Payment_Page_Load();
		
		Assert.assertTrue(payment.isPaymentPageDisplayed(), "payment page is not displayed");
		System.out.println("payment page is displayed successfully");
		
		payment.select_CC_Payment_Option();
		payment.enter_CC_No();
		
		Assert.assertTrue(payment.isCardNoEntered(), "credit card no is not entered");
		System.out.println("credit card number is entered successfully");

	}
	

}
