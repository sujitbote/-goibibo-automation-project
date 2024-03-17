package source_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut_Page 
{
	WebDriver driver;
	
	@FindBy (xpath="//div[@data-id='user-info-tab']")
	WebElement account_section_menu;
	
	@FindBy (xpath="//div[@data-id='header-dropdown']/li")
	WebElement select_profilename_from_account_menu;
	
	@FindBy (xpath="//span[.='LOGOUT']")
	WebElement click_on_logout_pb;
	
	@FindBy (xpath="//button[.='Yes, Log out']")
	WebElement click_logout_confirmation_pb;
	
	@FindBy (css="*.sc-19vq0g0-6.gvmlSY")
	WebElement login_button_after_logged_out;
	
	public boolean isLoggedOutSuccessfull()
	{
		boolean condition = false;
		if(login_button_after_logged_out.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public void hover_Over_account_section_menu()
	{
		Actions action = new Actions(driver);
		action.moveToElement(account_section_menu).perform();
	}
	
	public void select_profile_from_AccountSection_menu()
	{
		select_profilename_from_account_menu.click();
	}

	public void click_On_Logout_PB()
	{
		click_on_logout_pb.click();
	}	
	
	public void click_Logout_Confirmation_PB()
	{
		click_logout_confirmation_pb.click();
	}	
	
	public LogOut_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
