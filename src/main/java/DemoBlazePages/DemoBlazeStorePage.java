package DemoBlazePages;

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
    public DemoBlazeStorePage enterUserName(String userNme) {
        enterByXpath(prop.getProperty("DemoBlazeStorePage.TxtFieldUserNameSignUpForm.XPath"),userNme);
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
    
        public void acceptAlert() {
    }
}


