package com.cognizant.framework;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VGs.BusinessFlow;
import com.aventstack.extentreports.Status;





public class VMOReusableLibrary{
	
	
	public WebDriver getWebDriver() {
		return (WebDriver) driver;
	}
    private WebDriver driver =BusinessFlow.getDriver();

	public  VMOReusableLibrary() throws Exception {
		
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
						//******Click Method*****//
	
	public void r_click(WebElement locator,String elementname) throws Exception{
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));

			locator.click();
             ExtentReport.log(elementname , elementname+ " is Clicked Successfully",Status.PASS);
             }catch(Exception exc){
			ExtentReport.log(elementname , elementname+" is not in a visible and in a clickable state",Status.FAIL);
			
		}
	}

                        //*****Enter Text Method***////
	public void r_enterText(WebElement locator, String Text, String elementname) throws Exception{
		
		try {
		
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		    wait.until(ExpectedConditions.visibilityOf(locator));
			locator.clear();
			locator.sendKeys(Text);
			ExtentReport.log(elementname , elementname+ " Text entered Successfully",Status.PASS);
		}catch(Exception exc) {
			ExtentReport.log(elementname , elementname+ " Text is not entered Successfully",Status.FAIL);
		}


	}
	
	                   //*****Mouse hover and click*****////
	public void hoverAndClickElement(WebElement hoverLocator, WebElement clickLocator, int timeoutInSeconds,String elementname)
	{
		try
		{
			Actions actions;
			actions= new Actions(driver);		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement elementToHover = wait.until(ExpectedConditions.elementToBeClickable(hoverLocator));
			actions.moveToElement(elementToHover).perform();
			WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(clickLocator));
			elementToClick.click();	
			ExtentReport.log(elementname , elementname+ " is hovered and Clicked Successfully",Status.PASS);

		}
		catch (Exception e)
		{
			
			 
			ExtentReport.log(elementname , elementname+ " is not hovered and Clicked Successfully",Status.FAIL);

		}
	}

	               //*****Select by Visible text******////
	public void selectByVisibleText(WebElement locator, String option,String elementname)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30) );
			WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));
			Select select = new Select(dropdown);
			select.selectByVisibleText(option);
			ExtentReport.log(elementname,  elementname+ "is selected by text sucessfully", Status.PASS);
		}
		catch (Exception e)
		{
			ExtentReport.log(elementname, elementname+ "is not selected by text",Status.FAIL);
			
		}
	}
	
	
	
	public void selectByValue(WebElement locator, String option,String elementname) 
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30) );
			WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));
			Select select = new Select(dropdown);
			select.selectByValue(option);
			ExtentReport.log(elementname,  elementname+ "is selected by Value sucessfully", Status.PASS);
		}
		catch (Exception e) 
		{
			ExtentReport.log(elementname, elementname+ "is not selected by Value",Status.FAIL);
			
		}
	}	
	          //***Click By JavaScriptExecutor*****//
	public void r_clickByJse(WebElement e,String elementname)
	{
		try 
		{


			
			JavascriptExecutor jse1 = (JavascriptExecutor) driver;
			jse1.executeScript("arguments[0].click();", e);
			ExtentReport.log(elementname,  elementname+ "is Clicked sucessfully", Status.PASS);

		}
		catch (Exception exc) {
			ExtentReport.log(elementname , elementname+" is not in a visible and in a clickable state",Status.FAIL);
		}
			


		}

                  //**Click By JavaScriptExecutor IfExists**//
		
		public void r_clickByJseIfExists(WebElement e,String elementname)
		{
			try 
			{


				
				JavascriptExecutor jse1 = (JavascriptExecutor) driver;
				jse1.executeScript("arguments[0].click();", e);
				ExtentReport.log(elementname,  elementname+ "is Clicked sucessfully", Status.PASS);

			}
			catch (Exception exc) {
				System.out.println("No element is present to click");
				ExtentReport.log(elementname , elementname+" is not in a visible and in a clickable state",Status.SKIP);

			}

	}

	
	
	    //***Enter Text with JavaScriptExecutor IfExists**//
		
		public void enterTextWithJSExecutorIfExists(WebElement e, String text,String elementname)
		{
			try
			{
				
				
				
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].value = arguments[1];", e, text);
				ExtentReport.log(elementname , elementname+ " Text entered Successfully",Status.PASS);

			} catch (Exception exc)
			{
				ExtentReport.log(elementname , elementname+ " is not present and not entered text",Status.SKIP);
			}
		}
	
	
	
		//**Get Text of Element**//
		public String getText(WebElement e) {
			String val1 =null;
			try {
				
				 val1 =e.getText();
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			return val1;
			
		}
		
		
		//Validate text
		public void validateText(String expectedText, By locator,String elementname)
		{
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				String actualText = element.getText();
				if (actualText.trim().equalsIgnoreCase(expectedText)){
					System.out.println("Text validation passed.");
					ExtentReport.log("expected text is displayed",actualText.trim(), Status.PASS);
					
				} else
				{
					System.out.println("Text validation failed. Expected: " + expectedText + ", but got: " + actualText);
					ExtentReport.log("expected text is not displayed","text validation", Status.FAIL);
				}
			}
			catch (Exception e)
			{
				System.out.println("Error: " + e.getMessage());
				ExtentReport.log("expected text is not displayed","text validation", Status.FAIL);
			}
		}
	
//  scroll to element
		public  void scroll(WebElement e) throws Exception {
			try {
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", e);
			}
            catch (Exception exc) {
				throw new Exception(exc + "Exception on scroll to element" + e);
			}
		}
	
	
//wait 
		public void craftWait(final WebElement e, int timeout) {
			//Declare and initialise a fluent wait

			Wait<WebDriver> wait = new FluentWait<WebDriver>(getWebDriver())
					.withTimeout(Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);

			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver arg0) {
					Boolean eletype =false;
					try {
						WebElement element = arg0.findElement((By) e);
						eletype = element.isDisplayed();
						//     System.out.println("Eleement is Displayed" + eletype);

					}catch (Exception exc) {
						eletype = false;
						// System.out.println("Eleement is not Displayed" + eletype);
					}

					if (eletype.equals(true)) {
						//element.click();
						return true;
					}
					return false;
				}
			};
			wait.until(function);
		}
	
	
	
	
	
	
	
	
	
}
