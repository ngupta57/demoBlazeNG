package DemoBlazeTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DemoBlazePages.DemoBlazeStorePage;
import wrappers.ProjectWrappers;

public class TC_004_DemoBlaze_SendMSG_ContactUS extends ProjectWrappers{
	
	  @BeforeClass
	    public void setConditions() {
	        testCaseName="TC_004_DemoBlaze_SendMSG_ContactUS";
	        testCaseDescription="TC_004_DemoBlaze_SendMSG_ContactUS-Validates the user can send message using contact link and upon successful send alert msg is displayed.with correct user name and correcr password";
	        author="Narinder Gupta";
	        category="Smoke";
	        sheetname="TC_004_DemoBlaze";	 
	        
	  }
	        
	        @Test(dataProvider="fetchData")
	        
	    	public void SendContactMsg(String contactEmail, String contactName, String msgText) {      
	       
	            //from landing page
	            new DemoBlazeStorePage()
	                    //Validate Brand logo is displayed on the landing page
	                    .verifyBrandLogoIsDisplayed()
	                    //Click on Contact Link on the top nav bar
	                    .clickContactTab()
	                    //Validate new msg text header on message form is displayed
	                    .verifyNewMessageFormIsDisplayed()
	                    //enter Contact email in the text field on message form
	                    .enterContactEmail(contactEmail)                    
	                    //enter Contact Name  in the text field on  message form
	                    .enterContactName(contactName)	                    
	                    //enter text message in the msg text box of msg form
	                    .enterMessageText(msgText)
	                    //CLICK SEND MSG BUTTON , CAPTURE SUCCESS MSG FROM ALERT AND VALIDATE THE MESSAGE AND CLOSE THE ALERT	                 
	                   .clickSendMsg()
	                   .acceptAlert();
	           
	                  //Validate login MSG text AFTER LOGIN MATCH
	                    
	                   

	        }
	        }






