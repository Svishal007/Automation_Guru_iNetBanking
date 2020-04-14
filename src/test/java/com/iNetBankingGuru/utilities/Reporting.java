package com.iNetBankingGuru.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/////////Listner class to generate extent report 

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //timeStamp
		String repName = "Test-Report-"+ timeStamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName); //Specify Location
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Vishal");
		
		htmlReporter.config().setDocumentTitle("iNetBanking Test Practice"); //TileOfReport
		htmlReporter.config().setReportName("Test Functinal Automation Report"); // NAme Of Report
		htmlReporter.config().setTheme(Theme.DARK);
	}
	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName()); //This will create new entry in report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.PINK)); //Send passed info color
			
	}
	public void onTestailure(ITestResult tr) {
		logger=extent.createTest(tr.getName()); //This will create new entry in report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE)); //Send passed info color
		
		String screenshotPath= System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f= new File(screenshotPath);
		
		if (f.exists()) {
			try {
				logger.fail("Screenshot is Below:"+ logger.addScreenCaptureFromPath(screenshotPath));
				
			} catch (Exception e) {
				e.getMessage();

			}
			
		}
		
	}
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName()); //This will create new entry in report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.LIME)); //Send passed info color
			
	}
	public void onTestFinish(ITestContext testContext) {
		extent.flush();
			
	}

}
