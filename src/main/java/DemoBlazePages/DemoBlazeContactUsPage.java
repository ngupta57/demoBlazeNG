package DemoBlazePages;

import wrappers.GenericWrappers;

public class DemoBlazeContactUsPage  extends GenericWrappers{

		
	public DemoBlazeContactUsPage verifyNewMessageFormIsDisplayed() {
		verifyIsElementDisplayedByXpath(prop.getProperty("DemoBlazeContactUsPage.TxtHeaderNewMessage.XPath"));
		waitProperty(2000);
		return this;
	}

	//Enter contact Email in the Message form
	public DemoBlazeContactUsPage enterContactEmail(String conEmail) {
		enterByXpath(prop.getProperty("DemoBlazeContactUsPage.TxtfieldMsgContactEmail.XPath"),conEmail);
		return this;

	}
	//Enter contact Name in the Message form

	public DemoBlazeContactUsPage enterContactName(String conName) {
		enterByXpath(prop.getProperty("DemoBlazeContactUsPage.TxtfieldMsgContactName.XPath"),conName);
		return this;

	}
	//Enter Message text in the msg text box

	public DemoBlazeContactUsPage enterMessageText(String message) {
		enterByXpath(prop.getProperty("DemoBlazeContactUsPage.TxtfieldMsgBox.XPath"),message);
		waitProperty(3000);
		return this;               
	}
	public DemoBlazeStorePage clickSendMsg() {
		clickByXpath(prop.getProperty("DemoBlazeContactUsPage.ButtonSendMsg.XPath"));
		acceptAlert();
		return new DemoBlazeStorePage();
	}



	}
	
