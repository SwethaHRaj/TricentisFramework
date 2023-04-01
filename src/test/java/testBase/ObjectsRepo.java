package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterInsurantData;
import pageObjects.EnterProductData;
import pageObjects.EnterVehicleData;
import pageObjects.Home;
import pageObjects.SelectPriceOptions;
import pageObjects.SendQuote;
import reusableComponents.CommonMethods;

public class ObjectsRepo {
	
	public static WebDriver driver;
	public static Home home;
	public static EnterVehicleData vehicleData;
	public static CommonMethods cm=new CommonMethods();
	public static EnterInsurantData insurantData;
	public static EnterProductData productData;
	public static SelectPriceOptions priceOptions;
	public static SendQuote quote;
	public static ExtentReports report;
	public static ExtentTest test;

}


