package resources;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Take_Screenshots extends Launch_Quit
{
	public static void takeScreenshots() throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Shree\\eclipse new version workplace\\MavenProject_GoiBibo\\Screenshots\\ss_"+Math.random()+".png");
		FileUtils.copyFile(src, dest);
	}
}
