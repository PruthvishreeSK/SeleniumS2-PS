package utilities;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelRead {

	HSSFWorkbook file;
	HSSFSheet s;
	
	public String readExcel(String path, int sheetNo, int r, int c) throws IOException
	{
		FileInputStream fin = new FileInputStream(path);
		file = new HSSFWorkbook(fin);
		//s = file.getSheet("Sheet1");
		s = file.getSheetAt(sheetNo);
		String data = s.getRow(r).getCell(c).getStringCellValue();
		file.close();
		return data;
	}
	
	public int getLastRow(String path, String SheetName) throws IOException
	{
		FileInputStream fin = new FileInputStream(path);
		file = new HSSFWorkbook(fin);
		s = file.getSheet(SheetName);
		int LastRow = s.getLastRowNum();
		return LastRow;
	}
	
	
	public static void main(String args[]) throws IOException
	{
		ExcelRead e = new ExcelRead();
		int LastRow = e.getLastRow("C:\\Users\\HP\\Desktop\\Percipio\\PS\\Selenium S2\\TestData.xls", "Sheet1");
		
		for(int i=1; i<=LastRow; i++)
		{
			String Username = e.readExcel("C:\\Users\\HP\\Desktop\\Percipio\\PS\\Selenium S2\\TestData.xls", 0, i, 0);
			String Password = e.readExcel("C:\\Users\\HP\\Desktop\\Percipio\\PS\\Selenium S2\\TestData.xls", 0, i, 1);
			System.out.print(Username+" ");
			System.out.println(Password);
			System.out.println();
		}
		
	}
		
}
