package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import com.cognizant.craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.cognizant.framework.VMOReusableLibrary;

public class CreationOfVoucherPage extends VMOReusableLibrary
{
	public CreationOfVoucherPage(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	//******************locators********************

	//Voucher Management
	private static final By NavigationBar = By.xpath("//a[@title='List of NetCracker modules']");
	private static final By VoucherMngmnt = By.xpath("//ul[@id='navigationBar']//li[@id='menuItem_0']//ul[@class='subMenu scrollable']//li[@role='menuitem']//a//span[text()='Voucher Management']");

	//New Discount Voucher
	private static final By VoucherSpec = By.xpath("//a[text()='Voucher Specification']");
	private static final By NewVoucherSpec = By.xpath("//button[text()='New Discount Voucher Specification']");

	//Details of New Discount Voucher
	private static final By Type = By.xpath("//select[@class='gwt-ListBox nc-field-list-value nc-field-container']");
	private static final By NameBox = By.xpath(("//input[@class='gwt-TextBox nc-field-text-input']"));
	private static final By MaxNoOfRedemptions = By.xpath("(//input[@class='gwt-TextBox nc-field-text-input nc-field-required-input__placeholder placeholder_style'])[1]");
	private static final By AllowedConsumptions = By.xpath("//input[@class='gwt-TextBox nc-field-text-input nc-field-required-input__placeholder placeholder_style']");
	private static final By NDstartdate = By.xpath("(//input[@class='gwt-TextBox nc-field-date-input'])[1]");
	private static final By NDenddate = By.xpath("(//input[@class='gwt-TextBox nc-field-date-input'])[2]");
	private static final By ActionOffering = By.xpath("(//input[contains(@id,'id_ref')])[2]");
	private static final By AssignmentMode = By.xpath("(//select[@class='gwt-ListBox nc-field-list-value nc-field-container'])[2]");
	private static final By Amount = By.xpath("//input[@class='gwt-TextBox nc-field-text-input nc-field-input__placeholder placeholder_style']");
	private static final By Channel = By.xpath("//select[@class='gwt-ListBox nc-field-list-select']");
	private static final By PlusSign = By.xpath("//img[@class='gwt-Image nc-field-add-button']");
	private static final By NDCreate = By.xpath("//button[text()='Create']");

	//Standalone Voucher
	private static final By StandaloneVoucher = By.xpath("//a[text()='Standalone Vouchers']");
	private static final By NewStandaloneVoucher = By.xpath("//button[text()='New']");
	private static final By NSNameBox = By.xpath("(//input[@class='gwt-TextBox nc-field-text-input'])[1]");
	private static final By DiscountVoucherSpec = By.xpath("(//input[contains(@id, 'id_ref')])[2]");
	private static final By SerialNumber = By.xpath("(//input[@class='gwt-TextBox nc-field-text-input'])[2]");
	private static final By ActivityPeriod = By.xpath("(//input[@class='gwt-TextBox nc-field-text-input nc-field-input__placeholder placeholder_style'])[1]");
	private static final By SVstartdate = By.xpath("(//input[@class='gwt-TextBox nc-field-date-input'])[1]");
	private static final By SVenddate = By.xpath("(//input[@class='gwt-TextBox nc-field-date-input'])[2]");
	private static final By SVcreate = By.xpath("//button[text()='Create']");


	//Activation of Voucher
	private static final By VoucherSpecFilter = By.xpath("//span[text()='Voucher Specification']//following::img[1]//ancestor::div[1]//following::div[1]//child::img");
	private static final By SerialNumberFilter = By.xpath("//span[text()='Serial Number']//following::img[1]//ancestor::div[1]//following::div[1]//child::img");
	private static final By ContainsBox = By.xpath("//input[@class='gwt-TextBox nc-field-text-input']");
	private static final By Apply = By.xpath("//button[text()='Apply']");
	private static final By ActivateButton = By.xpath("//button[text()='Activate']");
	private static final By ConfirmButton = By.xpath("//button[text()='Confirm']");
	private static final By Active = By.xpath("(//div[@class='nc-field-list-color '])[2]");

	//declarations
	VMOReusableLibrary Vmor = new VMOReusableLibrary(scriptHelper);
	static String SerialNo;

	//***************** Actions **********************


	//Clicking on Voucher Management
	public void voucherManagement()
	{
		pause(5);
		clickByJse(NavigationBar, "list of NC modules", "Y");
		pause(5);
		scrollIntoView(VoucherMngmnt);
		pause(5);
		report.updateTestLog("VoucherMngmnt","VoucherMngmnt is visible", Status.PASS);
		clickByJse(VoucherMngmnt, "VoucherMngmnt", "Y");
		pause(5);
	}

	//Fetching Start Date
	public  String startDatenew() 
	{

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}

	//Fetching End Date
	public  String endDatenew(int day_count) 
	{
		LocalDate currentDate = LocalDate.now();
		LocalDate mOdifiedDate = currentDate.plusDays(day_count);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);
		String formattedDate = mOdifiedDate.format(formatter);
		return formattedDate;
	}



	//Creation of New Discount Voucher 
	public void newDiscountVoucher()
	{
		String startdate, enddate;
		switchToTab(1);
		pause(3);
		clickByJse(VoucherSpec, "VoucherSpecs", "Y");
		pause(6);
		clickByJse(NewVoucherSpec, "NewVoucherSpec", "Y");
		pause(5);
		//change
		if(dataTable.getData("Vouchers", "type").contains("One- Time"))
		{
			clickByJse(Type, "Type", "Y");
			pause(5);
			selectOptionByVisibleText(Type,"Type", dataTable.getData("Vouchers", "type")); 
			pause(5);
			selectOptionByVisibleText(AssignmentMode,"AssignmentMode", "Mandatory");
		}
		else
		{
			clickByJse(Type, "Type", "Y");
			pause(5);
			selectOptionByVisibleText(Type,"Type", dataTable.getData("Vouchers", "type")); 
			//pause(5);
			//selectOptionByVisibleText(AssignmentMode,"AssignmentMode", "Not Allowed");
			pause(5);
			enterText(MaxNoOfRedemptions, "MaxNoOfRedemptions", dataTable.getData("Vouchers", "maxNoOfRedemptions"), "Y");
			pause(5);
			enterText(AllowedConsumptions, "AllowedConsumptions", dataTable.getData("Vouchers", "allowedCustomerConsumptions"), "Y");	
		}
		//change
		pause(5);
		enterText(NameBox, "NameBox", dataTable.getData("Vouchers", "voucherName"), "Y");
		pause(5);
		startdate = startDatenew();
		enterText(NDstartdate, "NDstartdate", startdate, "Y"); 
		pause(5);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.TAB);
		enddate = endDatenew(7);
		pause(5);
		clickByJse(driver.findElement(By.xpath("//textarea[@class='nc-memo-field']")), "description", "Y");
		pause(5);
		enterText(NDenddate, "NDenddate", enddate, "Y");
		pause(5);
		hoverAndClickElement(ActionOffering, ActionOffering, 5);
		enterText(ActionOffering, "ActionOffering", dataTable.getData("Vouchers", "offeringName"), "Y");
		pause(5);
		driver.findElement(ActionOffering).sendKeys(Keys.TAB);
		//pause(5);
		//selectOptionByVisibleText(AssignmentMode,"AssignmentMode", "Mandatory");  
		pause(5);
		if(!dataTable.getData("Vouchers", "amount").equalsIgnoreCase("NA")) {
			enterText(Amount, "Amount", dataTable.getData("Vouchers", "amount"), "Y");
		}
		pause(5);
		selectOptionByVisibleText(Channel,"Channel", "Voice");
		clickByJse(PlusSign, "plussign", null);
		pause(5);
		selectOptionByVisibleText(Channel,"Channel", "E-comm");
		clickByJse(PlusSign, "plussign", null);
		pause(5);
		//selectOptionByVisibleText(Channel,"Channel", "MyO2 app");
		//clickByJse(PlusSign, "PlusSign", null);
		//pause(5);
		selectOptionByVisibleText(Channel,"Channel",  "O2 owned stores");
		clickByJse(PlusSign, "PlusSign", null);
		pause(5);
		clickByJse(NDCreate, "Create", null);
		pause(5);	
		report.updateTestLog("New Discount Voucher","Discount Voucher  is created", Status.PASS);
	}


	//Creation of Standalone Vouchers
	public void standAloneVoucher()
	{
		String SVStartDate,SVEndDate;
		clickByJse(StandaloneVoucher, "StandaloneVoucher", "Y"); 
		pause(5);
		clickByJse(NewStandaloneVoucher, "NewStandaloneVoucher", "Y");
		pause(5);
		enterText(NSNameBox, "NSNameBox", dataTable.getData("Vouchers", "voucherName"), "Y");
		pause(5);
		enterText(DiscountVoucherSpec, "DiscountVoucherSpec", dataTable.getData("Vouchers", "voucherName"), "Y"); 
		pause(5);
		driver.findElement(DiscountVoucherSpec).sendKeys(Keys.TAB);
		pause(2);
		//		waitScrollAndClickJs(15, SerialNumber, "SerialNumber", "Y");
		//		pause(5);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.TAB);
		enterText(SerialNumber, "SerialNumber", dataTable.getData("Vouchers", "serialNumber") + RandomStringUtils.randomAlphabetic(3)+RandomStringUtils.randomNumeric(3) , "Y");  //change
		pause(5);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.TAB);
		SerialNo = getAttribute(driver.findElement(SerialNumber), "value");
		dataTable.putData("Vouchers", "voucherCode", SerialNo );
		System.out.println("SerialNo is " + SerialNo);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.TAB);
		SVStartDate = endDatenew(1);
		enterText(SVstartdate, "SVstartdate", SVStartDate, "Y"); 
		pause(5);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.TAB);
		SVEndDate = endDatenew(2);
		enterText(SVenddate, "SVenddate", SVEndDate, "Y");
		pause(5);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.TAB);
		clickByJse(SVcreate, "Create", "Y");
		report.updateTestLog("Standalone Voucher","Standalone Voucher is created", Status.PASS);
		pause(5);
	}

	public void activateVoucher()
	{
		//hoverAndClickElement(VoucherSpecFilter, VoucherSpecFilter, 5);
		hoverAndClickElement(SerialNumberFilter, SerialNumberFilter, 5);
		pause(5);
		enterText(ContainsBox, "ContainsBox", SerialNo, "Y");
		pause(5);
		//By checkbox = By.xpath("//label[text()='"+dataTable.getData("Vouchers","voucherName")+"']");
		//By checkbox = By.xpath("//label[text()='Select All']");
		//hoverAndClickElement(checkbox, checkbox, 5);
		//pause(5);
		hoverAndClickElement(Apply, Apply, 5);
		pause(2);
		By ClickVoucherLink = By.xpath("//div[text()='"+SerialNo+"']//preceding::a[text()='"+dataTable.getData("Vouchers", "voucherName")+"'][2]");
		scrollIntoView(ClickVoucherLink);
		clickByJse(ClickVoucherLink, "ClickVoucherLink", "Y");
		pause(5);
		clickByJse(ActivateButton, "ActivateButton", "Y");
		pause(5);
		clickByJse(ConfirmButton, "ConfirmButton", "Y");
		pause(5);
		String active = r_getText(Active);
		if(active.equals("ACTIVE"))
		{
			report.updateTestLog("Activation","Created Voucher is active", Status.PASS);	
		}
		else
		{
			report.updateTestLog("Activation","Created Voucher is not active", Status.FAIL);
		}


	}

}


