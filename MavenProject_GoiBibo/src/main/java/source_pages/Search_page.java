package source_pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search_page 
{
	WebDriver driver;	
	
	@FindBy (xpath="(//button[.='VIEW FARES'])[1]")
	WebElement view_fares_pb;
	
	@FindBy (xpath="(//span[@class='dF flexCol'])[1]")
	WebElement book_flight_pb;
	
	@FindBy (xpath="//span[.='Flight Information']")
	WebElement select_fligh_info_section;
	
	@FindBy (xpath="//div[@class='srp-card-uistyles__FltDetailCont-sc-3flq99-42 krcEOu width100 flexCol']")
	WebElement details_of_fligh_info_section;
	
	@FindBy (xpath="//span[.='Fare Details']")
	WebElement select_fair_details_section;
	
	@FindBy (xpath="//div[@class='pad10 padB20']")
	WebElement details_of_fair_section;
	
	@FindBy (xpath="//span[.='Baggage Rules']")
	WebElement select_baggage_rules_section;

	@FindBy (xpath="//div[@class='bagCancelRulesstyles__Baggage-sc-1li590v-3 faNkAw']")
	WebElement details_of_baggage_rules_section;
	
	@FindBy (xpath="//span[.='Cancellation Rules']")
	WebElement select_cancellation_rules_section;
	
	@FindBy (id="cancellation_policy")
	WebElement details_of_cancellation_rules_section;
	
	@FindBy (xpath="(//span[.='Flight Details'])[1]")
	WebElement select_flight_details_section;
	
	@FindBy (xpath="((//div[@class='srp-card-uistyles__ViewFaresLeft-sc-3flq99-54 gFZYIF flexCol'])[1]/div)[3]")
	WebElement check_luggage_space;
	
	@FindBy (xpath="((//div[@class='srp-card-uistyles__ViewFaresLeft-sc-3flq99-54 gFZYIF flexCol'])[1]/div)[6]")
	WebElement check_premium_seat;
	
	@FindBy (xpath="((//div[@class='srp-card-uistyles__ViewFaresLeft-sc-3flq99-54 gFZYIF flexCol'])[1]/div)[7]")
	WebElement check_free_meal;
	
	@FindBy (css="div.search-widget-uistyles__PaxWrapperStyle-sc-f6e3g4-10.kmrdNu>input")
	WebElement check_selected_travel_class;
	
	public void click_On_Flight_Details_Section()
	{
		select_flight_details_section.click();
	}
	
	public boolean verify_Flight_Info_Details()
	{
		boolean condition = false;
		
		if(details_of_fligh_info_section.isDisplayed())
		{
			condition = true;
		}
		return condition; 
	}
	
	public void click_On_Fare_Details_Section()
	{
		select_fair_details_section.click();
	}
	public boolean verify_Fair_Details_Section()
	{
		boolean condition = false;
		
		if(details_of_fair_section.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	public void click_On_Baggage_Details_Section()
	{
		select_baggage_rules_section.click();
	}
	public boolean verify_Baggage_Details_Section()
	{
		boolean condition = false;
		
		if(details_of_baggage_rules_section.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public void click_On_Cancellation_Details_Section()
	{
		select_cancellation_rules_section.click();
	}
	public boolean verify_Cancellation_Details_Section()
	{
		boolean condition = false;
		
		if(details_of_cancellation_rules_section.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public void click_On_View_Fares_PB()
	{
		view_fares_pb.click();
	}
	
	public void click_Book_Flight_PB()
	{
		book_flight_pb.click();
	}

	public String getPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void wait_until_searchPage_load()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='UPDATE SEARCH']")));
	}
	
	public boolean isLuggageSpaceAvaiable()
	{		
		boolean condition = false;
		if(check_luggage_space.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public boolean isPremiumSeatAvaiable()
	{		
		boolean condition = false;
		if(check_premium_seat.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public boolean isFreeMealAvaiable()
	{		
		boolean condition = false;
		if(check_free_meal.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public String checkString()
	{
		String splitted_string[] = check_selected_travel_class.getAttribute("value").split(",");
		String passanger_class = splitted_string[1].trim();
		return passanger_class;
	}
	
	public boolean isEconomyTravelClassSelected()
	{
		boolean condition = false;
		if(checkString().equalsIgnoreCase("economy"))
		{
			condition = true;
		}
		return condition;
	}
	public boolean isPremiumEconomyTravelClassSelected()
	{
		boolean condition = false;
		if(checkString().equalsIgnoreCase("premium economy"))
		{
			condition = true;
		}
		return condition;
	}
	public boolean isBusinessTravelClassSelected()
	{
		boolean condition = false;
		if(checkString().equalsIgnoreCase("business"))
		{
			condition = true;
		}
		return condition;
	}
	
	public Search_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
