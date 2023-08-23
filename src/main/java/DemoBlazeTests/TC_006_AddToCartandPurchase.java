package DemoBlazeTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DemoBlazePages.DemoBlazeStorePage;
import wrappers.ProjectWrappers;

public class TC_006_AddToCartandPurchase extends ProjectWrappers{
	
	  @BeforeClass
	    public void setConditions() {
	        testCaseName="TC_006_AddToCartandPurchase";
	        testCaseDescription="TC_006_AddToCartandPurchase-Validates the user can add product to cart and msg prosuct added is displayed and user is able to fill cart form and place order. Validates"
	        		+ " Thank you for purchase message is displayed.";
	        author="Narinder Gupta";
	        category="Smoke";
	        sheetname="TC_006_CartAndPurchase";	 
	        
	  }
	        
	        @Test(dataProvider="fetchData")
	        
	    	public void addToCartTest(String expName,String expPrice,String expMsg,String expProductTitle,String expCartFormHeaderTxt,String cusName,String countryName,String cityName,String cardNum,String cardMonth,String cardYear,String expThankMsg) {      
	       
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
	                    . GetAlertMSGandAccept(expMsg)
	                    .clickCartTab()
	                    .verifyCartHeaderTextIsDisplayed()
	                    .validateProductTitle(expProductTitle)
	                    .clickOnButtonPlaceOrder()
	                    .validateCartFormHeaderText(expCartFormHeaderTxt)
	                    .enterName(cusName)
	                    .enterCountryName(countryName)
	                    .enterCityName(cityName)
	                   .enterCardNum(cardNum)
	                    .enterCardMonth(cardMonth)
	                    .enterCardYear(cardYear)
	                   .clickOnButtonPurchase()
	                    .validateMsgThankU(expThankMsg)
	                    .displayOrderDetails()
	                    .clickOnOk();  
	                    
	                    
	                    
	                  
	        }
	        }






