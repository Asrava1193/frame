package com.cognizant.framework;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.VGs.BusinessFlow;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReport {
	
	
	 private  WebDriver driver =BusinessFlow.getDriver();
	static ExtentReports extentReports;
//	ExtentHtmlReporter htmlReporter;
	static ExtentTest test;
	static ExtentSparkReporter sparkReporter;
	static File screenshotFolder;
	static File reportFile;
	static File reportFolder;
       
	
	
	public void startReport() {
	
    //initialize ExtentReports and attach the SparkReporter
		extentReports = new ExtentReports();
		
        // Create result folder if it doesn't exist
        File resultFolder = new File("result");
        if (!resultFolder.exists()) {
            resultFolder.mkdir();
        }
 
        // Create folder with timestamp for report
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
         reportFolder = new File(resultFolder, timestamp);
        reportFolder.mkdir();
        
        // Create report file
         reportFile = new File(reportFolder, "report.html");
         
         
        
         sparkReporter = new ExtentSparkReporter(reportFile);
    	extentReports.attachReporter(sparkReporter);	
    	
    	

    }
		
	public static void createTest(String testName,String testDescription) {
		test = extentReports.createTest(testName, testDescription);
		
	}
	
	/*public static void log(String elmentname, String message, Status status) {
		test.log(status, message);
		
	}*/
	
	
	
	public static void log(String elementName, String message, Status status) {
        if (status == Status.FAIL) {
            // Take screenshot and attach to report only if status is fail
        	ExtentReport ex = new ExtentReport()
;            String screenshotPath = ex.takeScreenshot(reportFolder,elementName);
            test.log(status, message,MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.log(status, message);
        }
    }
 
	private String takeScreenshot(File reportFolderPath,String elementName) {
	    // Create the screenshots folder inside the report folder if it doesn't exist
	    File screenshotsFolder = new File(reportFolderPath, "screenshots");
	    if (!screenshotsFolder.exists()) {
	        screenshotsFolder.mkdir();
	    }
	    // Generate a unique file name for the screenshot
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
        String timestamp = dateFormat.format(new Date());
        String screenshotFileName = elementName + "_" + timestamp + ".png";
 
        // Define the path to save the screenshot
        String screenshotPath = screenshotsFolder.getAbsolutePath() + File.separator + screenshotFileName;
	 
	    try {
	        // Capture screenshot
	        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 
	        // Copy the screenshot to the specified path
	        Files.copy(screenshotFile.toPath(), new File(screenshotPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	 
	    return screenshotPath;
	}	public void tearDown() throws IOException {
        //to write or update test information to reporter
		
		
		extentReports.flush();
		String latestReportPath = reportFile.getAbsolutePath();
		
		Desktop.getDesktop().browse(new File(latestReportPath).toURI());
    }

}
