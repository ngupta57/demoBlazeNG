package DemoBlazeTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DemoBlazePages.DemoBlazeStorePage;
import wrappers.ProjectWrappers;

public class TC_002_DemoBlaze_Login_Test extends ProjectWrappers{
	
	  @BeforeClass
	    public void setConditions() {
	        testCaseName="TC_002_DemoBlaze_Login_Test";
	        testCaseDescription="TC_002_DemoBlaze_Login_Test-Validates the user can login with correct user name and correcr password";
	        author="Narinder Gupta";
	        category="Smoke";
	        sheetname="TC_002_DemoBlaze";	 
	        
	  }
	        
	        @Test(dataProvider="fetchData")
	        
	    	public void logInTest(String userName, String password) {      
	       
	            //from landing page
	            new DemoBlazeStorePage()
	                    //Validate Brand logo is displayed on the landing page
	                    .verifyBrandLogoIsDisplayed()
	                    //Click on Login Link on the top nav bar
	                    .clickLogin()
	                    //Validate login text header on login form is displayed
	                   // .verifyLoginFormIsDisplayed()
	                    //enter UserName in the text field on login form
	                    .enterLoginName(userName)	                    
	                    //enter password in the text field on login form
	                    .enterLoginPassWord(password)	                    
	                    //Click login Button present on login form
	                    .clickLoginButton();
	                   

	        }
	        }






