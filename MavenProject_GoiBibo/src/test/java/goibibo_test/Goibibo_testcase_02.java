package goibibo_test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.Launch_Quit;
import source_pages.OneWay_Search;

//test login with invalid credentials and ensure proper error message displayed

@Listeners(resources.Listeners.class)
public class Goibibo_testcase_02 extends Launch_Quit
{
	
	@Test(dataProvider="data", dataProviderClass=resources.Fetch_Excel_Data.class, groups={"smoke","regression"}, retryAnalyzer=resources.Retry_Analyzer.class)
	public void testCase_01(String source1, String destiny1, String destiny2, String date1, String month1, String date2 ,String month2, String pincode)
	{
		OneWay_Search home = new OneWay_Search(driver);
		
		home.enter_Wrong_Mobile_No();
		
		Assert.assertEquals(home.error_Msg_Of_Wrong_Mobile_No_Entered(), "Please enter a valid mobile number", "wrong error message is displayed");
		System.out.println("proper error message is displayed as expected");

	}
	

}
