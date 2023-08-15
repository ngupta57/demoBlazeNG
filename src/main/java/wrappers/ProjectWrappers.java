package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;

public class ProjectWrappers extends GenericWrappers{

	public String browserName, url;	
	public String sheetname;
	
	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}
	
	@BeforeTest
	public void beforeTest() {
		loadObjects();
		loadConfiProperties();
	}	
	
	@BeforeMethod
	public void beforeMethod() {
		startTest(testCaseName, testCaseDescription);
		invokeApp(cProp.getProperty("browserName"),cProp.getProperty("url"));
	}
	
	@AfterMethod
	public void afterMethod() {
		closeAllBrowsers();
		
	}
	@AfterClass
	public void afterClass() {
		
		endTest();
	}
	@AfterTest
	public void afterTest() {
		unloadObjects();
	}
	
	@AfterSuite
	public void afterSuite() {
		endReport();
	}
	
	@DataProvider(name="fetchData")
	public String[][] getDataFromExcel() {
		String[][] testData= DataInputProvider.getData(sheetname);
		return testData;
		
	}
	
	
}
