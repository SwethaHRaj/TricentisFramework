package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class EnterVehicleData extends BaseClass {

	@FindBy(id = "make")
	WebElement dd_Make;

	@FindBy(id = "engineperformance")
	WebElement text_EnginePerformance;

	@FindBy(id = "dateofmanufacture")
	WebElement text_DateOfManufacture;

	@FindBy(id = "numberofseats")
	WebElement dd_NumberOfSeats;

	@FindBy(id = "fuel")
	WebElement dd_FuelType;

	@FindBy(id = "listprice")
	WebElement text_Listprice;

	@FindBy(id = "licenseplatenumber")
	WebElement text_LicensePlateNumber;

	@FindBy(id = "annualmileage")
	WebElement text_AnnualMileage;

	@FindBy(id = "nextenterinsurantdata")
	WebElement btn_Next;

	public EnterVehicleData() {
		PageFactory.initElements(driver, this);
	}

	public void enterAllDetails(HashMap<String, String> data) {
		cm.selectFromDropdown(dd_Make, data.get("Vehicle_Make"));
		text_EnginePerformance.sendKeys(data.get("Vehicle_Engine Performance [kW]"));
		text_DateOfManufacture.sendKeys(data.get("Vehicle_Date of Manufacture"));
		cm.selectFromDropdown(dd_NumberOfSeats, data.get("Vehicle_Number of Seats"));
		cm.selectFromDropdown(dd_FuelType, data.get("Vehicle_Fuel Type"));
		text_Listprice.sendKeys(data.get("Vehicle_List Price [$]"));
		text_LicensePlateNumber.sendKeys(data.get("Vehicle_License Plate Number"));
		text_AnnualMileage.sendKeys(data.get("Vehicle_Annual Mileage [mi]"));
	}

	public void clickOnNextButton() {
		btn_Next.click();
	}

	// -----------ERROR VALIDATION Methods-------------------

	public void enterEnginePerformance(String value) {
		text_EnginePerformance.sendKeys(value);
	}

	public String getErrorMessageOnEnginePerformance() {
		return driver.findElement(By.xpath("//input[@id='engineperformance']/following-sibling::span")).getText();
	}

	public List<String> getDropDownOptions_FuelType() {
		return cm.getDropDownOptionsAsList(dd_FuelType);
	}

}
