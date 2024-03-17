package resources;

import org.openqa.selenium.WebDriver;

public class Navigations 
{
	WebDriver driver;
	
	public void navigate_Back()
	{
		driver.navigate().back();
	}
	
	public void navigate_Forward()
	{
		driver.navigate().forward();
	}
	
	public void refresh_Page()
	{
		driver.navigate().refresh();
	}
	
	public Navigations(WebDriver driver)
	{
		this.driver = driver;
	}

}
