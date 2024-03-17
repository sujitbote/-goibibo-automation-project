package goibibo_test;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.Launch_Quit;
import source_pages.OneWay_Search;
import source_pages.Search_page;
import source_pages.Booking_Summary_Page;

//validate if value is accepted in pin,state,radio,fname,lname,email,mobno,promocode,etc in booking page

@Listeners(resources.Listeners.class)
public class Goibibo_testcase_10 extends Launch_Quit
{
	
	@Test(dataProvider="data", dataProviderClass=resources.Fetch_Excel_Data.class, groups={"regression"}, retryAnalyzer=resources.Retry_Analyzer.class)
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
		//summary.click_Travel_Unsecure();
		
		summary.enter_Billing_Address(source1);
		Assert.assertTrue("fail to enter address", summary.isAddressEntered(source1));
		System.out.println("address is entered successfully");
		
		summary.enter_Pincode(pincode);
		Assert.assertTrue("failed to enter pincode", summary.isPinCodeEntered(pincode));
		System.out.println("pincode is entered successfully");

		summary.select_State_From_DD();
		Assert.assertTrue("failed to select state", summary.isStateSelected());
		System.out.println("state is selected successfully");

		summary.confirm_Billing_Details_Checkbox();
		Assert.assertTrue("failed to select confirmation checkbox", summary.isConfirmationCheckboxSelected());
		System.out.println("confirmation checkbox is selected successfully");
		
		summary.select_Gender_DD();
		Assert.assertTrue("failed to select gender", summary.isGenderSelected());
		System.out.println("gender is selected successfully");
		
		summary.enter_first_name();
		Assert.assertTrue("failed to enter name", summary.isNameEntered());
		System.out.println("name is entered successfully");
		
		summary.enter_email_id();
		Assert.assertTrue("failed to enter email id", summary.isEmailEntered());
		System.out.println("email id is entered successfully");
		
		summary.enter_mobile_no();
		Assert.assertTrue("failed to enter mobile no", summary.isMobileNoEntered());
		System.out.println("mobile no is entered successfully");
		
		

	}
	

}
