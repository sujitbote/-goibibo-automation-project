package resources;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.annotations.DataProvider;

public class Fetch_Excel_Data 
{
	
	@DataProvider(name="data")
	public static Object[][] fetch_Data() throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("C:\\Users\\Shree\\eclipse new version workplace\\MavenProject_GoiBibo\\TestDataBibo\\TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet2");
		int row_count = sheet.getPhysicalNumberOfRows();
		int cell_count = sheet.getRow(0).getPhysicalNumberOfCells();
				
		Object[][] obj = new Object[row_count-1][cell_count];
		
		for(int i=1; i<row_count; i++)
		{
			for(int j=0; j<cell_count; j++)
			{
				if(j==0 || j==1 || j==2 || j==4 || j==6)
				{
					obj[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();

				}
				else
				{
					obj[i-1][j] = NumberToTextConverter.toText(sheet.getRow(i).getCell(j).getNumericCellValue());
				}
			}

		}
		
		return obj;
	}
	

}
