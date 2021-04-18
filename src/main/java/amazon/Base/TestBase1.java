package amazon.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase1  {
	public static Properties config;
	public static WebDriver driver;
	public static Properties OR ;
	
	
	
	
	@BeforeSuite
	public void initialize() throws Throwable {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/properties/Config.properties");
		config.load(fis);
		
		
		fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
		OR.load(fis);
		
		
		System.setProperty(System.getProperty("CHROM_KEY"), System.getProperty("CHROM_VALUE"));
		System.setProperty(System.getProperty("GECKO_KEY"), System.getProperty("GECKO_VALUE"));
	}


	
	public static void openApplication(String browser) {
		if(browser.equals("chrome")) {

			driver=new ChromeDriver();
		}
		else {

			driver = new FirefoxDriver();
			
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();


		}
		
	}
	public static void openweb() {
		
	}


@AfterSuite
public void teardown() {
	if (driver != null) {
		driver.close();
	}
}
}