package resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Launch_Quit 
{
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void launch_Quit(String browser)
	{
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.navigate().to("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

	}
	
//	@AfterMethod
//	public void close_Browser()
//	{
//		driver.quit();
//	}
	
	

}
