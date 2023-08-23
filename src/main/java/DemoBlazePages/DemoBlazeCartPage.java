package DemoBlazePages;

import org.testng.Assert;

import wrappers.GenericWrappers;

public class DemoBlazeCartPage extends GenericWrappers {

	public DemoBlazeCartPage verifyBrandLogoIsDisplayed() {
		verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeCartPage.LnkNavbarBrand.XPath"));
		return this;
	}
	public DemoBlazeCartPage verifyCartHeaderTextIsDisplayed() {
		verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeCartPage.HeaderTextProducts.XPath"));
		return this;
	}
	public DemoBlazeCartPage validateProductTitle(String expProductName) {
		verifyTextByXpath(prop.getProperty("DemoBlazeCartPage.CartItemTitle.XPath"),expProductName);
		waitProperty(3000);
		return this;
	} 
	public DemoBlazeCartPage clickOnButtonPlaceOrder() {
		clickByXpath(prop.getProperty("DemoBlazeCartPage.ButtonPlaceOrder.XPath"));
		waitProperty(3000);
		return this;
	} 
	public DemoBlazeCartPage validateCartFormHeaderText(String expFormHeader) {
		verifyTextByXpath(prop.getProperty("DemoBlazeCartPage.CartFormHeaderText.XPath"),expFormHeader);
		waitProperty(3000);
		return this;
	} 
	public DemoBlazeCartPage enterName(String cName) {
		enterByXpath(prop.getProperty("DemoBlazeCartPage.CartFormTxtFieldName.XPath"),cName);
		waitProperty(3000);
		return this;               
	}
	public DemoBlazeCartPage enterCountryName(String countryName) {
		enterByXpath(prop.getProperty("DemoBlazeCartPage.CartFormTxtFieldCountry.XPath"),countryName);
		waitProperty(3000);
		return this;               
	}
	public DemoBlazeCartPage enterCityName(String cityName) {
		enterByXpath(prop.getProperty("DemoBlazeCartPage.CartFormTxtFieldCity.XPath"),cityName);
		waitProperty(3000);
		return this;               
	}
	public DemoBlazeCartPage enterCardNum(String cardNum) {
		enterByXpath(prop.getProperty("DemoBlazeCartPage.CartFormTxtFieldCcard.XPath"),cardNum);
		waitProperty(3000);
		return this;               
	}
	public DemoBlazeCartPage enterCardMonth(String cardMonth) {
		enterByXpath(prop.getProperty("	DemoBlazeCartPage.CartFormTxtFieldMonth.XPath"),cardMonth);
		waitProperty(3000);
		return this;               
	}
	public DemoBlazeCartPage enterCardYear(String cardYear) {
		enterByXpath(prop.getProperty("	DemoBlazeCartPage.CartFormTxtFieldYear.XPath"),cardYear);
		waitProperty(3000);
		return this;               
	}
	public DemoBlazeCartPage clickOnButtonPurchase() {
		clickByXpath(prop.getProperty("	DemoBlazeCartPage.CartFormButtonPurchase.XPath"));
		waitProperty(3000);
		return this;
	} 
	public DemoBlazeCartPage validateMsgThankU(String expMsg) {
		verifyTextByXpath(prop.getProperty("DemoBlazeCartPage.CartFormThankUMsg.XPath"),expMsg);
		waitProperty(3000);
		return this;
	} 
	public DemoBlazeCartPage displayOrderDetails() {
		getTextByXpath(prop.getProperty("DemoBlazeCartPage.CartFormOrderDetails.XPath"));
		waitProperty(3000);
		return this;
	} 
	public DemoBlazeStorePage clickOnOk() {
		clickByXpath(prop.getProperty("DemoBlazeCartPage.CartFormOkButton.XPath"));
		waitProperty(3000);
		return new DemoBlazeStorePage();
	} 	
				
			}
				
			

		
		
	
		
		





        
        
       
        
        
       
        



