package com.iNetBankingGuru.TestCases;

import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iNetBankingGuru.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL(); // "https://demo.guru99.com/V4/";
	public String username = readconfig.getuserName();// "mngr254440";
	public String password = readconfig.getPassword();// "pAmuzYm";

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		//System Path
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		// Logger functionality
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if (br.equals("IE")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			driver=new FirefoxDriver();
		}
		driver.get(baseURL);
		logger.info("URL is opened");
		

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
