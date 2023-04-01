package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class Home extends BaseClass {

	@FindBy(id = "nav_automobile")
	WebElement link_Automobile;

	@FindBy(id = "nav_truck")
	WebElement link_Truck;

	@FindBy(id = "nav_motorcycle")
	WebElement link_Motorcycle;

	@FindBy(id = "nav_camper")
	WebElement link_Camper;

	public Home() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnSpecifiedLink(HashMap<String, String> data) {
		driver.findElement(
				By.xpath("//div[@class='main-navigation']/ul/li/a[text()='" + data.get("Vehicle_Type") + "']")).click();
	}
	
	
	
	
	//-----------ERROR VALIDATION Methods-------------------
	
	public void clickOnAutomobile() {
		link_Automobile.click();
	}
	
}
