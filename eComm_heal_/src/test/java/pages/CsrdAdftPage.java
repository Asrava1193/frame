package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.cognizant.framework.VMOReusableLibrary;

public class CsrdAdftPage extends VMOReusableLibrary
{
	public CsrdAdftPage(ScriptHelper scriptHelper) 
	{
		super(scriptHelper);
	}

	//******************locators********************
	//CSRD Login page
	private static final By lanId = By.id("user");
	private static final By password = By.id("pass");
	private static final By loginButton = By.xpath("//input[@value='Log In']");
	private static final By loginNtBtn = By.xpath("//input[@value='Log on as NT user']");
	private static final By lanID = By.id("loginSearchUserTextBox");
	private static final By searchBtn = By.xpath("//*[@id='loginSearchUserBtn']/span/mat-icon/i");
	private static final By lanPwd = By.id("password");
	private static final By submitBtn = By.id("appSubmitButton");

	//CSRD Home page
	private static final By quickCreate = By.xpath("(//a[contains(text(),'Quick Create')])");
	private static final By residentialCustomer = By.xpath("//*[text()='Residential Customer']");
	private static final By emailBox = By.id("email");
	private static final By continueBtn = By.id("btn");

	//New Customer page
	private static final By titleFieldDD = By.xpath("//div[contains(@id,'ui-id')]//td[contains(@title,'Title')]//select");
	private static final By firstNameField = By.xpath("//div[contains(@id,'ui-id')]//td[contains(@title,'First Name')]//input");
	private static final By lastNameField = By.xpath("//div[contains(@id,'ui-id')]//td[contains(@title,'Last Name')]//input");
	private static final By mobileContainer = By.xpath("//select[@class='jbss_list_box']/parent::td/following-sibling::td[1]/div");
	private static final By mobileField = By.xpath("//select[@class='jbss_list_box']/parent::td/following-sibling::td[1]/div/input");
	private static final By yearDDInCalender = By.xpath("//div[contains(@id,'ui-id')]//td[contains(@title,'Birth')]//input");	
	private static final By addAddressButton = By.xpath("//*[@title='Address Lookup']");	
	private static final By postCodeField = By.xpath("//div[text()='Postcode']/following-sibling::div//input");
	private static final By bldngNumField = By.xpath("//div[text()='Building Name/Number']/following-sibling::div//input");
	private static final By addressLookUpBtn = By.xpath("//button[text()='Address Lookup']");
	private static final By addressDropdown = By.xpath("//select[@class='gwt-ListBox nc-field-list-value nc-field-container']");
	private static final By cnfrmAddressBtn = By.xpath("//*[text()='Confirm Address']");
	private static final By checkbox = By.xpath("(//input[@type='checkbox'])[2]");
	private static final By createBtn = By.xpath("(//button[contains(text(),'Create')])[2]");

	//Payment mandate page
	private static final By billingAcct = By.xpath("(//a[text()='Billing Accounts'])[2]");
	private static final By newBillingAccountButton = By.xpath("//button[text()='New Pay Monthly Billing Account']");
	private static final By createAcct = By.xpath("//button[contains(text(),'Create')]");
	private static final By confirmAcct = By.xpath("//button[contains(text(),'Confirm')]");
	private static final By paymentInstrument = By.xpath("//button[contains(text(),'New Payment Instrument')]");
	private static final By sortCode = By.xpath("//div[text()='Sort Code']/following-sibling::div//input");
	private static final By bankAccountNumber = By.xpath("//div[text()='Bank Account Number']/following-sibling::div//input");
	private static final By bankAccountName = By.xpath("//div[text()='Bank Account Holder']/following-sibling::div//input");	
	private static final By createPaymentInstrument = By.xpath("//button[contains(text(),'Create')]");
	private static final By confirmPaymentInstrument = By.xpath("//button[text()='Confirm']");
	private static final By setupPayment = By.xpath("//button[text()='Set up Payment Mandate']");
	private static final By createPaymentMandate = By.xpath("//button[contains(text(),'Create')]");
	private static final By mandateCheckbox = By.xpath("//span[@class='mandatecheck__labels']/input[contains(@id,'gwt-uid')]");

	//Device Selection page
	private static final By placeOrder = By.xpath("//button[text()='Place Order']");
	private static final By distributionChanel = By.xpath("(//*[@class='refsel_input'])[1]");
	//private static final By campaignInput = By.xpath("(//*[@class='refsel_input'])[2]");
	private static final By campaignInput = By.xpath("(//*[contains(@class,'refsel_input ')])"); 
	private static final By createNewOrder = By.xpath("//button[contains(text(),'Create')]");
	private static final By nextButton = By.xpath("//a[contains(text(),'Next')]");
	private static final By previousButton = By.xpath("//a[contains(text(),'Previous')]");
	private static final By equipmentList = By.xpath("//div[@class='tab_filter tab_filter-hardware tab_filter-equipment']/ul/li/a");
	private static final By deviceSearch = By.cssSelector(".hw-search-filter__search-input input");
	private static final By phoneSearch = By.xpath("//span[contains(text(),'Phones')]");
	private static final By deactivationText = By.xpath("//*[text()=' There are no such offerings found. ']");


	//Payment and delivery selection page
	private static final By ddl_saleType = By.xpath("//div[@class='characteristicValues equipment_value_element']/span/select");
	private static final By btn_ok = By.xpath("//*[@role='toolbar']//*[text()='OK']");
	private static final By txt_upfrontGbp = By.xpath("//table[@class='parameters']/tbody/tr[2]/td[2]/div/span/span/input");
	private static final By txt_months = By.xpath("//table[@class='parameters']/tbody/tr[3]/td[2]/div/span/span/input");
	private static final By nonRecurringCharge = By.xpath("//div[@class='roe-widget-content contracts__button_disabled']/table/tbody/tr/td[2]/div");
	private static final By clickAndCollect = By.xpath("//*[text()='Click and Collect']");
	private static final By collectionStore = By.xpath("//*[contains(text(),'Collection Store')]");
	private static final By collectionStoreText = By.xpath("//label[contains(text(),'Collection Store')]/parent::td/following-sibling::td/div/div/div/div/input");


	//Special Features page
	private static final By regularPhoneNumber = By.xpath("//*[contains(text(),'Regular Phone Number ')]");
	private static final By phoneNumberText = By.xpath("//label[contains(text(),'Regular Phone Number')]/parent::td/following-sibling::td/child::div/span/div/div/div[@class='refsel_single']/child::input");
	private static final By phoneNumberDropdown = By.xpath("(//*[@class='refsel_list_label']/following-sibling::div)[1]");
	private static final By spendCap = By.xpath("//*[text()='Spend Cap Value']/parent::td/following-sibling::td//select");
	private static final By allowanceBundleDropdown = By.xpath("//*[text()='Allowance Bundle']/parent::td/following-sibling::td/div/div/span/select");
	private static final By allowancePriceLink = By.xpath("//span[text()='Allowance Price']");
	private static final By allowanceClose = By.xpath("(//button[text()='Close'])[2]");
	private static final By allowancePerksLink = By.xpath("//span[text()='Available Perks']");
	private static final By allowancePerksClose = By.xpath("//div[@class='close-icon-btn']");
	private static final By opalExtrasList = By.xpath("//table[@summary='Ingrid Mode']/tbody/tr");
	private static final By btn_show = By.xpath("//span[@class='collapsed']/span");
	private static final By reserveLink = By.cssSelector(".roe-hardware-area-reserve");
	private static final By removeButton = By.xpath("(//*[text()='Remove'])[1]");
	private static final By deviceTier = By.xpath("(//*[@class='bulkTreeItem bulkTreeItemRoeTreeItem'])[1]");
	private static final By allowanceBundleDropdownOption = By.xpath("//*[text()='Allowance Bundle']/parent::td/following-sibling::td/div/div/span/select/option");
	private static final By lbl_price = By.xpath("//div[@class='roe-widget-content contracts__button_disabled']/table/tbody/tr/td[3]");
	private static final By ddl_insureFullCoverTermAndConditions = By.xpath("//div[@class='characteristicValues characteristic-invalid-change']/span/select");
	private static final By extendedWarranty = By.xpath("//label[contains(text(),'Extended Warranty Term')]");
	private static final By standardPlan = By.xpath("//div[@class='roe-widget-content contracts__button_disabled']/table/tbody/tr/td[1]/span");
	private static final By standardPrice = By.xpath("//div[@class='roe-widget-content contracts__button_disabled']/table/tbody/tr/td[2]/div");


	//Discount and Eligibility Check page
	private static final By eligibiltyCheckButton = By.xpath("//button[text()=' Eligibility Check ']");
	private static final By eligibiltyCheckDropdowns = By.xpath("//h3[text()='Eligibility checker ']/parent::div//select");
	private static final By confirmAndContinueButton = By.xpath("//button[text()='Confirm and continue']");
	private static final By lbl_upfrontDiscount = By.xpath("//span[contains(@class,'roe-table-cell roe-table-body-title')]/span[contains(text(),'Upfront Discount')]");
	private static final By UpfrontDiscountreasonselect = By.xpath("//select[contains(@id,'listCharacteristicsSelect_9158369203265231')]");
	private static final By txt_specialCode = By.xpath("//div[@class='characteristicValues characteristic-invalid-change']/input");
	private static final By txt_justification = By.xpath("//*[text()='Justification']/parent::td/following-sibling::td/div/input");
	private static final By txt_upfrontDiscount = By.xpath("//span[@class='ui-spinner ui-corner-all ui-widget ui-widget-content input-errorHighlight']/input");
	private static final By upfrontDiscountCharge = By.xpath("//span[text()='Discounts']/parent::td/following-sibling::td[contains(@class,'nrc')]");
	private static final By discountTxtField = By.xpath("//span[@class='ui-spinner ui-corner-all ui-widget ui-widget-content']/input[@aria-required='true']");
	private static final By discountReason = By.xpath("//label[text()='Discount Reason']");


	//Interaction Description page
	private static final By interactionDescription = By.cssSelector(".nc-interaction.nc-interaction-submit.notes-textarea");
	private static final By orderParametersBlock = By.cssSelector(".order-configuration-block__sh-button._hidden");
	private static final By scriptLink = By.xpath("//*[contains(@id,'listCharacteristicsSelect_') and contains(@id,'_script')] ");
	private static final By readTheScriptConfirmation = By.id("listCharacteristicsSelect_9158507778513980661");
	private static final By readTheScriptCompliance = By.id("listCharacteristicsSelect_9163234162213012232");
	private static final By selectJourneyType = By.xpath("//div[@class='characteristicValues']//div//span//select[1]");
	private static final By selectProductType = By.xpath("//div[@class='characteristicValues']//div//span//select[2]");
	private static final By approveDiscount = By.xpath("//button[text()='Approve Discount']");
	private static final By usernameDiscount = By.xpath("//*[@data-placeholder='Username']");
	private static final By passwordDiscount = By.xpath("//*[@data-placeholder='Password']");
	private static final By submitDiscount = By.xpath("//span[text()='Approve']");


	//Payments Details page
	private static final By cicsDocumentButton = By.xpath("//button[text()='Send CI/CS Documents']");
	private static final By continueAnywayButton = By.xpath("//*[text()='Continue anyway']");
	private static final By creditCheckButton = By.xpath("//button[text()='Credit Check']");
	private static final By paymentDetails = By.xpath("//a[contains(text(),'Payment Details')]");
	private static final By cardNumber = By.id("cardNumber");
	private static final By expiryDateInput = By.id("expiryDateMonthInput");
	private static final By expiryDateYear = By.id("expiryDateYearInput");
	private static final By cvv = By.id("csc");
	private static final By onlineValidationButton = By.id("pre-copyBtnMc");	
	private static final By ddl_newCardSelect = By.xpath("//*[text()=' Payment Instrument: ']/following-sibling::td/select");
	private static final By btn_newCard = By.xpath("//*[@class='payment-create-button']");
	private static final By application = By.xpath("//*[text()='Application']");
	private static final By checkboxes1 = By.xpath("(//input[@type='checkbox'])[2]");
	private static final By checkboxes2 = By.xpath("(//input[@type='checkbox'])[3]");


	//Credit check and Order confirmation page
	private static final By configureContract = By.xpath("//*[contains(text(),'Configure Contract')]");
	private static final By confirmAndContinueBtn = By.xpath("//*[contains(text(),'Confirm and continue')]");
	private static final By closeButton = By.xpath("//button[@class='ui-button ui-corner-all ui-widget']");
	private static final By contractLinks = By.cssSelector(".contract-element-link");
	private static final By acceptTheSimo = By.cssSelector(".nc-table-cell-checkbox");
	private static final By saveButton = By.xpath("(//button[contains(@class,'gwt-Button button_action_id_')])[1]");
	private static final By checkOutBtn = By.xpath("//button[contains(text(),'Check Out')]");
	private static final By submitButton1 = By.xpath("(//*[@value='Submit'])[1]");
	private static final By submitButton2 = By.xpath("(//*[@value='Submit'])[2]");
	private static final By customerName = By.xpath("//*[@class='customer-name csrd-tooltip-field']");
	private static final By resetButton = By.xpath("//*[text()='Reset']");
	private static final By orderConfirmation = By.xpath("//*[@class='roe-widget-header']/h1");
	private static final By paymentsButton = By.xpath("//button[text()='Payment']");
	private static final By otacText = By.id("otac");
	private static final By questionText = By.id("sqa");
	private static final By bankAccount = By.id("bankAccount");
	private static final By birth = By.id("birth");
	private static final By postcode = By.id("postcode");
	private static final By overRide = By.id("mandatoryOverride");


	private static final By expandplm = By.xpath("//*[@id='gen_menu_0']");
	private static final By productmanagement = By.xpath("//span[contains(text(),'Product Management')]");
	private static final By PLMManagement = By.xpath("//span[contains(text(),'PLM Management')]");
	private static final By rpipricetemplate = By.xpath("//a[contains(text(),'RPI Price Template')]");
	private static final By promoText = By.xpath("//div[contains(text(),'Claim')]");
	private static final By promoClose = By.xpath("//div[@class='close-icon-btn']");

	private static final By Voucher = By.xpath("//label[text()='Vouchers:']");
	private static final By VoucherAdd = By.xpath("//a[text()='+ Add']");
	private static final By VoucherCode = By.xpath("(//div[@class='voucher_form']//table//tbody//tr//input[contains(@id,'gwt-uid')])[1]");
	private static final By Apply = By.xpath("//a[text()='Apply']");
	private static final By MonthlyRecurringVoucherTotalPrice = By.xpath("//div[@class='roe-widget-content']//td[@class='roe-table-cell mrc summaryTotalBold']");
	private static final By NonRecurringVoucherTotalPrice = By.xpath("(//div[@class='roe-widget-content']//td[@class='roe-table-cell nrc'])[4]");
	private static final By Summary = By.xpath("//h1[text()='Summary']");


	private static final By offeringcode = By.xpath("//td/input[@class='gwt-TextBox nc-field-text-input']");
	private static final By offeringsearch = By.xpath("//div[@class='nc-toolbar-cell disable-border gwt-Button-wrapper button_action_id_9157107553913147671_9137007409413676336-wrapper TableCtrl-button-wrapper nc-search-button-wrapper']");
	private static final By TariffStartDateHeader = By.xpath("//span[text()='Tariff Start Date']");
	private static final By TariffEndDateHeader = By.xpath("//span[text()='Tariff End Date']");
	private static final By blankCheckboxInEnddateFilter= By.xpath("//label[text()='Blank']/parent::span/input");
	private static final By applyButtonInFilter = By.xpath("//button[text()='Apply']");
	private static final By valueColumn = By.xpath("//span[text()='Value']");
	private static final By defaultColumn = By.xpath("//span[text()='Default']"); 
	private static final By clearButton = By.xpath("(//button[text()='Clear'])[1]"); 
	private static final By flatOfferingresults = By.xpath("//*[@id='9157107424613147577']/div/div[4]/div[2]/table/tbody[1]/tr/td[3]/div/div/a/div"); 
	private static final By conditionSetNames = By.xpath("//*[@id='9157107424613147577']/div/div[4]/div[2]/table/tbody[1]/tr/td[4]/div/div/a");  
	private static final By tariffStartDates = By.xpath("//*[@id='9157107424613147577']/div/div[4]/div[2]/table/tbody[1]/tr/td[7]/div/div");  
	private static final By tariffEnddateColumnFilter = By.xpath("//img[@aria-label='Sorting and Filtering for Tariff End Date column']");   
	private static final By priceValues = By.xpath("//*[@id='9157107424613147577']/div/div[4]/div[2]/table/tbody[1]/tr/td[9]/div/div"); 

	static String parent = "";


	//declarations
	java.util.List<WebElement> l1=new ArrayList<WebElement>();
	VMOReusableLibrary Vmor = new VMOReusableLibrary(scriptHelper);

	//***************** Actions **********************

	//launching the CSRD application
	/*public void invokeApplicationCSRD() 
	{
System.out.println("test passed");
}*/
	
	
	
	public void invokeApplicationCSRD() 
	{
		String AdftEnvironment = properties.getProperty("AdftEnvironment");
		if(AdftEnvironment==null)
		{
			report.updateTestLog("The variable is null","Please give a URL", Status.FAIL);
			SHdriver.quit();
		}
		else
		{	
			SHdriver.get(getEnvironmentUrl(AdftEnvironment, "CSRD"));	
			report.updateTestLog("Url is launched successfully",getEnvironmentUrl(AdftEnvironment, "CSRD"), Status.PASS);
		}
	}	

	//Login with valid credentials
	/*public void loginCSRD()
	{
		craftFluentWait(lanId,5);
		if(dataTable.getData("General_Data", "Username").contains("uattestuser")) {
			enterText(lanId, "LAN ID", dataTable.getData("General_Data", "Username"), null);
			enterText(password, "Password", dataTable.getData("General_Data", "Password"), "Y");
			click(loginButton, "Login Button", null);
		}
		else {
			click(loginNtBtn, "Log on as NT user", "Y");
			craftFluentWait(lanID, 10);
			enterText(lanID, "Lan ID", dataTable.getData("General_Data", "Username"), "Y");
			click(searchBtn, "search Button", null);
			craftFluentWait(lanPwd, 10);
			enterText(lanPwd, "Password", dataTable.getData("General_Data", "Password"), "Y");
			click(submitBtn, "submitBtn", null);
			craftFluentWait(quickCreate, 15);
			report.updateTestLog("The Login is completed","Login", Status.PASS);
		}

	}*/
	
	public void loginCSRD()
	{
		//driver.getSelfHealingDriver().findElement(By.id("username")).sendKeys("hi");
		craftFluentWait(lanId,5);
		if(dataTable.getData("General_Data", "Username").contains("uattestuser1")) {
			enterText(lanId, "LAN ID", dataTable.getData("General_Data", "Username"), null);
			enterText(password, "Password", dataTable.getData("General_Data", "Password"), "Y");
			click(loginButton, "Login Button", null);
		}
		else {
			click(loginNtBtn, "Log on as NT user", "Y");
			craftFluentWait(lanID, 10);
			enterText(lanID, "Lan ID", dataTable.getData("General_Data", "Username"), "Y");
			click(searchBtn, "search Button", null);
			craftFluentWait(lanPwd, 10);
			enterText(lanPwd, "Password", dataTable.getData("General_Data", "Password"), "Y");
			click(submitBtn, "submitBtn", null);
			craftFluentWait(quickCreate, 15);
			report.updateTestLog("The Login is completed","Login", Status.PASS);
		}
 
	}


	//Email creation
	public void enteringMail() 
	{	
		pause(5);
		hoverAndClickElement(quickCreate, residentialCustomer, 5);
	    report.updateTestLog("Customer creation","Customer", Status.PASS);	
		craftFluentWait(emailBox,15);
		if(SHdriver.findElement(emailBox).isDisplayed())
		{
			enterText(emailBox, "emailBox", RandomStringUtils.randomAlphabetic(2)+"_"+RandomStringUtils.randomNumeric(2)+"_"+RandomStringUtils.randomAlphabetic(4)+"_"+RandomStringUtils.randomNumeric(4)
			+dataTable.getData("General_Data", "email"), "Y");
			click(continueBtn, "continue Button", null);	
		}
		else {
			report.updateTestLog("Entering e-mail is failed","E-mail", Status.FAIL);
		}
	}


	//Creating new customer
	public void residentialAccountPage() 
	{
		craftFluentWait(titleFieldDD,15);
		selectOptionByVisibleText(titleFieldDD, "titleFieldDD", dataTable.getData("General_Data", "title"));
		craftFluentWait(firstNameField,5);
		enterText(firstNameField, "firstNameField", dataTable.getData("General_Data", "firstName")+
				RandomStringUtils.randomAlphabetic(2)+RandomStringUtils.randomAlphabetic(3), null);
		craftFluentWait(lastNameField,5);
		enterText(lastNameField, "lastNameField", dataTable.getData("General_Data", "lastName")+
				RandomStringUtils.randomAlphabetic(3)+RandomStringUtils.randomAlphabetic(2), null);
		craftFluentWait(mobileContainer,5);
		click(mobileContainer, "mobileContainer", null);
		craftFluentWait(mobileField,5);
		enterText(mobileField, "mandatoryFiled", "07"+RandomStringUtils.randomNumeric(3)+
				RandomStringUtils.randomNumeric(3)+RandomStringUtils.randomNumeric(3), null);
		craftFluentWait(yearDDInCalender,5);
		enterText(yearDDInCalender, "yearDDInCalender", dataTable.getData("General_Data", "dob"), null);
		craftFluentWait(addAddressButton,5);
		click(addAddressButton, "addAddressButton", null);
		craftFluentWait(postCodeField,10);
		enterText(postCodeField, "postCodeField", dataTable.getData("General_Data", "postalCode"), null);
		craftFluentWait(bldngNumField,5);
		enterText(bldngNumField, "bldngNumField", RandomStringUtils.randomNumeric(3), null);
		craftFluentWait(addressLookUpBtn,5);
		click(addressLookUpBtn, "addressLookUpBtn", null);
		craftFluentWait(addressDropdown,30);
		selectByIndex(addressDropdown, "addressDropdown", 1);
		craftFluentWait(cnfrmAddressBtn,5);
		click(cnfrmAddressBtn, "cnfrmAddressBtn", "Y");
		craftFluentWait(checkbox,5);
		click(checkbox, "checkbox", null);
		pause(5);
		waitScrollAndClickJs(15,createBtn, "createBtn", "Y");
	}	


	//Payment mandate and Billing account
	public void createBillingAccount() 
	{
		pause(10);
		refresh();
		pause(5);
		waitScrollAndClickJs(10,billingAcct, "billingAcct", null);
		waitScrollAndClickJs(10,newBillingAccountButton, "newBillingAccountButton", null);
		craftFluentWait(createAcct,10);
		click(createAcct, "createAcct", null);
		pause(5);
		craftFluentWait(confirmAcct,10);     
		click(confirmAcct, "confirmAcct", "Y");
		craftFluentWait(paymentInstrument,10);
		click(paymentInstrument, "paymentInstrument", null);
		craftFluentWait(sortCode,10);
		enterText(sortCode, "sortCode", dataTable.getData("General_Data", "bankSortCode"), null);
		craftFluentWait(bankAccountNumber,10);
		enterText(bankAccountNumber, "bankAccountNumber", dataTable.getData("General_Data", "bankAccount"), null);
		craftFluentWait(bankAccountName,10);
		enterText(bankAccountName, "bankAccountName", dataTable.getData("General_Data", "name"), "Y");
		try
		{
			click(mandateCheckbox,"mandateCheckbox",null);
			click(createPaymentInstrument, "createPaymentInstrument", null);
			pause(15);
		}catch (Exception e) {
			click(createPaymentInstrument, "createPaymentInstrument", null);
			click(confirmPaymentInstrument, "confirmPaymentInstrument", "Y");
			pause(10);
			waitScrollAndClickJs(10,setupPayment, "setupPayment", null);
			craftFluentWait(createPaymentMandate,10);
			click(createPaymentMandate, "setupPayment", "Y");
			pause(5);
		}

	}

	public void clickNext() {
		pause(5);
		craftFluentWait(nextButton,10);
		scrollIntoView(nextButton);
		mouseHover(nextButton, "nextButton", null);
		clickByJse(nextButton, "nextButton", null);		
	}


	//New Order creation
	public void placingOrder() 
	{
		craftFluentWait(placeOrder,20);
		click(placeOrder, "placeOrder", null);
		craftFluentWait(distributionChanel,10);
		pause(5);
		enterText(distributionChanel, "distributionChanel", "Voice and IVR", null);
		craftFluentWait(distributionChanel,5);
		pause(5);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.TAB);
		pause(5);
		craftFluentWait(campaignInput,10);
		pause(5);
		enterText(campaignInput, "campaignInput", "Customer Service", "Y");	
		pause(5);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.TAB);
		click(createNewOrder, "createNewOrder", "Y");
		pause(5);
		switchTo("iframe_roe");
	}



	public void selectingEquipment() 
	{
		pause(15);
		craftFluentWait(driver.findElements(equipmentList).get(0),30);
		for (WebElement addEquipment : driver.findElements(equipmentList)) {
			if (addEquipment.getText().equalsIgnoreCase(dataTable.getData("CSRD_E2E", "deviceSystem"))) {
				pause(10);
				waitScrollAndClickJs(15,addEquipment, "addEquipment", "Y");       
				break;
			}
		}
	}


	public void validatePromo()
	{
		By promoClick = By.xpath("//div[text()='"+ dataTable.getData("CSRD_E2E", "deviceName")+"']/following::span[@role='button' and text()='Promo']");
		pause(5);
		try {
			scrollIntoView(promoClick);
			waitScrollAndClickJs(15, promoClick,"promoClick" ,"Y");
		}catch(Exception e) {
			report.updateTestLog("GWP","The Promo is Not Enabled", Status.FAIL);
		}
		pause(2);
		if(getListOfElements(promoClick).size()==0) {
			report.updateTestLog("GWP","The Promos are not availble", Status.FAIL);
		}else {
			for(int i=0; i<=getListOfElements(promoText).size()-1;i++) {
				pause(2);
				report.updateTestLog("The List of Promos are",getListOfElements(promoText).get(i).getText(), Status.PASS);
			}
			click(promoClose, "promoClose", "N");
		}
	}


	//Selecting device type and delivery type
	public void validateDevicePrice() 
	{
		pause(15);
		if (dataTable.getData("CSRD_E2E", "deliveryType").equalsIgnoreCase("Click and Collect")) {
			waitScrollAndClickJs(15,clickAndCollect, "clickAndCollect", "Y");
		}
		pause(5);
		craftFluentWait(phoneSearch,15);
		By deviceType = By.xpath("//span[contains(text(),'" + dataTable.getData("CSRD_E2E", "deviceType") + "')]");
		waitScrollAndClickJs(15,deviceType, "deviceType", "Y");
		clickNext();	
		if (!dataTable.getData("CSRD_E2E", "deviceType").contains("Sim Only")) {	
			if (dataTable.getData("CSRD_E2E", "deliveryType").equalsIgnoreCase("Click and Collect")) {	
				if (dataTable.getData("CSRD_E2E", "deviceType").equalsIgnoreCase("Accessories")) {
					pause(10);
					clickNext();
				}			
				pause(10);
				craftFluentWait(collectionStoreText,20);
				scrollIntoView(collectionStoreText);			
				enterText(collectionStoreText, "collectionStoreText", "Leeds", null);
				pause(5);
				clickByJse(collectionStore, "collectionStore", null);
				pause(5);
				By collectionStoreDropdown = By.xpath("//*[@class='refsel_name'][contains(text(),'"+dataTable.getData("General_Data", "collectCode")+"')]");
				craftFluentWait(collectionStoreDropdown, 30);
				click(collectionStoreDropdown, "collectionStoreDropdown", "Y");
				if (dataTable.getData("CSRD_E2E", "deliveryType").equalsIgnoreCase("Click and Collect")
						&& dataTable.getData("CSRD_E2E", "deviceType").equalsIgnoreCase("Accessories")) {
					pause(5);
					waitScrollAndClickJs(15,previousButton, "previousButton", null);
				}else {
					pause(10);
					clickNext();
				}
			}
			try {			
				selectingEquipment();
			}catch (Exception e) {
				clickNext();
				selectingEquipment();
			}		
			pause(5);
			click(deviceSearch, "deviceSearch", null);
			enterText(deviceSearch, "deviceSearch", dataTable.getData("CSRD_E2E", "deviceName"), "Y");
			pause(5);
			if (dataTable.getData("CSRD_E2E", "deviceDeactivation").equalsIgnoreCase("Yes")){
				scrollIntoView(deactivationText);
				String deactivationTxt = r_getText(deactivationText);
				if(deactivationTxt.equals("There are no such offerings found.")) {
					report.updateTestLog("Deactivation of Device ","Device is Deactivated "+dataTable.getData("CSRD_E2E", "deviceName"), Status.PASS);
				}
				else {
					report.updateTestLog("Deactivation of Device ","Device is not Deactivated "+dataTable.getData("CSRD_E2E", "deviceName"), Status.FAIL);
				}
			}
			else if (dataTable.getData("CSRD_E2E", "deviceDeactivation").equalsIgnoreCase("NA")) {
				String devicePrice = "";
				By priceElement = By.xpath("//a[@aria-label='Add " + dataTable.getData("CSRD_E2E", "deviceName") + "']/parent::td/preceding-sibling::td[@class='sale equipment_price']/span");
				devicePrice = r_getText(priceElement);
				if (devicePrice.equals(dataTable.getData("CSRD_E2E", "devicePrice"))) {
					report.updateTestLog("Expected Device price "+dataTable.getData("CSRD_E2E", "devicePrice"),"Actual Device price is correct "+devicePrice, Status.PASS);			
				} else {
					if(!dataTable.getData("CSRD_E2E", "devicePrice").equals("NA")) {
						report.updateTestLog("Expected Device price "+dataTable.getData("CSRD_E2E", "devicePrice"),"Actual Device price is incorrect "+devicePrice, Status.FAIL);
					}
				}	
				if(dataTable.getData("CSRD_E2E","promoGWP").equalsIgnoreCase("Yes")) {
					pause(5);
					validatePromo();
				}
				By deviceName = By.xpath("//a[@aria-label='Add " + dataTable.getData("CSRD_E2E", "deviceName") + "']");
				waitScrollAndClickJs(15,deviceName, "deviceName", "Y");
				pause(10);	
			}
		}
	}


	public void validateAllowanceBundle() 
	{
		String allowanceBundle = "";
		String allowancePrice = "";
		if (dataTable.getData("CSRD_E2E", "allowance").equalsIgnoreCase("All Allowances")) {
			for (int i = 1; i < getListOfElements(allowanceBundleDropdownOption).size(); i++) {
				craftFluentWait(allowanceBundleDropdown, 25);
				selectByIndex(allowanceBundleDropdown, "allowanceBundleDropdown", i);
				pause(10);				
				allowancePrice = getListOfElements(lbl_price).get(0).getText();
				scrollIntoView(allowanceBundleDropdown);
				craftFluentWait(allowanceBundleDropdown, 10);
				allowanceBundle = getSelectedValue(allowanceBundleDropdown,"allowanceBundleDropdown");	
				report.updateTestLog("Allowance bundle is "+allowanceBundle,"Allowance Price is "+allowancePrice, Status.PASS);	
			}
		}
		if (dataTable.getData("CSRD_E2E", "allowance").contains("GB") || dataTable.getData("CSRD_E2E", "allowance").contains("Unlimited")) {
			craftFluentWait(allowanceBundleDropdown, 25);
			selectOptionByVisibleText(allowanceBundleDropdown, "allowanceBundleDropdown", dataTable.getData("CSRD_E2E", "allowance"));
			pause(30);
			waitScrollAndClickJs(15,allowancePriceLink, "allowancePriceLink", "Y");
			pause(10);
			report.updateTestLog("Allowance bundle","All Allowance Price", Status.PASS);
			waitScrollAndClickJs(15,allowanceClose, "allowanceClose", "Y");
			pause(10);
			allowancePrice = getListOfElements(lbl_price).get(0).getText();
			scrollIntoView(allowanceBundleDropdown);
			craftFluentWait(allowanceBundleDropdown, 10);
			allowanceBundle = getSelectedValue(allowanceBundleDropdown,"allowanceBundleDropdown");	
			report.updateTestLog("Allowance bundle is "+allowanceBundle, "allowance bundle selected", Status.DONE );
			if (allowancePrice.equals(dataTable.getData("CSRD_E2E", "allowancePrice"))) {
				report.updateTestLog("Expected Allowance price is "+dataTable.getData("CSRD_E2E", "allowancePrice"), "Actual Allowance price is correct " +allowancePrice, Status.PASS);			
			} else
				if(!dataTable.getData("CSRD_E2E", "allowancePrice").equals("NA")) {
					report.updateTestLog("Expected Allowance price is "+dataTable.getData("CSRD_E2E", "allowancePrice"), "Actual Allowance price is incorrect " +allowancePrice, Status.FAIL);
				}

		}
		if (!dataTable.getData("CSRD_E2E", "opalExtras").equalsIgnoreCase("NA")) {
			waitScrollAndClickJs(15,allowancePerksLink, "allowancePerksLink", "Y");
			pause(6);
			for (int i = 0; i < getListOfElements(opalExtrasList).size(); i++) {
				int count = i+1;
				String extraAllowance = driver.findElement(By.xpath("(//table[@summary='Ingrid Mode']/tbody/tr["+count+"]/td/div/div)[1]")).getText();
				if(extraAllowance.equals(allowanceBundle)) {
					pause(5);
					scrollIntoView(By.xpath("(//div[text()='" + extraAllowance + "'])[1]"));
					String opalExtraName = driver.findElement(By.xpath("(//table[@summary='Ingrid Mode']/tbody/tr["+count+"]/td/div/div)[2]")).getText();
					String opalExtraTerms = driver.findElement(By.xpath("(//table[@summary='Ingrid Mode']/tbody/tr["+count+"]/td/div/div)[3]")).getText();
					pause(5);
					//report.updateTestLog(extraAllowance+" _ "+opalExtraName,opalExtraTerms, Status.PASS);
					report.updateTestLog(extraAllowance+" - "+opalExtraName,opalExtraTerms, Status.DONE);
					report.updateTestLog("Opal extras ","Extras allowance ", Status.PASS);
					pause(5);
				}
			}
			waitScrollAndClickJs(15,allowancePerksClose, "allowancePerksClose", "Y");
		}
	}


	public void applyVouchers()
	{
		clickByJse(Voucher, "Voucher", "Y");
		pause(5);
		clickByJse(VoucherAdd, "VoucherAdd", "Y");
		pause(2);
		enterText(VoucherCode, "VoucherCode", dataTable.getData("CSRD_E2E", "voucherCode"), "Y");
		pause(5);
		clickByJse(Apply, "apply", "Y");
		pause(5);
		clickByJse(Voucher, "voucher", "Y");
		pause(5);
		hoverAndClickElement(Summary, Summary, 5);
		scrollIntoView(MonthlyRecurringVoucherTotalPrice);
		if(r_getText(MonthlyRecurringVoucherTotalPrice).contains(dataTable.getData("CSRD_E2E", "voucherDiscountPrice")))
		{
			report.updateTestLog("Expected Monthly Recurring Voucher Discount Price is "+dataTable.getData("CSRD_E2E", "voucherDiscountPrice"),"Actual Monthly Recurring Voucher Discount Price is correct "+r_getText(MonthlyRecurringVoucherTotalPrice), Status.PASS);
		}
		else if(r_getText(NonRecurringVoucherTotalPrice).contains(dataTable.getData("CSRD_E2E", "voucherDiscountPrice")))
		{
			report.updateTestLog("Expected Non-recurring Voucher Discount Price is "+dataTable.getData("CSRD_E2E", "voucherDiscountPrice"),"Actual Non-recurring Voucher Discount Price is correct "+r_getText(NonRecurringVoucherTotalPrice), Status.PASS);
		}
		else {
			report.updateTestLog("Voucher Discount Price","Voucher Discount Price is incorrect ", Status.FAIL);
		}
	}


	//Selecting sale type and CCA validations
	public void validateAllowanceAndCCA() 
	{
		if (!dataTable.getData("CSRD_E2E", "deviceType").contains("Sim Only")) {
			craftFluentWait(driver.findElements(ddl_saleType).get(0), 20);
			driver.findElements(ddl_saleType).get(0).click();
			new Select(driver.findElements(ddl_saleType).get(0)).selectByVisibleText(dataTable.getData("CSRD_E2E", "saleType"));
			pause(5);	
			report.updateTestLog("Sale type ","Sale type selected is "+dataTable.getData("CSRD_E2E", "saleType"), Status.PASS);
			waitScrollAndClickJs(15,btn_ok, "btn_ok", "Y");
			pause(5);	
			clickNext();
			pause(10);
		}
		if (dataTable.getData("CSRD_E2E", "saleType").equalsIgnoreCase("Standard Plan") || dataTable.getData("CSRD_E2E", "deliveryType").equalsIgnoreCase("Click and Collect") ||
				dataTable.getData("CSRD_E2E", "deviceType").equalsIgnoreCase("Accessories") || dataTable.getData("CSRD_E2E", "deviceType").contains("Sim Only")) {
			try {
				waitScrollAndClickJs(15,reserveLink, "reserveLink", "Y");
				pause(10);
				report.updateTestLog("Reservation ","Device is reserved", Status.PASS);
				clickNext();
				pause(10);
			}
			catch (Exception e) {
				e.getMessage();
				report.updateTestLog("Reservation ","Device can be reserved after selecting allowance ", Status.DONE);
			}
		}
		if (!dataTable.getData("CSRD_E2E", "standardTier").equalsIgnoreCase("NA")) {
			scrollIntoView(removeButton);				
			String standardTierName = r_getText(standardPlan);            
			if (standardTierName.contains(dataTable.getData("CSRD_E2E", "standardTier"))) {
				report.updateTestLog("Expected Standard device tier name is "+dataTable.getData("CSRD_E2E", "standardTier"),"Actual Standard device Tier name is correct"+standardTierName, Status.PASS);
			} else {
				report.updateTestLog("Expected Standard device tier name is "+dataTable.getData("CSRD_E2E", "standardTier"),"Actual Standard device Tier name is incorrect"+standardTierName, Status.FAIL);
			}
		}
		if (!dataTable.getData("CSRD_E2E", "deviceType").equalsIgnoreCase("Accessories")) {
			pause(25);
			if (!dataTable.getData("CSRD_E2E", "allowancePrice").equalsIgnoreCase("NA")) {
				validateAllowanceBundle(); 
			}
			else {
				waitScrollAndClickJs(30,allowanceBundleDropdown, "allowanceBundleDropdown", "Y");
				selectByIndex(allowanceBundleDropdown, "allowanceBundleDropdown", getListOfElements(allowanceBundleDropdownOption).size()-1);
			}
			pause(25);
			report.updateTestLog("Allowance bundle ","Allowance bundle selected ", Status.PASS);	
		}
		if (!dataTable.getData("CSRD_E2E", "standardPrice").equalsIgnoreCase("NA")) {
			String standardPlanPrice = r_getText(standardPrice);
			if (standardPlanPrice.equals(dataTable.getData("CSRD_E2E", "standardPrice"))) {
				report.updateTestLog("Expected Standard price "+dataTable.getData("CSRD_E2E", "standardPrice"),"Actual Standard price is correct "+standardPlanPrice, Status.PASS);			
			} else {
				report.updateTestLog("Expected Standard price "+dataTable.getData("CSRD_E2E", "standardPrice"),"Actual Standard price is incorrect "+standardPlanPrice, Status.FAIL);
			}
		}
		if (!dataTable.getData("CSRD_E2E", "deviceType").contains("Sim Only")) {
			waitScrollAndClickJs(25,btn_show, "btn_show", "Y");
			pause(20);
		}
		if(dataTable.getData("CSRD_E2E", "saleType").equalsIgnoreCase("Custom plan with CCA")) {		
			waitScrollAndClickJs(25,txt_upfrontGbp, "txt_upfrontGbp", "Y");
			String minAmount = getElement(txt_upfrontGbp).getAttribute("value");
			report.updateTestLog("CCA amount ","Minimum CCA amount  "+minAmount, Status.PASS);
			enterTextWithJSExecutor(txt_upfrontGbp, dataTable.getData("CSRD_E2E", "ccaMaxAmount"));
			pause(10);	
			driver.findElement(txt_upfrontGbp).sendKeys(Keys.ARROW_UP);
			pause(10);
			waitScrollAndClickJs(15,txt_upfrontGbp, "txt_upfrontGbp", "Y");
			pause(5);
			if (dataTable.getData("CSRD_E2E", "ccaMonth").equalsIgnoreCase("12") || dataTable.getData("CSRD_E2E", "ccaMonth").equalsIgnoreCase("36") 
					|| dataTable.getData("CSRD_E2E", "ccaMonth").equalsIgnoreCase("48")) {
				driver.findElement(txt_upfrontGbp).sendKeys(Keys.ARROW_UP);			
			} else if (dataTable.getData("CSRD_E2E", "ccaMonth").equalsIgnoreCase("3")) {
				driver.findElement(txt_upfrontGbp).sendKeys(Keys.ARROW_DOWN);
			}
			if (dataTable.getData("CSRD_E2E", "ccaMinmonth").equalsIgnoreCase("3")) {
				enterTextWithJSExecutor(txt_months, dataTable.getData("CSRD_E2E", "ccaMinmonth"));
				pause(3);
				driver.findElement(txt_months).sendKeys(Keys.ARROW_DOWN);	
				pause(3);
				String ccaminmonth = getElement(txt_months).getAttribute("value");
				if(ccaminmonth.equals(dataTable.getData("CSRD_E2E", "ccaMinmonth"))){
					report.updateTestLog("Expected Minimum CCA month is "+dataTable.getData("CSRD_E2E", "ccaMinmonth"), "Actual Minimum CCA month is correct "+ccaminmonth,  Status.PASS);
				}
				else{
					report.updateTestLog("Expected Minimum CCA month is "+dataTable.getData("CSRD_E2E", "ccaMinmonth"), "Actual Minimum CCA month is incorrect "+ccaminmonth,  Status.FAIL);
				}
			}
			if (dataTable.getData("CSRD_E2E", "ccaMonth").equalsIgnoreCase("12") || dataTable.getData("CSRD_E2E", "ccaMonth").equalsIgnoreCase("36") 
					|| dataTable.getData("CSRD_E2E", "ccaMonth").equalsIgnoreCase("48")) {
				enterTextWithJSExecutor(txt_months, dataTable.getData("CSRD_E2E", "ccaMonth"));
				pause(3);
				driver.findElement(txt_months).sendKeys(Keys.ARROW_UP);	
				pause(3);
				String ccamaxmonth = getElement(txt_months).getAttribute("value");
				if(ccamaxmonth.equals(dataTable.getData("CSRD_E2E", "ccaMonth"))){
					report.updateTestLog("Expected Maximum CCA month is  "+dataTable.getData("CSRD_E2E", "ccaMonth"), " Actual Maximum CCA month is correct "+ccamaxmonth , Status.PASS);
				}
				else {
					report.updateTestLog("Expected Maximum CCA month is  "+dataTable.getData("CSRD_E2E", "ccaMonth"), " Actual Maximum CCA month is incorrect "+ccamaxmonth , Status.FAIL);
				}
			}
			pause(10);
			scrollIntoView(getListOfElements(nonRecurringCharge).get(0));
			String maxAmount = getListOfElements(nonRecurringCharge).get(0).getText();
			String maxAmountexpected = "£" + dataTable.getData("CSRD_E2E", "ccaMaxAmount") + ".00";
			String minAmountexpected = dataTable.getData("CSRD_E2E", "ccaMinAmount") + ".00";
			if (maxAmount.equals(maxAmountexpected) && minAmount.equals(minAmountexpected)) {
				report.updateTestLog("Expected Minimum CCA amount is "+minAmountexpected + " Actual Minimum CCA amount is "+minAmount , "Expected Maximum CCA amount is "+maxAmountexpected + " Actual Maximum CCA amount is "+maxAmount , Status.PASS);
			} else {
				report.updateTestLog("Expected Minimum CCA amount is "+minAmountexpected + " Actual Minimum CCA amount is "+minAmount , "Expected Maximum CCA amount is "+maxAmountexpected + " Actual Maximum CCA amount is "+maxAmount , Status.FAIL);
			}
		} 
		if(dataTable.getData("CSRD_E2E", "saleType").equalsIgnoreCase("Sim Free Financing")) {		
			waitScrollAndClickJs(25,txt_upfrontGbp, "txt_upfrontGbp", "Y");
			driver.findElement(txt_upfrontGbp).sendKeys(Keys.ARROW_UP);
			pause(3);
			driver.findElement(txt_upfrontGbp).sendKeys(Keys.TAB);
			pause(10);	
			String ccaAmount = getElement(txt_upfrontGbp).getAttribute("value");
			waitScrollAndClickJs(25,txt_upfrontGbp, "txt_upfrontGbp", "Y");
			String ccaMaxAmountExpected = "£" + dataTable.getData("CSRD_E2E", "ccaMaxAmount") + ".00";
			String ccaMinAmountExpected = dataTable.getData("CSRD_E2E", "ccaMinAmount") + ".00";
			if (ccaAmount.equals(ccaMaxAmountExpected) && ccaAmount.equals(ccaMinAmountExpected)) {
				report.updateTestLog("Expected Minimum CCA amount is "+ccaMinAmountExpected + " Actual Minimum CCA amount is "+ccaAmount, "Expected Maximum CCA amount is "+ccaMaxAmountExpected + " Actual Maximum CCA amount is "+ccaAmount, Status.PASS);
			} else {
				report.updateTestLog("Expected Minimum CCA amount is "+ccaMinAmountExpected + " Actual Minimum CCA amount is "+ccaAmount, "Expected Maximum CCA amount is "+ccaMaxAmountExpected + " Actual Maximum CCA amount is "+ccaAmount, Status.FAIL);
			}
		}
		if (!dataTable.getData("CSRD_E2E", "voucherCode").equalsIgnoreCase("NA")) 
		{
			applyVouchers();
		}
	}


	//Selecting special features
	public void validateDeviceTier() {
		if (!dataTable.getData("CSRD_E2E", "deviceType").equalsIgnoreCase("Accessories")) {
			pause(20);
			craftFluentWait(spendCap, 30);
			scrollIntoView(spendCap);
			pause(20);
			selectOptionByVisibleText(spendCap, "spendCap", dataTable.getData("General_Data", "spendCap"));
			pause(15);			
			if (!dataTable.getData("CSRD_E2E", "deviceTier").equals("NA")) {
				scrollIntoView(removeButton);				
				String deviceTierName = r_getText(deviceTier);            
				if (deviceTierName.contains(dataTable.getData("CSRD_E2E", "deviceTier"))) {
					report.updateTestLog("Expected Device tier name is " +dataTable.getData("CSRD_E2E", "deviceTier"),"Actual Device Tier name is "+deviceTierName, Status.PASS);
				} else {
					report.updateTestLog("Expected Device tier name is " +dataTable.getData("CSRD_E2E", "deviceTier"),"Actual Device Tier name is "+deviceTierName, Status.FAIL);
				}
			}
			scrollIntoView(regularPhoneNumber);
			pause(10);
			craftFluentWait(phoneNumberText, 10);
			enterText(phoneNumberText, "phoneNumberText", "700", null);
			pause(10);
			clickByJse(regularPhoneNumber, "regularPhoneNumber", null);
			pause(10);
			craftFluentWait(phoneNumberDropdown, 30);
			click(phoneNumberDropdown, "phoneNumberDropdown", "Y");
			pause(15);
			waitScrollAndClickJs(15,regularPhoneNumber, "regularPhoneNumber", "Y");			
			pause(10);
			try {
				craftFluentWait(spendCap, 30);
				scrollIntoView(spendCap);
				pause(10);
				selectOptionByVisibleText(spendCap, "spendCap", dataTable.getData("General_Data", "spendCap"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public void validateInsuranceUpfrontDiscountWarranty() {
		if (!dataTable.getData("CSRD_E2E", "deviceType").equalsIgnoreCase("Accessories")) {
			if (!dataTable.getData("CSRD_E2E", "insuranceType").equals("NA")) {
				validateInsurance();
			}
			pause(10);
		}
		if (!dataTable.getData("CSRD_E2E", "discountAmount").equals("NA")) {
			validationUpfrontDiscount();
			pause(10);
		}
		if (!dataTable.getData("CSRD_E2E", "deviceType").equalsIgnoreCase("Accessories")) {
			if (!dataTable.getData("CSRD_E2E", "extendedWarranty").equals("NA")) {
				validateExtendedWarranty();
			}
		}
		//Accessories click next
		pause(10);
		clickNext();
		pause(5);
		if (!(dataTable.getData("CSRD_E2E", "saleType").equalsIgnoreCase("Standard Plan") || dataTable.getData("CSRD_E2E", "deliveryType").equalsIgnoreCase("Click and Collect") ||
				dataTable.getData("CSRD_E2E", "deviceType").equalsIgnoreCase("Accessories"))) {
			//			|| dataTable.getData("CSRD_E2E", "deviceType").contains("Sim Only")
			try {
				waitScrollAndClickJs(15,reserveLink, "reserveLink", "Y");
				pause(10);
				clickNext();
			}
			catch (Exception e) {
				e.getMessage();
				report.updateTestLog("Reservation","Device is already reserved", Status.DONE);
			}
		}
	}


	public void validateInsurance() {
		By insuranceType = By.xpath("//span[text()='" + dataTable.getData("CSRD_E2E", "insuranceType") + "']");
		String insuranceText = dataTable.getData("CSRD_E2E", "insuranceType")+" #";
		By insuranceSelected = By.xpath("//span[contains(text(),'" + insuranceText + "')]");
		waitScrollAndClickJs(35,insuranceType, "insuranceType", "Y");	
		try {
			pause(15);
			scrollIntoView(insuranceSelected);
			craftFluentWait(ddl_insureFullCoverTermAndConditions, 30);
			scrollIntoView(ddl_insureFullCoverTermAndConditions);
			selectByIndex(ddl_insureFullCoverTermAndConditions, "ddl_insureFullCoverTermAndConditions", 1);                
			report.updateTestLog("Insurance","Insurance is selected " +dataTable.getData("CSRD_E2E", "insuranceType"), Status.PASS);
		}catch(Exception e) {
			report.updateTestLog("Insurance","Insurance is not available ", Status.FAIL);
		}
	}


	public void validationUpfrontDiscount() {
		int num = getListOfElements(lbl_upfrontDiscount).size()-1;
		int index = 1;
		if(dataTable.getData("CSRD_E2E", "discountReason").equalsIgnoreCase("Loyalty")) {
			num = 0;
		}
		if(dataTable.getData("CSRD_E2E", "discountReason").contains("Company Owned")) {
			num = getListOfElements(lbl_upfrontDiscount).size()-2;
			index = 0;
		}
		waitScrollAndClickJs(15,getListOfElements(lbl_upfrontDiscount).get(num), "lbl_upfrontDiscount", "Y");
		pause(15);			
		waitScrollAndClickJs(15,getListOfElements(discountReason).get(num), "discountReason", null);
		pause(3);
		selectOptionByVisibleText(getListOfElements(UpfrontDiscountreasonselect).get(num), "UpfrontDiscountreasonselect", dataTable.getData("CSRD_E2E", "discountReason"));
		pause(20);	
		if(!dataTable.getData("CSRD_E2E", "discountReason").equalsIgnoreCase("Loyalty")) {
			try {
				scrollIntoView(txt_specialCode);
				enterText(txt_specialCode, "txt_specialCode", dataTable.getData("General_Data", "discountCode"), "Y");			
				waitScrollAndClickJs(15,getListOfElements(txt_justification).get(index), "txt_justification2", null);
				pause(10);
				enterText(getListOfElements(txt_justification).get(index), "txt_justification", "test", "Y");
				pause(10);
			}
			catch (Exception e) {
				e.getMessage();
			}
		}
		waitScrollAndClickJs(15,txt_upfrontDiscount, "txt_upfrontDiscount", null);
		pause(10);	
		enterText(txt_upfrontDiscount, "txt_upfrontDiscount", "0.001", "Y");
		pause(5);
		driver.findElement(discountTxtField).sendKeys(Keys.TAB);
		pause(2);
		report.updateTestLog("Upfront Discount","Upfront Discount minimum limit is displayed ", Status.PASS);
		pause(5);
		enterText(txt_upfrontDiscount, "txt_upfrontDiscount", dataTable.getData("CSRD_E2E", "discountAmount"), "Y");
		pause(5);
		driver.findElement(discountTxtField).sendKeys(Keys.TAB);
		pause(10);
		scrollIntoView(upfrontDiscountCharge);	
		if(!dataTable.getData("CSRD_E2E", "discountReason").equalsIgnoreCase("Loyalty")) {
			waitScrollAndClickJs(15,getListOfElements(txt_justification).get(index), "txt_justification2", null);
			pause(10);
			enterText(getListOfElements(txt_justification).get(index), "txt_justification", "test", "Y");
			getListOfElements(txt_justification).get(index).sendKeys(Keys.TAB);
		}
		pause(10);
		int size = driver.findElements(discountTxtField).size();
		waitScrollAndClickJs(15,getListOfElements(discountTxtField).get(size-1), "discountTxtField", "Y");
		pause(5);
		driver.findElements(discountTxtField).get(size-1).sendKeys(Keys.ARROW_UP);
		pause(5);
		driver.findElements(discountTxtField).get(size-1).sendKeys(Keys.TAB);
		pause(2);
		scrollIntoView(upfrontDiscountCharge);	
		report.updateTestLog("Upfront Discount","Upfront Discount amount limit is displayed ", Status.PASS);
		pause(10);
		String upfrontDiscountAmount = r_getText(upfrontDiscountCharge).replaceAll("-", "");
		if (upfrontDiscountAmount.equals("£"+dataTable.getData("CSRD_E2E", "discountAmount"))) {
			report.updateTestLog("Expected Upfront Discount is "+("£"+dataTable.getData("CSRD_E2E", "discountAmount")),"Actual Upfront Discount amount is correct " +upfrontDiscountAmount, Status.PASS);
		}
		else {
			report.updateTestLog("Expected Upfront Discount is "+("£"+dataTable.getData("CSRD_E2E", "discountAmount")),"Actual Upfront Discount amount is incorrect " +upfrontDiscountAmount, Status.FAIL);
		}
	}					



	public void validateExtendedWarranty() {
		try {
			craftFluentWait(extendedWarranty, 20);
			scrollIntoView(extendedWarranty);
			String extWar = r_getText(extendedWarranty);			
			if (extWar.equals("Extended Warranty Term")) {
				report.updateTestLog("Extended warranty ","Extended warranty is available ", Status.PASS);            
			}
		}
		catch (Exception e) {
			e.getMessage();
			report.updateTestLog("Extended warranty ","Extended warranty is unavailable ", Status.FAIL);
		}
	}


	//Performing eligibility check
	public void eligibiltyCheck() {
		if (!dataTable.getData("CSRD_E2E", "saleType").equalsIgnoreCase("Sim Free Purchase")) {
			waitScrollAndClickJs(15,eligibiltyCheckButton, "eligibiltyCheckButton", "Y");
			pause(3);
			craftFluentWait(driver.findElements(eligibiltyCheckDropdowns).get(0), 10);
			scrollIntoView(driver.findElements(eligibiltyCheckDropdowns).get(0));
			selectByValue(driver.findElements(eligibiltyCheckDropdowns).get(0), "employmentStatus",  dataTable.getData("General_Data", "employmentStatus"));
			selectByValue(driver.findElements(eligibiltyCheckDropdowns).get(1), "personalAnnualIncome",  dataTable.getData("General_Data", "personalAnnualIncome"));
			selectByValue(driver.findElements(eligibiltyCheckDropdowns).get(2), "liveAtAddressPeriod",  dataTable.getData("General_Data", "liveAtAddressPeriod"));
			click(confirmAndContinueButton, "confirmAndContinueButton", "Y");
		}
		//Accessories click next
		clickNext();
		pause(20);
	}

	public void interactionDescription() {
		clickNext();
		pause(10);
		if (!(dataTable.getData("CSRD_E2E", "discountReason").equals("NA") || dataTable.getData("CSRD_E2E", "discountReason").equals("Loyalty"))) {
			waitScrollAndClickJs(15,approveDiscount, "approveDiscount", "Y");
			pause(10);
			switchTo("approvalIFrame");
			enterText(usernameDiscount, "usernameDiscount", dataTable.getData("General_Data", "Username"), null);
			enterText(passwordDiscount, "passwordDiscount", dataTable.getData("General_Data", "Password"), "Y");
			pause(5);
			waitScrollAndClickJs(15,submitDiscount, "submitDiscount", "Y");
			pause(5);
			driver.switchTo().defaultContent();
			pause(2);
			switchTo("iframe_roe");
		}
		scrollIntoView(interactionDescription);
		enterText(interactionDescription, "interactionDescription", dataTable.getData("General_Data", "description"), "Y");
		pause(5);
		waitScrollAndClickJs(15,orderParametersBlock, "orderParametersBlock", "Y");
		pause(5);
		waitScrollAndClickJs(15,scriptLink, "scriptLink", "Y");
		craftFluentWait(readTheScriptConfirmation, 5);
		pause(5);
		selectOptionByVisibleText(readTheScriptConfirmation, "readTheScriptConfirmation",  "Yes");
		scriptCheck();
	}	

	public void scriptCheck() {
		pause(5);
		craftFluentWait(selectJourneyType, 5);
		selectByIndex(selectJourneyType, "selectJourneyType", 1);
		pause(5);
		craftFluentWait(selectProductType, 5);
		selectByIndex(selectProductType, "selectProductType", 1);
		pause(5);
		craftFluentWait(readTheScriptCompliance, 5);
		pause(5);
		selectOptionByVisibleText(readTheScriptCompliance, "readTheScriptCompliance",  "Yes");
		pause(5);
	}


	//Performing credit check
	public void creditCheckPayments() {
		if (!dataTable.getData("CSRD_E2E", "saleType").equalsIgnoreCase("Sim Free Purchase")) {
			craftFluentWait(cicsDocumentButton, 20);
			waitScrollAndClickJs(25,cicsDocumentButton, "cicsDocumentButton", "Y");
			pause(10);
			waitScrollAndClickJs(25,creditCheckButton, "creditCheckButton", "Y");
			pause(8);
			try {
				waitScrollAndClickJs(25,continueAnywayButton, "continueAnywayButton", "Y");
			}catch (Exception e) {
				e.getMessage();
			}
			pause(15);
			waitScrollAndClickJs(25,paymentDetails, "paymentDetails", "Y");
			pause(5);
		}
		else if(dataTable.getData("CSRD_E2E", "deviceType").equalsIgnoreCase("Accessories")) {
			waitScrollAndClickJs(25,paymentsButton, "paymentsButton", "Y");
		}
		try {
			craftFluentWait(ddl_newCardSelect, 20);
			selectByIndex(ddl_newCardSelect, "ddl_newCardSelect", 1);
			craftFluentWait(btn_newCard, 20);
			clickByJse(btn_newCard, "btn_newCard", "Y");
		}catch (Exception e) {
			e.getMessage();
		}
		pause(5);
		switchTo("cardIFrame");
		enterText(cardNumber, "cardNumber", dataTable.getData("General_Data", "cardPan"), null);
		selectByValue(expiryDateInput, "expiryDateInput", dataTable.getData("General_Data", "cardExpiryMonth"));
		selectOptionByVisibleText(expiryDateYear, "expiryDateYear", dataTable.getData("General_Data", "cardExpiryYear"));
		enterText(cvv, "cvv", dataTable.getData("General_Data", "cardCvv"), null);
		waitScrollAndClickJs(15,onlineValidationButton, "onlineValidationButton", "Y");
		switchToDefault();
		switchTo("iframe_roe");
		pause(5);
		if (!dataTable.getData("CSRD_E2E", "saleType").equalsIgnoreCase("Sim Free Purchase")) {
			scrollIntoView(application);
			waitScrollAndClickJs(15,application, "application", "Y");
			pause(20);
			if(dataTable.getData("CSRD_E2E", "saleType").equalsIgnoreCase("Custom plan with CCA")) {
				craftFluentWait(confirmAndContinueBtn,15);
				scrollIntoView(confirmAndContinueBtn);
				clickByJse(checkboxes1, "checkboxes1", null);
				pause(2);
				clickByJse(checkboxes2, "checkboxes2", "Y");
			}
			waitScrollAndClickJs(15,confirmAndContinueBtn, "confirmAndContinueBtn", "Y");	
		}
		if (dataTable.getData("CSRD_E2E", "saleType").equalsIgnoreCase("Sim Free Purchase")) {
			waitScrollAndClickJs(25,closeButton, "closeButton", "Y");
		}
	}


	public void sign() {
		craftFluentWait(driver.findElements(contractLinks).get(2), 20);
		driver.findElements(contractLinks).get(2).click();
		pause(5);
		waitScrollAndClickJs(15,acceptTheSimo, "acceptTheSimo", "Y");
		pause(5);
		waitScrollAndClickJs(15,saveButton, "saveButton", "Y");
	}


	//Checkout and place order
	public void checkoutOrder() {
		if (!dataTable.getData("CSRD_E2E", "saleType").equalsIgnoreCase("Sim Free Purchase")) {
			pause(10);
			waitScrollAndClickJs(15,configureContract, "configureContract", "Y");
			pause(5);
			try {
				sign();
			}
			catch (Exception e) {
				report.updateTestLog("Error when checkout is clicked","Proceeding with work-around",Status.DONE);
				try {
					switchTo("Interface");
					securityCheck();
					switchTo("iframe_roe");
					sign();
				}
				catch(Exception e1){
					pause(5);
					switchToDefault();
					String parent = driver.getWindowHandle();
					clickByJse(customerName, "customerName", "Y");
					pause(10);
					switchToTab(1);
					securityCheck();
					driver.switchTo().window(parent);
					pause(5);
					switchTo("iframe_roe");
					waitScrollAndClickJs(15,resetButton, "resetButton", "Y");
					pause(5);
					scriptCheck();
					try {
						waitScrollAndClickJs(15,configureContract, "configureContract", "Y");
					} catch (Exception e2) {
						e.getMessage();
					}
					pause(10);
					sign();
				}
			}
		}
		pause(5);
		if (dataTable.getData("CSRD_E2E", "saleType").equalsIgnoreCase("Sim Free Purchase")) {
			waitScrollAndClickJs(15,driver.findElements(checkOutBtn).get(0), "checkOutBtn", "Y");
		}
		else {
			waitScrollAndClickJs(15,driver.findElements(checkOutBtn).get(1), "checkOutBtn", "Y");
		}
		pause(20);
		report.updateTestLog("Order compltion","Order is placed " +r_getText(orderConfirmation), Status.PASS);
		waitScrollAndClickJs(15, orderConfirmation, "orderConfirmation", "Y");
	}


	//Performing security check
	public void securityCheck() {
		try {
			craftFluentWait(otacText,15);
		}
		catch(Exception e) 
		{
			driver.switchTo().window(parent);
			clickByJse(customerName, "customerName", "Y");
			switchToTab(2);
			try {
				craftFluentWait(otacText,15);
			}catch(Exception e1) {
				switchToTab(1);
				craftFluentWait(otacText,15);
			}
		}
		scrollIntoView(otacText);
		try {
			waitScrollAndClickJs(15, overRide, "overRide", null);
			waitScrollAndClickJs(15,submitButton1, "submitButton1", null);
		}catch (Exception e) {
			enterText(otacText, "otacText", "1", null);
			waitScrollAndClickJs(15,submitButton1, "submitButton1", null);
			pause(5);
			craftFluentWait(questionText,15);
			enterText(questionText, "questionText", "1", null);
			enterText(bankAccount, "bankAccount", "1", null);
			enterText(birth, "birth", "1", null);
			enterText(postcode, "postcode", "1", null);
		}
		waitScrollAndClickJs(15,submitButton2, "submitButton2", "Y");
		pause(15);
	}


	public void navigatePlmForRpi() {
		waitScrollAndClickJs(15,expandplm, "expandplm", "Y");
		mouseHover(productmanagement, "productmanagement", "Y");
		hoverAndClickElement(PLMManagement, PLMManagement, 10);
		switchToTab(1);
		waitScrollAndClickJs(15,rpipricetemplate, "rpipricetemplate", "Y");
	}


	public void rpiPreCheck() throws ParseException {
		int count = 0;
		getListOfElements(offeringcode).get(0).sendKeys(dataTable.getData("CSRD_E2E", "offering"));
		waitScrollAndClickJs(15,offeringsearch, "offeringsearch", "Y");
		scrollIntoView(TariffEndDateHeader);
		clickByJse(tariffEnddateColumnFilter, "tariffEnddateColumnFilter", "Y");
		pause(10);
		String TariffStartDate = getListOfElements(tariffStartDates).get(0).getText();
		String SDate = TariffStartDate.substring(0, 10);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = simpleDateFormat.parse(SDate);
		Date date2 = simpleDateFormat.parse("01/04/2024");
		if (date1.compareTo(date2) < 0) {
			report.updateTestLog("Tariff start date is before the expected date", count+" Tariff start date " + SDate, Status.PASS);
		}
		if (date1.compareTo(date2) > 0) {
			report.updateTestLog("Tariff start date is after the expected date", count+" Tariff start date " + SDate, Status.FAIL);
		}
		if (date1.compareTo(date2) == 0) {
			report.updateTestLog("Tariff start date is on the same date", count+" Tariff start date " + SDate, Status.FAIL);
		}
		String PlanName = getListOfElements(flatOfferingresults).get(0).getText();
		if(PlanName.equals(dataTable.getData("CSRD_E2E", "flatOffering"))) {
			report.updateTestLog("Actual plan name is "+PlanName,"Expected plan name is "+dataTable.getData("CSRD_E2E", "flatOffering") , Status.PASS);
		}
		else {
			report.updateTestLog("Actual plan name is "+PlanName,"Expected plan name is "+dataTable.getData("CSRD_E2E", "flatOffering") , Status.FAIL);
		}
		String ConditionSetName = getListOfElements(conditionSetNames).get(0).getText();
		if(ConditionSetName.equals(dataTable.getData("CSRD_E2E", "conditionSet"))) {
			report.updateTestLog("Actual Condition Set is "+ConditionSetName,"Expected Condition Set is "+dataTable.getData("CSRD_E2E", "conditionSet") , Status.PASS);
		}
		else {
			report.updateTestLog("Actual Condition Set is "+ConditionSetName,"Expected Condition Set is "+dataTable.getData("CSRD_E2E", "conditionSet") , Status.FAIL);
		}	
		String priceValue = getListOfElements(priceValues).get(0).getText(); 
		if(priceValue.equals(dataTable.getData("CSRD_E2E", "price"))) {
			report.updateTestLog("Actual price Value is "+priceValue,"Expected Condition Set is "+dataTable.getData("CSRD_E2E", "price") , Status.PASS);
		} else {
			report.updateTestLog("Actual price Value is "+priceValue,"Expected Condition Set is "+dataTable.getData("CSRD_E2E", "price") , Status.FAIL);
		}
		waitScrollAndClickJs(15,clearButton, "clearButton", "Y");
	}


	public void rpiPostCheck() throws ParseException {
		getListOfElements(offeringcode).get(0).sendKeys(dataTable.getData("CSRD_E2E", "offering"));
		waitScrollAndClickJs(15,offeringsearch, "offeringsearch", "Y");
		for (int i = 0; i < getListOfElements(tariffStartDates).size(); i++) {
			if (getListOfElements(tariffStartDates).get(i).getText().contains(dataTable.getData("CSRD_E2E", "tariffStartDate"))) {
				String PlanName = getListOfElements(flatOfferingresults).get(0).getText();
				if(PlanName.equals(dataTable.getData("CSRD_E2E", "flatOffering"))) {
					report.updateTestLog("Actual plan name is "+PlanName,"Expected plan name is "+dataTable.getData("CSRD_E2E", "flatOffering") , Status.PASS);
				}
				else {
					report.updateTestLog("Actual plan name is "+PlanName,"Expected plan name is "+dataTable.getData("CSRD_E2E", "flatOffering") , Status.FAIL);
				}
				String ConditionSetName = getListOfElements(conditionSetNames).get(0).getText();
				if(ConditionSetName.equals(dataTable.getData("CSRD_E2E", "conditionSet"))) {
					report.updateTestLog("Actual Condition Set is "+ConditionSetName,"Expected Condition Set is "+dataTable.getData("CSRD_E2E", "conditionSet") , Status.PASS);
				}
				else {
					report.updateTestLog("Actual Condition Set is "+ConditionSetName,"Expected Condition Set is "+dataTable.getData("CSRD_E2E", "conditionSet") , Status.FAIL);
				}	

				String TariffStDate = getListOfElements(tariffStartDates).get(0).getText(); 
				if(TariffStDate.substring(0, 10).equals(dataTable.getData("CSRD_E2E", "tariffStartDate"))) {
					report.updateTestLog("Actual Tariff Start Date is "+ TariffStDate.substring(0, 10),"Expected Tariff Start Date is "+dataTable.getData("CSRD_E2E", "tariffStartDate") , Status.PASS);
				} else {
					report.updateTestLog("Actual Tariff Start Date is "+ TariffStDate.substring(0, 10),"Expected Tariff Start Date is "+dataTable.getData("CSRD_E2E", "tariffStartDate") , Status.FAIL);
				}

				String priceValue = getListOfElements(priceValues).get(0).getText(); 
				if(priceValue.equals(dataTable.getData("CSRD_E2E", "price"))) {
					report.updateTestLog("Actual price Value is "+priceValue,"Expected Condition Set is "+dataTable.getData("CSRD_E2E", "price") , Status.PASS);
				} else {
					report.updateTestLog("Actual price Value is "+priceValue,"Expected Condition Set is "+dataTable.getData("CSRD_E2E", "price") , Status.FAIL);
				}
			}
		}
	}
}
