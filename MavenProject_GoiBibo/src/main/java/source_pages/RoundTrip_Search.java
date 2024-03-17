package source_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoundTrip_Search 
{
	
	
	@FindBy (xpath="(//ul[@class='sc-12foipm-81 ilMOeX']/li)[2]")
	WebElement click_roundtrip_rb;	
	
	public void click_RoundTrip_RB()
	{
		click_roundtrip_rb.click();
	}
	
	
	
	public RoundTrip_Search(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
