package DemoBlazePages;

import wrappers.GenericWrappers;

public class SignupPage  extends GenericWrappers{

	
	public SignupPage verifySignUpFormIsDisplayed() {
		verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeSignUpPage.HeaderTxtSignUpForm.XPath"));
		return this;
	}

	//Enter username in the signup form
	public SignupPage enterUserName(String uname) {
		enterByXpath(prop.getProperty("DemoBlazeSignUpPage.TxtFieldUserNameSignUpForm.XPath"),uname);
		return this;
	}



	//Enter username in the signup form
	public SignupPage enterRandomUserName() {
		String user2Nme=randomAlphaNumeric();
		enterByXpath(prop.getProperty("DemoBlazeSignUpPage.TxtFieldUserNameSignUpForm.XPath"),user2Nme);
		return this;
	}
	//Enter pwd in the signup form
	public SignupPage enterPassWord(String passWord) {
		enterByXpath(prop.getProperty("DemoBlazeSignUpPage.TxtFieldUserPasswordSignUpForm.XPath"),passWord);
		return this;
	}
	//Click on signUp button in the signup form
	public DemoBlazeStorePage clickSignUpButton() {
		clickByXpath(prop.getProperty("DemoBlazeSignUpPage.ButtonSignUpSignUpForm.XPath"));
		return new DemoBlazeStorePage();
	}
}
