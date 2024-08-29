package utils;




import java.io.File;


import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.online.GeckodriverSupport.GeckodriverRelease;



public class utility {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	 public String sheetname;
	
	 
	 Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(100))
				.withMessage("Increase the polling time");
	
	
	public void geturl(String url) throws Exception {
				//validate the broken link
				//make connection
				URL link = new URL(url);//give the url to get connection
				HttpURLConnection httpURL= (HttpURLConnection) link.openConnection();// initiate connection
				httpURL.setConnectTimeout(2000);//address the connection timeout
				httpURL.connect();
				
				if (httpURL.getResponseCode()==200) {
					System.out.println(url + "-" + httpURL.getResponseMessage());			
					driver.get(url);
				} else {
					System.out.println(url + "-"+ httpURL.getResponseCode());
					System.out.println(url + "-" + httpURL.getResponseMessage());
							
				}		
		
	}
	
	public void launchbrowser(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
		} else {
			System.out.println("Opening Chrome browser as Default browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		waitPageLoad();
		driver.manage().window().maximize();		
		waitImplicit();
					
	}	
	
	
	public static void waitImplicit() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));	
	}
	
	public static void waitPageLoad() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(35));
	}

	public static void waitExplicit(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public static void waitExplicitUntillTitle(String titleToWait) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleIs(titleToWait));
	}
	
	
	
		
		
	
	public  static String  readpropfile(String keys) throws Exception {
		// read file 
		FileReader file = new FileReader("C:\\Users\\Lishanth\\eclipse-workspace\\demoblaze\\src\\test\\resources\\data.properties");
		prop = new Properties();
		prop.load(file);
		return prop.get(keys).toString();
	}
	
	public static String[][] readexcel(String sheetname) throws Exception   {
		
		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\Lishanth\\eclipse-workspace\\demoblaze\\src\\test\\resources\\demotestcase.xlsx");
		
		XSSFSheet sheet= book.getSheet(sheetname);
		
		int rowcount = sheet.getLastRowNum();
		
		short coloumncount=sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowcount][coloumncount];
		
		for (int i=1; i<=rowcount; i++) {
			XSSFRow row = sheet.getRow(i);		
		
			for (int j =0; j<coloumncount; j++ ) { 
				XSSFCell cell=row.getCell(j);
			//System.out.println("Read Excel "+ cell.getStringCellValue());
				
			data[i-1][j]=cell.getStringCellValue();		
		
			}
		
		}
		book.close();	
		return data;
			
		
	}
	
	
	public static void assertTrue(boolean condition ,String message) {
		if(!condition) {
			throw new AssertionError(message);
		}
	}
	
	public static void hardassertion(String actualtext,String expectedtext) {
		Assert.assertEquals(actualtext, expectedtext);
	}
	
	
	
	
	public  static void softassertion(String actualText,String expectedText) {
		
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(actualText, expectedText);
		assertObj.assertAll();
		
	}
	
		
	
	
	public static void clickOn(WebElement element) {
		waitExplicit(element);
		element.click();
	}
	

	 public static void pressTab(WebElement element, String text) {
		 	waitExplicit(element);
		 	element.sendKeys(text);
		 	element.sendKeys(Keys.TAB);
		 	
	    }

	public static void type(WebElement element, String text) {
		waitExplicit(element);
		element.clear();
		element.sendKeys(text);
	}
	
	public  void alertwait() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		 try {
		        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		        
		       
		    } catch (NoAlertPresentException e) {
		        System.out.println("No alert present");
		        
		    }

		
	}
	
	public  String getalertmessage() {
		alertwait();
		Alert alert= driver.switchTo().alert();
		String alertmsg = alert.getText();
		return alertmsg;
	}
	
	
	public void acceptalert() {
		alertwait();
		Alert alert= driver.switchTo().alert();
		alert= driver.switchTo().alert();
		alert.accept();	
		
		
	}
	
	
	public String screenshot(String Name) throws IOException {
		String filepath ="C:\\Users\\Lishanth\\eclipse-workspace\\demoblaze\\src\\test\\resources\\Screenshotdemoblaze\\" +Name+ ".png";
		File src = (File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File(filepath);
		FileUtils.copyFile(src, des);
		return filepath;	
		
		
	}
	

	public void closebrowser() {
		
		driver.quit();	
	}
	
	
	
	

}
