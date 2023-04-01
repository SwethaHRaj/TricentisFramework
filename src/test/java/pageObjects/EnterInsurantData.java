package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class EnterInsurantData extends BaseClass {

	@FindBy(id = "enterinsurantdata")
	WebElement link_EnterInsurantData;

	@FindBy(id = "firstname")
	WebElement text_FirstName;

	@FindBy(id = "lastname")
	WebElement text_LastName;

	@FindBy(id = "birthdate")
	WebElement text_DateOfBirth;

	@FindBy(xpath = "//div/label[text()='Gender']/following-sibling::p/label")
	List<WebElement> radio_Gender;

	@FindBy(id = "streetaddress")
	WebElement text_StreetAddress;

	@FindBy(id = "country")
	WebElement dd_Country;

	@FindBy(id = "zipcode")
	WebElement text_ZipCode;

	@FindBy(id = "city")
	WebElement text_City;

	@FindBy(id = "occupation")
	WebElement dd_Occupation;

	@FindBy(xpath = "//div/label[text()='Hobbies']/following-sibling::p/label")
	List<WebElement> check_Hobbies;

	@FindBy(id = "website")
	WebElement text_Website;

	@FindBy(id = "picturecontainer")
	WebElement upload_Picture;

	@FindBy(id = "preventervehicledata")
	WebElement btn_Prev;

	@FindBy(id = "nextenterproductdata")
	WebElement btn_Next;

	public EnterInsurantData() {
		PageFactory.initElements(driver, this);
	}

	public void enterAllInsurantDetails(HashMap<String, String> data) throws Exception {
		text_FirstName.sendKeys(data.get("Insurant_First Name"));
		text_LastName.sendKeys(data.get("Insurant_Last Name"));
		text_DateOfBirth.sendKeys(data.get("Insurant_Date of Birth"));
		cm.selectRadioButton(radio_Gender, data.get("Insurant_Gender"));
		text_StreetAddress.sendKeys(data.get("Insurant_Street Address"));
		cm.selectFromDropdown(dd_Country, data.get("Insurant_Country"));
		text_ZipCode.sendKeys(data.get("Insurant_Zip Code"));
		text_City.sendKeys(data.get("Insurant_City"));
		cm.selectFromDropdown(dd_Occupation, data.get("Insurant_Occupation"));
		cm.selectCheckboxes(check_Hobbies, data.get("Insurant_Hobbies"));
		text_Website.sendKeys(data.get("Insurant_Website"));
		cm.uploadPicture(upload_Picture, data.get("Insurant_Picture"));
	}

	public void clickOnNext() {
		btn_Next.click();
	}

}
