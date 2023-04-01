package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class SelectPriceOptions extends BaseClass {

//	@FindBy(xpath="//input[@name='Select Option' and @value='Silver']/parent::label")
//	WebElement radio_SilverOption;
//	
//	@FindBy(xpath="//input[@name='Select Option' and @value='Gold']/parent::label")
//	WebElement radio_GoldOption;
//	
//	@FindBy(xpath="//input[@name='Select Option' and @value='Platinum']/parent::label")
//	WebElement radio_PlatinumOption;
//	
//	@FindBy(xpath="//input[@name='Select Option' and @value='Ultimate']/parent::label")
//	WebElement radio_UltimateOption;

	@FindBy(id = "selectpriceoption")
	WebElement link_SelectPriceOption;

	@FindBy(id = "preventerproductdata")
	WebElement btn_Prev;

	@FindBy(id = "nextsendquote")
	WebElement btn_Next;

	public SelectPriceOptions() {
		PageFactory.initElements(driver, this);
	}

	public void selectPlan(HashMap<String, String> data) {
		String pricePlan = data.get("Price_Option");
		driver.findElement(By.xpath("//tfoot/tr/th/label/input[@value='" + pricePlan + "']/following-sibling::span"))
				.click();
	}

	public void clickOnNextButton() {
		btn_Next.click();
	}
}
