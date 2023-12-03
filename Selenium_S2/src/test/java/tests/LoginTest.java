package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.TestBase;
import utilities.ExcelRead;
import utilities.ExcelWrite;
import utilities.MyListener;

@Listeners(value= {MyListener.class})
public class LoginTest extends TestBase {

	WebDriver d;
	HomePage h;
	LoginPage l;
	
	/*
	 * ExcelRead e = new ExcelRead(); //ExcelWrite w = new ExcelWrite();
	 * 
	 * int rowNum=1;
	 * 
	 * @DataProvider public Object[][] loginData() throws IOException { int LastRow
	 * = e.
	 * getLastRow("C:\\Users\\HP\\Desktop\\Percipio\\PS\\Selenium S2\\TestData.xls",
	 * "Sheet1"); Object[][] mydata = new Object[LastRow+1][2];
	 * 
	 * for(int i=1; i<=LastRow; i++) { mydata[i][0] =
	 * e.readExcel("C:\\Users\\HP\\Desktop\\Percipio\\PS\\Selenium S2\\TestData.xls"
	 * , 0, i, 0); mydata[i][1] =
	 * e.readExcel("C:\\Users\\HP\\Desktop\\Percipio\\PS\\Selenium S2\\TestData.xls"
	 * , 0, i, 1); }
	 * 
	 * return mydata;
	 * 
	 * }
	 */
	
	@Test//(dataProvider="loginData")
	public void testLogin1() throws IOException
	{
		h.clickLoginLink();
		l.enterLoginDetails("Itest@test.com", "Itest@test");
		l.clickLogout();
		
		/*
		 * try { l.clickLogout(); // w.
		 * writeExcel("C:\\Users\\HP\\Desktop\\Percipio\\PS\\Selenium S2\\Testdatanew.xls"
		 * , "Sheet1", rowNum, 2, "Pass"); } catch(Exception e) {
		 * Assert.fail("Logout is not available"); // w.
		 * writeExcel("C:\\Users\\HP\\Desktop\\Percipio\\PS\\Selenium S2\\Testdatanew.xls"
		 * , "Sheet1", rowNum, 2, "Fail");
		 * 
		 * }
		 * 
		 * rowNum++;
		 */
	}
	
	@Test(priority=2)
	public void testLogin2() throws IOException
	{
		
		h.clickLoginLink();
		l.enterLoginDetails("admin", "admin123");
		l.clickLogout();
	}
	
	@BeforeTest
	public void setup()
	{
		getBrowser();
		h= new HomePage();
		l= new LoginPage();
	}
	
}
