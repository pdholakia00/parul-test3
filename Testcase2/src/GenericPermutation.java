/*
 * * This code is to test any testcase that has permutation types test scenarios
 */

import java.util.Random;
import java.time.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class GenericPermutation {


	static WebDriver driver ;
	static WebElement webElement;
	static String url;
	
	// update start 
	public static final String TEST_APP = "DEAZPS1547995034";
	//public static final String REFID = "F9FACFC5-21E7-45E6-9499-EF89D02EC82E"; // 54588
	public static final String REFID = "2603871C-E482-4D4E-B8BE-743A9AEBCB7D"; // 21310
	//public static final String REFID = "23581F22-DFCA-4D0C-B129-7A3FDBE87378";// 54587
	//public static final String REFID = "D020D505-1604-4A9A-97DB-902B71DA9821"; // 54590
	// update end. 
	
	public static final String XPATH_REFID = "//input [@name='refid']";
	public static final String XPATH_SEARCH = "//div[@class='icon-wrap with-icon search icon-wrap-medium icon-wrap-clickable']";
	public static final String XPATH_EDIT_MEASURE = "//div[@title='Edit']";
	
	public static final String XPATH_DETRIOT_ACC_NUMBER = "//input[contains(@id, 'leftcol_field40844')]";
	public static final String XPATH_MICHCON_ACC_NUMBER = "//input[contains(@id, 'leftcol_field40845')]";
	public static final String XPATH_HVAC_SLAB_INSULATION = "//input[contains(@id, 'rightcol_field331847')]";
	public static final String XPATH_EXPECTED_rOUGH_CLOSE_DATE = "//input[contains(@id, 'leftcol_field168933')]";
	
    public static final String XPATH_ELEC_INCENTIVE = "//input[contains(@name,'elec_util_cust_incentive')]";
	public static final String XPATH_GAS_INCENTIVE = "//input[contains(@name,'gas_util_cust_incentive')]";
	public static final String XPATH_CEILING_AREA = "//input[contains(@name,'ceiling_area')]";
	public static final String XPATH_ANNUAL_THERMS_SAVED2 = "//input[contains(@name,'annual_therms_saved_2')]";
	public static final String XPATH_ANNUAL_THERMS_SAVED3 = "//input[contains(@name,'annual_therms_saved_3')]";
    public static final String XPATH_INSULATION_BAG_COUNT = "//input[contains(@name,'insulation_bag_count')]";
    
    public static final String XPATH_CENTRAL_AC = "//label [ contains(@for ,'leftcol_field42602')]//parent::div//child::div[ @class='field-group']//child::div//child::div";
    public static final String XPATH_SYSTEM_TYPE = "//label [ contains(@for ,'leftcol_field43245')]//parent::div//child::div[ @class='field-group']//child::div//child::div";

	public static void main(String[] args) {		
		try{
			
			System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
			url = "https://visiondsm.programprocessing.com/";
			Random randomNum ;
			Long time1, time2;
			int randomNum1, randomNum2;
			String strMichconAccounNumber, strDetroitAccountNumber;
			String strElec_incentive_7, strInsulationBagCount, strElec_incentive_6;
			String strAnnualThermsSavde2, strAnnualThermsSavde3, strCeilingArea;
			String  scenario; 
			//String strHouseType , strHVACSystemOneFuel;
			String strCentralAC, strSystemType ;
			String HVACSlabInsualation , roughCloseDate;
			String tempxpath;
			Float expectedElecIncentive7, expectedAnnualThermsSaved3;
			int QCResult = 0 , i ;
			// 54590
//			String[][] testData = {					
//				{"1", "Not Blank", "Not Blank", "Yes", "Gas" , "442.8" , "49.2"},
//				{"2", "Not Blank", "Not Blank", "No", "Gas" , "442.8" , "49.2"},								
//				{"3", "Blank", "Not Blank", "Yes", "Gas" ,  "0" , "492"},
//				{"4", "Blank", "Not Blank", "No", "Gas" ,  "0" , "492"},				
//				{"5", "Not Blank", "Blank", "Yes", "Electric" ,  "492" , "0"},				
//				{"6", "Not Blank", "Blank", "No", "Electric" ,  "492" , "0"},				
//				{"7", "Not Blank", "Not Blank", "No", "Electric" ,  "492" , "0"},				
//				{"8", "Not Blank", "Not Blank", "Yes", "Electric" ,  "492" , "0"},				
//				{"9", "Blank", "Blank", "Yes", "Gas" ,  "0" , "0"}
//			};

			      
			//21310			
			String[][] testData = {					
					{"1", "Not Blank", "Not Blank", "Yes", "Gas" 	, "55" , "5"},
					{"2", "Not Blank", "Not Blank", "No", "Gas" 	, "45" , "5"},								
					{"3", "Blank", "Not Blank", "Yes", "Gas" 		, "0"  , "50"},
					{"4", "Blank", "Not Blank", "No", "Gas" 		, "0"  , "50"},				
					{"5", "Not Blank", "Blank", "Yes", "Electric" 	, "50" , "0"},				
					{"6", "Not Blank", "Blank", "No", "Electric" 	, "50" , "0"},				
					{"7", "Not Blank", "Not Blank","No","Electric"	, "50" , "0"},				
					{"8", "Not Blank", "Not Blank","Yes","Electric"	, "50" , "0"},				
					{"9", "Not Blank", "Blank", "Yes", "Gas"		, "50" 	, "0"},
					{"10", "Not Blank", "Blank", "Yes", "Electric"	, "50" 	, "0"},
					{"11", "Blank", "Blank", "Yes", "Gas" 			, "0" 	, "0"}
				};			

			
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					
		driver.manage().window().maximize();
		driver.findElement(By.name("userName")).sendKeys("pdholakiaauto"); // enter data in"user name " field.
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // enter data in"user name " field.
		driver.findElement(By.name("password")).sendKeys("Globesnow1!"); // enter data in"user name " field.
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // enter data in"user name " field.
			
		driver.findElement(By.cssSelector("div.global-search")).click(); // click on global search icon
		driver.findElement(By.cssSelector("input[placeholder='Type keyword']")).sendKeys(TEST_APP);
		driver.findElement(By.cssSelector("div[class='btn search btn-standard btn-blue btn-square with-icon']")).click(); //click search button

		LocalTime localTime = LocalTime.now();
	    System.out.println("Current time: "+localTime + "\n");
		
		for (i = 0 ; i < 2 ; i++) {
			scenario = testData[i][0];
			strDetroitAccountNumber = testData[i][1];
			strMichconAccounNumber = testData[i][2];
			strCentralAC = testData[i][3];
			strSystemType = testData[i][4];
			expectedElecIncentive7 = Float.valueOf(testData[i][5]);
			expectedAnnualThermsSaved3 = Float.valueOf(testData[i][6]);
			QCResult = 0;
						 			
			Long time = System.currentTimeMillis();
			randomNum = new Random(time.intValue());
			randomNum1 = randomNum.nextInt();
			randomNum1 = Math.abs(randomNum1);
			randomNum2  = randomNum.nextInt();
			randomNum2 = Math.abs(randomNum2);
			driver.findElement(By.xpath("//span[@class='tool-info-text' and text()='Forms']")).click(); //click Forms
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='Edit Form']")).click();
			
			webElement = driver.findElement(By.xpath(XPATH_DETRIOT_ACC_NUMBER));
			webElement.clear();
			if (strDetroitAccountNumber.equals("Blank"))
			{
				webElement.sendKeys(Keys.BACK_SPACE);
				webElement.sendKeys(Keys.SPACE);
			}
			else
			{ 
				strDetroitAccountNumber = String.valueOf(randomNum1);
				webElement.sendKeys(strDetroitAccountNumber);
			}
			
			webElement.sendKeys(Keys.TAB);			
			TimeUnit.SECONDS.sleep(1);
					
			webElement = driver.findElement(By.xpath(XPATH_MICHCON_ACC_NUMBER));		
			webElement.clear();
			
			if (strMichconAccounNumber.equals("Blank"))
			{
				webElement.sendKeys(Keys.BACK_SPACE);
				webElement.sendKeys(Keys.SPACE);
			}
			else	
			{
				strMichconAccounNumber = String.valueOf(randomNum2);
				webElement.sendKeys(strMichconAccounNumber);
			}
			webElement.sendKeys(Keys.TAB);
			Thread.sleep(1000);		
			
			webElement = driver.findElement(By.xpath(XPATH_SYSTEM_TYPE)); 
			JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			jse2.executeScript("arguments[0].scrollIntoView()", webElement); 
			Thread.sleep(1000);
			webElement.click();		
			webElement = driver.findElement(By.xpath("//input[ @placeholder='Filter List']"));
			tempxpath = "//div [text()= '" + strSystemType + "']";
			
			webElement = driver.findElement(By.xpath(tempxpath));		
			webElement.click();		
			Thread.sleep(1000);
			//new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(webElement));
			
			webElement = driver.findElement(By.xpath(XPATH_CENTRAL_AC)); 
			webElement.click();		
			Thread.sleep(2000);
			webElement = driver.findElement(By.xpath("//input[ @placeholder='Filter List']"));
			tempxpath = "";
			tempxpath = "//div[text()='" + strCentralAC + "']";
			
			webElement = driver.findElement(By.xpath(tempxpath));
			webElement.click();		
					
			webElement = driver.findElement(By.xpath("//button[text()='Save']"));		
			new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(webElement));
			webElement.click();
			
			webElement = driver.findElement(By.xpath("//span[ text()= 'Equipment' and @class= 'tool-info-text']"));
			webElement.click();

		/*
		 * this code is to wait till "Calculations are done message disappears. 
		 */	
			webElement = driver.findElement(By.xpath("//div[ @class='Toastify__toast-body']"));		
			new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(webElement));
			webElement = driver.findElement(By.xpath("//div[ @class='Toastify__toast-body']"));		
			new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOf(webElement));

			
			
		/*
		 * this code is to wait till "Calculations are done message disappears. 
		 * Somehow the message is not coming now so commented out this code.
		 *   
			webElement = driver.findElement(By.xpath("//div[ contains( @class,'activity-icon')]"));		
			new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(webElement));

			webElement = driver.findElement(By.xpath("//div[ contains( @class,'activity-icon')]"));		
			new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOf(webElement));
		 */
			Thread.sleep(1000);
			
			webElement = driver.findElement(By.xpath(XPATH_REFID));
			webElement.clear();
			webElement.sendKeys(REFID);
			Thread.sleep(1000);
			
			webElement = driver.findElement(By.xpath(XPATH_SEARCH)); 
			webElement.click();
			Thread.sleep(1000);
			
			webElement = driver.findElement(By.xpath(XPATH_EDIT_MEASURE)); 
			webElement.click();

			Thread.sleep(1000);
			
			webElement = driver.findElement(By.xpath(XPATH_ELEC_INCENTIVE)); 
			strElec_incentive_7 = webElement.getAttribute("Value");		
			 if (expectedElecIncentive7.compareTo(Float.valueOf(strElec_incentive_7)) == 0) 
			{
				QCResult++;
			}else {
				System.out.println("Expected Electric incentive  : " + expectedElecIncentive7  + " Actual = " + strElec_incentive_7);
			}
			 Thread.sleep(1000);
			 
			webElement = driver.findElement(By.xpath(XPATH_GAS_INCENTIVE)); 
			strAnnualThermsSavde3 = webElement.getAttribute("Value");
			if (expectedAnnualThermsSaved3.compareTo(Float.valueOf(strAnnualThermsSavde3)) == 0) 			
			{
				QCResult++;
			}else {
				System.out.println("Expected Gas incentive : " + expectedAnnualThermsSaved3  + " Actual = " + strAnnualThermsSavde3);
			}		
			if ( QCResult == 2 )
			{
				System.out.println("Scenario : "+  scenario + " QC Result = PASS  \n");
			}
			else {
				System.out.println("Scenario : "+  scenario + " QC Result = FAIL  \n");	
			}

			driver.findElement(By.xpath("//button[ text() ='Cancel']")).click(); //click Cancel button on equipment
			
			Thread.sleep(1000);
		}// end of for all scenarios	
			
		}//end of try
		catch(Exception e) {
			System.out.println("The exception in the code... START... \n");
			System.out.println(e.getMessage());
			System.out.println("The exception in the code... END... \n");
			
		}
		finally{
			driver.quit();
			driver=null;
		}

	}//end of main
}
