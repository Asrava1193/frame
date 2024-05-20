package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VGs.BusinessFlow;
import com.aventstack.extentreports.Status;
import com.cognizant.framework.ExcelData;
import com.cognizant.framework.ExtentReport;
import com.cognizant.framework.Main;
import com.cognizant.framework.VMOReusableLibrary;

public class CSRD {

	private WebDriver driver = BusinessFlow.getDriver();
	public static String storeEmail = null;
	public static String firstName = null;
	public static String lastName = null;
	public static String ExternalReservationID = null;
	public static String ModelNo = null;
	public static String FulfillmentOrderNo = null;
	public static String ProductCode = null;

	public static String ProductDescription1 = null;
	public static String ProductDescription = null;
	public static String OrderID = null;
	public static int index1;

	// Constructor of the CSRD class page
	public CSRD() throws Exception {

		PageFactory.initElements(driver, this);

	}

	ExcelData readData = new ExcelData();

	// ** Reading Input Excel**///
	public void readDataExcel(int curriteration, int iteration) throws IOException, Exception {

		readData.readinputdata(curriteration, iteration);

	}

	// ** Writing Output Excel**///
	public void writeDataExcel() throws IOException, Exception {

		readData.Writeoutputdata();

	}

	// ** getting Current Url**//
	public String getCurrenturl() {
		String selectedurl = driver.getCurrentUrl().trim();
		return selectedurl;
	}

	VMOReusableLibrary Vmor = new VMOReusableLibrary();

	// Login page
	@FindBy(xpath = "//input[@value='Log on as NT user']")
	WebElement loginAsNTUserBtn;
	@FindBy(id = "loginSearchUserTextBox")
	WebElement lanID;
	@FindBy(xpath = "//*[@id='loginSearchUserBtn']/span/mat-icon/i")
	WebElement searchBtn;
	@FindBy(id = "password")
	WebElement lanPwd;
	@FindBy(id = "appSubmitButton")
	WebElement submitBtn;

	// Login As NTUser
	public void loginToCSRD() throws Exception {
		System.out.println("Logging to CSRD");

		Thread.sleep(5000);
		Vmor.r_click(loginAsNTUserBtn, "LoginAsNTUserBtn");
		Thread.sleep(8000);
		Vmor.r_enterText(lanID, readData.Username, "lanID");
		Thread.sleep(1000);
		searchBtn.click();
		Thread.sleep(5000);
		Vmor.r_enterText(lanPwd, readData.Password, "lanPwd");
		Thread.sleep(1000);
		Vmor.r_click(submitBtn, "SubmitBtn");
		Thread.sleep(5000);
	}

	// Create New Customer page
	@FindBy(xpath = "(//a[contains(text(),'Quick Create')])")
	WebElement quickCreate;
	@FindBy(xpath = "//span[text()='Residential Customer']")
	WebElement residentalCustomer;
	@FindBy(xpath = "//input[@id='email']")
	WebElement csedNewEmail;
	@FindBy(xpath = "//input[@id='confirm-email']")
	WebElement csedReenterNewEmail;
	@FindBy(xpath = "//button[contains(text(),' Continue')]")
	WebElement csrdNewContnBtn;

	public void CsrdnewLogin() throws Exception {
		System.out.println("Creating new user");

		Vmor.hoverAndClickElement(quickCreate, residentalCustomer, 5, "quickCreate, residentalCustomer ");
		Thread.sleep(2000);
		String randomEmail = RandomStringUtils.randomAlphanumeric(5);

		Vmor.r_enterText(csedNewEmail, "Testauto" + randomEmail + "@yopmail.com", "csedNewEmail");
		Thread.sleep(2000);
		Vmor.r_enterText(csedReenterNewEmail, "Testauto" + randomEmail + "@yopmail.com", "csedReenterNewEmail");
		Thread.sleep(2000);

		storeEmail = "Testauto" + randomEmail + "@yopmail.com";

		System.out.println(storeEmail);

		ExtentReport.log("email", "Email entered is " + storeEmail, Status.PASS);

		Vmor.r_click(csrdNewContnBtn, "CsrdNewContnBtn");
		Thread.sleep(8000);

	}

	// Customer New Details page
	@FindBy(xpath = "//select[contains(@class,'gwt-ListBox nc-field-list-value nc-field-container')]")
	WebElement csrdNewDetailsTitle;
	@FindBy(xpath = "(//input[@class='gwt-TextBox nc-field-text-input'])[17]")
	WebElement csrdNewDetailsFirstName;
	@FindBy(xpath = "(//input[contains(@aria-labelledby,'tfnukrccreateformwidget_')])[4]")
	WebElement csrdNewDetailsLastName;
	@FindBy(xpath = "(//img[@class='gwt-Image add-button nc-reference-selector-add-button'])")
	WebElement csrdNewAddressPlusBtn;
	@FindBy(xpath = "(//input[@class='gwt-TextBox nc-field-text-input'])[17]")
	WebElement csrdNewAddressPostCode;
	@FindBy(xpath = "(//input[contains(@aria-labelledby,'label_')])[2]")
	WebElement csrdNewAddressBldngNum;
	@FindBy(xpath = "(//button[contains(text(),'Create')])[2]")
	WebElement csrdNewAddressCreateBtn;
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement csrdNewAddressChkBox;
	@FindBy(xpath = "//input[@id='it_ploicy_screen']")
	WebElement rdBtnCustNotPrsnt;
	@FindBy(xpath = "//button[contains(text(),'Place Order')]")
	WebElement csrdNewPlaceOrderBtn;
	@FindBy(xpath = "//button[contains(text(),'Address Lookup')]")
	WebElement addressLookUpBtn;
//	@FindBy(xpath = "//option[contains(text(),'Bath Road')][2]")
//	WebElement lookedUpAddressValue;
	@FindBy(xpath = "//option[contains(text(),'0')][1]")
	WebElement lookedUpAddressValue;

	@FindBy(xpath = "//button[contains(text(),'Confirm Address')]")
	WebElement cnfrmAddressBtn;
	@FindBy(xpath = "//input[@class='gwt-TextBox nc-field-date-input']")
	WebElement enterDate;
	@FindBy(xpath = "//input[@class='gwt-TextBox jbss-empty-textbox jbss_text_box jbss_invalid_text_box'])[1]")
	WebElement mandatoryEmailField;
	@FindBy(xpath = "//input[contains(@class,'gwt-TextBox jbss-empty-textbox jbss_text_box')]")
	WebElement mandatoryMobileField;

	// Customer New Details Method

	public void csrdNewDetails() throws Exception {
		System.out.println("Enter New Details");
		// random name
		// create a string of all characters
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// create random string builder
		StringBuilder sb = new StringBuilder();
		// create an object of Random class
		Random random = new Random();
		// specify length of random string
		int length = 7;
		for (int i = 0; i < length; i++) {
			// generate random index number
			int index = random.nextInt(alphabet.length());
			// get character specified by index
			// from the string
			char randomChar = alphabet.charAt(index);
			// append the character to string builder
			sb.append(randomChar);
		}

		String randomString = sb.toString();
		firstName = randomString;
		lastName = "Last" + randomString;
		System.out.println("FName is: " + randomString);

		Thread.sleep(5000);
		Vmor.r_click(csrdNewDetailsTitle, "Title");
		Thread.sleep(2000);
		Vmor.selectByVisibleText(csrdNewDetailsTitle, "Mr", "csrdNewDetailsTitle");
		Thread.sleep(2000);
		Vmor.r_enterText(csrdNewDetailsFirstName, firstName, "csrdNewDetailsFirstName");
		Thread.sleep(2000);
		Vmor.r_enterText(csrdNewDetailsLastName, lastName, "csrdNewDetailsLastName");

		Thread.sleep(2000);
		Vmor.r_click(csrdNewAddressPlusBtn, "AddressPlusBtn");
		Thread.sleep(4000);
		Vmor.r_enterText(csrdNewAddressPostCode, readData.Postcode, "csrdNewAddressPostCode");
		Thread.sleep(2000);
		Vmor.r_enterText(csrdNewAddressBldngNum, readData.BuildingNumber, "csrdNewAddressBldngNum");
		Thread.sleep(2000);
		Vmor.r_click(addressLookUpBtn, "AddressLookUpBVtn");

		Thread.sleep(4000);
		Vmor.r_click(lookedUpAddressValue, "LookedUpAddressValue");

		Thread.sleep(2000);
		Vmor.r_click(cnfrmAddressBtn, "cnfrmAddressBtn");

		Thread.sleep(2000);
		Vmor.r_enterText(enterDate, "01/01/1995", "enterDate");
		Vmor.r_enterText(mandatoryMobileField, "07688887766", "mandatoryMobileField");

		Thread.sleep(2000);
		Vmor.r_click(csrdNewAddressChkBox, "csrdNewAddressChkBox");

		Thread.sleep(2000);
		Vmor.r_click(csrdNewAddressCreateBtn, "csrdNewAddressCreateBtn");

		Thread.sleep(8000);
	}
	// Billing And Mandate page

	@FindBy(xpath = "//button[@title='Expand (Alt+M)']")
	WebElement expandButton;
	@FindBy(xpath = "(//a[contains(text(),'Billing Accounts')])[1]")
	WebElement billingAccBtnInSideBar;
	@FindBy(xpath = "(//button[contains(text(),'New Pay Monthly Billing Account')])")
	WebElement newBillingAccBtnfromSideBar;
	@FindBy(xpath = "(//button[contains(text(),'Create')])")
	WebElement createBtnInBillingAcc;
	@FindBy(xpath = "(//button[contains(text(),'Confirm')])")
	WebElement continueBtnInBilling;
	@FindBy(xpath = "(//button[contains(text(),'New Payment Instrument')])")
	WebElement newPaymentInstrument;
	@FindBy(xpath = "(//input[@class='gwt-TextBox nc-field-text-input'])[1]")
	WebElement sortCodeInPaymentMandate;
	@FindBy(xpath = "//div[text()='Bank Account Number']//following-sibling::div//input")
	WebElement accNumInPaymentMandate;
	@FindBy(xpath = "//div[text()='Bank Account Holder']//following-sibling::div//input")
	WebElement accaNameInPaymentMandate;
	@FindBy(xpath = "//label[contains(text(),'Use as Payment Mandate for this Billing Account')]//..//child::input")
	WebElement chkbox1InPaymentMandate;
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement createBtnInPaymentMandate;

	// Billing And Mandate method

	public void billingAndMandate() throws Exception {

		System.out.println("Creating new billing acc and mandate");

		// creating billing account
		Thread.sleep(10000);
		Vmor.r_clickByJse(expandButton, "expandButton");

		Thread.sleep(6000);
		Vmor.r_click(billingAccBtnInSideBar, "billingAccBtnInSideBar");

		Thread.sleep(4000);
		Vmor.r_click(newBillingAccBtnfromSideBar, "newBillingAccBtnfromSideBar");

		Thread.sleep(4000);
		Vmor.r_click(createBtnInBillingAcc, "createBtnInBillingAcc");

		Thread.sleep(2000);
		Vmor.r_click(continueBtnInBilling, "continueBtnInBilling");

		Thread.sleep(20000);
		// creating payment instrument
		Vmor.r_click(newPaymentInstrument, "newPaymentInstrument");

		Thread.sleep(4000);
		Vmor.r_enterText(sortCodeInPaymentMandate, "201596", "sortCodeInPaymentMandate");

		Thread.sleep(4000);
		Vmor.r_enterText(accNumInPaymentMandate, "10207136", "accNumInPaymentMandate");

		Thread.sleep(4000);
		Vmor.r_enterText(accaNameInPaymentMandate, "test", "accaNameInPaymentMandate");

		Vmor.r_click(chkbox1InPaymentMandate, "chkbox1InPaymentMandate");

		Thread.sleep(2000);
		Vmor.r_click(createBtnInPaymentMandate, "createBtnInPaymentMandate");

		Thread.sleep(10000);

	}

	// New Order Page
	@FindBy(xpath = "//button[contains(@class,'placeOrderButton')]")
	WebElement orderButton;
	@FindBy(xpath = "(//input[contains(@id,'id_refsel')])[2]")
	WebElement DcChannelDropDown;
	@FindBy(xpath = "(//input[contains(@id,'id_refsel')])[4]")
	WebElement CampaignBar;
	@FindBy(xpath = "(//button[contains(text(),'Create')])")
	WebElement createButton;
	@FindBy(xpath = "//div[contains(@title,'Voice') and not(contains(@aria-selected,'true'))]")
	WebElement VoiceIVRopt;
	@FindBy(xpath = "//div[contains(@title,'Sales') and not(contains(@aria-selected,'true'))]")
	WebElement SalesAgentopt;

	// New Order Method
	public void creatingNewOrder() throws Exception

	{
		System.out.println("Creating new order");
		Vmor.r_click(orderButton, "orderButton");

		Thread.sleep(3000);

		Vmor.r_click(DcChannelDropDown, "DcChannelDropDown");

		Vmor.r_enterText(DcChannelDropDown, readData.CSRD_DcChannelName, "DcChannelDropDown");
		Thread.sleep(3000);
		Vmor.r_click(VoiceIVRopt, "VoiceIVRopt");

		// entering value in campaign Bar
		Thread.sleep(3000);

		Vmor.r_clickByJse(CampaignBar, "CampaignBar");

		Thread.sleep(3000);

		Vmor.r_enterText(CampaignBar, readData.CSRD_campaignName, "CampaignBar");
		Thread.sleep(3000);
		Vmor.r_click(SalesAgentopt, "SalesAgentopt");

		Thread.sleep(4000);

		// clicking on create button

		Vmor.r_clickByJse(createButton, "createButton");
		Thread.sleep(2000);
	}

	// Verify Order No. Page

	@FindBy(xpath = "//*[@id='iframe_roe']")
	WebElement iframeElement;
	@FindBy(xpath = "//span[contains(text(),'Order #')]")
	WebElement ordernumber;

	// Verify Order No. method
	public void verifyOrderNo() throws InterruptedException {

		Thread.sleep(25000);

		// now using the switch command
		driver.switchTo().frame(iframeElement);

		String txtNCOrder = ordernumber.getText();
		System.out.println("NC Order no : " + txtNCOrder);
		Thread.sleep(5000);
	}

	// Add Simo Plan Page
	@FindBy(xpath = "//span[contains(text(),'Sim Only Plan Handset 12 month 2')]")
	WebElement simonly12month2Plan;
	@FindBy(xpath = "(//span[contains(text(),'Sim Only Plan Handset 12 month 2')])[2]")
	WebElement simonly12month2PlanBulktree;
	@FindBy(xpath = "(//select[contains(@aria-describedby,'gwt-uid-')])[1]")
	WebElement allowanceBundle;
	@FindBy(xpath = "(//i[@class='refsel_arrow'])[2]")
	WebElement phoneNumArrowDD;
	@FindBy(xpath = "//div[@class='refsel_name' and not(contains(@role,'prese'))]")
	WebElement selectFirstPhnNum;
	@FindBy(xpath = "(//select[contains(@aria-describedby,'gwt-uid-')])[2]")
	WebElement spendCapDD;
	@FindBy(xpath = "//span[text()='Sim Only Plan Handset 12 month 1']")
	WebElement simonly12month1Plan;
	@FindBy(xpath = "(//span[contains(text(),'Sim Only Plan Handset 12 month 1')])[2]")
	WebElement simonly12month1PlanBulktree;
	@FindBy(xpath = "//span[@class='roe-table-cell roe-table-body-title']/span[contains(text(),'SIM Card')]")
	WebElement plasticSimRadiBtn;
	@FindBy(xpath = "//span[@class='roe-table-cell roe-table-body-title']/span[contains(text(),'eSIM')]")
	WebElement eSimRadiBtn;

	// Add Simo plan method
	public void addnewSimoPlan() throws InterruptedException, Exception {

		Thread.sleep(5000);
		System.out.println("Selecting simPlan");
		String current_url = getCurrenturl();

		if (current_url.contains("e2e3")) {

			// E2E3 Env
			WebElement selectSimPlan = driver.findElement(By.xpath("//span[text()='" + ExcelData.simPlanEnv3 + "']"));
			System.out.println(selectSimPlan);
			Vmor.r_clickByJseIfExists(selectSimPlan, "selectSimPlan");
			Thread.sleep(5000);
			WebElement simPlanBulkTree = driver
					.findElement(By.xpath("(//span[contains(text(),'" + ExcelData.simPlanEnv3 + "')])[2]"));

			Vmor.r_clickByJseIfExists(simPlanBulkTree, "simPlanBulkTree");
			System.out.println(simPlanBulkTree);
			Thread.sleep(3000);
		} else if (current_url.contains("e2e2")) {
			// E2E2 ENV

			WebElement selectSimPlan = driver.findElement(By.xpath("//span[text()='" + ExcelData.simPlanEnv2 + "']"));
			System.out.println(selectSimPlan);

			Vmor.r_clickByJseIfExists(selectSimPlan, "selectSimPlan");
			Thread.sleep(5000);
			WebElement simPlanBulkTree = driver
					.findElement(By.xpath("(//span[contains(text(),'" + ExcelData.simPlanEnv2 + "')])[2]"));
			System.out.println(simPlanBulkTree);

			Vmor.r_clickByJseIfExists(simPlanBulkTree, "simPlanBulkTree");
		} else if (current_url.contains("e2e")) {
			// E2E ENV
			WebElement selectSimPlan = driver.findElement(By.xpath("//span[text()='" + ExcelData.simPlanEnv1 + "']"));

			Vmor.r_clickByJseIfExists(selectSimPlan, "selectSimPlan");
			Thread.sleep(5000);
			WebElement simPlanBulkTree = driver
					.findElement(By.xpath("(//span[contains(text(),'" + ExcelData.simPlanEnv1 + "')])[2]"));

			Vmor.r_clickByJseIfExists(simPlanBulkTree, "simPlanBulkTree");
		}

	}

	// Select Allowance Bundle
	public void selectAllowanceBundle(String SpendCap) throws InterruptedException, Exception {
		Thread.sleep(5000);
		System.out.println("Selecting Allowance Bundle");

		Vmor.selectByVisibleText(allowanceBundle, readData.AllowanceBundle, "allowanceBundle");
		Thread.sleep(4000);
		Vmor.r_click(phoneNumArrowDD, "phoneNumArrowDD");
		Thread.sleep(6000);
		Vmor.hoverAndClickElement(selectFirstPhnNum, selectFirstPhnNum, 0, "selectFirstPhnNum");
		Vmor.r_clickByJseIfExists(selectFirstPhnNum, "selectFirstPhnNum");

		Thread.sleep(5000);
		Vmor.selectByVisibleText(spendCapDD, SpendCap, "spendCapDD");
		Thread.sleep(3000);
		Vmor.r_click(plasticSimRadiBtn, "plasticSimRadiBtn");
		Thread.sleep(5000);

	}

	// cafeyn extra's

	@FindBy(xpath = "//input[@aria-label='Cafeyn']")
	WebElement cafeynChkBx;
	@FindBy(xpath = "//select[@aria-label='Extra Type*' and not(contains(@class,'disabled'))]")
	WebElement cafeynExtraType;

	public void cafeynExtra() throws InterruptedException, Exception {

		Vmor.r_clickByJse(cafeynChkBx, "cafeynExtraChkBx");
		Thread.sleep(3000);
		Vmor.selectByVisibleText(cafeynExtraType, "Paid Only", "Extra Type");
		Thread.sleep(3000);
	}

	// Add 2SIMO Plan

	@FindBy(xpath = "//span[contains(text(),'Sim Only Plan Handset 24 month 2')]")
	WebElement simonly24month2Plan;
	@FindBy(xpath = "(//span[contains(text(),'Sim Only Plan Handset 24 month 2')])[2]")
	WebElement simonly24month2PlanBulktree;

	@FindBy(xpath = "//span[text()='Sim Only Plan Handset 24 month 5']")
	WebElement simonly24month5Plan;
	@FindBy(xpath = "(//span[contains(text(),'Sim Only Plan Handset 24 month 5')])[2]")
	WebElement simonly24month5PlanBulktree;

	public void add2SimoPlan() throws InterruptedException, Exception {

		Thread.sleep(5000);
		System.out.println("Selecting 2 simPlan");

		String current_url = getCurrenturl();

		if (current_url.contains("e2e3")) {

			// E2E3 Env
			WebElement selectSimPlan = driver.findElement(By.xpath("//span[text()='" + ExcelData.sim2PlanEnv3 + "']"));
			System.out.println(selectSimPlan);
			Vmor.r_clickByJseIfExists(selectSimPlan, "selectSimPlan");
			Thread.sleep(3000);
			WebElement simPlanBulkTree = driver
					.findElement(By.xpath("(//span[contains(text(),'" + ExcelData.sim2PlanEnv3 + "')])[2]"));

			Vmor.r_clickByJseIfExists(simPlanBulkTree, "simPlanBulkTree");
			System.out.println(simPlanBulkTree);
			Thread.sleep(3000);
		} else if (current_url.contains("e2e2")) {
			// E2E2 ENV

			WebElement selectSimPlan = driver.findElement(By.xpath("//span[text()='" + ExcelData.sim2PlanEnv2 + "']"));

			Vmor.r_clickByJseIfExists(selectSimPlan, "selectSimPlan");
			Thread.sleep(3000);
			WebElement simPlanBulkTree = driver
					.findElement(By.xpath("(//span[contains(text(),'" + ExcelData.sim2PlanEnv2 + "')])[2]"));

			Vmor.r_clickByJseIfExists(simPlanBulkTree, "simPlanBulkTree");
		} else if (current_url.contains("e2e")) {
			// E2E ENV
			WebElement selectSimPlan = driver.findElement(By.xpath("//span[text()='" + ExcelData.sim2PlanEnv1 + "']"));

			Vmor.r_clickByJseIfExists(selectSimPlan, "selectSimPlan");
			Thread.sleep(3000);
			WebElement simPlanBulkTree = driver
					.findElement(By.xpath("(//span[contains(text(),'" + ExcelData.sim2PlanEnv1 + "')])[2]"));

			Vmor.r_clickByJseIfExists(simPlanBulkTree, "simPlanBulkTree");
		}

	}

	/*
	 * 
	 * // Add Sim Only 12 Month Set Ultimate Test1
	 * 
	 * @FindBy(xpath =
	 * "//span[contains(text(),'Sim Only 12 Month Set Ultimate Test1')]") WebElement
	 * simonly12monthPlanUltimate;
	 * 
	 * @FindBy(xpath =
	 * "(//span[contains(text(),'Sim Only 12 Month Set Ultimate Test1')])[2]")
	 * WebElement simonly12monthPlanUltimateBulktree;
	 * 
	 * public void addnewSimoPlan_U() throws InterruptedException, Exception {
	 * 
	 * Thread.sleep(5000); String current_url = getCurrenturl();
	 * 
	 * if (current_url.contains("e2e3")) { // E2E3 Env
	 * Vmor.r_clickByJseIfExists(simonly12monthPlanUltimate,
	 * "simonly12monthPlanUltimate"); Thread.sleep(3000);
	 * 
	 * Vmor.r_clickByJseIfExists(simonly12monthPlanUltimateBulktree,
	 * "simonly12monthPlanUltimateBulktree"); Thread.sleep(3000); } else { // E2E2
	 * ENV Vmor.r_clickByJseIfExists(simonly12monthPlanUltimate,
	 * "simonly12month1Plan"); Thread.sleep(5000);
	 * Vmor.r_clickByJseIfExists(simonly12monthPlanUltimateBulktree,
	 * "simonly12month1PlanBulktree"); } Thread.sleep(5000);
	 * Vmor.selectByVisibleText(allowanceBundle, readData.AllowanceBundle,
	 * "allowanceBundle");// 10GB Ultimate, // Unlimited UK Minutes, // Unlimited UK
	 * Texts Thread.sleep(4000); Vmor.r_click(phoneNumArrowDD, "phoneNumArrowDD");
	 * Thread.sleep(6000); Vmor.hoverAndClickElement(selectFirstPhnNum,
	 * selectFirstPhnNum, 0, "selectFirstPhnNum");
	 * Vmor.r_clickByJseIfExists(selectFirstPhnNum, "selectFirstPhnNum");
	 * 
	 * Thread.sleep(3000); Vmor.selectByVisibleText(spendCapDD, "No Spend Cap",
	 * "spendCapDD"); Thread.sleep(3000); Vmor.r_click(plasticSimRadiBtn,
	 * "plasticSimRadiBtn"); Thread.sleep(5000);
	 * 
	 * }
	 * 
	 * // Simo Only Data Plan
	 * 
	 * @FindBy(xpath =
	 * "//span[contains(text(),'Sim Only Plan Data Only 12 month 1')]") WebElement
	 * SimOnlyPlanDataOnly12month1;
	 * 
	 * @FindBy(xpath =
	 * "(//span[contains(text(),'Sim Only Plan Data Only 12 month 1')])[2]")
	 * WebElement SimOnlyPlanDataOnly12month1Bulktree;
	 * 
	 * public void addnewSimoDataPlan() throws InterruptedException, Exception {
	 * 
	 * Thread.sleep(5000);
	 * 
	 * Vmor.r_clickByJseIfExists(SimOnlyPlanDataOnly12month1,
	 * "SimOnlyPlanDataOnly12month1"); Thread.sleep(3000);
	 * 
	 * Vmor.r_clickByJseIfExists(SimOnlyPlanDataOnly12month1Bulktree,
	 * "SimOnlyPlanDataOnly12month1Bulktree"); Thread.sleep(5000);
	 * 
	 * Vmor.selectByVisibleText(allowanceBundle, readData.AllowanceBundle,
	 * "allowanceBundle");// 20GB, 100 UK Texts Thread.sleep(4000);
	 * Vmor.r_click(phoneNumArrowDD, "phoneNumArrowDD"); Thread.sleep(6000);
	 * Vmor.hoverAndClickElement(selectFirstPhnNum, selectFirstPhnNum, 0,
	 * "selectFirstPhnNum"); Vmor.r_clickByJseIfExists(selectFirstPhnNum,
	 * "selectFirstPhnNum");
	 * 
	 * Thread.sleep(3000); Vmor.selectByVisibleText(spendCapDD, "No Spend Cap",
	 * "spendCapDD"); Thread.sleep(3000); Vmor.r_click(plasticSimRadiBtn,
	 * "plasticSimRadiBtn"); Thread.sleep(5000);
	 * 
	 * }
	 */

	// Sim Free Financing

	@FindBy(xpath = "//span[contains(text(),'Accessories')]")
	WebElement accessoriesInCsrd;
	@FindBy(xpath = "(//span[contains(text(),'Accessories')])[2]")
	WebElement selectaccessoryfromleftside;
	@FindBy(xpath = "//*[contains(text(),'Tablet and iPad Accessories')]")
	WebElement tabletAndIPadAccessories;
	
	public void addSmartKeyboard(String keyboard) throws Exception {
		System.out.println("Selecting SFF device");
		Thread.sleep(2000);
		Vmor.r_clickByJse(accessoriesInCsrd, "accessoriesInCsrd");
		Thread.sleep(5000);
		Vmor.r_clickByJse(selectaccessoryfromleftside, "selectaccessoryfromleftside");
		Thread.sleep(5000);
		Vmor.r_clickByJse(tabletAndIPadAccessories, "tabletAndIPadAccessories");
		Thread.sleep(5000);
		Vmor.r_click(searchFilterBox, "clickOnSearchBoxNew");
		Thread.sleep(5000);
		Vmor.r_enterText(searchFilterBox, keyboard, "Entered device");
		Thread.sleep(5000);
		WebElement selectedkeyboard = driver.findElement(
				By.xpath("//*[text()='" + keyboard + "']//..//following::td[@class='sale equipment_action']/a"));
		System.out.println(selectedkeyboard);
		Vmor.r_click(selectedkeyboard, "selectedphone");
		// Vmor.r_click(clickOnAddPhone, "clickOnAddPhone");
		Thread.sleep(5000);
		Vmor.selectByVisibleText(clickonSaleTypedropdown, "Sim Free Financing", "clickonSaleTypedropdown");

		Thread.sleep(1500);
		Vmor.r_click(clickOnOk, "clickOnOk");
		Thread.sleep(10000);
	}
	

	// Customer Info page

	@FindBy(xpath = "//a[contains(text(),'Customer Information')]")
	WebElement customerInfoTab;
	@FindBy(xpath = "//button[contains(text(),'Eligibility Check')]")
	WebElement eligibilityChkBtn;
	@FindBy(xpath = "(//td[@class='roe-table-cell'])[19]//child::select")
	WebElement customerInfoEmpStatusField;
	@FindBy(xpath = "(//td[@class='roe-table-cell'])[21]//child::select")
	WebElement customerInfoAnnualIncomeField;
	@FindBy(xpath = "(//td[@class='roe-table-cell'])[26]//child::select")
	WebElement customerInfoHowLongDoYouliveField;
	@FindBy(xpath = "//button[contains(text(),'Confirm and continue')]")
	WebElement customerInfoTabCntBtn;

	// Customer Info Method
	public void customerInfoPage() throws Exception

	{
		Thread.sleep(4000);
		System.out.println("Performing eligibility check");
		Vmor.r_click(customerInfoTab, "customerInfoTab");

		Thread.sleep(3000);
		Vmor.r_click(eligibilityChkBtn, "eligibilityChkBtn");

		Thread.sleep(6000);
		Vmor.selectByVisibleText(customerInfoEmpStatusField, "Employed", "customerInfoEmpStatusField");
		Thread.sleep(2000);
		Vmor.selectByVisibleText(customerInfoAnnualIncomeField, "£30,001-£40,000", "customerInfoAnnualIncomeField");

		Thread.sleep(2000);
		Vmor.selectByVisibleText(customerInfoHowLongDoYouliveField, "5 to 6 years",
				"customerInfoHowLongDoYouliveField");

		Thread.sleep(2000);
		Vmor.r_click(customerInfoTabCntBtn, "customerInfoTabCntBtn");

		Thread.sleep(8000);
		Vmor.r_clickByJseIfExists(closePopUp, "closePopUp");
	}

	// Review Order Page
	@FindBy(xpath = "//a[contains(@href,'review')]")
	WebElement review;
	@FindBy(xpath = "//textarea[contains(@class,'nc-interaction-submit')]")
	WebElement txtInterDesc;
	@FindBy(xpath = "//th[contains(text(),'Discounts')]")
	WebElement outsideDiscBtn;
	@FindBy(xpath = "//span[@class='order-configuration-block__sh-button _hidden'][text()='Order Parameters']")
	WebElement orderParaDD;
	@FindBy(xpath = "//a[contains(text(),'script')]")
	WebElement scriptLink;
	@FindBy(xpath = "//select[@aria-label='Order Value Characteristic Involvement*']")
	WebElement script1DD;
	@FindBy(xpath = "//select[@id='journey_type']")
	WebElement journeyTypeDD;
	@FindBy(xpath = "//select[@id='product_type']")
	WebElement productTypeDD;
	@FindBy(xpath = "//select[@aria-label='Compliance Script *']")
	WebElement script2DD;
	@FindBy(xpath = "//button[contains(text(),'Send CI/CS Documents')]")
	WebElement sendCICSDocsBtn;
	@FindBy(xpath = "//button[contains(text(),'Credit Check')]")
	WebElement creditCheckBtn;
	@FindBy(xpath = "//a[contains(text(),'Payment Details')]")
	WebElement paymentDetails;
	@FindBy(xpath = "//input[@id='cardName']")
	WebElement newCSRDCardName;
	@FindBy(xpath = "//input[@id='cardNumber']")
	WebElement newCsrdcardNumber;
	@FindBy(xpath = "//select[@id='expiryDateMonthInput']")
	WebElement newCsrdmonthField;
	@FindBy(xpath = "//select[@id='expiryDateYearInput']")
	WebElement newCsrdyearField;
	@FindBy(xpath = "//input[@id='csc']")
	WebElement newCsrdcvvField;
	@FindBy(xpath = "//button[@title='Register recurrent payment']")
	WebElement registerCardBtn;
//	@FindBy(xpath = "//*[@id='iframe_roe']")
//	WebElement frameElement;
	@FindBy(xpath = "//a[contains(text(),'Application')]")
	WebElement applicationTabInpopup;
	@FindBy(xpath = "//button[contains(text(),'Confirm and continue')]")
	WebElement cnfrmAndCntnBtnInPopup;
	@FindBy(xpath = "//button[contains(text(),'Configure Contract')]")
	WebElement configureContract;
	@FindBy(xpath = "//a[contains(text(),'Sign')]")
	WebElement sign;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement signchkBx;
	@FindBy(xpath = "//div[text()='Accept PAYM']//..//..//preceding-sibling::tr[1]//input")
	WebElement acceptPaymChkBx;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement signSaveBtn;
	@FindBy(xpath = "(//button[contains(text(),'Check Out')])[2]")
	WebElement checkOutBtn;
	@FindBy(xpath = "//iframe[@class='cardIframe']")
	WebElement iframeElementCard;
	@FindBy(xpath = "//*[@id='expiryDateMonthyearInput']")
	WebElement newMnthYearText;
	@FindBy(xpath = "//button[@title='close']")
	WebElement closePopUp;

	// Review Order Method
	public void reviewPageForSIMO() throws Exception

	{

		Thread.sleep(15000);
		System.out.println("Reviewing order");
		Vmor.r_click(review, "review");

		Thread.sleep(8000);
		Vmor.r_enterText(txtInterDesc, "test", "txtInterDesc");

		Thread.sleep(4000);
		Vmor.r_clickByJse(orderParaDD, "orderParaDD");

		Thread.sleep(5000);
		Vmor.r_click(scriptLink, "scriptLink");

		Thread.sleep(5000);
		Vmor.selectByVisibleText(script1DD, "Yes", "script1DD");

		Thread.sleep(5000);
		Vmor.selectByValue(journeyTypeDD, "Acquisition", "journeyTypeDD");

		Thread.sleep(5000);
		Vmor.selectByValue(productTypeDD, "SIMO", "productTypeDD");

		Thread.sleep(5000);
		Vmor.selectByVisibleText(script2DD, "Yes", "script2DD");

		Thread.sleep(5000);
		Vmor.r_click(sendCICSDocsBtn, "sendCICSDocsBtn");

		Thread.sleep(10000);
		Vmor.r_click(creditCheckBtn, "creditCheckBtn");

		Thread.sleep(5000);
		Vmor.r_click(paymentDetails, "paymentDetails");

		// card details
		Thread.sleep(15000);

		// now using the switch command
		driver.switchTo().frame(iframeElementCard);

		Vmor.r_enterText(newCSRDCardName, "Test", "newCSRDCardName");

		Thread.sleep(1000);

		Vmor.r_enterText(newCsrdcardNumber, "4546380000000009", "newCsrdcardNumber");

		Thread.sleep(1000);

		Vmor.selectByVisibleText(newCsrdmonthField, "03", "newCsrdmonthField");

		Thread.sleep(1000);

		Vmor.selectByVisibleText(newCsrdyearField, "2025", "newCsrdyearField");

		Thread.sleep(1000);

		Thread.sleep(1000);
		Vmor.enterTextWithJSExecutorIfExists(newMnthYearText, "03/25", "newMnthYearText");

		Thread.sleep(1000);
		Vmor.r_enterText(newCsrdcvvField, "242", "newCsrdcvvField");

		Thread.sleep(2000);

		Vmor.r_click(registerCardBtn, "registerCardBtn");

		Thread.sleep(15000);

		driver.switchTo().parentFrame();

		Thread.sleep(5000);
		Vmor.r_click(applicationTabInpopup, "applicationTabInpopup");

		Thread.sleep(4000);
		Vmor.r_click(cnfrmAndCntnBtnInPopup, "cnfrmAndCntnBtnInPopup");

		// Thread.sleep(6000);

		Thread.sleep(10000);
		Vmor.r_click(configureContract, "configureContract");

		Thread.sleep(5000);
		Vmor.r_click(sign, "sign");

		Thread.sleep(5000);
		Vmor.r_clickByJse(acceptPaymChkBx, "acceptPaymChkBx");

		Thread.sleep(3000);
		Vmor.r_click(signSaveBtn, "signSaveBtn");

		Thread.sleep(5000);
		Vmor.r_click(checkOutBtn, "checkOutBtn");

		Thread.sleep(7000);

	}

	// Review Second Order Method
	public void reviewPageForSecondOrderSIMO() throws Exception

	{

		Thread.sleep(15000);
		System.out.println("Reviewing 2 order");
		Vmor.r_click(review, "review");

		Thread.sleep(8000);
		Vmor.r_enterText(txtInterDesc, "test", "txtInterDesc");

		Thread.sleep(4000);
		Vmor.r_clickByJse(orderParaDD, "orderParaDD");
		Thread.sleep(5000);
		Vmor.r_click(scriptLink, "scriptLink");

		Thread.sleep(5000);
		Vmor.selectByVisibleText(script1DD, "Yes", "script1DD");

		Thread.sleep(5000);
		Vmor.selectByValue(journeyTypeDD, "Acquisition", "journeyTypeDD");

		Thread.sleep(5000);
		Vmor.selectByValue(productTypeDD, "SIMO", "productTypeDD");

		Thread.sleep(5000);
		Vmor.selectByVisibleText(script2DD, "Yes", "script2DD");

		Thread.sleep(5000);
		Vmor.r_click(sendCICSDocsBtn, "sendCICSDocsBtn");

		Thread.sleep(10000);
		Vmor.r_click(creditCheckBtn, "creditCheckBtn");

		Thread.sleep(5000);
		Vmor.r_click(cnfrmAndCntnBtnInPopup, "cnfrmAndCntnBtnInPopup");

		Thread.sleep(15000);
		Vmor.r_click(configureContract, "configureContract");

		Thread.sleep(5000);
		Vmor.r_click(sign, "sign");

		Thread.sleep(5000);
		Vmor.r_clickByJse(acceptPaymChkBx, "acceptPaymChkBx");

		Thread.sleep(3000);
		Vmor.r_click(signSaveBtn, "signSaveBtn");

		Thread.sleep(5000);
		Vmor.r_click(checkOutBtn, "checkOutBtn");

		Thread.sleep(7000);

	}
	// Review SFF Order Method
	@FindBy(xpath = "//button[contains(text(),'Payment')]")
	WebElement Payment;
	@FindBy(xpath = "(//button[text()='Close'])[2]")
	WebElement closePaymentTab;
		public void reviewPageForSFFOrder() throws Exception

		{
			System.out.println("Clicking on review Info tab");

			Thread.sleep(5000);
			Vmor.r_click(review, "review");
			Thread.sleep(8000);
			Vmor.r_enterText(txtInterDesc, "test", "txtInterDesc");
			Thread.sleep(5000);
			Vmor.r_clickByJse(orderParaDD, "order ParaDD");
			Thread.sleep(5000);
			Vmor.r_click(scriptLink, "scriptLink");
			Thread.sleep(10000);
			Vmor.selectByVisibleText(script1DD, "Yes", "script1DD");
			Thread.sleep(5000);
			Vmor.selectByValue(journeyTypeDD, "Acquisition", "journeyTypeDD");
			Thread.sleep(2000);
			Vmor.selectByValue(productTypeDD, "Custom Plan", "productTypeDD");
			Thread.sleep(2000);
			Vmor.selectByVisibleText(script2DD, "Yes", "script2DD");
			Thread.sleep(10000);
			Vmor.r_click(creditCheckBtn, "creditCheckBtn");
			Thread.sleep(5000);
			Vmor.r_clickByJse(paymentDetails, "payment Details");
			Thread.sleep(5000);
			// card details
			Vmor.selectByVisibleText(paymentInstrument, "New Card", "paymentInstrument");
			Thread.sleep(2000);
			Vmor.r_clickByJseIfExists(createBtn, "createBtn");
			Thread.sleep(5000);

			// now using the switch command

			driver.switchTo().frame(iframeElementCard);
			Thread.sleep(5000);
			Vmor.r_enterText(newCSRDCardName, "Test", "newCSRDCardName");
			Thread.sleep(1000);
			Vmor.r_enterText(newCsrdcardNumber, "4546380000000009", "newCsrdcardNumber");
			Thread.sleep(1000);
			Vmor.selectByVisibleText(newCsrdmonthField, "03", "newCardmonthField");
			Thread.sleep(1000);
			Vmor.selectByVisibleText(newCsrdyearField, "2025", "newCardyearField");
			Thread.sleep(1000);
			Vmor.r_enterText(newCsrdcvvField, "242", "newCsrdcvvField");
			Thread.sleep(5000);
			Vmor.r_click(makepaymentbtn, "makepaymentbtn");
			Thread.sleep(15000);
		
			try {
				driver.switchTo().frame(frameElement);
				By cardIframe = By.xpath(
						"//div[contains(text(),'That card has been successful! You can now continue with your order.')]");
				Vmor.validateText("That card has been successful! You can now continue with your order.", cardIframe,
						"cardIframe");
			} catch (Exception exc) {
				System.out.println("Payment was not successful");
				ExtentReport.log("Make Payment ", "Make Payment failed", Status.FAIL);
				driver.switchTo().parentFrame();
			}

			
			System.out.println("Clicking on application tab:");
			Vmor.r_click(applicationTabInpopup, "applicationTabInpopup");
			Thread.sleep(10000);
			System.out.println("Clicking on confirm button");
			Vmor.r_click(cnfrmAndCntnBtnInPopup, "cnfrmAndCntnBtnInPopup");
			Thread.sleep(15000);
			System.out.println("Clicking on configure button");
			Vmor.r_click(configureContract, "configureContract");
			Thread.sleep(6000);
			Vmor.r_click(sign, "sign");
			Thread.sleep(5000);
			Vmor.r_clickByJse(acceptPaymChkBx, "acceptPaymChkBx");
			Thread.sleep(5000);
			Vmor.r_click(signSaveBtn, "signSaveBtn");
			Thread.sleep(5000);
			Vmor.r_click(checkOutBtn, "checkOutBtn");
			Thread.sleep(10000);

		}

	
	// after checkout
	@FindBy(xpath = "//*[contains(text(),'has been successfully checked out')]")
	WebElement ordertxt;

	public void afterChkOut() {

		System.out.println("Validating Order after checkout");

		if (ordertxt.isDisplayed()) {
			String Order = Vmor.getText(ordertxt);

			OrderID = Order.substring(6, 15);
			System.out.println(OrderID);
			ExtentReport.log("Order", Order, Status.PASS);
		} else {
			ExtentReport.log("Order", "Order is not placed successfully", Status.FAIL);
		}

	}

	// Fetching the FulfillmentOrderNo and ExternalReservationID

	@FindBy(xpath = "//div[@class='rightnavigationpanel-slot']/div/div/div/button[@id='backToCSRD']")
	WebElement clickOnCSRDesktop;
	@FindBy(xpath = "//div[contains(text(),'Order Items')]")
	WebElement Orderitems;
	@FindBy(xpath = "(//a[contains(text(),'Home Delivery')])[1]")
	WebElement HomeDeliveryfromOrders;
	@FindBy(xpath = "(//*[contains(text(),'Characteristics')])[4]")
	WebElement Characteristicstab;
	@FindBy(xpath = "//div[text()='External Reservation ID']//..//following-sibling::td//*[@class='nc-field-text-readonly nc-field-html-focusable-content']")
	WebElement ExternalReservationID1;
	@FindBy(xpath = "//div[text()='Fulfillment Order Number']//..//following-sibling::td//*[@class='nc-field-text-readonly nc-field-html-focusable-content']")
	WebElement FulfillmentOrderNo1;
	@FindBy(xpath = "(//a[contains(text(),'Orders')])[1]")
	WebElement ordersOptionn;
	@FindBy(xpath = "//div[text()='Model']//..//following-sibling::td//*[@class='nc-field-text-readonly nc-field-html-focusable-content']")
	WebElement productCode1;
	@FindBy(xpath = "(//a[contains(text(),'Sim Free Financing')])[1]")
	WebElement simFreeFinancing;

	public void FetchOrderDetails() throws Exception

	{
		System.out.println("Fetching order details");
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		Vmor.r_clickByJse(clickOnCSRDesktop, "clickOnCSRDesktop");
		Thread.sleep(8000);
		Vmor.r_clickByJseIfExists(clickOnCSRDesktop, "clickOnCSRDesktop");
		Thread.sleep(8000);
		Vmor.r_clickByJse(expandButton, "expandButton");
		Thread.sleep(5000);
		Vmor.r_click(ordersOptionn, "ordersOptionn");
		Thread.sleep(5000);
		WebElement Ordername = driver.findElement(By.xpath("//a[contains(text(),'" + OrderID + "')]"));
		Vmor.r_click(Ordername, "Ordername");
		Thread.sleep(5000);
		Vmor.r_click(Orderitems, "Orderitems");
		Thread.sleep(5000);
		
		if(driver.getPageSource().contains("Sim Free Financing")) {
			
			Thread.sleep(1500);
			Vmor.r_click(simFreeFinancing, "simFreeFinancing");
			Vmor.r_click(Characteristicstab, "Characteristicstab");
			Thread.sleep(5000);
			ModelNo = productCode1.getText();
			System.out.println("Model is:" + ModelNo);
			Thread.sleep(2000);
			Vmor.r_click(HomeDeliveryfromOrders, "HomeDeliveryfromOrders");
			Thread.sleep(5000);
			Vmor.r_click(Characteristicstab, "Characteristicstab");
			Thread.sleep(5000);
			ExternalReservationID = ExternalReservationID1.getText();
			System.out.println("External Reservation id is:" + ExternalReservationID);
			FulfillmentOrderNo = FulfillmentOrderNo1.getText();
			System.out.println("Fulfillment Order No is is:" + FulfillmentOrderNo);
			
			
		}else {
		
		
		Vmor.r_click(HomeDeliveryfromOrders, "HomeDeliveryfromOrders");
		Thread.sleep(5000);
		Vmor.r_click(Characteristicstab, "Characteristicstab");
		Thread.sleep(5000);
		ExternalReservationID = ExternalReservationID1.getText();
		System.out.println("External Reservation id is:" + ExternalReservationID);
		FulfillmentOrderNo = FulfillmentOrderNo1.getText();
		System.out.println("Fulfillment Order No is is:" + FulfillmentOrderNo);
		}
	}

	// Yogita Code

	// Add Custom plan

	@FindBy(xpath = "//span[contains(text(),'Phones')]")
	WebElement phonesInCsrd;
	@FindBy(xpath = "//span[contains(text(),'Connected Smartwatches')]")
	WebElement WatchInCsrd;
	@FindBy(xpath = "(//span[contains(text(),'Phones')])[2]")
	WebElement selectphonefromleftside;
	@FindBy(xpath = "(//span[contains(text(),'Connected Smartwatches')])[2]")
	WebElement selectWatchfromleftside;
	@FindBy(xpath = "//a[contains(text(),'Apple Watch')]")
	WebElement appleWatchtab;
	@FindBy(xpath = "//a[contains(text(),'Android')]")
	WebElement Android;
	@FindBy(xpath = "//*[@aria-label='Search filter']")
	WebElement searchFilterBox;
	@FindBy(xpath = "(//a[@id='addEquipBtn_'])[1]")
	WebElement clickOnAddPhone;
	@FindBy(xpath = "//*[@class='characteristicValues equipment_value_element']/span/select[@aria-label='Sale Type*']")
	WebElement clickonSaleTypedropdown;
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement clickOnOk;
	@FindBy(xpath = "//*[@class='roe-tree-composite-cell-left-cell-right-label-cell']/span[contains(text(),'Custom Plan')]")
	WebElement clickOnCustomPlan;
	@FindBy(xpath = "(//span[@class='bulkTreeItem bulkTreeItemRoeTreeItem'])[1]")
	WebElement clickOnCustomPlan1;
	@FindBy(xpath = "//*[@class='roe-tree-composite-cell-left-cell-right-label-cell']/span[contains(text(),'Standard Plan')]")
	WebElement clickOnStandardPlan;
	@FindBy(xpath = "(//*[contains(text(),'Custom Plan Apple Watch')])[2]")
	WebElement clickOnCustomPlanWatch;
	@FindBy(xpath = "//span[contains(text(),'Show')]")
	WebElement showlink;
	@FindBy(xpath = "//span[@class='ui-spinner ui-corner-all ui-widget ui-widget-content input-errorHighlight']/input[@type='text']")
	WebElement installmentmonth;
	@FindBy(xpath = "(//span[contains(text(),'Home Delivery')])[2]")
	WebElement clickOnHomeDeliveryleftside;
	@FindBy(xpath = "//a[contains(text(), 'Reserve')]")
	WebElement clickOnReseve;
	@FindBy(xpath = "//*[(text()='Upfront')]/../following-sibling::td")
	WebElement upfrontamount;
	@FindBy(xpath = "(//*[(text()='Upfront')]/../following-sibling::td/div/span/span/a)[1]")
	WebElement upfrontamountarrow;
	@FindBy(xpath = "//*[(text()='Total Upfront')]/../following-sibling::td")
	WebElement upfrontamount1;
	@FindBy(xpath = "(//*[(text()='Total Upfront')]/../following-sibling::td/div/span/span/a)[1]")
	WebElement upfrontamount1arrpw;

//addiphone device

	public void addiphone(String device, String plan) throws Exception {
		System.out.println("Creating phone");
		Thread.sleep(5000);
		Vmor.r_clickByJse(phonesInCsrd, "phonesInCsrd");
		Thread.sleep(5000);
		Vmor.r_clickByJse(selectphonefromleftside, "phonesexstngPlanSelection");
		Thread.sleep(5000);
		Vmor.r_click(searchFilterBox, "clickOnSearchBoxNew");
		Thread.sleep(5000);
		Vmor.r_enterText(searchFilterBox, device, "Entered device");
		Thread.sleep(5000);
		WebElement selectedphone = driver.findElement(
				By.xpath("//*[text()='" + device + "']//..//following::td[@class='sale equipment_action']/a"));
		System.out.println(selectedphone);
		Vmor.r_click(selectedphone, "selectedphone");
		// Vmor.r_click(clickOnAddPhone, "clickOnAddPhone");
		Thread.sleep(5000);
		Vmor.selectByVisibleText(clickonSaleTypedropdown, plan, "clickonSaleTypedropdown");
		Thread.sleep(5000);
		Vmor.r_click(clickOnOk, "clickOnOk");
		Thread.sleep(10000);
	}

//add android phone device

	public void addandroidphone(String device, String plan) throws Exception {
		System.out.println("Creating phone");
		Thread.sleep(5000);
		Vmor.r_clickByJse(phonesInCsrd, "phonesInCsrd");
		Thread.sleep(5000);
		Vmor.r_clickByJse(selectphonefromleftside, "phonesexstngPlanSelection");
		Thread.sleep(5000);
		Vmor.r_clickByJse(Android, "Android");
		Thread.sleep(5000);
		Vmor.r_click(searchFilterBox, "clickOnSearchBoxNew");
		Thread.sleep(5000);
		Vmor.r_enterText(searchFilterBox, device, "Entered device");
		Thread.sleep(5000);
		WebElement selectedphone = driver.findElement(
				By.xpath("//*[text()='" + device + "']//..//following::td[@class='sale equipment_action']/a"));
		System.out.println(selectedphone);
		Vmor.r_click(selectedphone, "selectedphone");
		// Vmor.r_click(clickOnAddPhone, "clickOnAddPhone");
		Thread.sleep(5000);
		Vmor.selectByVisibleText(clickonSaleTypedropdown, plan, "clickonSaleTypedropdown");
		Thread.sleep(5000);
		Vmor.r_click(clickOnOk, "clickOnOk");
		Thread.sleep(10000);
	}

//add watch
	public void addwatch(String device) throws Exception {
		System.out.println("Adding Watch");
		Thread.sleep(5000);
		Vmor.r_clickByJse(WatchInCsrd, "WatchInCsrd");
		Thread.sleep(5000);
		Vmor.r_clickByJse(selectWatchfromleftside, "selectWatchfromleftside");
		Thread.sleep(5000);
		Vmor.r_clickByJse(appleWatchtab, "appleWatchtab");
		Thread.sleep(5000);
		Vmor.r_click(searchFilterBox, "clickOnSearchBoxNew");
		Thread.sleep(5000);
		Vmor.r_enterText(searchFilterBox, device, "clickOnSearchBoxNew");
		Thread.sleep(5000);
		WebElement selectedphone = driver.findElement(
				By.xpath("//*[text()='" + device + "']//..//following::td[@class='sale equipment_action']/a"));
		System.out.println(selectedphone);
		Vmor.r_click(selectedphone, "selectedphone");
		// Vmor.r_click(clickOnAddPhone, "clickOnAddPhone");
		Thread.sleep(5000);
		Vmor.selectByVisibleText(clickonSaleTypedropdown, "Custom Plan with CCA", "clickonSaleTypedropdown");
		Thread.sleep(5000);
		Vmor.r_click(clickOnOk, "clickOnOk");
		Thread.sleep(10000);
	}
	
	//add Ipad
	
	@FindBy(xpath = "//span[contains(text(),'Tablets')]")
	WebElement IpadInCsrd;
	@FindBy(xpath = "(//span[contains(text(),'Tablets')])[2]")
	WebElement selectIpadfromleftside;
	

	
	
		public void addIpad(String device) throws Exception {
			System.out.println("Adding Ipad");
			Thread.sleep(5000);
			Vmor.r_clickByJse(IpadInCsrd, "IpadInCsrd");
			Thread.sleep(5000);
			Vmor.r_clickByJse(selectWatchfromleftside, "selectWatchfromleftside");
			Thread.sleep(5000);
			Vmor.r_click(searchFilterBox, "clickOnSearchBoxNew");
			Thread.sleep(5000);
			Vmor.r_enterText(searchFilterBox, device, "clickOnSearchBoxNew");
			Thread.sleep(5000);
			WebElement selectedphone = driver.findElement(
					By.xpath("//*[text()='" + device + "']//..//following::td[@class='sale equipment_action']/a"));
			System.out.println(selectedphone);
			Vmor.r_click(selectedphone, "selectedphone");
			// Vmor.r_click(clickOnAddPhone, "clickOnAddPhone");
			Thread.sleep(5000);
			Vmor.selectByVisibleText(clickonSaleTypedropdown, "Custom Plan with CCA", "clickonSaleTypedropdown");
			Thread.sleep(5000);
			Vmor.r_click(clickOnOk, "clickOnOk");
			Thread.sleep(10000);
		}

	// add custom plan for phone

	public void addCustomPlanforphone(String allowance,String SpendCap) throws Exception {

		Vmor.r_click(clickOnCustomPlan, "clickOnCustomPlan");
		Thread.sleep(10000);
		Vmor.selectByVisibleText(allowanceBundle, allowance, "allowanceBundle");
		Thread.sleep(15000);
		Vmor.r_click(phoneNumArrowDD, "phoneNumArrowDD");
		Thread.sleep(6000);
		Vmor.hoverAndClickElement(selectFirstPhnNum, selectFirstPhnNum, 0, "selectFirstPhnNum");
		Vmor.r_clickByJseIfExists(selectFirstPhnNum, "selectFirstPhnNum");
		Thread.sleep(20000);
		Vmor.selectByVisibleText(spendCapDD, SpendCap, "spendCapDD");
		Thread.sleep(5000);
		Vmor.r_click(eSimRadiBtn, "eSimRadiBtn");
		Thread.sleep(10000);
		Vmor.r_clickByJse(showlink, "showlink");
		Thread.sleep(10000);
		Vmor.r_enterText(installmentmonth, "12", "installmentmonth");
		Thread.sleep(10000);
		// Vmor.selectByVisibleText(TermsandCondition, "Yes","TermsandCondition" );
		// Thread.sleep(15000);
	}

	// add custom plan for phone

		public void addCustomPlanforipad(String allowance,String SpendCap) throws Exception {

			Vmor.r_click(clickOnCustomPlan, "clickOnCustomPlan");
			Thread.sleep(10000);
			Vmor.selectByVisibleText(allowanceBundle, allowance, "allowanceBundle");
			Thread.sleep(15000);
			Vmor.r_click(phoneNumArrowDD, "phoneNumArrowDD");
			Thread.sleep(6000);
			Vmor.hoverAndClickElement(selectFirstPhnNum, selectFirstPhnNum, 0, "selectFirstPhnNum");
			Vmor.r_clickByJseIfExists(selectFirstPhnNum, "selectFirstPhnNum");
			Thread.sleep(20000);
			Vmor.selectByVisibleText(spendCapDD, SpendCap, "spendCapDD");
			Thread.sleep(10000);
			Vmor.r_clickByJse(showlink, "showlink");
			Thread.sleep(10000);
			Vmor.r_enterText(installmentmonth, "12", "installmentmonth");
			Thread.sleep(10000);
			// Vmor.selectByVisibleText(TermsandCondition, "Yes","TermsandCondition" );
			// Thread.sleep(15000);
		}

	// add standard plan for phone
	public void addStandardPlanforphone(String allowance,String SpendCap) throws Exception {

		Vmor.r_click(clickOnStandardPlan, "clickOnStandardPlan");
		Thread.sleep(10000);
		Vmor.selectByVisibleText(allowanceBundle, allowance, "allowanceBundle");
		Thread.sleep(10000);
		Vmor.r_click(phoneNumArrowDD, "phoneNumArrowDD");
		Thread.sleep(6000);
		Vmor.hoverAndClickElement(selectFirstPhnNum, selectFirstPhnNum, 0, "selectFirstPhnNum");
		Vmor.r_clickByJseIfExists(selectFirstPhnNum, "selectFirstPhnNum");
		Thread.sleep(20000);
		Vmor.selectByVisibleText(spendCapDD, SpendCap, "spendCapDD");
		Thread.sleep(10000);
	}

	// DamageCoverTandC

	public void DamageCoverTandC() throws Exception {

		Thread.sleep(10000);
//	Vmor.selectByVisibleText(TermsandCondition, "Yes","TermsandCondition" );
		Vmor.r_click(TermsandCondition, "TermsandCondition");
		Thread.sleep(10000);
		Vmor.r_click(TermsandConditionoption, "TermsandConditionoption");
		Thread.sleep(5000);

	}

	// add Custom plan for Watch

	@FindBy(xpath = "(//i[@class='refsel_arrow'])[1]")
	WebElement primaryMSDNArrowwatch;
	@FindBy(xpath = "(//div[@class='refsel_name' and not(contains(@role,'prese'))])[1]")
	WebElement selectMSDNNo;
	@FindBy(xpath = "(//i[@class='refsel_arrow'])[3]")
	WebElement phoneNumArrowDDwatch;

	public void addCustomPlanforwatch() throws Exception {

		Vmor.r_click(clickOnCustomPlanWatch, "clickOnCustomPlanWatch");
		Thread.sleep(10000);
		Vmor.r_click(primaryMSDNArrowwatch, "primaryMSDNArrowwatch");
		Thread.sleep(6000);
		Vmor.hoverAndClickElement(selectMSDNNo, selectMSDNNo, 0, "selectMSDNNo");
		Vmor.r_clickByJseIfExists(selectMSDNNo, "selectMSDNNo");
		Thread.sleep(20000);
		// Vmor.selectByVisibleText(allowanceBundle,plan, "allowanceBundle");
		// Thread.sleep(10000);
		Vmor.r_click(phoneNumArrowDDwatch, "phoneNumArrowDDwatch");
		Thread.sleep(6000);
		Vmor.hoverAndClickElement(selectFirstPhnNum, selectFirstPhnNum, 0, "selectFirstPhnNum");
		Vmor.r_clickByJseIfExists(selectFirstPhnNum, "selectFirstPhnNum");
		Thread.sleep(20000);
		Vmor.r_clickByJse(showlink, "showlink");
		Thread.sleep(10000);
		Vmor.r_enterText(installmentmonth, "12", "installmentmonth");
		Thread.sleep(15000);
	}
	
	//O2 Recycle for custom paln with CCA
	@FindBy(xpath = "//a[contains(@href,'#overview')]")
	WebElement servicesFeatures;
	@FindBy(xpath = "//span[contains(text(),'O2 Recycle')]")
	WebElement o2Recycle;
	@FindBy(xpath = "(//span[contains(text(),'O2 Recycle')])[2]")
	WebElement o2RecycleAtLeftSide;
	@FindBy(xpath = "(//i[@class='refsel_arrow'])[1]")
	WebElement makeArrowDD;
	@FindBy(xpath = "(//i[@class='refsel_arrow'])[2]")
	WebElement modelArrowDD;
	@FindBy(xpath = "//div[@class='refsel_name' and not(contains(@role,'prese')) and contains(text(),'Apple')]")
	WebElement makeDeviceSelection;
	@FindBy(xpath = "//div[@class='refsel_name' and not(contains(@role,'prese')) and contains(text(),'iPhone')]")
	WebElement makeModelSelection;
	@FindBy(xpath = "//span[contains(text(),'Get Accurate Quote')]")
	WebElement getAccurateQuote;
	@FindBy(xpath = "//span[contains(text(),'Have you removed your iCloud account and Find My iPhone from this device?')]//..//following-sibling::div//select")
	WebElement removediCloudDD;
	@FindBy(xpath = "//span[contains(text(),'Please select your network')]//..//following-sibling::div//select")
	WebElement selectYourNetworkDD;
	@FindBy(xpath = "//span[contains(text(),'Is the device fully functional?')]//..//following-sibling::div//select")
	WebElement deviceFullyFunctionalDD;
	@FindBy(xpath = "//span[contains(text(),'Does the device have any physical damage?')]//..//following-sibling::div//select")
	WebElement anyPhysicalDamage;
	@FindBy(xpath = "//span[contains(text(),'Is the device water damaged?')]//..//following-sibling::div//select")
	WebElement deviceWaterDamaged;
	@FindBy(xpath = "//span[contains(text(),'Does the screen show signs of screen burn, or has missing or faded pixels?')]//..//following-sibling::div//select")
	WebElement screenShowSigns;
	@FindBy(xpath = "//button[text()=' Calculate Quote ']")
	WebElement calculateQuote;
	@FindBy(xpath = "//button[text()='Add Recycle']")
	WebElement addRecycle;
	@FindBy(xpath = "(//i[@class='refsel_arrow'])[5]")
	WebElement airtimeArrowDD;
	@FindBy(xpath = "//div[@class='refsel_name' and not(contains(@role,'prese')) and contains(text(),'Custom')]")
	WebElement airtimeSelection;
	
	public void addO2Recycle() throws Exception {
		System.out.println("Adding O2 Recycle");
		Thread.sleep(3000);
		Vmor.r_click(servicesFeatures, "servicesFeatures");
		Thread.sleep(6000);
		Vmor.r_click(o2Recycle, "o2Recycle");
		Thread.sleep(2000);
		Vmor.r_click(o2RecycleAtLeftSide, "o2RecycleAtLeftSide");
		Thread.sleep(4000);
		Vmor.r_click(makeArrowDD, "makeArrowDD");
		Thread.sleep(4000);
		Vmor.hoverAndClickElement(makeDeviceSelection, makeDeviceSelection, 5, "makeDeviceSelection");
		Vmor.r_clickByJseIfExists(makeDeviceSelection, "makeDeviceSelection");
		Thread.sleep(4000);
		Vmor.r_click(modelArrowDD, "modelArrowDD");
		Vmor.hoverAndClickElement(makeModelSelection, makeModelSelection, 5, "makeModelSelection");
		Vmor.r_clickByJseIfExists(makeModelSelection, "makeModelSelection");
		Thread.sleep(4000);
		Vmor.r_click(getAccurateQuote, "getAccurateQuote");
		Thread.sleep(6000);
		Vmor.selectByVisibleText(removediCloudDD, "Yes", "removediCloudDD");
		Thread.sleep(2000);
		Vmor.selectByVisibleText(selectYourNetworkDD, "O2", "selectYourNetworkDD");
		Thread.sleep(2000);
		Vmor.selectByVisibleText(deviceFullyFunctionalDD, "Yes, everything works as it should", "deviceFullyFunctionalDD");
		Thread.sleep(2000);
		Vmor.selectByVisibleText(anyPhysicalDamage, "No, it's not damaged (general wear and tear is okay)", "anyPhysicalDamage");
		Thread.sleep(2000);
		Vmor.selectByVisibleText(deviceWaterDamaged, "No", "deviceWaterDamaged");
		Thread.sleep(2000);
		Vmor.selectByVisibleText(screenShowSigns, "No, this display shows no sign of screen burn, or missing / faded pixels", "screenShowSigns");
		Thread.sleep(2000);
		Vmor.r_clickByJse(calculateQuote, "calculateQuote");
		Thread.sleep(4000);
		Vmor.r_click(addRecycle, "addRecycle");		
		//Airtime Radio btn
		Thread.sleep(7000);
		Vmor.r_click(airtimeArrowDD, "airtimeArrowDD");
		Thread.sleep(4000);
		Vmor.hoverAndClickElement(airtimeSelection, airtimeSelection, 5, "airtimeSelection");
		Vmor.r_clickByJseIfExists(airtimeSelection, "airtimeSelection");
		Thread.sleep(6000);
		
	}
      
	//5G Access Bolton
	@FindBy(xpath = "//input[@aria-label='5G Access Bolt On']")
	WebElement Bolton5GAccessChkBx;
	public void bolton5GAccess() throws InterruptedException {
		
		Thread.sleep(3000);
		Vmor.r_clickByJse(Bolton5GAccessChkBx, "Bolton5GAccessChkBx");
		Thread.sleep(6000);
		
	}
	
	// HomedeliveryReserve

	public void HomedeliveryReserve() throws Exception {

		Vmor.r_clickByJse(clickOnHomeDeliveryleftside, "clickOnHomeDeliveryleftside");
		Thread.sleep(10000);
		Vmor.r_clickByJse(clickOnReseve, "clickOnReseve");
		Thread.sleep(30000);
		System.out.println("Reserved for Home Delivery");
	}

	// HomedeliveryReserve for Watch

	public void HomedeliveryReservewatch() throws Exception {

		Vmor.r_click(clickOnHomeDeliveryleftside, "clickOnHomeDeliveryleftside");
		Thread.sleep(10000);
		Vmor.r_click(clickOnReseve, "clickOnReseve");
		Thread.sleep(15000);
		System.out.println("Custom plan added");
	}

	// Review page for Custom plan

	@FindBy(xpath = "//button[@id='bConfirmPaymentButton']")
	WebElement makepaymentbtn;
	@FindBy(xpath = "(//*[@type='checkbox'])[2]")
	WebElement AppCheckbox1;
	@FindBy(xpath = "(//*[@type='checkbox'])[3]")
	WebElement AppCheckbox2;
	@FindBy(xpath = "//*[text()=' Payment Instrument: ']/..//td/select")
	WebElement paymentInstrument;
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement createBtn;
	@FindBy(xpath = "//iframe[@class='cardIframe']")
	WebElement cardFrame;
	@FindBy(xpath = "//*[@id='iframe_roe']")
	WebElement frameElement;
	@FindBy(xpath = "//div[contains(text(),'That card has been successful! You can now continue with your order.')]")
	WebElement cardIframe;

	public void reviewPageForCustomPlan() throws Exception

	{
		System.out.println("Clicking on review Info tab");

		Thread.sleep(5000);
		Vmor.r_click(review, "review");
		Thread.sleep(8000);
		Vmor.r_enterText(txtInterDesc, "test", "txtInterDesc");
		Thread.sleep(5000);
		Vmor.r_clickByJse(orderParaDD, "order ParaDD");
		Thread.sleep(5000);
		Vmor.r_click(scriptLink, "scriptLink");
		Thread.sleep(10000);
		Vmor.selectByVisibleText(script1DD, "Yes", "script1DD");
		Thread.sleep(5000);
		Vmor.selectByValue(journeyTypeDD, "Acquisition", "journeyTypeDD");
		Thread.sleep(2000);
		Vmor.selectByValue(productTypeDD, "Custom Plan", "productTypeDD");
		Thread.sleep(2000);
		Vmor.selectByVisibleText(script2DD, "Yes", "script2DD");
		Thread.sleep(6000);
		Vmor.r_click(sendCICSDocsBtn, "sendCICSDocsBtn");
		Thread.sleep(10000);
		Vmor.r_click(creditCheckBtn, "creditCheckBtn");
		Thread.sleep(5000);
		Vmor.r_clickByJse(paymentDetails, "payment Details");
		Thread.sleep(5000);
		// card details
		Vmor.selectByVisibleText(paymentInstrument, "New Card", "paymentInstrument");
		Thread.sleep(2000);
		Vmor.r_clickByJseIfExists(createBtn, "createBtn");
		Thread.sleep(5000);

		// now using the switch command

		driver.switchTo().frame(iframeElementCard);
		Thread.sleep(5000);
		Vmor.r_enterText(newCSRDCardName, "Test", "newCSRDCardName");
		Thread.sleep(1000);
		Vmor.r_enterText(newCsrdcardNumber, "4546380000000009", "newCsrdcardNumber");
		Thread.sleep(1000);
		Vmor.selectByVisibleText(newCsrdmonthField, "03", "newCardmonthField");
		Thread.sleep(1000);
		Vmor.selectByVisibleText(newCsrdyearField, "2025", "newCardyearField");
		Thread.sleep(1000);
		Vmor.r_enterText(newCsrdcvvField, "242", "newCsrdcvvField");
		Thread.sleep(5000);
		Vmor.r_click(makepaymentbtn, "makepaymentbtn");
		Thread.sleep(15000);
	
		try {
			driver.switchTo().frame(frameElement);
			By cardIframe = By.xpath(
					"//div[contains(text(),'That card has been successful! You can now continue with your order.')]");
			Vmor.validateText("That card has been successful! You can now continue with your order.", cardIframe,
					"cardIframe");
		} catch (Exception exc) {
			System.out.println("Payment was not successful");
			ExtentReport.log("Make Payment ", "Make Payment failed", Status.FAIL);
			driver.switchTo().parentFrame();
		}

		
		System.out.println("Clicking on application tab:");
		Vmor.r_click(applicationTabInpopup, "applicationTabInpopup");
		Thread.sleep(10000);
		System.out.println("Clicking on checkboxes");
		Vmor.r_clickByJseIfExists(AppCheckbox1, "AppCheckbox1");
		Thread.sleep(5000);
		Vmor.r_clickByJseIfExists(AppCheckbox2, "AppCheckbox2");
		Thread.sleep(5000);
		System.out.println("Clicking on confirm button");
		Vmor.r_click(cnfrmAndCntnBtnInPopup, "cnfrmAndCntnBtnInPopup");
		Thread.sleep(15000);
		System.out.println("Clicking on configure button");
		Vmor.r_click(configureContract, "configureContract");
		Thread.sleep(6000);
		WebElement element = sign;
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','visibility:visible;');",
				element);
		Thread.sleep(5000);
		Vmor.r_click(sign, "sign");
		Thread.sleep(5000);
		Vmor.r_clickByJse(signchkBx, "signchkBx");
		Thread.sleep(5000);
		Vmor.r_click(signSaveBtn, "signSaveBtn");
		Thread.sleep(5000);
		Vmor.r_click(checkOutBtn, "checkOutBtn");
		Thread.sleep(10000);

	}
	// Fetching order details for custom plan

	@FindBy(xpath = "//div[text()='Model']//..//following-sibling::td//*[@class='nc-field-text-readonly nc-field-html-focusable-content']")
	WebElement Model;
	@FindBy(xpath = "//div[text()='Model Display']//..//following-sibling::td//*[@class='nc-field-text-readonly nc-field-html-focusable-content']")
	WebElement Modeldisplay;
	@FindBy(xpath = "(//*[contains(text(),'Custom Plan')])[1]")
	WebElement Customplanlink;
	@FindBy(xpath = "//*[contains(text(),'Skip')]")
	WebElement Skip;

	public void FetchOrderDetailsCustomPlan(String Plan) throws Exception

	{
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		Vmor.r_click(clickOnCSRDesktop, "clickOnCSRDesktop");
		Thread.sleep(10000);
		Vmor.r_clickByJseIfExists(Skip, "Skip");
		Thread.sleep(5000);
		Vmor.r_clickByJseIfExists(clickOnCSRDesktop, "clickOnCSRDesktop");
		Thread.sleep(5000);
		// driver.switchTo().parentFrame();
		Vmor.r_clickByJseIfExists(Skip, "Skip");
		Thread.sleep(5000);
		Vmor.r_clickByJse(expandButton, "expandButton");
		Thread.sleep(5000);
		Vmor.r_click(ordersOptionn, "ordersOptionn");
		Thread.sleep(10000);
		Vmor.r_clickByJseIfExists(Skip, "Skip");
		Thread.sleep(10000);
		WebElement Ordername = driver.findElement(By.xpath("//a[contains(text(),'" + OrderID + "')]"));
		Vmor.r_click(Ordername, "Ordername");
		Thread.sleep(5000);
		Vmor.r_clickByJseIfExists(Skip, "Skip");
		Thread.sleep(5000);
		Vmor.r_click(Orderitems, "Orderitems");
		Thread.sleep(5000);
		WebElement Customplanlink = driver.findElement(By.xpath("(//*[contains(text(),'" + Plan + "')])[1]"));
		Vmor.r_click(Customplanlink, "Customplanlink");
		Thread.sleep(5000);
		Vmor.r_click(Characteristicstab, "Characteristicstab");
		Thread.sleep(5000);
		ProductCode = Model.getText();
		System.out.println("Product Code is:" + ProductCode);
		ProductDescription1 = Modeldisplay.getText();
		ProductDescription = ProductDescription1.substring(0, 20);
		System.out.println("Product Description is:" + ProductDescription);
		Thread.sleep(5000);
		Vmor.r_click(HomeDeliveryfromOrders, "HomeDeliveryfromOrders");
		Thread.sleep(5000);
		Vmor.r_click(Characteristicstab, "Characteristicstab");
		Thread.sleep(5000);
		ExternalReservationID = ExternalReservationID1.getText();
		System.out.println("External Reservation id is:" + ExternalReservationID);
		FulfillmentOrderNo = FulfillmentOrderNo1.getText();
		System.out.println("Fulfillment Order No is is:" + FulfillmentOrderNo);
	}

	// Adding Custom plan VG25

	@FindBy(xpath = "(//*[contains(text(),'Disney')])[1]")
	WebElement Disney;
	@FindBy(xpath = "(//*[contains(text(),'Amazon Prime')])[2]")
	WebElement AmazonPrime;
	@FindBy(xpath = "(//*[@class='roe-table-cell roe-table-body-title']/span[contains(text(),'O2 Insure Damage Cover')])[1]")
	WebElement O2InsureCover;

	@FindBy(xpath = "//tr[@class='characteristic-item characteristic-invalid force_enabled']//select[@aria-label='T&C has read and confirmed*']")
	WebElement TermsandConditionvg25;

	@FindBy(xpath = "//tr[@class='characteristic-item characteristic-invalid force_enabled']//select[@aria-label='T&C has read and confirmed*']/option[contains(text(),'Yes')]")
	WebElement TermsandConditionoptionvg25;

	@FindBy(xpath = "//tr[@class='characteristic-item force_enabled characteristic-invalid']//select[@aria-label='T&C has read and confirmed*']")
	WebElement TermsandCondition;

	@FindBy(xpath = "//tr[@class='characteristic-item force_enabled characteristic-invalid']//select[@aria-label='T&C has read and confirmed*']/option[contains(text(),'Yes')]")
	WebElement TermsandConditionoption;

	public void addCustomPlanVG25(String allowance) throws Exception {
		System.out.println("Creating Custom plan");
		Vmor.r_click(clickOnCustomPlan, "clickOnCustomPlan");
		Thread.sleep(5000);
		Vmor.selectByVisibleText(allowanceBundle, allowance, "allowanceBundle");
		Thread.sleep(7000);
		Vmor.r_click(phoneNumArrowDD, "phoneNumArrowDD");
		Thread.sleep(6000);
		Vmor.hoverAndClickElement(selectFirstPhnNum, selectFirstPhnNum, 0, "selectFirstPhnNum");
		Vmor.r_clickByJseIfExists(selectFirstPhnNum, "selectFirstPhnNum");
		Thread.sleep(10000);
		Vmor.selectByVisibleText(spendCapDD, "No Spend Cap", "spendCapDD");
		Thread.sleep(5000);
		Vmor.r_click(eSimRadiBtn, "eSimRadiBtn");
		Thread.sleep(7000);
		Vmor.r_click(Disney, "Disney");
		Thread.sleep(7000);
		Vmor.r_click(AmazonPrime, "AmazonPrime");
		Thread.sleep(10000);
		Vmor.r_click(showlink, "showlink");
		Thread.sleep(7000);
		// Vmor.enterTextWithJSExecutorIfExists(upfrontamount,"30", "upfrontamount");
		// Thread.sleep(5000);
		/*
		 * for(int i=0;i<=10;i++) { Vmor.r_click(upfrontamountarrow,"upfrontamount1");
		 * Thread.sleep(2000); i++; } Thread.sleep(10000);
		 */
		// Vmor.r_click(installmentmonth,"installmentmonth");
		Vmor.r_enterText(installmentmonth, "12", "installmentmonth");
		Thread.sleep(7000);
		Vmor.r_clickByJse(O2InsureCover, "O2InsureCover");
		Thread.sleep(7000);
		// System.out.println("Selecting terms and conditions:");
		Vmor.r_click(TermsandConditionvg25, "TermsandConditionvg25");
		Thread.sleep(5000);
		Vmor.r_click(TermsandConditionoptionvg25, "TermsandConditionoptionvg25");
		Thread.sleep(7000);
		// Vmor.selectByVisibleText(TermsandConditionvg25, "Yes","TermsandConditionvg25"
		// );
		// Thread.sleep(10000);
		// Vmor.selectByValue(TermsandConditionvg25, "Yes","TermsandConditionvg25" );
		// Thread.sleep(10000);
		Vmor.r_clickByJse(clickOnHomeDeliveryleftside, "clickOnHomeDeliveryleftside");
		Thread.sleep(5000);
		Vmor.r_clickByJse(clickOnReseve, "clickOnReseve");
		Thread.sleep(10000);
		System.out.println("Custom plan added");
	}

	public void customerInfoPagesecondorder() throws Exception

	{
		System.out.println("Clicking on Customer Info tab");
		Thread.sleep(4000);
		Vmor.r_click(customerInfoTab, "customerInfoTab");
		Thread.sleep(3000);
		Vmor.r_click(eligibilityChkBtn, "eligibilityChkBtn");
		Thread.sleep(3000);
		Vmor.r_click(customerInfoTabCntBtn, "customerInfoTabCntBtn");
		Thread.sleep(15000);
		Vmor.r_clickByJseIfExists(closePopUp, "closePopUp");
		Thread.sleep(5000);

	}
	// Billing account selection for Second order

	@FindBy(xpath = "//a[contains(text(),'Billing & Payment')]")
	WebElement billingTab;
	@FindBy(xpath = "(//select)[6]")
	WebElement billingdropdown;
	@FindBy(xpath = "(//select)[6]/option[contains(text(),'Pay Monthly')]")
	WebElement billingdropdownoption;

	public void Billingtab() throws Exception

	{
		System.out.println("Clicking on Billing tab");
		Thread.sleep(5000);
		Vmor.r_click(billingTab, "billingTab");
		Thread.sleep(3000);
		Vmor.r_click(billingdropdown, "billingdropdown");
		Thread.sleep(6000);
		Vmor.r_click(billingdropdownoption, "billingdropdownoption");
		Thread.sleep(5000);
	}

	// Creating new Customer (parameterised)
	public void csrdNewCustomer() throws Exception {
		// random name
		// create a string of all characters
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// create random string builder
		StringBuilder sb = new StringBuilder();
		// create an object of Random class
		Random random = new Random();
		// specify length of random string
		int length = 7;
		for (int i = 0; i < length; i++) {
			// generate random index number
			int index = random.nextInt(alphabet.length());
			// get character specified by index
			// from the string
			char randomChar = alphabet.charAt(index);
			// append the character to string builder
			sb.append(randomChar);
		}

		String randomString = sb.toString();
		firstName = randomString;
		lastName = "Last" + randomString;
		System.out.println("FName is: " + randomString);

		System.out.println("Creating new Customer");

		Thread.sleep(5000);
		Vmor.r_click(csrdNewDetailsTitle, "Title");
		Thread.sleep(2000);
		Vmor.selectByVisibleText(csrdNewDetailsTitle, "Mr", "csrdNewDetailsTitle");
		Thread.sleep(2000);
		Vmor.r_enterText(csrdNewDetailsFirstName, firstName, "csrdNewDetailsFirstName");
		Thread.sleep(2000);
		Vmor.r_enterText(csrdNewDetailsLastName, lastName, "csrdNewDetailsLastName");

		Thread.sleep(2000);
		Vmor.r_click(csrdNewAddressPlusBtn, "AddressPlusBtn");
		Thread.sleep(4000);
		Vmor.r_enterText(csrdNewAddressPostCode, readData.Postcode, "csrdNewAddressPostCode");
		Thread.sleep(2000);
		Vmor.r_enterText(csrdNewAddressBldngNum, readData.BuildingNumber, "csrdNewAddressBldngNum");
		Thread.sleep(2000);
		Vmor.r_click(addressLookUpBtn, "AddressLookUpBVtn");

		Thread.sleep(4000);
		Vmor.r_click(lookedUpAddressValue, "LookedUpAddressValue");

		Thread.sleep(2000);
		Vmor.r_click(cnfrmAddressBtn, "cnfrmAddressBtn");

		Thread.sleep(2000);
		Vmor.r_enterText(enterDate, "01/01/1995", "enterDate");
		Vmor.r_enterText(mandatoryMobileField, "07688887766", "mandatoryMobileField");

		Thread.sleep(2000);
		Vmor.r_click(csrdNewAddressChkBox, "csrdNewAddressChkBox");

		Thread.sleep(2000);
		Vmor.r_click(csrdNewAddressCreateBtn, "csrdNewAddressCreateBtn");

		Thread.sleep(10000);
	}

	// Entering email address for searching the customer

	@FindBy(xpath = "(//input[contains(@aria-labelledby,'tfnukrcasearchformwidget')])[7]")
	WebElement emailBox;

	public void enteringMail() throws Exception {
		Thread.sleep(15000);
		if (emailBox.isDisplayed()) {
			Vmor.r_enterText(emailBox, readData.email, "emailBox");
			Thread.sleep(3000);
			ExtentReport.log("emailBox", "email box is Displayed", Status.PASS);
            Thread.sleep(5000);
		}

		else {
			ExtentReport.log("emailBox", "email box was not Displayed", Status.FAIL);
		}
	}
	
	public void enteringEcomUserEMail() throws Exception {
		Thread.sleep(15000);
		if (emailBox.isDisplayed()) {
			Vmor.r_enterText(emailBox, Ecom.ecomUserEmail, "emailBox");
			Thread.sleep(3000);
			ExtentReport.log("emailBox", "email box is Displayed", Status.PASS);
            Thread.sleep(5000);
		}

		else {
			ExtentReport.log("emailBox", "email box was not Displayed", Status.FAIL);
		}
	}

	// Clicking on search button

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchButton;

	public void clickingOnsearch() throws Exception {

		if (searchButton.isDisplayed()) {
			Vmor.r_click(searchButton, "searchButton");
			Thread.sleep(15000);

		} else {
			ExtentReport.log("emailBox", "Search button is not displayed", Status.FAIL);
		}

	}

	// Accepting Agent Authorization

	@FindBy(xpath = "//input[@id='owner-yes']")
	WebElement rdBtnAccOwner;
	@FindBy(xpath = "//input[@id='it_ploicy_screen']")
	WebElement rdBtnCusNotPresent;
	@FindBy(xpath = "//input[@id='agentdefaultButton']")
	WebElement btnAgentAuthContinue;
	@FindBy(xpath = "//*[@id='btnSubmit']")
	WebElement btnAccept;

	public void acceptingAgentAuth() throws Exception {

		Vmor.r_click(rdBtnAccOwner, "Accept Owner");
		Thread.sleep(5000);
		Vmor.r_click(rdBtnCusNotPresent, "Accept Customer Not present");
		Vmor.r_click(btnAgentAuthContinue, "Continue Button");
		Thread.sleep(5000);
		Vmor.r_click(btnAccept, "Accept Button");

	}

	// Placing BroadbandOrder

	@FindBy(xpath = "//span[contains(text(),'Broadband (Fixed Line)')]")
	WebElement broadband;
	@FindBy(xpath = "(//span[contains(text(),'Broadband (Fixed Line)')])[2]")
	WebElement Broadbandfromleftside;

	public void placeBroadbandOrder() throws Exception {
		System.out.println("Adding Broadband");
		Thread.sleep(5000);
		if (broadband.isDisplayed()) {
			Vmor.r_click(broadband, "broadband");
			Thread.sleep(5000);

		} else {
			ExtentReport.log("broadband", "Broadband checkbox is not displayed", Status.FAIL);
		}

		// Vmor.r_clickByJse(Broadbandfromleftside, "phonesexstngPlanSelection");
		// Thread.sleep(5000);
	}

	// Scheduling appointment for Broadband

	@FindBy(xpath = "//a[contains(text(),'Schedule Appointment')]")
	WebElement Scheduleappointmenttab;
	@FindBy(xpath = "(//*[@class='shadow-radio'])[1]")
	WebElement Schedulenow;
	@FindBy(xpath = "(//*[@class='connect__table-cell connect__table-cell_active'])[1]")
	WebElement appointment;
	@FindBy(xpath = "//*[contains(text(),'InHome.')]")
	WebElement inHome;

	public void Scheduleappointment() throws Exception {
		System.out.println("Scheduling appointment");
		Thread.sleep(5000);
		Vmor.r_click(Scheduleappointmenttab, "Scheduleappointmenttab");
		Thread.sleep(5000);
		Vmor.r_clickByJse(Schedulenow, "Schedulenow");
		Thread.sleep(5000);
		Vmor.r_clickByJse(appointment, "appointment");
		Thread.sleep(5000);
		Vmor.r_clickByJse(inHome, "inHome");
		Thread.sleep(5000);
		Vmor.r_clickByJse(appointment, "appointment");
		Thread.sleep(5000);
	}

	// Broadband
	@FindBy(xpath = "(//button[contains(text(),'Check Out')])[1]")
	WebElement checkOutBtn1;

	public void reviewPageForBroadband() throws Exception

	{

		Thread.sleep(10000);
		Vmor.r_click(review, "review");
		Thread.sleep(5000);
		Vmor.r_enterText(txtInterDesc, "test", "txtInterDesc");
		Thread.sleep(4000);
		Vmor.r_clickByJse(orderParaDD, "orderParaDD");
		Thread.sleep(5000);
		Vmor.r_click(scriptLink, "scriptLink");
		Thread.sleep(5000);
		Vmor.selectByVisibleText(script1DD, "Yes", "script1DD");
		Thread.sleep(5000);
		Vmor.selectByValue(journeyTypeDD, "Acquisition", "journeyTypeDD");
		Thread.sleep(5000);
		Vmor.selectByValue(productTypeDD, "SIMO", "productTypeDD");
		Thread.sleep(5000);
		Vmor.selectByVisibleText(script2DD, "Yes", "script2DD");
		Thread.sleep(10000);
		Vmor.r_clickByJse(checkOutBtn1, "checkOutBtn1");
		Thread.sleep(10000);

	}

}
