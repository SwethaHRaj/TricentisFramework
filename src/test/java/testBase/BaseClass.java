package testBase;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsurantData;
import pageObjects.EnterProductData;
import pageObjects.EnterVehicleData;
import pageObjects.Home;
import pageObjects.SelectPriceOptions;
import pageObjects.SendQuote;
import reusableComponents.PropertiesOperations;


public class BaseClass extends ObjectsRepo{
	

	@BeforeMethod
	public void setup() throws Exception {
		if(PropertiesOperations.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(PropertiesOperations.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}	
		else 
			throw new Exception("Browser not Valid. Please specify chrome or edge");
		
		driver.get(PropertiesOperations.getProperty("url"));
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		home=new Home();
		vehicleData=new EnterVehicleData();
		insurantData=new EnterInsurantData();
		productData=new EnterProductData();
		priceOptions=new SelectPriceOptions();
		quote=new SendQuote();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}