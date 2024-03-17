package source_pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultiCIty_Search 
{
	
	@FindBy (xpath="(//ul[@class='sc-12foipm-81 ilMOeX']/li)[3]")
	WebElement click_on_multi_city_rb;
	
	@FindBy (xpath="(//div[@class='sc-12foipm-14 lhvXDk']/div/div)[1]")
	WebElement from_city_1;
	
	@FindBy (xpath="//input[@type='text']")
	WebElement enter_city;
	
	@FindBy (xpath="(//div[@class='sc-12foipm-14 lhvXDk']/div/div)[6]")
	WebElement click_on_to_city_2;
	
	@FindBy (xpath="//span[.='SEARCH FLIGHTS']")
	WebElement click_on_search_flight_pb;
	
	@FindBy (xpath="//span[@aria-label='Next Month']")
	WebElement navigate_to_next_month;
	
	@FindBy (xpath="(//div[@class='DayPicker-Caption']/div)[1]")
	WebElement actual_month;
	
	@FindBy (xpath="(//div[@class='DayPicker-Body'])[1]//p[@class='fsw__date']")
	List<WebElement> list_of_dates_in_month;
	
	@FindBy (xpath="//ul[@id='autoSuggest-list']/li")
	List<WebElement> list_of_search;
	
	@FindBy (xpath="//span[.='Done']")
	WebElement date_done_pb;
	
	@FindBy (xpath="//span[.='Cancel']")
	WebElement date_cancel_pb;
	
	@FindBy (xpath="//a[.='Done']")
	WebElement traveller_class_done_pb;
	
	public void click_On_Multi_City_RB()
	{
		click_on_multi_city_rb.click();
	}
	
	public void traveller_class_Done_pb()
	{
		traveller_class_done_pb.click();
	}
	
	public void click_On_From_City_TextBox()
	{
		from_city_1.click();
	}
	public void enter_From_city_1(String source1)
	{
		enter_city.sendKeys(source1);
	}
	public void enter_To_city_1(String destiny1)
	{
		enter_city.sendKeys(destiny1);
	}
	
	public void enter_To_city_2(String destiny2)
	{
		enter_city.sendKeys(destiny2);
	}
	
	public void selectCity_from_SearchList()
	{
		list_of_search.get(0).click();
	}
	
	public void date_Done_pb()
	{
		date_done_pb.click();
	}
	public void date_Cancel_pb()
	{
		date_cancel_pb.click();
	}
	
	public void click_on_Search_Flight_pb()
	{
		click_on_search_flight_pb.click();
	}
	
	public void click_On_To_City_2()
	{
		click_on_to_city_2.click();
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
	
	public MultiCIty_Search(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	
}
