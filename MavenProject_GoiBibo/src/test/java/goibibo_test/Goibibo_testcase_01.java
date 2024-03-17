package goibibo_test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.Launch_Quit;
import source_pages.OneWay_Search;

//validate blogin functionality with valid credentials

@Listeners(resources.Listeners.class)
public class Goibibo_testcase_01 extends Launch_Quit
{
	
	@Test(dataProvider="data", dataProviderClass=resources.Fetch_Excel_Data.class, groups={"smoke","regression"}, retryAnalyzer=resources.Retry_Analyzer.class)
	public void testCase_01(String source1, String destiny1, String destiny2, String date1, String month1, String date2 ,String month2, String pincode)
	{
		
		OneWay_Search home = new OneWay_Search(driver);
		
		home.enter_Mobile_No();
		home.wait_Until_HomePage_Load();
		
		Assert.assertTrue(home.isLoginSuccessfull(), "user is unable to login");
		System.out.println("Login is successfull");

	}
	

}
