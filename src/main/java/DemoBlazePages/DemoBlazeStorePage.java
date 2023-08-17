package DemoBlazePages;

import org.testng.Assert;

import wrappers.GenericWrappers;

public class DemoBlazeStorePage extends GenericWrappers {

	public DemoBlazeStorePage verifyBrandLogoIsDisplayed() {
		verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarBrand.XPath"));
		return this;
	}
	public DemoBlazeStorePage clickSignUp() {
		clickByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarSignUp.XPath"));
		return this;
	}
	public DemoBlazeStorePage verifySignUpFormIsDisplayed() {
		verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeStorePage.HeaderTxtSignUpForm.XPath"));
		return this;
	}

	//Enter username in the signup form
	public DemoBlazeStorePage enterUserName(String uname) {
		enterByXpath(prop.getProperty("DemoBlazeStorePage.TxtFieldUserNameSignUpForm.XPath"),uname);
		return this;
	}



	//Enter username in the signup form
	public DemoBlazeStorePage enterRandomUserName() {
		String user2Nme=randomAlphaNumeric();
		enterByXpath(prop.getProperty("DemoBlazeStorePage.TxtFieldUserNameSignUpForm.XPath"),user2Nme);
		return this;
	}
	//Enter pwd in the signup form
	public DemoBlazeStorePage enterPassWord(String passWord) {
		enterByXpath(prop.getProperty("DemoBlazeStorePage.TxtFieldUserPasswordSignUpForm.XPath"),passWord);
		return this;
	}
	//Click on signUp button in the signup form
	public DemoBlazeStorePage clickSignUpButton() {
		clickByXpath(prop.getProperty("DemoBlazeStorePage.ButtonSignUpSignUpForm.XPath"));
		return this;
	}

	//public void acceptAlert() {
	
	public DemoBlazeStorePage clickLogin() {
		clickByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarLogIn.XPath"));
		waitProperty(3000);
		return this;
	}
	public DemoBlazeStorePage verifyLoginFormIsDisplayed() {
		verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeStorePage.HeaderTxtLoginForm.XPath"));
		return this;
	}
	//Enter login user name in the login form
	public DemoBlazeStorePage enterLoginName(String userNme) {
		enterByXpath(prop.getProperty("DemoBlazeStorePage.TxtFldLoginUser.XPath"),userNme);
		waitProperty(3000);
		return this;
	}
	//Enter pwd in the login form
	public DemoBlazeStorePage enterLoginPassWord(String passWord) {
		waitProperty(3000);
		enterByXpath(prop.getProperty("DemoBlazeStorePage.TxtFldLoginPassword.XPath"),passWord);

		return this;
	}
	//Click on login button in the login form
	public DemoBlazeStorePage clickLoginButton() {
	clickByXpath(prop.getProperty("DemoBlazeStorePage.ButtonLogin.XPath"));
	waitProperty(3000);
		return this;
	} 
	//VERIFY AFTER LOGIN 
	public DemoBlazeStorePage verifyLoginSuccess() {
		verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeStorePage.TxtLnkWelcomeText.XPath"));
		waitProperty(3000);
		return this;
	} 
	//VERIFY AFTER LOGIN TEXT PRESENT AS EXPECTED
	public DemoBlazeStorePage validateWelcomeMsgLogin(String expectedMsg) {
		verifyTextByXpath(prop.getProperty("DemoBlazeStorePage.TxtLnkWelcomeText.XPath"),expectedMsg);
		waitProperty(3000);
		return this;
	} 


	//Click on cONTACT TAB IN TOP NAV BAR

	public DemoBlazeStorePage clickContactTab() {
		clickByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarContact.XPath"));
		waitProperty(6000);
		return this;
	}
	public DemoBlazeStorePage verifyNewMessageFormIsDisplayed() {
		verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeStorePage.TxtHeaderNewMessage.XPath"));
		waitProperty(2000);
		return this;
	}

	//Enter contact Email in the Message form
	public DemoBlazeStorePage enterContactEmail(String conEmail) {
		enterByXpath(prop.getProperty("DemoBlazeStorePage.TxtfieldMsgContactEmail.XPath"),conEmail);
		return this;

	}
	//Enter contact Name in the Message form

	public DemoBlazeStorePage enterContactName(String conName) {
		enterByXpath(prop.getProperty("DemoBlazeStorePage.TxtfieldMsgContactName.XPath"),conName);
		return this;

	}
	//Enter Message text in the msg text box

	public DemoBlazeStorePage enterMessageText(String message) {
		enterByXpath(prop.getProperty("DemoBlazeStorePage.TxtfieldMsgBox.XPath"),message);
		waitProperty(3000);
		return this;               
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
		public DemoBlazeStorePage clickSendMsg() {
			clickByXpath(prop.getProperty("DemoBlazeStorePage.ButtonSendMsg.XPath"));
			return this;
		}
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
			verifyTextByXpath(prop.getProperty("DemoBlazeHomePage.MonitorItem2Name.XPath"),expPrice);
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
			if (ActMsg==ExpMsg) {
				System.out.println("On Adding Cart EXP msg was displayed"+ActMsg);
				Assert.assertTrue(true);}
			else
			{System.out.println("On Adding Cart EXP msg was not displayed"+ActMsg);
			Assert.assertTrue(false);
			}
			acceptAlert();
			return this;
			
				
			}
				
			}

		
		
	
		
		





        
        
       
        
        
       
        



