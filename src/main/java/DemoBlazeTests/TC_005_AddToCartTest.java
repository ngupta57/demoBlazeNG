package DemoBlazeTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DemoBlazePages.DemoBlazeStorePage;
import wrappers.ProjectWrappers;

public class TC_005_AddToCartTest extends ProjectWrappers{
	
	  @BeforeClass
	    public void setConditions() {
	        testCaseName="TC_005_AddToCartTest";
	        testCaseDescription="TC_005_AddToCartTest-Validates the user can add product to cart and msg prosuct added is displayed";
	        author="Narinder Gupta";
	        category="Smoke";
	        sheetname="TC_005_AddToCart";	 
	        
	  }
	        
	        @Test(dataProvider="fetchData")
	        
	    	public void addToCartTest(String expName,String expPrice,String expMsg) {      
	       
	            //from landing page
	            new DemoBlazeStorePage()
	                    //Validate Brand logo is displayed on the landing page
	                    .verifyBrandLogoIsDisplayed()
	                    //Click on Home Link on the top nav bar
	                    .clickHomeTab()
	                    //Validate login text header on login form is displayed
	                    .verifyBrandLogoIsDisplayed()
	                    .verifyCategoryIsDisplayed()
	                    .clickMonitorsCategory()
	                    .verifyMonitorSearchItem2IsDisplayed()
	                    .ClickMonitorSearchItem2()
	                    .validateSearch2ProductName(expName)
	                  .validateSearch2ProductPrice(expPrice)
	                    .ClickAddToCart()
	                    . GetAlertMSGandAccept(expMsg);
	                    
	                  
	        }
	        }






