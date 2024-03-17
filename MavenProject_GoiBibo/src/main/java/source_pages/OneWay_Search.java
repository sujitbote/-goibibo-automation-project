package source_pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneWay_Search 
{
	WebDriver driver;
	
	@FindBy (xpath="(//div[@class='sc-12foipm-16 wRKJm fswFld '])[1]")
	WebElement click_on_source_city;
	
	@FindBy (xpath="//input[@type='text']")
	WebElement enter_city;
	
	@FindBy (xpath="(//div[@class='DayPicker-Caption']/div)[1]")
	WebElement actual_month;
	
	@FindBy (xpath="(//div[@class='DayPicker-Body'])[1]//p[@class='fsw__date']")
	List<WebElement> list_of_dates_in_month;
	
	@FindBy (xpath="//ul[@id='autoSuggest-list']/li")
	List<WebElement> list_of_search;
	
	@FindBy (xpath="//span[.='Done']")
	WebElement date_done_pb;

	@FindBy (xpath="//a[.='Done']")
	WebElement traveller_class_done_pb;
	
	@FindBy (xpath="//span[@class='sc-gsFSXq bGTcbn']")
	WebElement cancel_signup_popup;
	
	@FindBy (xpath="//span[@aria-label='Next Month']")
	WebElement navigate_to_next_month;
	
	@FindBy (xpath="//span[.='SEARCH FLIGHTS']")
	WebElement click_on_search_flight_pb;
	
	@FindBy (xpath="//input[@type='text']")
	WebElement enter_mobile_no;
	
	@FindBy (xpath="//button[.='Continue']")
	WebElement click_continue_login;
	
	@FindBy (xpath="//span[@class=' closeIcon logSprite icClose']")
	WebElement click_close_login_confirmation_popup;
	
	@FindBy (css=".sc-12foipm-58.juWqGL > li:nth-child(2)")
	WebElement select_premium_economy_travel_class;
	
	@FindBy (css="ul.sc-12foipm-58.juWqGL>li:first-child")
	WebElement select_economy_travel_class;
	
	@FindBy (css="ul.sc-12foipm-58.juWqGL>li:nth-child(3)")
	WebElement select_business_travel_class;
	
	@FindBy (css="ul.sc-12foipm-58.juWqGL>li:last-child")
	WebElement select_first_class_travel;
	
	@FindBy (css="div.sc-12foipm-34.imEUuQ>div")
	WebElement click_on_travel_class_option;

	@FindBy (css=".sc-jlZhew.dSoaQL")
	WebElement verify_wrong_mobile_no_error_msg;
	
	public void click_On_Travel_Class_Option()
	{
		click_on_travel_class_option.click();
	}
	
	public void click_on_source_City()
	{
		click_on_source_city.click();
	}
	
	public void enter_Source_City(String dest)
	{
		enter_city.sendKeys(dest);
		
	}
	
	public void enter_Destination_City(String src)
	{
		enter_city.sendKeys(src);
	}
	
	public void selectCity_from_SearchList()
	{
		list_of_search.get(0).click();
	}
	
	public void date_Done_pb()
	{
		date_done_pb.click();
	}
	public void traveller_class_Done_pb()
	{
		traveller_class_done_pb.click();
	}
	
	public void cancel_Signup_Popup()
	{
		cancel_signup_popup.click();
	}
	public void select_Premium_Economy_Travel_Class()
	{
		select_premium_economy_travel_class.click();
	}
	public void select_economy_travel_class()
	{
		select_economy_travel_class.click();
	}
	public void select_business_travel_class()
	{
		select_business_travel_class.click();
	}
	
	public void select_expected_month(String exp_month)
	{
		while(true)
		{
			if(!(exp_month.equalsIgnoreCase(actual_month.getText())))
			{
				navigate_to_next_month.click();
			}
			else
			{
				break;
			}
		}
	}
	
	public void select_expected_date(String exp_date)
	{
		for(WebElement actual_date : list_of_dates_in_month)
		{
			if(actual_date.getText().equals(exp_date))
			{
				actual_date.click();
				break;
			}

		}
	}
	
	
	public void click_on_Search_Flight_pb()
	{
		click_on_search_flight_pb.click();
	}
	
	public String getPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void enter_Mobile_No()
	{
		enter_mobile_no.sendKeys("8668337932");
	}
	public void enter_Wrong_Mobile_No()
	{
		enter_mobile_no.sendKeys("1234567890");
	}
	public String error_Msg_Of_Wrong_Mobile_No_Entered()
	{
		return verify_wrong_mobile_no_error_msg.getText();
	}
	
	public void click_Continue_Login()
	{		
		click_continue_login.click();
	}
	
	public void wait_Until_HomePage_Load()
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h3[.='Congratulations']")));
	}
	
	public boolean isLoginSuccessfull()
	{
		boolean condition = false;
		if(click_on_source_city.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public void click_Close_Login_Confirmation_Popup()
	{		
		click_close_login_confirmation_popup.click();
	}
	
	public OneWay_Search(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
