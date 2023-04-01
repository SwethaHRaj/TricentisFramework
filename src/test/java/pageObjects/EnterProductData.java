package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class EnterProductData extends BaseClass {

	@FindBy(id = "startdate")
	WebElement text_StartDate;

	@FindBy(id = "insurancesum")
	WebElement dd_InsuranceSum;

	@FindBy(id = "meritrating")
	WebElement dd_MeritRating;

	@FindBy(id = "damageinsurance")
	WebElement dd_DamageInsurance;

	@FindBy(xpath = "//input[@name='Optional Products[]']/..")
	List<WebElement> check_OptionalProducts;

	@FindBy(id = "courtesycar")
	WebElement dd_CurtesyCar;

	@FindBy(id = "preventerinsurancedata")
	WebElement btn_Prev;

	@FindBy(id = "nextselectpriceoption")
	WebElement btn_Next;

	public EnterProductData() {
		PageFactory.initElements(driver, this);
	}

	public void enterAllProductDetails(HashMap<String, String> data) {
		text_StartDate.sendKeys(data.get("Product_Start Date"));
		cm.selectFromDropdown(dd_InsuranceSum, data.get("Product_Insurance Sum [$]"));
		cm.selectFromDropdown(dd_MeritRating, data.get("Product_Merit Rating"));
		cm.selectFromDropdown(dd_DamageInsurance, data.get("Product_Damage Insurance"));
		cm.selectCheckboxes(check_OptionalProducts, data.get("Product_Optional Products"));
		cm.selectFromDropdown(dd_CurtesyCar, data.get("Product_Courtesy Car"));
	}

	public void clickOnNextButton() {
		btn_Next.click();
	}

}
