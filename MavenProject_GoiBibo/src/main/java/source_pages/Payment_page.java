package source_pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payment_page 
{
	WebDriver driver;
	
	@FindBy (xpath="(//ul[@class='paymentListCtr']/li)[1]")
	WebElement select_cc_payment_option;
	
	@FindBy (name="cardNumber")
	WebElement enter_cc_no;
	
	@FindBy (css="div.bookingSumry")
	WebElement booking_summary;
	
	public boolean isPaymentPageDisplayed()
	{
		boolean condition = false;
		if(booking_summary.isDisplayed())
		{
			condition = true;
		}
		return condition;
	}
	
	public void select_CC_Payment_Option()
	{
		select_cc_payment_option.click();
	}
	public void enter_CC_No()
	{
		enter_cc_no.sendKeys("112342353453135335");
	}
	public boolean isCardNoEntered()
	{
		boolean condition = false;
		if(enter_cc_no.getAttribute("value").equals("112342353453135335"))
		{
			condition = true;
		}
		return condition;
	}
	
	public void wait_Until_Payment_Page_Load()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off"));
		
	}
	
	
	public Payment_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
