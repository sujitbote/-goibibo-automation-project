package source_pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Booking_Summary_Page 
{
	
	WebDriver driver;

	@FindBy (xpath="(//div[@class='billing-input-container']/div)[1]")
	WebElement click_on_billing_address;
	
	@FindBy (xpath="(//input[@type='text'])[1]")
	WebElement enter_billing_address;
	
	@FindBy (xpath="(//div[@class='billing-input-container']/div)[2]")
	WebElement click_on_pincode;
	
	@FindBy (xpath="//input[@type='tel']")
	WebElement enter_pincode;
	
	@FindBy (xpath="(//div[@class='billing-input-container']/div)[3]/div/p")//(//div[@class='billing-input-container']/div)[3]/div/p
	WebElement select_state_dd;//(//div[@class='billing-input-container']/div)[3]
	
	@FindBy (xpath="(//div[@class='billing-input-container']/div)[3]/div/p")
	WebElement get_selected_state_name;
	
	@FindBy (xpath="//ul[@class='sc-iapWAC bPcczV']/li")
	List<WebElement> list_of_state;
	
	@FindBy (xpath="//button[.='Travel Unsecured']")
	WebElement click_travel_unsecure;
	
	@FindBy (xpath="//div[@class='sc-cVzyXs hGsVXY']/div")
	WebElement confirm_billing_details_checkbox;
	
	@FindBy (name="confirm_check")
	WebElement verify_billing_details_checkbox;
	
	@FindBy (xpath="(//div/select)[1]")
	//select[@class='common-elementsstyles__CustSelectTrvl-sc-ilw4bs-9 gwiSrF']
	WebElement select_gender_dd;
	
	@FindBy (name="givenname")
	WebElement enter_first_name;
	
	@FindBy (name="email")
	WebElement enter_email_id;
	
	@FindBy (name="mobile")
	WebElement enter_mobile_no;
	
	@FindBy (css="*.width100.borderTop.dF.justifyEnd.pad10>button")
	WebElement click_submit_pb;
	
	@FindBy (xpath="//button[.='That’s Correct']")
	WebElement submit_added_details;
	
	@FindBy (xpath="//span[.='Skip to Payment']")
	WebElement skip_to_payment_page;
	
	@FindBy (id="goPromo")
	WebElement enter_promo_code;
	
	@FindBy (xpath="//button[.='Apply']")
	WebElement click_apply_promocode;
	
	@FindBy (xpath="//button[.='OK']")
	WebElement click_ok_on_promocode_popup;
	
	@FindBy (xpath="(//div[@class='flexCol'])[1]//div[@class='dF']/parent::div")
	List<WebElement> select_multiple_passangers;
	
	@FindBy (xpath="(//span[@class='sc-12foipm-64 dGRyPm'])[2]")
	WebElement select_adult_passangers;
	
	@FindBy (xpath="(//span[@class='sc-12foipm-64 dGRyPm'])[4]")
	WebElement select_children_passangers;
	
	@FindBy (xpath="(//span[@class='sc-12foipm-64 dGRyPm'])[6]")
	WebElement select_infant_passangers;
	
	@FindBy (css="div.reviewTravellerOverlaystyles__RtdHeader-sc-w2a3p-2.kWjcYj.font22.f600.dF.justifyBetween.alignItemsCenter")
	WebElement review_traveller_details;
	
	@FindBy (css=".dweb-commonstyles__Modal-sc-13fxsy5-9")
	WebElement promo_code_popup;
	
	public void enter_Billing_Address(String source1)
	{
		click_on_billing_address.click();
		enter_billing_address.sendKeys(source1);
	}
	
	public boolean isPromoCodeAccepted()
	{
		boolean condition = false;
		if(promo_code_popup.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public boolean isAllTravellersDetailsEntered()
	{
		boolean condition = false;
		if(review_traveller_details.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public void enter_details_for_multiple_passangers()
	{
		String name[] = {"sujit", "ram", "shyam", "laxman", "kiran"};

		for(int i=0; i<select_multiple_passangers.size(); i++)
		{
			
			if(i==0)
			{
				Select select = new Select(select_gender_dd);
				select.selectByValue("MALE");
				enter_first_name.sendKeys(name[i]);
			}
			else
			{
				select_multiple_passangers.get(i).click();
				Select select = new Select(select_gender_dd);
				select.selectByValue("MALE");
				enter_first_name.sendKeys(name[i]);
			}
		}
	}
	
	public void select_Multiple_Passangers()
	{
		for(int i=0; i<3; i++)
		{
			select_adult_passangers.click();
		}
		for(int i=0; i<1; i++)
		{
			select_children_passangers.click();
		}
	}
	
	public boolean isAddressEntered(String source1)
	{
		boolean condition = false;
		
		if(enter_billing_address.getAttribute("value").equalsIgnoreCase(source1))
		{
			condition = true;
		}
		
		return condition;
	}
	
	public void enter_Pincode(String pincode)
	{
		click_on_pincode.click();
		enter_pincode.sendKeys(pincode);
	}
	
	public boolean isPinCodeEntered(String pincode)
	{
		boolean condition = false;
		
		if(enter_pincode.getAttribute("value").equalsIgnoreCase(pincode))
		{
			condition= true;
		}
		return condition;
	}
	
	public void click_Travel_Unsecure()
	{
		click_travel_unsecure.click();
	}
	
	public void confirm_Billing_Details_Checkbox()
	{
		confirm_billing_details_checkbox.click();
		//System.out.println(confirm_billing_details_checkbox.isSelected());
	}
	
	public boolean isConfirmationCheckboxSelected()
	{		
		boolean condition = false;
		
		if(verify_billing_details_checkbox.isSelected())
		{
			condition= true;
		}
		return condition;
	}
	
	public void enter_first_name()
	{
		enter_first_name.sendKeys("sujit");;
	}
	public boolean isNameEntered()
	{		
		boolean condition = false;
		
		if(enter_first_name.getAttribute("value").equalsIgnoreCase("sujit"))
		{
			condition= true;
		}
		return condition;
	}
	public void select_Gender_DD()
	{
		Select select = new Select(select_gender_dd);
		select.selectByValue("MALE");
	}
	
	public boolean isGenderSelected()
	{		
		Select select = new Select(select_gender_dd);
		boolean condition = false;
		
		if(select.getFirstSelectedOption().getText().equalsIgnoreCase("male"))
		{
			condition= true;
		}
		return condition;
	}
	
	public void enter_email_id()
	{
		enter_email_id.sendKeys("abc@gmail.com");;
	}
	public boolean isEmailEntered()
	{		
		boolean condition = false;
		
		if(enter_email_id.getAttribute("value").equalsIgnoreCase("abc@gmail.com"))
		{
			condition= true;
		}
		return condition;
	}
	
	public void enter_mobile_no()
	{
		enter_mobile_no.sendKeys("7350495068");;
	}
	public boolean isMobileNoEntered()
	{		
		boolean condition = false;
		
		if(enter_mobile_no.getAttribute("value").equalsIgnoreCase("7350495068"))
		{
			condition= true;
		}
		return condition;
	}
	
	public void click_Submit_PB()
	{
		click_submit_pb.click();
	}
	public void submit_Added_Details()
	{
		submit_added_details.click();
	}
	public void skip_To_Payment_Page()
	{
		skip_to_payment_page.click();
	}
	
	public void wait_Until_Page_Load()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("Book Cheap Flights, Air Tickets, Hotels, Bus & Holiday Package at Goibibo"));
	}
	
	public void switch_Control_To_ChildTab()
	{
		Set<String> handles = driver.getWindowHandles();
		//System.out.println(handles);
		Iterator<String> iterate= handles.iterator();
		iterate.next();
		String child_tab = iterate.next();
		//System.out.println(child_tab);
		driver.switchTo().window(child_tab);
		//driver.close();
	}
	
	public void select_State_From_DD()
	{
		select_state_dd.click();
		
		for(WebElement state : list_of_state)
		{
			
			if(state.getText().equalsIgnoreCase("Maharashtra"))
			{				
				state.click();
				break;
			}
		}
		
	}//get_selected_state_name
	
	public boolean isStateSelected()
	{
		boolean condition = false;
		
		if(select_state_dd.getText().equals("Maharashtra"))
		{
			condition= true;
		}
		return condition;
	}
	
	public void enter_PromoCode()
	{
		enter_promo_code.sendKeys("testing");
	}
	
	public void click_Apply_PromoCode()
	{
		click_apply_promocode.click();
	}
	
	public void click_Ok_On_PromoCode_Popup()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dF font18 padR10 alignItemsCenter']")));
		click_ok_on_promocode_popup.click();
	}
	
	public Booking_Summary_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
