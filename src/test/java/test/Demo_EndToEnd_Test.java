package test;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusableComponents.ExcelOperations;
import testBase.BaseClass;


public class Demo_EndToEnd_Test extends BaseClass{
	
	ExcelOperations excel=new ExcelOperations("Sheet1");
	
	@Test(dataProvider = "demoTest")
	public void demoTest(Object obj) throws Exception {
		
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> data=(HashMap<String, String>) obj;
		
		home.clickOnSpecifiedLink(data);
		vehicleData.enterAllDetails(data);
		vehicleData.clickOnNextButton();
		insurantData.enterAllInsurantDetails(data);
		insurantData.clickOnNext();
		productData.enterAllProductDetails(data);	
		productData.clickOnNextButton();
		priceOptions.selectPlan(data);
		priceOptions.clickOnNextButton();
		quote.enterAllDetails(data);
		quote.clickOnSendButton();
	}
	
	@DataProvider(name="demoTest")
	public Object[][] demoTestDataProvider() throws Exception {
		Object[][] obj=new Object[excel.getRowCount()][1];
		HashMap<String, String> hm=null;
		for(int i=0;i<excel.getRowCount();i++) {
			hm=excel.getTestDataInMap(i+1);		
			obj[i][0]=hm;
		}
		return obj;						
	}
	
}
