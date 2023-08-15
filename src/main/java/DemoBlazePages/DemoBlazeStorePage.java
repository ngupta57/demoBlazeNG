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
    
        public void acceptAlert() {
    }
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
        //Click on login button in the login form
        public DemoBlazeStorePage verifyLoginSuccess() {
        	verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeStorePage.TxtLnkWelcomeText.XPath"));
            waitProperty(3000);
            return this;
        } 
        public DemoBlazeStorePage validateWelcomeMsgLogin(String expectedMsg) {
        	verifyTextByXpath(prop.getProperty("DemoBlazeStorePage.TxtLnkWelcomeText.XPath"),expectedMsg);
            waitProperty(3000);
            return this;
        } 
       
        
        
       
        
}


