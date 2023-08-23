package DemoBlazePages;

import org.testng.Assert;

import wrappers.GenericWrappers;

public class DemoBlazeLoginPage extends GenericWrappers {

	public DemoBlazeLoginPage verifyLoginFormIsDisplayed() {
		verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeLogInPage.HeaderTxtLoginForm.XPath"));
		return this;
	}
	//Enter login user name in the login form
		public DemoBlazeLoginPage enterLoginName(String userNme) {
			enterByXpath(prop.getProperty("DemoBlazeLogInPage.TxtFldLoginUser.XPath"),userNme);
			waitProperty(3000);
			return this;
		}
		//Enter pwd in the login form
		public DemoBlazeLoginPage enterLoginPassWord(String passWord) {
			waitProperty(3000);
			enterByXpath(prop.getProperty("DemoBlazeLogInPage.TxtFldLoginPassword.XPath"),passWord);
			return this;
		}

	
	
	/*
	 * public DemoBlazeLoginPage clickLogin() {
	 * clickByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarLogIn.XPath"));
	 * waitProperty(3000); return this; }
	 */
	
	
	//Enter pwd in the login form

	//Click on login button in the login form
	public DemoBlazeStorePage clickLoginButton() {
	clickByXpath(prop.getProperty("DemoBlazeStorePage.ButtonLogin.XPath"));
	waitProperty(3000);
		return new DemoBlazeStorePage();
	} 
	
	//VERIFY AFTER LOGIN TEXT PRESENT AS EXPECTED
	public DemoBlazeLoginPage validateWelcomeMsgLogin(String expectedMsg) {
		verifyTextByXpath(prop.getProperty("DemoBlazeStorePage.TxtLnkWelcomeText.XPath"),expectedMsg);
		waitProperty(3000);
		return this;
	} 


	//Click on cONTACT TAB IN TOP NAV BAR

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
		public DemoBlazeLoginPage clickHomeTab() {
			clickByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarHome.XPath"));
			waitProperty(3000);
			return this;			
		}
		public DemoBlazeLoginPage verifyCategoryIsDisplayed() {
			verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeHomePage.LnkTextHeaderHomeCategories.XPath"));
			return this;
		}
		public DemoBlazeLoginPage clickMonitorsCategory() {
			clickByXpath(prop.getProperty("DemoBlazeHomePage.LnkMonitorsHomeCategories.XPath"));
			waitProperty(3000);
			return this;			
		}
		public DemoBlazeLoginPage verifyMonitorSearchItem2IsDisplayed() {
			verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeHomePage.LnkMonitorsSearchItem2.XPath"));
			return this;
		}
		public DemoBlazeLoginPage ClickMonitorSearchItem2() {
			clickByXpath(prop.getProperty("DemoBlazeHomePage.LnkMonitorsSearchItem2.XPath"));
			return this;
		}
		public DemoBlazeLoginPage validateSearch2ProductName(String expName) {
			verifyTextByXpath(prop.getProperty("DemoBlazeHomePage.MonitorItem2Name.XPath"),expName);
			waitProperty(3000);
			return this;
		} 
		public DemoBlazeLoginPage validateSearch2ProductPrice(String expPrice) {
			verifyTextByXpath(prop.getProperty("DemoBlazeHomePage.MonitorItem2price.XPath"),expPrice);
			waitProperty(3000);
			return this;
		} 
		public DemoBlazeLoginPage ClickAddToCart() {
			clickByXpath(prop.getProperty("DemoBlazeHomePage.BttnAddToCart.XPath"));
			waitProperty(3000);
			return this;
		} 
		public DemoBlazeLoginPage GetAlertMSGandAccept(String ExpMsg) {
			String ActMsg = getAlertText();
			if (ActMsg.contentEquals(ExpMsg)) {
				System.out.println("On Adding Cart EXP msg was displayed" +ActMsg);
				//Assert.assertTrue(true);}
			//else 
				//System.out.println("On Adding Cart EXP msg was not displayed" +ActMsg);
			
			//Assert.assertTrue(false);
			} 
			acceptAlert();
			return this;
			
			}
		public DemoBlazeLoginPage clickCartTab() {
			clickByXpath(prop.getProperty("DemoBlazeStorePage.LnkNavbarCart.XPath"));
			waitProperty(6000);
			return this;
		}
		/*
		 * public DemoBlazeStorePage verifyCartHeaderTextIsDisplayed() {
		 * verifyIsElementDisplayedByXpath(prop.getProperty(
		 * "DemoBlazeCartPage.HeaderTextProducts.XPath")); return this; } public
		 * DemoBlazeStorePage validateProductTitle(String expProductName) {
		 * verifyTextByXpath(prop.getProperty("DemoBlazeCartPage.CartItemTitle.XPath"),
		 * expProductName); waitProperty(3000); return this; } public DemoBlazeStorePage
		 * clickOnButtonPlaceOrder() {
		 * clickByXpath(prop.getProperty("DemoBlazeCartPage.ButtonPlaceOrder.XPath"));
		 * waitProperty(3000); return this; } public DemoBlazeStorePage
		 * validateCartFormHeaderText(String expFormHeader) {
		 * verifyTextByXpath(prop.getProperty(
		 * "DemoBlazeCartPage.CartFormHeaderText.XPath"),expFormHeader);
		 * waitProperty(3000); return this; } public DemoBlazeStorePage enterName(String
		 * cName) {
		 * enterByXpath(prop.getProperty("DemoBlazeCartPage.CartFormTxtFieldName.XPath")
		 * ,cName); waitProperty(3000); return this; } public DemoBlazeStorePage
		 * enterCountryName(String countryName) { enterByXpath(prop.getProperty(
		 * "DemoBlazeCartPage.CartFormTxtFieldCountry.XPath"),countryName);
		 * waitProperty(3000); return this; } public DemoBlazeStorePage
		 * enterCityName(String cityName) {
		 * enterByXpath(prop.getProperty("DemoBlazeCartPage.CartFormTxtFieldCity.XPath")
		 * ,cityName); waitProperty(3000); return this; } public DemoBlazeStorePage
		 * enterCardNum(String cardNum) {
		 * enterByXpath(prop.getProperty("DemoBlazeCartPage.CartFormTxtFieldCcard.XPath"
		 * ),cardNum); waitProperty(3000); return this; } public DemoBlazeStorePage
		 * enterCardMonth(String cardMonth) { enterByXpath(prop.
		 * getProperty("	DemoBlazeCartPage.CartFormTxtFieldMonth.XPath"),cardMonth);
		 * waitProperty(3000); return this; } public DemoBlazeStorePage
		 * enterCardYear(String cardYear) { enterByXpath(prop.
		 * getProperty("	DemoBlazeCartPage.CartFormTxtFieldYear.XPath"),cardYear);
		 * waitProperty(3000); return this; } public DemoBlazeStorePage
		 * clickOnButtonPurchase() { clickByXpath(prop.
		 * getProperty("	DemoBlazeCartPage.CartFormButtonPurchase.XPath"));
		 * waitProperty(3000); return this; } public DemoBlazeStorePage
		 * validateMsgThankU(String expMsg) { verifyTextByXpath(prop.getProperty(
		 * "DemoBlazeCartPage.CartFormThankUMsg.XPath"),expMsg); waitProperty(3000);
		 * return this; } public DemoBlazeStorePage displayOrderDetails() {
		 * getTextByXpath(prop.getProperty(
		 * "DemoBlazeCartPage.CartFormOrderDetails.XPath")); waitProperty(3000); return
		 * this; } public DemoBlazeStorePage clickOnOk() {
		 * clickByXpath(prop.getProperty("DemoBlazeCartPage.CartFormOkButton.XPath"));
		 * waitProperty(3000); return this; }
		 */
	
		
		
			}

		
		
	
		
		





        
        
       
        
        
       
        



