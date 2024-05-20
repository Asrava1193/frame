package com.cognizant.framework;

import java.io.FileReader;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.craft.ReusableLibrary;
import com.cognizant.craft.ScriptHelper;
import com.cognizant.framework.APIReusuableLibrary.ASSERT_RESPONSE;
import com.cognizant.framework.APIReusuableLibrary.COMPARISON;
import com.cognizant.framework.APIReusuableLibrary.SERVICEMETHOD;


import io.restassured.response.ValidatableResponse;

public class VMOReusableLibrary extends ReusableLibrary{

	public VMOReusableLibrary(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	public String getEnvironmentUrl(String environment,String application) {
		JSONParser parser = new JSONParser();
		String url = "";
		try {
			Object obj = parser.parse(new FileReader(properties.getProperty("environmentPath"))); 
			JSONObject jsonObject =  (JSONObject) obj;
			JSONObject envJsonObject = (JSONObject) jsonObject.get(environment);
			url = (String) envJsonObject.get(application);	
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return url;
	}

	
	public void craftFluentWait(By locator, int timeout) {
		try {
			//Wait<WebDriver> wait = new FluentWait<WebDriver>(driver.getRemoteWebDriver())
					Wait<WebDriver> wait = new FluentWait<WebDriver>(SHdriver.getDelegate())
					.withTimeout(Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);

			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver arg0) {
					Boolean eletype =false;
					try {
						WebElement webElement = arg0.findElement(locator);
						eletype = webElement.isDisplayed();						
					}catch (Exception exc) {
						eletype = false;						
					}
					if (eletype.equals(true)) {						
						return true;
					}
					return false;
				}
			};
			wait.until(function);
		}catch (Exception e) {
			report.updateTestLog(locator.toString(),
					locator.toString()+"is not in a visible state",
					Status.FAIL);
		}
	}


	public void craftFluentWait(WebElement element, int timeout) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver.getWebDriver())
					.withTimeout(Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);

			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver arg0) {
					Boolean eletype =false;
					try {		
						eletype = element.isDisplayed();				
					}catch (Exception exc) {
						eletype = false;					
					}
					if (eletype.equals(true)) {				
						return true;
					}
					return false;
				}
			};
			wait.until(function);
		}catch (Exception e) {
			report.updateTestLog(element.toString(),
					element.toString()+"is not in a visible state",
					Status.FAIL);
		}
	}


	public void mouseHover(By locator , String elementname,String Screenshot) {
		try {
			WebElement element  = driver.findElement(locator);
			//Action actions;
			Actions actions= new Actions(driver.getWebDriver());
			actions.moveToElement(element).build().perform();
			if (Screenshot=="Y") {
				report.updateTestLog(elementname,
						elementname+"is in a visible state and moved to the element",
						Status.PASS);
			}
			else {
				report.updateTestLog(elementname,
						elementname+"is in a visible state and moved to the element",
						Status.DONE);
			}
		}
		catch (Exception exc) {
			report.updateTestLog(elementname,
					elementname+"is not in a visible state",
					Status.FAIL);
		}
	}


	public void click(By locator, String elementname, String Screenshot) {
		try {
			/*WebDriverWait wait = new WebDriverWait(SHdriver.getRemoteWebDriver(), 60, 500);
			wait.until(ExpectedConditions.visibilityOf(SHdriver.findElement(locator)));
			wait.until(ExpectedConditions.elementToBeClickable(SHdriver.findElement(locator)));*/
			Boolean visible  = SHdriver.findElement(locator).isDisplayed();
			if(visible==true) {
				SHdriver.findElement(locator).click();
				if (Screenshot=="Y") {
					report.updateTestLog(elementname,
							elementname+" is clicked Successfully",
							Status.PASS);
				}
				else {
					report.updateTestLog(elementname,
							elementname+" is clicked Successfully",
							Status.DONE);				
				}
			}
			else {
				report.updateTestLog(elementname,
						elementname+" is not in a visible and in a clickable state",
						Status.FAIL);
			}
		}
		catch (Exception exc) {
			report.updateTestLog(elementname,
					elementname+" is not in a visible and in a clickable state",
					Status.FAIL);
		}
	}


	public void clickByJse(WebElement element, String elementname, String Screenshot) {
		try {
			JavascriptExecutor jse1 = (JavascriptExecutor) driver.getWebDriver();
			jse1.executeScript("arguments[0].click();", element);
			if (Screenshot=="Y") {
				report.updateTestLog(elementname,
						elementname+" is clicked Successfully",
						Status.PASS);
			}
			else {
				report.updateTestLog(elementname,
						elementname+" is clicked Successfully",
						Status.DONE);				
			}
		}
		catch (Exception exc) {
			report.updateTestLog(elementname,
					elementname+" is not in a visible and in a clickable state",
					Status.FAIL);
		}
	}


	public void clickByJse(By locator, String elementname, String Screenshot) {
		try {
			WebElement element1 = driver.findElement(locator);
			JavascriptExecutor jse1 = (JavascriptExecutor) driver.getWebDriver();
			jse1.executeScript("arguments[0].click();", element1);
			if (Screenshot=="Y") {
				report.updateTestLog(elementname,
						elementname+" is clicked Successfully",
						Status.PASS);
			}
			else {
				report.updateTestLog(elementname,
						elementname+" is clicked Successfully",
						Status.DONE);				
			}
		}
		catch (Exception exc) {
			report.updateTestLog(elementname,
					elementname+" is not in a visible and in a clickable state",
					Status.FAIL);
		}
	}


	public void enterText(By locator, String elementname, String Text, String Screenshot) {
		
		
		try {
			/*WebDriverWait wait = new WebDriverWait(SHdriver.getDelegate(), 60, 500);
			wait.until(ExpectedConditions.visibilityOf(SHdriver.findElement(locator)));*/
			Boolean visible  = SHdriver.findElement(locator).isDisplayed();
			Boolean enabled  = SHdriver.findElement(locator).isEnabled();
			if(visible==true && enabled==true) {
				SHdriver.findElement(locator).clear();
				SHdriver.findElement(locator).sendKeys(Text);;
				if (Screenshot=="Y") {
					report.updateTestLog(elementname,
							Text +" is entered successfully in the text box  - "+elementname,
							Status.PASS);
				}
				else {
					report.updateTestLog(elementname,
							Text +" is entered successfully in the text box  - "+elementname,
							Status.DONE);
				}
			}
			else {
				report.updateTestLog(elementname,
						elementname+"is not in a visible and in a clickable state",
						Status.FAIL);
			}
		}
		catch (Exception exc) {
			report.updateTestLog(elementname,
					elementname+" is not in a visible and in a clickable state",
					Status.FAIL);
		}
	}
	
	
	public void enterText(WebElement element, String elementname, String Text, String Screenshot) {
		try {
			WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 60, 500);
			wait.until(ExpectedConditions.visibilityOf(element));
			Boolean visible  = element.isDisplayed();
			Boolean enabled  = element.isEnabled();
			if(visible==true && enabled==true) {
				element.clear();
				element.sendKeys(Text);;
				if (Screenshot=="Y") {
					report.updateTestLog(elementname,
							Text +" is entered successfully in the text box  - "+elementname,
							Status.PASS);
				}
				else {
					report.updateTestLog(elementname,
							Text +" is entered successfully in the text box  - "+elementname,
							Status.DONE);
				}
			}
			else {
				report.updateTestLog(elementname,
						elementname+"is not in a visible and in a clickable state",
						Status.FAIL);
			}
		}
		catch (Exception exc) {
			report.updateTestLog(elementname,
					elementname+" is not in a visible and in a clickable state",
					Status.FAIL);
		}
	}


	public void isDisplayed(By locator, String elementname, String Screenshot) throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 60, 500);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));

			Boolean visible  = driver.findElement(locator).isDisplayed();

			if(visible==true) {
				if (Screenshot=="Y") {
					report.updateTestLog(elementname,
							elementname+" is visible State and clickable state",
							Status.PASS);

				}
				else {
					report.updateTestLog(elementname,
							elementname+" is visible State and clickable state",
							Status.DONE);	
				}
			}
		}catch (Exception exc) {
			report.updateTestLog(elementname,
					"Scroll to element " + "" + elementname + "" + " successful",
					Status.FAIL);
			throw new Exception(exc + "Exception on displaying element" + elementname);
		}
	}


	public void createTestData(String user, String password,String vgno, String environment, String email)
	{
		String buildVgURL = "https://${"+ user +"}:${"+ password +"}@10.244.166.5/job/ATP2/job/SSP%20VG%20Activation/buildWithParameters?TEST_PLAN=TEST%20DATA%20CREATION%20[VG]&TA_TOOLS_GROUP=Workable%20DVM%20Chrome%20108&Test_Case=${"+ vgno +"}&ENVIRONMENT=${"+ environment +"}&Recipient=${"+email+"}";
		ValidatableResponse vr=apiDriver.sendNReceive(buildVgURL,SERVICEMETHOD.GET, null, 0);
		vr.assertThat().statusCode(200);

		apiDriver.assertIt(buildVgURL, vr, ASSERT_RESPONSE.BODY, "", "Finished: SUCCESS", COMPARISON.IS_CONTAINS);    		
		apiDriver.assertIt(buildVgURL, vr, ASSERT_RESPONSE.TAG, "email", email, COMPARISON.IS_EQUALS);	    
	}


	public boolean isElementPresent(WebElement webelement) {
		boolean exists = false;
		try {
			webelement.getTagName();
			exists = true;
			System.out.println(" Element exists");
		} catch (NoSuchElementException e) {
			// nothing to do.
		}
		return exists;
	}


	public void validateText(String expectedText, By locator,String elementname)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 10);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			String actualText = element.getText();
			if (actualText.trim().contains(expectedText)){
				System.out.println("Text validation passed.");
				report.updateTestLog("expected text is displayed","text validation", Status.PASS);
			} else
			{
				System.out.println("Text validation failed. Expected: " + expectedText + ", but got: " + actualText);
				report.updateTestLog("expected text is not displayed","text validation", Status.FAIL);
			}
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
			report.updateTestLog("expected text is not displayed","text validation", Status.FAIL);
		}
	}


	public void pause(int seconds) {
		try {
			Thread.sleep(seconds * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void hoverAndClickElement(By hoverLocator, By clickLocator, int timeoutInSeconds)
	{
		try
		{
			//Actions actions = new Actions(driver.getWebDriver());
			Actions actions = new Actions(SHdriver.getDelegate());
			//WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), timeoutInSeconds);
			//WebDriverWait wait = new WebDriverWait(SHdriver.getDelegate(), timeoutInSeconds);
			//WebElement elementToHover = wait.until(ExpectedConditions.visibilityOfElementLocated(hoverLocator));
			WebElement elementToHover = SHdriver.findElement(hoverLocator);
			actions.moveToElement(elementToHover).perform();
			//WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(clickLocator));
			WebElement elementToClick = SHdriver.findElement(clickLocator);
			elementToClick.click();
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}


	public void enterTextWithJSExecutor(By locator, String text)
	{
		try
		{			
			WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 10);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver.getWebDriver();
			jsExecutor.executeScript("arguments[0].value = arguments[1];", element, text);
		} catch (NoSuchElementException e)
		{
			System.out.println("Input field not found: " + locator.toString());
		}
	}
	
	
	public void enterTextWithJSExecutor(WebElement element, String text)
	{
		try
		{			
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver.getWebDriver();
			jsExecutor.executeScript("arguments[0].value = arguments[1];", element, text);
		} catch (NoSuchElementException e)
		{
			System.out.println("Input field not found: ");
		}
	}


	public void selectOptionByVisibleText(By locator,String elementname, String option)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 10);
			WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			Select select = new Select(dropdown);
			select.selectByVisibleText(option);
		}
		catch (Exception e)
		{
			System.out.println(" Error: " + e.getMessage());
			report.updateTestLog(elementname,"Error: " + e.getMessage(),Status.FAIL);
		}
	}
	
	
	public void selectOptionByVisibleText(WebElement element,String elementname, String option)
	{
		try {		
			Select select = new Select(element);
			select.selectByVisibleText(option);
		}
		catch (Exception e)
		{
			System.out.println(" Error: " + e.getMessage());
			report.updateTestLog(elementname,"Error: " + e.getMessage(),Status.FAIL);
		}
	}


	public void selectByIndex(By locator,String elementname, int index)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 10);
			WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			Select select = new Select(dropdown);
			select.selectByIndex(index);
		}
		catch (Exception e)
		{
			System.out.println(" Error: " + e.getMessage());
			report.updateTestLog(elementname,"Error: " + e.getMessage(),Status.FAIL);
		}
	}


	public String getSelectedValue(By locator,String elementname)
	{
		WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 10);
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(dropdown);
		return select.getFirstSelectedOption().getText();
	}


	public boolean waitForPageLoad() throws Exception {
		try {
			return ((JavascriptExecutor) driver.getWebDriver()).executeScript("return document.readyState")
					.equals("complete");

		}catch (Exception exc) {

			throw new Exception(exc + "Exception : " + exc.getMessage());
		}
	}


	public void switchToNewWindow(String parentWindowHandle) throws TimeoutException {		
		String newWindowHandle = null;
		Set<String> allWindowHandles = driver.getWindowHandles();
		WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 10);
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				newWindowHandle = handle;
			}
		}
		if (newWindowHandle != null) {
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			driver.switchTo().window(newWindowHandle);
		} else {
			System.out.println("Could not find a new window to switch to.");
		}
	}	


	public boolean assertIsElementDisplayed(By locator,String elementname) 
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 10);
			WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			report.updateTestLog(elementname,
					elementname+" is Displayedt",
					Status.PASS);
			return element1.isDisplayed();

		} catch (NoSuchElementException e) 
		{
			report.updateTestLog(elementname,
					elementname+" is not Displayedt",
					Status.FAIL);
			return false;
		}
	}


	public void selectByValue(By locator,String elementname, String option) 
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 10);
			WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			Select select = new Select(dropdown);
			select.selectByValue(option);
		}
		catch (Exception e) 
		{
			System.out.println("Error: " + e.getMessage());
			report.updateTestLog(elementname,
					"Error: " + e.getMessage(),
					Status.FAIL);
		}
	}	


	public void selectByValue(WebElement element,String elementname, String option) 
	{
		try 
		{
			Select select = new Select(element);
			select.selectByValue(option);
		}
		catch (Exception e) 
		{
			System.out.println("Error: " + e.getMessage());
			report.updateTestLog(elementname,
					"Error: " + e.getMessage(),
					Status.FAIL);
		}
	}	


	public void dragAndDrop(WebElement element1, WebElement element2) {
		Actions action = new Actions(driver.getWebDriver());
		action.dragAndDrop(element1, element2).perform();

	}


	public void scrollIntoView(By locator) {
		JavascriptExecutor jse1 = (JavascriptExecutor) driver.getWebDriver();
		jse1.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
	}


	public void scrollIntoView(WebElement element) {
		JavascriptExecutor jse1 = (JavascriptExecutor) driver.getWebDriver();
		jse1.executeScript("arguments[0].scrollIntoView(true);", element);
	}


	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver.getWebDriver());
		actions.doubleClick(element);
	}


	public String getValue(WebElement element) {
		return element.getAttribute("value");
	}

	public String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String getTagName(WebElement element) {
		return element.getTagName();
	}

	public String getCssValue(WebElement element,String cssName) {
		return element.getCssValue(cssName);
	}

	public Point getLocation(WebElement element) {
		return element.getLocation();
	}

	public Dimension getSize(WebElement element) {
		return element.getSize();
	}

	public void setValueSequence(WebElement element,CharSequence... value) {
		element.sendKeys(value);
	}

	public String title() {
		return driver.getTitle();
	}

	public void back() {
		driver.navigate().back();
	}

	public void forward() {
		driver.navigate().forward();
	}

	public void maximise() {
		driver.manage().window().maximize();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void close() {
		report.addTestLogSection("Closing Browser ...");
		if (driver == null) {
			report.addTestLogSubSection("Nothing to close as Browser is null! Has Browser been closed already?");
		} else {
			driver.close();
		}
	}

	public void quit() {
		report.addTestLogSection("Quiting Browser ...");
		driver.close();
		if (driver == null) {
			report.addTestLogSubSection("Nothing to quit as Browser is null! Has Browser been closed and/or quit already?");
		} else {
			driver.quit();
		}
	}

	public void setImplicitWait(Integer seconds) {
		report.addTestLogSection(MessageFormat.format(">>> Set implicit wait to seconds: ''{0}''!", seconds));
		this.driver.manage().timeouts().implicitlyWait((long)seconds, TimeUnit.SECONDS);
	}

	public void displayIframesInfo() {
		report.addTestLogSection(">>> Finding all iFrames on the page ...");
		List<WebElement> iframes = this.driver.findElements(By.tagName("iframe"));
		if (iframes.isEmpty()) {
			report.addTestLogSection(">> No iFrames found!");
		} else {
			Iterator<WebElement> var3 = iframes.iterator();

			while(var3.hasNext()) {
				WebElement iframe = (WebElement)var3.next();
				report.addTestLogSection(MessageFormat.format(">>> iFrame: ID = {0}, Name = {1}", iframe.getAttribute("id"), iframe.getAttribute("Name")));
			}

			report.addTestLogSection(">>> iFrames information displayed!");
		}
	}

	public int getAllTabs() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		return tabs.size();
	}

	public void switchToDefault() {
		report.addTestLogSection(">>> Switch to default content ...");
		this.driver.switchTo().defaultContent();
		report.addTestLogSection(">>> Switched to default content!");
	}

	public void switchToTab(int tabId) {
		report.addTestLogSection(MessageFormat.format(">>> Switching to tab ''{0}'' ...", tabId));
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		report.addTestLogSection(MessageFormat.format(">>> Total tabs: ''{0}''", tabs.size()));
		if (tabs.size() - 1 > tabId) {
			report.addTestLogSection(MessageFormat.format(">>> Could not navigate to tab ''{0}'' as no of total tabs is ''{1}''", tabId, tabs.size()));
		} else {
			driver.switchTo().window((String)tabs.get(tabId));
			report.addTestLogSection(MessageFormat.format(">>> Switched to tab ''{0}''!", tabId));
		}
	}

	public void switchTo(String iframe) {
		report.addTestLogSection(MessageFormat.format(">>> Switching to tab ''{0}'' ...", iframe));
		driver.switchTo().frame(iframe);
		report.addTestLogSection(MessageFormat.format(">>> Switched to tab ''{0}''!", iframe));
	}

	public void switchTo(WebElement element) {
		report.addTestLogSection(">>> Switching to tab using an Element ...");
		driver.switchTo().frame(element);
		report.addTestLogSection(">>> Switched to tab using an Element!");
	}

	public void switchTo(int iframe) {
		report.addTestLogSection(MessageFormat.format(">>> Switching to tab ''{0}'' ...", iframe));
		driver.switchTo().frame(iframe);
		report.addTestLogSection(MessageFormat.format(">>> Switched to tab ''{0}''!", iframe));
	}

	public String r_getText(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getListOfElements(By locator) {
		return driver.findElements(locator);
	}

	public void waitScrollAndClickJs(int time, By locator, String locatorName, String Screenshot) {
		craftFluentWait(locator, time);
		scrollIntoView(locator);
		clickByJse(locator, locatorName, Screenshot);
	}

	public void waitScrollAndClickJs(int time, WebElement element, String elementName, String Screenshot) {
		craftFluentWait(element, time);
		scrollIntoView(element);
		clickByJse(element, elementName, Screenshot);
	}
}