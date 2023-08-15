package DemoBlazeTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DemoBlazePages.DemoBlazeStorePage;
import wrappers.ProjectWrappers;

public class TC_001_DemoBlaze_Signup_Test extends ProjectWrappers{
	
	  @BeforeClass
	    public void setConditions() {
	        testCaseName="TC_001_DemoBlaze_Signup_Test";
	        testCaseDescription="TC_001_DemoBlaze_Signup_Test-Validates the user can SignUp for the site without any issue";
	        author="Narinder Gupta";
	        category="Smoke";
	        sheetname="TC_001_DemoBlaze";	 
	        
	  }
	        
	        @Test(dataProvider="fetchData")
	        
	    	public void signUpTest(String userName, String password) {      
	       
	            //from landing page
	            new DemoBlazeStorePage()
	                    //Validate Brand logo is displayed on the landing page
	                    .verifyBrandLogoIsDisplayed()
	                    //Click on Signup Link on the top nav bar
	                    .clickSignUp()
	                    //Validate signup form is displayed
	                    .verifySignUpFormIsDisplayed()
	                    //enter UserName in the text field on signup form
	                    .enterUserName(userName)
	                    //enter password in the text field on signup form
	                    .enterPassWord(password)
	                    //Click SignUp Button present on signup form
	                    .clickSignUpButton()
	                    .acceptAlert();

	        }
	        }






