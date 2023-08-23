package DemoBlazePages;

import org.testng.Assert;

import wrappers.GenericWrappers;

public class DemoBlazeStorePage extends GenericWrappers {

	public DemoBlazeStorePage verifyBrandLogoIsDisplayed() {
		verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarBrand.XPath"));
		return this;
	}
	public SignupPage clickSignUp() {
		clickByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarSignUp.XPath"));
		return new SignupPage();
	}
	
	public DemoBlazeLoginPage clickLogin() {
		clickByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarLogIn.XPath"));
		waitProperty(3000);
		return new DemoBlazeLoginPage();
	}
	
	//VERIFY AFTER LOGIN TEXT PRESENT AS EXPECTED
	public DemoBlazeStorePage validateWelcomeMsgLogin(String expectedMsg) {
		verifyTextByXpath(prop.getProperty("DemoBlazeStorePage.TxtLnkWelcomeText.XPath"),expectedMsg);
		waitProperty(3000);
		return this;
	} 


	//Click on Contact tab present under top   NAV BAR

	public DemoBlazeContactUsPage clickContactTab() {
		clickByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarContact.XPath"));
		waitProperty(6000);
		return new DemoBlazeContactUsPage();
	}

	//Click SEND Message bUTTON AND GET THE sUCCESSMSG FROM THE ALERT POPUP        
	/*
	 * public DemoBlazeStorePage clickSendButton(String expText) {
	 * clickByXpath(prop.getProperty("DemoBlazeStorePage.ButtonSendMsg.XPath"));
	 * waitProperty(6000); String actText=getAlertText(); if (expText == actText) {
	 * System.out.println("The Message was displayed as expected" +actText);
	 * Assert.assertTrue(true);} else {
	 * System.out.println("The Message was not displayed as expected" + actText );
	 * Assert.assertFalse(false); } acceptAlert(); return this; }
	 */
	//Click on signUp button in the signup form
		
		public void acceptAlert() {
		}
		//Actions on home page
		public DemoBlazeStorePage clickHomeTab() {
			clickByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarHome.XPath"));
			waitProperty(3000);
			return this;			
		}
		public DemoBlazeStorePage verifyCategoryIsDisplayed() {
			verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeHomePage.LnkTextHeaderHomeCategories.XPath"));
			return this;
		}
		public DemoBlazeStorePage clickMonitorsCategory() {
			clickByXpath(prop.getProperty("DemoBlazeHomePage.LnkMonitorsHomeCategories.XPath"));
			waitProperty(3000);
			return this;			
		}
		public DemoBlazeStorePage verifyMonitorSearchItem2IsDisplayed() {
			verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeHomePage.LnkMonitorsSearchItem2.XPath"));
			return this;
		}
		public DemoBlazeStorePage ClickMonitorSearchItem2() {
			clickByXpath(prop.getProperty("DemoBlazeHomePage.LnkMonitorsSearchItem2.XPath"));
			return this;
		}
		public DemoBlazeStorePage validateSearch2ProductName(String expName) {
			verifyTextByXpath(prop.getProperty("DemoBlazeHomePage.MonitorItem2Name.XPath"),expName);
			waitProperty(3000);
			return this;
		} 
		public DemoBlazeStorePage validateSearch2ProductPrice(String expPrice) {
			verifyTextByXpath(prop.getProperty("DemoBlazeHomePage.MonitorItem2price.XPath"),expPrice);
			waitProperty(3000);
			return this;
		} 
		public DemoBlazeStorePage ClickAddToCart() {
			clickByXpath(prop.getProperty("DemoBlazeHomePage.BttnAddToCart.XPath"));
			waitProperty(3000);
			return this;
		} 
		public DemoBlazeStorePage GetAlertMSGandAccept(String ExpMsg) {
			String ActMsg = getAlertText();
			if (ActMsg.contentEquals(ExpMsg)) {
				System.out.println("On Adding Cart EXP msg was displayed" +ActMsg);
				Assert.assertTrue(true);}
			else {
				System.out.println("On Adding Cart EXP msg was not displayed" +ActMsg);			
			    Assert.assertTrue(false);} 
			   acceptAlert();
			return this;			
			}
		
		public DemoBlazeCartPage clickCartTab() {
			clickByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarCart.XPath"));
			waitProperty(6000);
			return new DemoBlazeCartPage();
		}
		
		//VERIFY AFTER welcome text after LOGIN 
		public DemoBlazeStorePage verifyLoginSuccess() {
			verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeStorePage.TxtLnkWelcomeText.XPath"));
			waitProperty(3000);
			
			return this;
		} 

	
		
		
			}

		
		
	
		
		





        
        
       
        
        
       
        



