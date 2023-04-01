package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class SendQuote extends BaseClass {

	@FindBy(id = "sendquote")
	WebElement link_SendQuote;

	@FindBy(id = "email")
	WebElement text_Email;

	@FindBy(id = "phone")
	WebElement text_Phone;

	@FindBy(id = "username")
	WebElement text_UserName;

	@FindBy(id = "password")
	WebElement text_Password;

	@FindBy(id = "confirmpassword")
	WebElement text_ConfirmPassword;

	@FindBy(id = "Comments")
	WebElement text_Comments;

	@FindBy(id = "preventerproductdata")
	WebElement btn_Prev;

	@FindBy(id = "sendemail")
	WebElement btn_Send;

	public SendQuote() {
		PageFactory.initElements(driver, this);
	}

	public void enterAllDetails(HashMap<String, String> data) {
		text_Email.sendKeys(data.get("Quote_E-Mail"));
		text_Phone.sendKeys(data.get("Quote_Phone"));
		text_UserName.sendKeys(data.get("Quote_Username"));
		text_Password.sendKeys(data.get("Quote_Password"));
		text_ConfirmPassword.sendKeys(data.get("Quote_Confirm Password"));
		text_Comments.sendKeys(data.get("Quote_Comments"));
	}

	public void clickOnSendButton() {
		btn_Send.click();
	}
}
