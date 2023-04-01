package test;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;


public class Demo_ErrorValidations_Test extends BaseClass{
	
	@Test(priority=1)
	public void errorValidationOnEnginePerformance() {
		// value should be --->1 to 2000  else  Error Message----->Must be a number between 1 and 2000
		home.clickOnAutomobile();
		vehicleData.enterEnginePerformance("20000");
		String actualError=vehicleData.getErrorMessageOnEnginePerformance();
		String expectedError="Must be a number between 1 and 2000";
		Assert.assertEquals(actualError, expectedError);
	}
	
	@Test(priority=2)
	public void verifyDropdownOptions() {
		home.clickOnAutomobile();
		List<String> actualOptions = vehicleData.getDropDownOptions_FuelType();
		List<String> expecedOptions = Arrays.asList("– please select –","Petrol","Diesel","Electric Power","Gas","Other");
		Assert.assertEquals(actualOptions, expecedOptions);
	}
	
}
