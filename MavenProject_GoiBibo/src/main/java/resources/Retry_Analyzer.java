package resources;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Analyzer implements IRetryAnalyzer
{

	int count = 2;
	int retry = 0;
	
	public boolean retry(ITestResult result) 
	{
		if(count < retry )
		{
			count++;
			return true;
		}
		
		return false;
	}
	
	

}
