package pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.cognizant.craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.cognizant.framework.VMOReusableLibrary;

public class EposAdftPage  extends VMOReusableLibrary
{
	public EposAdftPage(ScriptHelper scriptHelper) 
	{
		super(scriptHelper);
	}

	//******************locators********************
	//Device selection and details page
	private static final By submitButton = By.xpath("//*[text()='Submit']");
	private static final By agentRoleTxt = By.xpath("//table[@id='usersList']/tbody/tr[1]/td[9]/input");
	private static final By shopLink = By.xpath("//a[text()=' Shop ']");
	private static final By deviceSearch = By.xpath("//input[contains(@class,'secondary-search__input ')]");
	private static final By searchResults = By.xpath("//*[contains(@class,'secondary-search__suggestion-text')]");
	private static final By payInFull = By.xpath("//*[text()='Pay in full']");
	private static final By spreadCost = By.xpath("//*[text()='Spread the cost']");
	private static final By selectPlan = By.xpath("//button[@autotest-target='select-plan-button-at-id']");
	private static final By upfrontInputField = By.xpath("//input[@id='upfrontInput']");
	private static final By homeDeliveryOption = By.xpath("//span[contains(text(),'Home delivery')]/parent::label/parent::button");
	private static final By colorDropdown = By.xpath("//o2uk-label[text()='Colour']/ancestor::span/following-sibling::div");
	private static final By defaultColor = By.xpath("//*[text()='Colour']/following-sibling::*");
	private static final By defaultCapacity = By.xpath("//*[text()='Capacity']/following-sibling::*");
	//private static final By colorDropdownField = By.xpath("//div[@class='o2uk-colour-dropdown__content-text']/span");
	private static final By colorDropdownField = By.xpath("//div[@class='o2uk-colour-dropdown__content']/div/span"); 
	private static final By deviceNameField = By.xpath("//*[contains(@class,'device-details-header__brand-name')]");
	private static final By capacityDropdownField = By.xpath("//span[contains(@class,'o2uk-select-value-text ng-tns')]/span");
	private static final By capacityDropdown = By.xpath("//o2uk-label[text()='Capacity']/ancestor::span/following-sibling::div");
	//private static final By colorDropdownList = By.xpath("//span[@class='o2uk-option-content']/div/div/div/following-sibling::div/span");
	private static final By colorDropdownList = By.xpath("//span[@class='o2uk-option-content']/div/div/div/span");
	private static final By capacityDropdownList = By.xpath("//div[@class='os-viewport os-viewport-native-scrollbars-invisible']/div/div/o2uk-option/span");
	private static final By viewPromo = By.xpath("//h2[contains(text(),'Offers included')]");
	//private static final By promoGWP = By.xpath("//p[contains(text(),'Claim')]");
	private static final By promoGWP = By.xpath("//div[@class='device-promo__info']//p[contains(text(),'Claim')]");


	//Add to basket page
	private static final By noInsurance = By.xpath("//*[contains(text(),' No insurance required ')]/parent::button");
	private static final By addBasket = By.xpath("//span[contains(text(),' Add to basket ')]/parent::button");
	//private static final By addBasket = By.xpath("//div[contains(@class,'order-configuration-total-cost__footer')]/div/button");
	//private static final By addSimToBasket = By.xpath("//span[contains(text(),' Add to basket ')]/parent::button");
	private static final By addSimToBasket = By.xpath("//*[contains(@aria-label,'Add to Basket')]");
	private static final By addToBasketAccessories = By.xpath("//*[text()=' Add to basket ']/parent::button");
	private static final By simAllowanceCapacity = By.xpath("//*[@class='order-configuration__control']/div/h3");
	private static final By showAllowanceDetails = By.xpath("//*[text()=' Show package details ']");
	private static final By simAllowancePrice = By.xpath("//*[@class='order-configuration-plan__container']/div/order-configuration-cost-item/div/div/div[3]/o2uk-price/div/div/span");
	private static final By listOfExtras = By.xpath("//o2uk-extra-card[@class='extra-card ng-star-inserted']/add-on/div/div/div[3]/div/div[2]/div/strong");
	private static final By basketOptions = By.xpath("//h2[text()=' Basket options ']");
	private static final By checkOutBtn = By.xpath("//div[contains(@class,'basket-section-cta__checkout-button')]/button");	
	private static final By customerCreateEmail = By.id("email");
	private static final By loginEmail = By.xpath("//*[@class='login-btn']");
	private static final By searchButton = By.xpath("//button[@aria-label='Start search']");

	private static final By resetCalculator = By.xpath("//*[text()=' Reset calculator ']");
	private static final By deviceCurrency = By.xpath("//div[@class='device-calculator__price-value']/o2uk-price/div/div/div[1]");
	private static final By devicePrice = By.xpath("//div[@class='device-calculator__price-value']/o2uk-price/div/div/div[2]");
	private static final By deviceDecimalPrice = By.xpath("//div[@class='device-calculator__price-value']/o2uk-price/div/div/div[3]/span");
	private static final By accessoriesPrice = By.xpath("//div[contains(@class,'margin_bottom')]/o2uk-price/div/div/div[2]");
	private static final By accessoriesDecimalPrice = By.xpath("//div[contains(@class,'margin_bottom')]/o2uk-price/div/div/div[3]/span");
	private static final By accessoriesCurrency = By.xpath("//div[contains(@class,'margin_bottom')]/o2uk-price/div/div/div[1]");
	private static final By ccaAmountField = By.xpath("//*[@class='o2uk-datapicker-footer-price ng-star-inserted']/span");
	private static final By allowanceCapacity = By.xpath("//*[@id='dataInput']/parent::div/div/div");
	private static final By ccaminmonthfield = By.xpath("(//div[@class='o2uk-plan-datapicker__footer-label o2uk-plan-datapicker__footer-label_left']/span)[1]");
	private static final By ccamaxmonthfield = By.xpath("(//div[@class='o2uk-plan-datapicker__footer-label o2uk-plan-datapicker__footer-label_right']/span)[1]");


	private static final By allowanceCurrency = By.xpath("//div[@class='device-calculator__price-value']/div/div/o2uk-price-new/div/div[1]");
	private static final By allowancePrice = By.xpath("//div[@class='device-calculator__price-value']/div/div/o2uk-price-new/div/div[2]");
	private static final By allowanceDecimalPrice = By.xpath("//div[@class='device-calculator__price-value']/div/div/o2uk-price-new/div/div[3]/span");
	private static final By decreaseAllowance = By.xpath("//*[contains(@aria-label,'Decrease tariff data')]");
	private static final By increaseAllowance = By.xpath("//*[contains(@aria-label,'Increase tariff data')]");
	private static final By allowanceMonthlyPrice = By.xpath("//*[@class='amount-info-monthly _margin_top-xs']/div");
	private static final By dataPlan = By.xpath("//*[text()=' Choose your data plan ']");
	private static final By insuranceList = By.xpath("//*[@class='insurance__info-title']");
	private static final By addInsuranceBtn = By.xpath("//*[text()=' Add this insurance ']/parent::button");
	private static final By calculatorField = By.xpath("//*[contains(text(),'Payment calculator') "
			+ "or contains(text(),'Package calculator') or contains(text(),' Finance calculator ')]");


	private static final By upfrontOption = By.xpath("//*[text()='Upfront options']");
	private static final By discountReason = By.xpath("//span[text()=' Please select a reason... ']");
	private static final By packageName = By.xpath("//*[text()='Package 1']");
	private static final By discountTypes = By.xpath("//span[@class='o2uk-option-content']");
	private static final By upfrontErrorMsg = By.xpath("//*[contains(@class,'error-message ng-star-inserted')]");
	private static final By discountJustification = By.xpath("//*[@formcontrolname='discountJustification']");
	private static final By discountCode = By.xpath("//*[@formcontrolname='discountCode']");
	private static final By discountInput = By.xpath("//*[@id='upfront discountInput']");
	private static final By applyDiscount = By.xpath("//span[text()=' Apply discount ']");
	private static final By changeDiscount = By.xpath("//*[text()='Change']");
	private static final By appliedDiscount = By.xpath("//dd[contains(@class,'discount-notification__')]/span");
	//	private static final By upfrontApproveBtn = By.xpath("//button[contains(@class,'discounts-approve-dialog__approve-button')]");
	//	private static final By upfrontApproveAmount = By.xpath("//b[contains(@class,'approve-item-value discounts-approve-dialog')]");


	//Customer details page
	private static final By customerPreferredTitle = By.xpath("//input[contains(@placeholder,'Select title')]");	
	private static final By customerFirstName = By.xpath("//input[@name='fname']");	
	private static final By customerLastName = By.xpath("//input[@name='lname']");	
	private static final By customerDOB = By.xpath("//input[@name='bday']");
	private static final By customerTelephoneNum = By.xpath("//input[@name='tel']");
	private static final By customerPostalCode = By.xpath("//input[@name='postal']");
	//private static final By customerFindButton = By.xpath("//div[@class='select-address-form__postcode-btn']/button");
	private static final By customerFindButton = By.xpath("//span[text()=' Find address ']/parent::button");
	private static final By addressDropdown = By.xpath("//div[contains(@class,'o2uk-select-value')]");
	private static final By addressDropdownOptions = By.xpath("//span[contains(@class,'o2uk-option-content')]");
	private static final By addressCheckbox = By.xpath("//*[@class='o2uk-checkbox-inner-container']");
	//private static final By addressConfirm = By.xpath("//button[contains(@class,'o2uk-primary-button')]");
	private static final By addressConfirm = By.xpath("//button[contains(@autotest-target,'bill-address-confirm-button-at-id')]");
	
	//Delivery type selection
	private static final By homeDelivery = By.xpath("//*[text()='Home delivery']/ancestor::button");
	private static final By clickAndCollect = By.xpath("//*[text()='Click and collect']/ancestor::button");
	private static final By todayAtStore = By.xpath("//*[text()='Today at this store']/ancestor::button");
	private static final By selectStore = By.xpath("//button//span[text()=' Select a store ']");
	private static final By clickNCollectPostCode = By.xpath("//div[@class='click-and-collect-dialog__control-town']//input");
	private static final By findByPostcodeButton = By.xpath("//span[text()=' Find ']/parent::button");
	private static final By listViewOfClickNCollectStores = By.xpath("//o2uk-click-and-collect-dialog//o2uk-tabs/div/button[1]");
	private static final By chooseFirstStore = By.xpath("//div[1]/o2uk-retail-shop-card/div[1]//button");
	private static final By confirmDeliveryOption = By.xpath("//button[contains(@autotest-target,'delivery-confirm-button-at-id')]");
	private static final By continueButton = By.xpath("//span[text()=' Continue ']/parent::button");
	private static final By questionContinueButton = By.xpath("//button[@aria-label='Continue']");


	//Eligibility check page
	private static final By timeAtAddress = By.xpath("//o2uk-select[@formcontrolname='timeAtAddressFC']");
	private static final By eligibilityCheckheckOptions = By.xpath("//o2uk-option[contains(@id,'mat-option-')]");
	private static final By employmentStatus = By.xpath("//o2uk-select[@formcontrolname='employmentStatusFC']");
	private static final By personalAnnualIncome = By.xpath("//o2uk-select[@formcontrolname='annualIncomeFC']");
	private static final By eligibilityCheckAgree = By.xpath("//div[contains(@class,'o2uk-checkbox-frame')]");
	private static final By eligibilityCheckContinue = By.xpath("(//span[contains(text(),' Confirm and continue ')])[2]");
	private static final By eligibilityCheckContinueSecond = By.xpath("(//span[contains(text(),' Confirm and continue ')])[3]");
	private static final By advisorButton = By.xpath("//button[contains(@autotest-target,'advisor-button-at-id')]");
	private static final By contractInfoButton = By.xpath("//span[text()=' Send Contract Info & Summary ']/parent::button");
	private static final By contractCheckbox = By.xpath("(//div[@class='o2uk-checkbox-frame'])[2]");
	private static final By confirmContinue = By.xpath("//span[text()=' Confirm and continue ']/parent::button");


	//Bank details page
	private static final By bankAccountHolder = By.xpath("//input[@placeholder='As displayed on your account']");
	private static final By sortCode = By.xpath("//input[@placeholder='00 - 00 - 00']");
	private static final By bankAccountNumber = By.xpath("//input[@placeholder='8 numbers long']");
	private static final By validateButton = By.xpath("//span[contains(text(),'Validate')]");
	private static final By checkBox = By.cssSelector(".o2uk-checkbox-inner-container");
	private static final By saveContinueBtn = By.xpath("//span[contains(text(),' Save and continue ')]");
	private static final By CardHolderName = By.id("cardName");
	private static final By CardNumber = By.id("cardNumber");
	private static final By CardMonth = By.id("expiryDateMonthInput");
	private static final By CardYear = By.id("expiryDateYearInput");
	private static final By SecurityCode = By.id("csc");
	private static final By completePurchase = By.xpath("//button[@id='bConfirmPaymentButton']");
	//	private static final By creditCheckBox = By.xpath("//div[@class='o2uk-checkbox-frame']");
	private static final By notNowBtn = By.xpath("//*[text()=' Not now ']");
	//	private static final By confirmCreditCheck = By.xpath("//button[@class='mat-focus-indicator mat-button-base o2uk-primary-button ng-star-inserted']");
	private static final By continueCreditCheck = By.xpath("//span[text()=' Continue ']/parent::button");
	private static final By confirmCreditButtton = By.xpath("//span[text()=' Confirm ']/parent::button");
	private static final By packageNme = By.xpath("//input[contains(@id,'mat-input-')][contains(@placeholder,'eg.')]");
	private static final By inStockAvailability = By.xpath("//strong[@class='o2uk-stock-availability__info-title']");

	//Order review page
	private static final By reviewOrder = By.xpath("//button[@class='mat-focus-indicator mat-button-base o2uk-primary-button']");
	private static final By secureCheckout = By.xpath("//span[text()=' Continue ']/parent::button");
	private static final By readPcci = By.xpath("//*[text()='Read PCCI']");
	private static final By agreeButton = By.xpath("//*[@aria-label='I agree']");
	private static final By consumerCreditAgreement = By.xpath("//*[text()='Read the Consumer Credit Agreement']");
	private static final By equipmentOnlyAgreement = By.xpath("//span[text()='O2 equipment only agreement']");
	private static final By monthlyMobileAgreement = By.xpath("//*[text()='Read Pay Monthly Mobile Agreement']");
	private static final By insuranceDocument = By.xpath("//*[text()='View Insurance Product Information Document' and contains(@class,'bold')]");
	private static final By insuranceAgreement = By.xpath("//*[text()='View Insurance Terms and Conditions']");
	private static final By secureCheckoutCheckbox = By.xpath("//div[@class='o2uk-checkbox-inner-container']");
	private static final By insuranceRadio = By.xpath("//*[text()=' By email only ']");
	private static final By placeOrderAndPay = By.xpath("//span[text()=' Place order and pay ']/parent::button");
	private static final By skipButton = By.xpath("//input[@value='Skip']");
	private static final By orderConfirmEpos = By.xpath("//h2[text()='Awaiting transaction confirmation']");

	private static final By basketDropdown = By.xpath("//div[@class='o2uk-svg o2uk-svg_size_s basket-voucher__expansion-icon']//span[@class='o2uk-icon-font icon-chevron-down']");
	private static final By voucherCode = By.xpath("//input[contains(@class,'o2uk-input-element mat-input-element mat-form-field-autofill-control ng-tns')]");
	private static final By updateButton = By.xpath("//button[@type='submit']");
	private static final By monthlyVoucherTotalPrice = By.xpath("//div[@class='total-section__total-costs-item-last-monthly-detail']");
	//private static final By upfrontTotalPrice = By.xpath("//div[@class='total-section__total-costs-item-last-upfront-detail']//div[@class='o2uk-price__amount ng-star-inserted']");
	private static final By upfrontTotalPrice = By.xpath("(//div[@class='total-section__total-costs-item-last-upfront-detail']//div[contains(@class,'ng-star-inserted')])[1]");

	private static final By simoFilter = By.xpath("//button[contains(@class,'o2uk-pseudo-dropdown')]//following::span[contains(@class,'o2uk-filter__selected-options')]");
	private static final By filterBy = By.xpath("//span[text()=' Filter by ']");
	//private static final By monthlyData = By.xpath("//p[text()='Monthly data']");
	private static final By monthlyData = By.xpath("//div[text()='Monthly data']");
	private static final By monthlyDataSelectAll = By.xpath("(//span[text()='Select all'])[1]");
	private static final By contractLengthfilter = By.xpath("//button[contains(@aria-label,'Contract length')]");
	//private static final By contractLength = By.xpath("//p[text()='Contract length']");

	private static String email = "";
	private static String insuranceStatus = "";


	//declarations
	java.util.List<WebElement> l1=new ArrayList<WebElement>();
	VMOReusableLibrary Vmor = new VMOReusableLibrary(scriptHelper);

	//***************** Actions **********************

	public void invokeApplicationEpos() 
	{
		String AdftEnvironment = properties.getProperty("AdftEnvironment");
		if(AdftEnvironment==null) {
			report.updateTestLog("The variable is null","Please give a URL", Status.FAIL);
			driver.quit();
		}
		else {	
			driver.get(getEnvironmentUrl(AdftEnvironment, "EPOS"));	
			report.updateTestLog("Url is launched successfully",getEnvironmentUrl(AdftEnvironment, "EPOS"), Status.PASS);
		}
	}

	public void selectDeviceEpos()
	{	
		if (!dataTable.getData("EPOS_E2E", "discountAmount").equalsIgnoreCase("NA")) {
			enterText(agentRoleTxt, "agentRoleTxt", "Franchise Sales Manager", null);
		}		
		craftFluentWait(submitButton,3);
		click(submitButton, "submitButton", "Y");
		craftFluentWait(shopLink,5);
		mouseHover(shopLink, "shopLink", "Y");
		By deviceType = By.linkText(dataTable.getData("EPOS_E2E", "deviceType"));
		craftFluentWait(deviceType,10);
		click(deviceType, "deviceType", "Y");
		pause(10);
		if (!dataTable.getData("EPOS_E2E", "deviceType").contains("SIM Only")) {
			craftFluentWait(deviceSearch,15);
			if(!dataTable.getData("EPOS_E2E", "deviceName").contains("Like New")) {
				enterText(deviceSearch, "deviceSearch", dataTable.getData("EPOS_E2E", "searchName"), null);
				pause(10);
				for (int i = 0; i < getListOfElements(searchResults).size(); i++) {
					if (getListOfElements(searchResults).get(i).getText().equalsIgnoreCase(dataTable.getData("EPOS_E2E", "deviceName"))) {
						waitScrollAndClickJs(10,getListOfElements(searchResults).get(i), "searchResults", "Y");	
						break;
					}
				}
			}
			else {
				enterText(deviceSearch, "deviceSearch", dataTable.getData("EPOS_E2E", "searchName"), null);
				pause(5);
				click(searchButton, "searchButton", null);
				pause(5);
				String searchName=dataTable.getData("EPOS_E2E", "searchName");
				String Phone="//div[@class='device-card__content']/div/h2/span[text()='"+searchName+"']"
						+"/parent::h2/following-sibling::div/o2uk-badge";
				List<WebElement> searchPhone=driver.findElements(By.xpath(Phone));
				for(WebElement se:searchPhone){
					if(se.getText().equalsIgnoreCase("Like New")) {
						pause(5);
						waitScrollAndClickJs(20, se, "searchPhone", "Y");
					}
				}
			}

		}
		pause(5);
		if (!dataTable.getData("EPOS_E2E", "deviceDeactivation").equalsIgnoreCase("NA")) {
			if(getListOfElements(searchResults).size()==0) {
				report.updateTestLog("Deactivation of devices ","Device is deactivated ", Status.PASS);
			}
		}
	}

	//validate Promo
	public void validtePromos()
	{
		pause(5);
		scrollIntoView(viewPromo);
		//report.updateTestLog("GWP","The List of Promos are", Status.PASS);
		int gwpPromo = getListOfElements(promoGWP).size();
		int numberOfGifts =0;
		if(gwpPromo==0) {
			report.updateTestLog("GWP","Promos are not available", Status.FAIL);
		}
		else {
			for(int i=0; i<=getListOfElements(promoGWP).size()-1;i++) {
				pause(2);
				numberOfGifts++;
				report.updateTestLog("The List of Promos are",getListOfElements(promoGWP).get(i).getText(), Status.PASS);
			}			
		}
		report.updateTestLog("Number of Gifts","Number of Gifts Count is " +numberOfGifts, Status.DONE);
	}



	public void selectColorCapacityEpos() 
	{
		boolean colorVal = false;
		boolean capacityVal = false;

		if (!dataTable.getData("EPOS_E2E", "deviceCapacity").equalsIgnoreCase("NA")) {
			try {			
				waitScrollAndClickJs(10,capacityDropdown, "capacityDropdown", "Y");
				for (WebElement obj : getListOfElements(capacityDropdownList)) {
					if (obj.getText().contains(dataTable.getData("EPOS_E2E", "deviceCapacity"))) {
						waitScrollAndClickJs(10,obj, "capacityDropdownList", "Y");  
						capacityVal = true;
						break;
					}
				}
				scrollIntoView(capacityDropdownField);
				if (r_getText(capacityDropdownField).equalsIgnoreCase(dataTable.getData("EPOS_E2E", "deviceCapacity"))) {
					capacityVal = true;
				}
			} catch (Exception e) {
				if (r_getText(defaultCapacity).equalsIgnoreCase(dataTable.getData("EPOS_E2E", "deviceCapacity"))) {
					capacityVal = true;
				}
			}
			if (!capacityVal) {
				report.updateTestLog("capacity is not available as expected","capacity is not available as expected", Status.FAIL);		
				pause(5);
			}
		}
		if (!dataTable.getData("EPOS_E2E", "deviceColor").equalsIgnoreCase("NA")) {
			try {
				waitScrollAndClickJs(10,colorDropdown,"colorDropdown", "Y");
				for (WebElement obj : getListOfElements(colorDropdownList)) {
					if (obj.getText().contains(dataTable.getData("EPOS_E2E", "deviceColor"))) {
						waitScrollAndClickJs(10,obj, "colorDropdownList", "Y"); 
						pause(3);
						colorVal = true;
						break;
					}
				}
				scrollIntoView(colorDropdownField);
				if (r_getText(colorDropdownField).equalsIgnoreCase(dataTable.getData("EPOS_E2E", "deviceColor"))) {
					colorVal = true;
				}
			} catch (Exception e) {
				if (r_getText(defaultColor).equalsIgnoreCase(dataTable.getData("EPOS_E2E", "deviceColor"))) {
					colorVal = true;
				}
			}
			if (!colorVal) {
				report.updateTestLog("color is not available as expected","color is not available as expected", Status.FAIL);
			}
			if (!dataTable.getData("EPOS_E2E", "deviceDeactivation").equalsIgnoreCase("NA")) {
				if(!(colorVal && capacityVal)) {
					report.updateTestLog("Deactivation of devices ","Device is deactivated ", Status.PASS);
				}
				else {
					report.updateTestLog("Deactivation of devices ","Device is not deactivated ", Status.FAIL);
				}
			}
		}
		pause(5);
		if (dataTable.getData("EPOS_E2E", "deviceDeactivation").equalsIgnoreCase("NA")) {
			scrollIntoView(deviceNameField);
			try {
				waitScrollAndClickJs(20, homeDeliveryOption, "homeDeliveryOption", "Y");
			}
			catch (Exception e) {
				e.getMessage();
				report.updateTestLog("Home Delivery ","Home delivery is selected already and is in stock", Status.PASS);
			}
			pause(5);
			String stockAvailability = r_getText(inStockAvailability);
			if(stockAvailability.contains("In stock")) {
				report.updateTestLog("Stock check","Device is in stock", Status.PASS);
			}
			else {
				report.updateTestLog("Stock check","Device is not in stock", Status.FAIL);
			}
		}
		pause(5);
		if(dataTable.getData("EPOS_E2E","promoGWP").equalsIgnoreCase("Yes")) {
			validtePromos();
		}
	}


	public void paymentPlanSelectionEpos() 
	{
		String devicePriceVal = "";
		if (!dataTable.getData("EPOS_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) {	
			waitScrollAndClickJs(15,payInFull, "payInFull", "Y");
			pause(2);
			try {
				scrollIntoView(resetCalculator);
			}
			catch (Exception e) {
				report.updateTestLog("resetCalculator ","resetCalculator is not available ", Status.DONE);
			}
			devicePriceVal = r_getText(deviceCurrency) + r_getText(devicePrice) + r_getText(deviceDecimalPrice);
		}
		else {
			pause(5);
			try {

				if(getElement(payInFull).isDisplayed()) {
					waitScrollAndClickJs(15,payInFull, "payInFull", "Y");
				}
			}
			catch (Exception e) {
				e.getMessage();
			}
			scrollIntoView(accessoriesPrice);
			devicePriceVal = r_getText(accessoriesCurrency) + r_getText(accessoriesPrice) + r_getText(accessoriesDecimalPrice);   
		}
		if (!dataTable.getData("EPOS_E2E", "devicePrice").equalsIgnoreCase("NA")) {				
			if (devicePriceVal.equals(dataTable.getData("EPOS_E2E", "devicePrice"))) {
				report.updateTestLog("Expected Device price is "+dataTable.getData("EPOS_E2E", "devicePrice"),"Actual Device price is correct "+devicePriceVal, Status.PASS);	            	
			} else {
				report.updateTestLog("Expected Device price is "+dataTable.getData("EPOS_E2E", "devicePrice"),"Actual Device price is incorrect "+devicePriceVal, Status.FAIL);  
			}
		}
		if (dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
			if (!dataTable.getData("EPOS_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) {
				waitScrollAndClickJs(15,spreadCost, "spreadCost", "Y");
				pause(5);
				try {
					driver.findElement(upfrontInputField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
					driver.findElement(upfrontInputField).sendKeys(dataTable.getData("EPOS_E2E", "maxUpfront"));
					pause(5);
					driver.findElement(upfrontInputField).sendKeys(Keys.ENTER);
				}
				catch (Exception e) {
					e.getMessage();
				}
				pause(5);
				if (!(dataTable.getData("EPOS_E2E", "devicePrice").equalsIgnoreCase("NA") ||  dataTable.getData("EPOS_E2E", "deviceType").equalsIgnoreCase("Tech and accessories"))) {
					scrollIntoView(getListOfElements(ccaAmountField).get(0));
					String minAmount = getListOfElements(ccaAmountField).get(0).getText();
					String maxAmount = getListOfElements(ccaAmountField).get(1).getText();
					scrollIntoView(calculatorField);	            
					if (maxAmount.equals(dataTable.getData("EPOS_E2E", "maxUpfront")) && minAmount.equals(dataTable.getData("EPOS_E2E", "minUpfront"))) { 
						report.updateTestLog("Expected Maximum upfront amount is "+dataTable.getData("EPOS_E2E", "maxUpfront"), " Actual Maximum upfront amount is "+maxAmount, Status.PASS);
						report.updateTestLog("Expected Minimum upfront amount is "+dataTable.getData("EPOS_E2E", "minUpfront"), " Actual Minimum upfront amount is "+minAmount, Status.PASS);
					} else {
						report.updateTestLog("Expected Maximum upfront amount is "+dataTable.getData("EPOS_E2E", "maxUpfront"), " Actual Maximum upfront amount is "+maxAmount, Status.FAIL);
						report.updateTestLog("Expected Minimum upfront amount is "+dataTable.getData("EPOS_E2E", "minUpfront"), " Actual Minimum upfront amount is "+minAmount, Status.FAIL);
					}
				}
			} else if (dataTable.getData("EPOS_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) {
				waitScrollAndClickJs(15,spreadCost, "spreadCost", "Y");	
				scrollIntoView(accessoriesPrice);
				devicePriceVal = r_getText(accessoriesCurrency) + r_getText(accessoriesPrice) + r_getText(accessoriesDecimalPrice);
				if(devicePriceVal.equals(dataTable.getData("EPOS_E2E", "maxUpfront")) && devicePriceVal.equals(dataTable.getData("EPOS_E2E", "minUpfront"))){					
					report.updateTestLog("Expected Maximum upfront amount is "+dataTable.getData("EPOS_E2E", "maxUpfront"), " Actual Maximum upfront amount is "+devicePriceVal, Status.PASS);
					report.updateTestLog("Expected Minimum upfront amount is "+dataTable.getData("EPOS_E2E", "minUpfront"), " Actual Minimum upfront amount is "+devicePriceVal, Status.PASS);
				}
				else {
					report.updateTestLog("Expected Maximum upfront amount is "+dataTable.getData("EPOS_E2E", "maxUpfront"), " Actual Maximum upfront amount is "+devicePriceVal, Status.FAIL);
					report.updateTestLog("Expected Minimum upfront amount is "+dataTable.getData("EPOS_E2E", "minUpfront"), " Actual Minimum upfront amount is "+devicePriceVal, Status.FAIL);
				}
			} 
			pause(5);
			scrollIntoView(ccamaxmonthfield);
			String ccamaxmonth = r_getText(ccamaxmonthfield);
			String ccaminmonth = r_getText(ccaminmonthfield);
			if (ccamaxmonth.equals(dataTable.getData("EPOS_E2E", "maxMonth")) && ccaminmonth.equals(dataTable.getData("EPOS_E2E", "minMonth"))) {	            	
				report.updateTestLog("Expected Maximum month is "+dataTable.getData("EPOS_E2E", "maxMonth") + " Actual Maximum month is "+ccamaxmonth,"Expected Minimum month is "+dataTable.getData("EPOS_E2E", "minMonth") + " Actual Minimum month is "+ccaminmonth, Status.PASS);
			} else {
				report.updateTestLog("Expected Maximum month is "+dataTable.getData("EPOS_E2E", "maxMonth") + " Actual Maximum month is "+ccamaxmonth,"Expected Minimum month is "+dataTable.getData("EPOS_E2E", "minMonth") + " Actual Minimum month is "+ccaminmonth, Status.FAIL);			
			}		}
		if (!dataTable.getData("EPOS_E2E", "allowanceBundle").equalsIgnoreCase("NA")) {
			validateAllowanceBundle();
		}
	}


	public void validateAllowanceBundle() {
		pause(5);
		while(getElement(decreaseAllowance).isEnabled()) {
			click(decreaseAllowance, "decreaseAllowance", null);
			pause(2);
		}
		if (dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
			report.updateTestLog("First Allowance bundle selected is "+r_getText(allowanceCapacity),"Allowance Price is "+r_getText(allowanceMonthlyPrice).split(" ")[2], Status.PASS);                   
		} else if(dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Pay in full")) {
			report.updateTestLog("First Allowance bundle selected is "+r_getText(allowanceCapacity),"Allowance Price is "+r_getText(allowanceCurrency) + r_getText(allowancePrice) + r_getText(allowanceDecimalPrice), Status.PASS);
		}
		while(getElement(increaseAllowance).isEnabled()) {
			if (dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
				scrollIntoView(getListOfElements(ccaAmountField).get(1));                       
			} else if(dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Pay in full")) {
				scrollIntoView(dataPlan);
			}
			click(increaseAllowance, "increaseAllowance", null);
			pause(3);
			String otherAllowanceCapacity = r_getText(allowanceCapacity);
			String otherAllowancePrice = r_getText(allowanceCurrency) + r_getText(allowancePrice) + r_getText(allowanceDecimalPrice); 
			if (dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
				String monthlyPrice =  r_getText(allowanceMonthlyPrice).split(" ")[2]; 
				report.updateTestLog("Allowance bundle selected is "+otherAllowanceCapacity,"Allowance monthly price is "+monthlyPrice, Status.PASS);                       
			} else if(dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Pay in full")) {
				report.updateTestLog("Allowance bundle selected is "+otherAllowanceCapacity,"Allowance monthly price is "+otherAllowancePrice, Status.PASS);
			}
		}
		if (dataTable.getData("EPOS_E2E", "allowanceBundle").contains("GB") || dataTable.getData("EPOS_E2E", "allowanceBundle").contains("Unlimited")) {
			String otherAllowanceCapacity = "";
			for (int i = 0; i <= 10; i++) {
				pause(3);
				otherAllowanceCapacity = r_getText(allowanceCapacity); 
				if (dataTable.getData("EPOS_E2E", "allowanceBundle").split(",")[0].equals(otherAllowanceCapacity)) {
					report.updateTestLog("Required Allowance bundle ","Required Allowance bundle is correct "+otherAllowanceCapacity, Status.DONE);
					if (dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
						String airTimePrice =  r_getText(allowanceMonthlyPrice).split("[\\s+]+")[2];
						if(dataTable.getData("EPOS_E2E", "allowancePrice").equals(airTimePrice)) {
							report.updateTestLog("Expected allowance price is "+dataTable.getData("EPOS_E2E", "allowancePrice"), "Actual allowance price is correct "+airTimePrice , Status.PASS); 
						} 
						else {
							report.updateTestLog("Expected allowance price is "+dataTable.getData("EPOS_E2E", "allowancePrice"), "Actual allowance price is incorrect "+airTimePrice, Status.FAIL); 
						}
					}
					else {

						String otherAllowancePrice = r_getText(allowanceCurrency) + r_getText(allowancePrice) + r_getText(allowanceDecimalPrice);
						if(dataTable.getData("EPOS_E2E", "allowancePrice").equals(otherAllowancePrice)) {
							report.updateTestLog("Expected allowance price is correct "+dataTable.getData("EPOS_E2E", "allowancePrice"), "Actual allowance price is correct "+otherAllowancePrice, Status.PASS); 
						} 
						else {
							report.updateTestLog("Expected allowance price is incorrect "+dataTable.getData("EPOS_E2E", "allowancePrice"),"Actual allowance price is incorrect "+otherAllowancePrice, Status.FAIL); 
						}					
					}

					break;
				}
				click(decreaseAllowance, "decreaseAllowance", null);
			}
			if (dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
				scrollIntoView(getListOfElements(ccaAmountField).get(1));                       
			} else if(dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Pay in full")) {
				scrollIntoView(dataPlan);
			}			
		}
	}


	public void validateInsurance() {
		if( getListOfElements(insuranceList).size()==0) {
			report.updateTestLog("Insurance ","Insurance is not available", Status.FAIL);
		}
		else {
			if (dataTable.getData("EPOS_E2E", "insurance").contains("O2 Insure Damage Cover")) {
				for (int i = 0; i <= getListOfElements(insuranceList).size() - 1; i++) {
					if (getListOfElements(insuranceList).get(i).getText().contains("O2 Insure Damage Cover")) {
						addInsurance(i);
					}
				}
			}
			else if (dataTable.getData("EPOS_E2E", "insurance").contains("O2 Insure Full Cover")) {
				for (int i = 0; i <= getListOfElements(insuranceList).size() - 1; i++) {
					if (getListOfElements(insuranceList).get(i).getText().contains("O2 Insure Full Cover")) {
						addInsurance(i);
					}
				}
			}
			else if (dataTable.getData("EPOS_E2E", "insurance").equalsIgnoreCase("No cover"))
			{
				try {
					waitScrollAndClickJs(5, noInsurance, "noInsurance", "Y"); 
					pause(5);
					report.updateTestLog("No cover Insurance","No cover Insurance is selected", Status.PASS);
				}
				catch (Exception e) {
					report.updateTestLog("No cover Insurance","No cover Insurance is already selected", Status.PASS);
				}
			}
		}
	}
	public void addInsurance(int num) {
		try {
			waitScrollAndClickJs(15, getListOfElements(addInsuranceBtn).get(num - 1), "addInsuranceBtn", "Y"); 
			pause(5);
			scrollIntoView(getListOfElements(insuranceList).get(num));
			report.updateTestLog("Insurance ","Insurance selected is "+getListOfElements(insuranceList).get(num).getText(), Status.PASS);
			insuranceStatus = "Available";
		} catch(Exception e) {
			report.updateTestLog("Insurance ","Insurance is not available", Status.FAIL);	
		}
	}


	public void validateExtras() 
	{
		for(int i=0;i<getListOfElements(listOfExtras).size();i++) {
			scrollIntoView(getListOfElements(listOfExtras).get(i));
			report.updateTestLog("Opal extra name ",getListOfElements(listOfExtras).get(i).getText(), Status.PASS);
		}
	}

	public void applyVouchers()
	{
		pause(5);
		clickByJse(basketDropdown, "basketDropdown", "Y");
		waitScrollAndClickJs(10,voucherCode, "voucherCode", "Y");	
		enterText(voucherCode, "voucherCode",dataTable.getData("EPOS_E2E", "voucherCode") , null);
		pause(5);
		clickByJse(updateButton, "updateButton", "Y");
		pause(5);
		if(r_getText(monthlyVoucherTotalPrice).contains(dataTable.getData("EPOS_E2E", "voucherDiscountPrice")))
		{
			report.updateTestLog("Expected Monthly Voucher Discount Price is "+dataTable.getData("EPOS_E2E", "voucherDiscountPrice"), "Actual Monthly Voucher Discount Price is correct "+r_getText(monthlyVoucherTotalPrice), Status.PASS);
		}
		else if(r_getText(upfrontTotalPrice).contains(dataTable.getData("EPOS_E2E", "voucherDiscountPrice")))
		{
			report.updateTestLog("Expected Upfront Discount Price is "+dataTable.getData("EPOS_E2E", "voucherDiscountPrice"), "Actual Upfront Discount Price is correct "+r_getText(upfrontTotalPrice), Status.PASS);
		}
		else {	
			report.updateTestLog("Voucher Discount Price","Voucher Discount Price is incorrect ", Status.FAIL);
		}
	}


	public void enterCustomerDetailsEpos() 
	{
		if (!(dataTable.getData("EPOS_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")
				|| dataTable.getData("EPOS_E2E", "deviceType").contains("SIM Only"))) {
			pause(8);
			waitScrollAndClickJs(10,selectPlan, "selectPlan", "Y");
			pause(5);
			if (!dataTable.getData("EPOS_E2E", "insurance").equalsIgnoreCase("NA")) {
				validateInsurance();
			}
			if (!dataTable.getData("EPOS_E2E", "opalExtras").equalsIgnoreCase("NA")) {
				validateExtras();
			}
			waitScrollAndClickJs(20,addToBasketAccessories, "addBasket", "Y");
		} else if (dataTable.getData("EPOS_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) { 
			waitScrollAndClickJs(20,addToBasketAccessories, "addToBasketAccessories", "Y");
		} else if(dataTable.getData("EPOS_E2E", "deviceType").contains("Monthly SIM")){ 
			if (dataTable.getData("EPOS_E2E", "searchName").equalsIgnoreCase("30 Day") || dataTable.getData("EPOS_E2E", "searchName").equalsIgnoreCase("12 Month") 
					|| dataTable.getData("EPOS_E2E", "searchName").equalsIgnoreCase("24 Month")) {

				/*scrollIntoView(filterBy);
				pause(5);
				click(simoFilter, "simoFilter", "Y");
				pause(5);
				click(monthlyData, "monthlyData", "Y");
				pause(5);
				waitScrollAndClickJs(5, monthlyDataSelectAll, "monthlyDataSelectAll", "Y");
				pause(5);
				clickByJse(contractLengthfilter, "contractLengthfilter", "Y");	
				pause(5);
				clickByJse(contractLength, "contractLength", "Y");		
				pause(5);
				String planName = dataTable.getData("EPOS_E2E", "searchName");
				By contractLengthSelection = By.xpath("//input[contains(@aria-label,'Select filter by "+planName+"')]//parent::div[@class='o2uk-checkbox-inner-container']");
				scrollIntoView(contractLengthSelection);
				pause(5);
				clickByJse(contractLengthSelection, "contractLengthSelection", "Y");
				pause(5);
				String deviceName = dataTable.getData("EPOS_E2E", "deviceName");
				By simaddtobasket = By.xpath("//h2[text()=' "+deviceName+" ']//following::button[@aria-label='Add to Basket "+deviceName+" tariff plan']");
				scrollIntoView(simaddtobasket);
				waitScrollAndClickJs(5, simaddtobasket, "simaddtobasket", "Y");*/

				scrollIntoView(filterBy);
				pause(5);
				clickByJse(contractLengthfilter, "contractLengthfilter", "Y");			
				pause(5);
				String planName = dataTable.getData("EPOS_E2E", "searchName");
				By contractLengthSelection = By.xpath("//div[text()=' "+planName+" ']//parent::div");
				//scrollIntoView(contractLengthSelection);
				pause(5);
				clickByJse(contractLengthSelection, "contractLengthSelection", "Y");
				pause(5);	
				click(simoFilter, "simoFilter", "Y");
				pause(5);
				if(driver.findElement(monthlyDataSelectAll).isDisplayed())
				{
					waitScrollAndClickJs(5, monthlyDataSelectAll, "monthlyDataSelectAll", "Y");
				}
				else {
					click(monthlyData, "monthlyData", "Y");
					waitScrollAndClickJs(5, monthlyDataSelectAll, "monthlyDataSelectAll", "Y");
				}
				pause(5);
				String deviceName = dataTable.getData("EPOS_E2E", "deviceName");
				By simaddtobasket = By.xpath("//h2[text()=' "+deviceName+" ']//following::button[@aria-label='Add to Basket "+deviceName+" tariff plan']"); 
				scrollIntoView(simaddtobasket);
				waitScrollAndClickJs(5, simaddtobasket, "simaddtobasket", "Y");
				pause(2);
			}else {
				String offeringUrl = driver.getCurrentUrl()+"/configuration?plan-offering-id="+dataTable.getData("EPOS_E2E", "searchName");
				waitScrollAndClickJs(10,getListOfElements(addSimToBasket).get(0), "addSimToBasket", "Y");
				pause(5);
				driver.get(offeringUrl);
				pause(2);
			} 
			pause(15);
			scrollIntoView(simAllowanceCapacity);
			waitScrollAndClickJs(10,showAllowanceDetails, "showAllowanceDetails", "Y");
			if (dataTable.getData("EPOS_E2E", "deviceName").split(",")[0].equalsIgnoreCase(r_getText(simAllowanceCapacity))) {
				report.updateTestLog("Expected Simo plan capacity is "+dataTable.getData("EPOS_E2E", "deviceName").split(",")[0], "Actual Simo plan capacity is correct "+r_getText(simAllowanceCapacity), Status.PASS);
			}
			else {
				report.updateTestLog("Expected Simo plan capacity is "+dataTable.getData("EPOS_E2E", "deviceName").split(",")[0], "Actual Simo plan capacity is incorrect "+r_getText(simAllowanceCapacity), Status.FAIL);
			}
			if (r_getText(simAllowancePrice).contains(dataTable.getData("EPOS_E2E", "devicePrice"))) {
				report.updateTestLog("Expected Simo plan price is "+dataTable.getData("EPOS_E2E", "devicePrice"), "Actual Simo plan price is correct "+r_getText(simAllowancePrice), Status.PASS);
			}
			else {
				report.updateTestLog("Expected Simo plan price is "+dataTable.getData("EPOS_E2E", "devicePrice"), "Actual Simo plan price is incorrect "+r_getText(simAllowancePrice), Status.FAIL);
			}
			if (!dataTable.getData("EPOS_E2E", "opalExtras").equalsIgnoreCase("NA")) {
				validateExtras();
			}
			waitScrollAndClickJs(10,addToBasketAccessories, "addBasket", "Y");
		}
		if (!dataTable.getData("EPOS_E2E", "discountAmount").equalsIgnoreCase("NA")) {
			validateUpfrontDiscount();
		}
		if (!dataTable.getData("EPOS_E2E", "voucherCode").equalsIgnoreCase("NA")) {
			applyVouchers();
		}
		pause(10);
		craftFluentWait(checkOutBtn,15);
		scrollIntoView(basketOptions);
		clickByJse(checkOutBtn, "checkOutBtn", "Y");			
		craftFluentWait(customerCreateEmail,10);
		scrollIntoView(customerCreateEmail);
		email = RandomStringUtils.randomAlphanumeric(12)+"@yopmail.com";
		enterText(customerCreateEmail, "customerCreateEmail", email, "Y");
		waitScrollAndClickJs(10,loginEmail, "loginEmail", "Y");
		craftFluentWait(customerPreferredTitle,15);
		enterText(customerPreferredTitle, "customerPreferredTitle",dataTable.getData("General_Data", "title") , null);
		enterText(customerFirstName, "customerFirstName",dataTable.getData("General_Data", "firstName")+RandomStringUtils.randomAlphabetic(5), null);
		enterText(customerLastName, "customerLastName", dataTable.getData("General_Data", "lastName"), null);
		enterText(customerDOB, "customerDOB",dataTable.getData("General_Data", "dob"), null);
		enterText(customerTelephoneNum, "customerTelephoneNum",dataTable.getData("General_Data", "mobile") , "Y");
		enterText(customerPostalCode, "customerPostalCode",dataTable.getData("General_Data", "postalCode"), "Y");
	}


	public void validateUpfrontDiscount() {
		{
			waitScrollAndClickJs(10,upfrontOption, "upfrontOption", "Y");
			pause(5);
			waitScrollAndClickJs(10,discountReason, "discountReason", "Y");
			pause(5);
			for (WebElement obj : getListOfElements(discountTypes)) {
				if (obj.getText().contains(dataTable.getData("EPOS_E2E", "discountReason"))) {
					waitScrollAndClickJs(10,obj, "discountReason", "Y");
					break;
				}
			}
			pause(3);
			try {
				enterText(discountJustification, "discountJustification","Test", "Y");
			}catch(Exception e)
			{
				report.updateTestLog("Discount Justification ","Discount Justification is not available", Status.FAIL); 
			}
			pause(3);
			try {
				enterText(discountCode, "discountCode","1111111111111", "Y");
			}catch(Exception e)
			{
				report.updateTestLog("Discount Code ","Discount Code is not available", Status.FAIL);
			}
			double maxValue = Double.parseDouble(dataTable.getData("EPOS_E2E", "discountAmount")) + 0.01;
			enteringUpfrontDiscount("0.01");
			pause(3);
			waitScrollAndClickJs(10,discountJustification, "discountJustification", null);
			pause(3);
			waitScrollAndClickJs(10,applyDiscount, "applyDiscount", "Y");
			pause(10);
			scrollIntoView(packageName);
			report.updateTestLog("Upfront discount ","Minimum Upfront discount is 0.01", Status.PASS); 
			waitScrollAndClickJs(10,changeDiscount, "changeDiscount", "Y");
			pause(3);
			waitScrollAndClickJs(10,discountInput, "discountInput", "Y");
			enteringUpfrontDiscount(String.valueOf(maxValue)); 
			waitScrollAndClickJs(10,discountJustification, "discountJustification", null);
			String maxErrorMessage = r_getText(upfrontErrorMsg);			
			if (maxErrorMessage.contains("You cannot give this much as a discount")) {
				report.updateTestLog("Upfront discount ", maxValue+" is not accepted as Upfront discount", Status.PASS);
			} else {
				report.updateTestLog("Upfront discount ",maxValue+" is accepted as Upfront discount", Status.FAIL);
			}
			waitScrollAndClickJs(10,discountInput, "discountInput", "Y");
			enteringUpfrontDiscount(dataTable.getData("EPOS_E2E", "discountAmount")); 
			waitScrollAndClickJs(10,discountJustification, "discountJustification", null);
			pause(3);
			waitScrollAndClickJs(10,applyDiscount, "applyDiscount", "Y");
			pause(10);
			scrollIntoView(packageName);
			String discountApplied = r_getText(appliedDiscount);
			if (discountApplied.equals("£"+dataTable.getData("EPOS_E2E", "discountAmount")+" off")) {
				report.updateTestLog("Expected Upfront discount is "+("£"+dataTable.getData("EPOS_E2E", "discountAmount")+" off"), "Upfront discount applied is correct "+discountApplied, Status.PASS);
			} else {
				report.updateTestLog("Expected Upfront discount is "+("£"+dataTable.getData("EPOS_E2E", "discountAmount")+" off"), "Upfront discount applied is incorrect "+discountApplied, Status.FAIL);
			} 
		}
	}


	public void enteringUpfrontDiscount(String amount) {
		pause(5);
		getElement(discountInput).clear();
		for (int j = 0; j < 9; j++) {
			getElement(discountInput).sendKeys(Keys.BACK_SPACE);
		}
		char[] arr = amount.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case '0':
				getElement(discountInput).sendKeys(Keys.NUMPAD0);
				break;
			case '1':
				getElement(discountInput).sendKeys(Keys.NUMPAD1);
				break;
			case '2':
				getElement(discountInput).sendKeys(Keys.NUMPAD2);
				break;
			case '3':
				getElement(discountInput).sendKeys(Keys.NUMPAD3);
				break;
			case '4':
				getElement(discountInput).sendKeys(Keys.NUMPAD4);
				break;
			case '5':
				getElement(discountInput).sendKeys(Keys.NUMPAD5);
				break;
			case '6':
				getElement(discountInput).sendKeys(Keys.NUMPAD6);
				break;
			case '7':
				getElement(discountInput).sendKeys(Keys.NUMPAD7);
				break;
			case '8':
				getElement(discountInput).sendKeys(Keys.NUMPAD8);
				break;
			case '9':
				getElement(discountInput).sendKeys(Keys.NUMPAD9);
				break;
			case '.':
				getElement(discountInput).sendKeys(Keys.DECIMAL);
				break;
			default:
				report.updateTestLog("Upfront discount ","Default ", Status.DONE);
			}
		}
		pause(5);
	}


	public void enterAddressDetailsEpos() 
	{
		try {
			waitScrollAndClickJs(10,customerFindButton, "customerFindButton", "Y");
			pause(10);
			waitScrollAndClickJs(20,addressDropdown, "addressDropdown", "Y");
		} catch (Exception e) {
			enterText(customerPostalCode, "customerPostalCode",dataTable.getData("General_Data", "postalCode"), "Y");
			waitScrollAndClickJs(10,customerFindButton, "customerFindButton", "Y");
			pause(10);
			waitScrollAndClickJs(15,addressDropdown, "addressDropdown", "Y");
		}
		pause(5);
		try {
			waitScrollAndClickJs(10,getListOfElements(addressDropdownOptions).get(0), "addressDropdownOptions", "Y");
		} catch (Exception e) {
			waitScrollAndClickJs(10,getListOfElements(addressDropdownOptions).get(0), "addressDropdownOptions", "Y");
		}
		waitScrollAndClickJs(10,addressCheckbox, "addressCheckbox", "Y");

		try {
			waitScrollAndClickJs(10,addressConfirm, "addressConfirm", "Y");
		} catch (Exception e) {
			pause(5);
			waitScrollAndClickJs(10,addressConfirm, "addressConfirm", "Y");
		}
	}


	public void selectDeliveryOptionEpos() 
	{
		pause(5);
		try {
			if (dataTable.getData("EPOS_E2E", "deliveryType").equalsIgnoreCase("Home delivery")) {
				waitScrollAndClickJs(10,homeDelivery, "homeDelivery", "Y");
			} else if (dataTable.getData("EPOS_E2E", "deliveryType").equalsIgnoreCase("Click and Collect")) {
				waitScrollAndClickJs(10,clickAndCollect, "clickAndCollect", "Y");
				waitScrollAndClickJs(10,selectStore, "selectStore", "Y");
				waitScrollAndClickJs(10,clickNCollectPostCode, "clickNCollectPostCode", "Y");
				enterText(clickNCollectPostCode, "clickNCollectPostCode",dataTable.getData("General_Data", "collectCode"), "Y");
				waitScrollAndClickJs(10,findByPostcodeButton, "findByPostcodeButton", "Y");
				waitScrollAndClickJs(10,listViewOfClickNCollectStores, "findByPostcodeButton", "Y");
				waitScrollAndClickJs(10,chooseFirstStore, "findByPostcodeButton", "Y");
			} else if (dataTable.getData("EPOS_E2E", "deliveryType").equalsIgnoreCase("Today at this store")) {         
				waitScrollAndClickJs(10,todayAtStore, "todayAtStore", "Y");       
			}
		} catch (Exception e) {	
			e.getMessage();
		}
		pause(10);
		try {
			waitScrollAndClickJs(20,confirmDeliveryOption, "confirmDeliveryOption", "Y");
			pause(5);
			waitScrollAndClickJs(15,getListOfElements(confirmContinue).get(1), "confirmContinue", "Y");
		} catch (Exception e) {	
			e.getMessage();
		}
		try {
			pause(5);
			waitScrollAndClickJs(20,getListOfElements(continueButton).get(getListOfElements(continueButton).size()-1), "continueButtton", "Y");
		} catch (Exception e) {	
			pause(5);
			waitScrollAndClickJs(20,continueButton, "continueButtton", "Y");
		}
		try {
			waitScrollAndClickJs(15,questionContinueButton, "questionContinueButtton", "Y");	
		} catch (Exception e) {
			waitScrollAndClickJs(15,getListOfElements(continueButton).get(getListOfElements(continueButton).size()-1), "continueButtton", "Y");
		}
	}


	public void eligibiltyCheckEpos() {
		if (!(dataTable.getData("EPOS_E2E", "deviceType").equalsIgnoreCase("Tech and accessories") &&
				dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Pay in full"))) {
			try {
				waitScrollAndClickJs(15,timeAtAddress, "timeAtAddress", "Y");
			} catch (Exception e) {
				pause(5);
				waitScrollAndClickJs(15,timeAtAddress, "timeAtAddress", "Y");
			}
			for (WebElement obj : getListOfElements(eligibilityCheckheckOptions)) {
				if (obj.getText().contains(dataTable.getData("General_Data", "liveAtAddressPeriod"))) {
					waitScrollAndClickJs(15,obj, "eligibilityCheckheckOptions", "Y");   
					break;
				}
			}
			waitScrollAndClickJs(15,employmentStatus, "employmentStatus", "Y");
			for (WebElement obj : getListOfElements(eligibilityCheckheckOptions)) {
				if (obj.getText().contains(dataTable.getData("General_Data", "employmentStatus"))) {
					waitScrollAndClickJs(15,obj, "eligibilityCheckheckOptions", "Y");   
					break;
				}
			}
			waitScrollAndClickJs(15,personalAnnualIncome, "personalAnnualIncome", "Y");
			for (WebElement obj : getListOfElements(eligibilityCheckheckOptions)) {
				if (obj.getText().contains(dataTable.getData("General_Data", "personalAnnualIncome"))) {
					waitScrollAndClickJs(15,obj, "eligibilityCheckheckOptions", "Y");   
					break;
				}
			}
			waitScrollAndClickJs(15,eligibilityCheckAgree, "EligibilityCheckAgree", "Y");
			try {
				waitScrollAndClickJs(15,eligibilityCheckContinue, "EligibilityCheckContinue", "Y");
			}catch (Exception e) {
				waitScrollAndClickJs(15,eligibilityCheckContinueSecond, "eligibilityCheckContinueSecond", "Y");
			} 
			waitScrollAndClickJs(15,advisorButton, "advisorButton", "Y"); 
			waitScrollAndClickJs(15,continueButton, "continueButtton", "Y");       
			pause(10);
			if (!dataTable.getData("EPOS_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) {
				waitScrollAndClickJs(30,contractInfoButton, "contractInfoButton", "Y");  
				pause(35);
				waitScrollAndClickJs(30,contractCheckbox, "contractCheckbox", "Y"); 
				try {
					waitScrollAndClickJs(15,getListOfElements(confirmContinue).get(3), "confirmContract", "Y");
				} catch (Exception e) {
					waitScrollAndClickJs(15,getListOfElements(confirmContinue).get(2), "confirmContract", "Y");
				} 
				pause(15);
				try {
					waitScrollAndClickJs(25,getListOfElements(advisorButton).get(0), "advisorButton", "Y");
				} catch (Exception e) {
					waitScrollAndClickJs(25,getListOfElements(advisorButton).get(1), "advisorButton", "Y");
				} 
				pause(10);
				try {
					waitScrollAndClickJs(25,continueButton, "continueButtton", "Y");
				} catch (Exception e) {
					e.printStackTrace();
				}       
				try {
					waitScrollAndClickJs(15,getListOfElements(continueButton).get(1), "continueButtton", "Y");
				} catch (Exception e) {
					waitScrollAndClickJs(15,getListOfElements(continueButton).get(2), "continueButtton", "Y");
				} 
				pause(10);
			}
		}
	}


	public void enterBankDetailsEpos() {
		if (!(dataTable.getData("EPOS_E2E", "deviceType").equalsIgnoreCase("Tech and accessories") && 
				dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Pay in full"))) {
			craftFluentWait(bankAccountHolder, 10);
			enterText(bankAccountHolder, "bankAccountHolder", dataTable.getData("General_Data", "name"), null);
			enterText(bankAccountNumber, "bankAccountNumber", dataTable.getData("General_Data", "bankAccount"), null);
			enterText(sortCode, "sortCode", dataTable.getData("General_Data", "bankSortCode"), null);
			craftFluentWait(validateButton, 10);
			click(validateButton, "validateButton", "Y");			
			craftFluentWait(checkBox, 10);
			click(checkBox, "checkBox", "Y");
			click(saveContinueBtn, "saveContinueBtn", "Y");	
			pause(20);
			switchTo("Interface");
			craftFluentWait(CardHolderName, 25);
			scrollIntoView(CardHolderName);
			enterText(CardHolderName, "CardHolderName", dataTable.getData("General_Data", "name"), null);
			craftFluentWait(CardNumber, 10);
			scrollIntoView(CardNumber);
			enterText(CardNumber, "CardNumber", dataTable.getData("General_Data", "cardPan"), null);
			craftFluentWait(CardMonth, 10);
			scrollIntoView(CardMonth);
			selectByValue(CardMonth, "CardMonth", dataTable.getData("General_Data", "cardExpiryMonth"));
			craftFluentWait(CardYear, 10);
			scrollIntoView(CardYear);
			selectOptionByVisibleText(CardYear, "CardYear", dataTable.getData("General_Data", "cardExpiryYear"));
			craftFluentWait(SecurityCode, 10);
			scrollIntoView(SecurityCode);
			enterText(SecurityCode, "SecurityCode", dataTable.getData("General_Data", "cardCvv"), null);
			waitScrollAndClickJs(15,completePurchase, "completePurchase", "Y");	
			switchToDefault();
			pause(5);			
			waitScrollAndClickJs(15,confirmContinue, "confirmContinue", "Y");
			waitScrollAndClickJs(15,continueCreditCheck, "continueCreditCheck", "Y");
			pause(5);		
		}
	}


	public void checkoutOrderEpos() {
		if (!dataTable.getData("EPOS_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) {
			craftFluentWait(packageNme, 15);
			scrollIntoView(packageNme);
			enterText(packageNme, "packageNme",dataTable.getData("General_Data", "name") , "Y");
			pause(5);
			waitScrollAndClickJs(15,getListOfElements(confirmCreditButtton).get(0), "confirmCreditButtton", "Y");
			waitScrollAndClickJs(15,getListOfElements(confirmCreditButtton).get(1), "confirmCreditButtton", "Y");
			if (!dataTable.getData("EPOS_E2E", "deviceType").equalsIgnoreCase("All Tablets and Laptops")) {
				try {
					waitScrollAndClickJs(15,notNowBtn, "notNowBtn", "Y");
					waitScrollAndClickJs(15,getListOfElements(confirmCreditButtton).get(2), "confirmCreditButtton", "Y");
				}catch(Exception e1) {
					try {
						waitScrollAndClickJs(15,getListOfElements(confirmCreditButtton).get(2), "confirmCreditButtton", "Y");
					}
					catch (Exception e) {
						e.getMessage();
					}			
				}
				try {
					waitScrollAndClickJs(15,getListOfElements(confirmCreditButtton).get(3), "confirmCreditButtton", "Y");
				}catch(Exception e) {
					e.getMessage();
				}
			}
			pause(10);
			waitScrollAndClickJs(15,continueCreditCheck, "continueCreditCheck", "Y");
			pause(10);
			waitScrollAndClickJs(15,reviewOrder, "reviewOrder", "Y");
			pause(5);
			waitScrollAndClickJs(15,getListOfElements(secureCheckout).get(0), "secureCheckout", "Y");
			pause(15);
			if (dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
				waitScrollAndClickJs(25,getListOfElements(secureCheckout).get(0), "secureCheckout", "Y");
				try {
					pause(5);
					waitScrollAndClickJs(25,getListOfElements(secureCheckout).get(0), "secureCheckout", "Y");
				}catch(Exception e) {
					e.getMessage();
				}
				waitScrollAndClickJs(15,readPcci, "readPcci", "Y");
				waitScrollAndClickJs(15,agreeButton, "agreeButton", "Y");
				waitScrollAndClickJs(15,getListOfElements(secureCheckout).get(1), "secureCheckout", "Y");
				waitScrollAndClickJs(15,consumerCreditAgreement, "consumerCreditAgreement", "Y");
				pause(2);
				waitScrollAndClickJs(15,agreeButton, "agreeButton", "Y");
				waitScrollAndClickJs(15,getListOfElements(secureCheckout).get(2), "secureCheckout", "Y");
			}
			waitScrollAndClickJs(15,monthlyMobileAgreement, "monthlyMobileAgreement", "Y");
			pause(2);
			waitScrollAndClickJs(15,agreeButton, "agreeButton", "Y");				
			if (dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
				waitScrollAndClickJs(15,getListOfElements(secureCheckoutCheckbox).get(5), "secureCheckoutCheckbox", "Y");
				waitScrollAndClickJs(15,getListOfElements(secureCheckoutCheckbox).get(6), "secureCheckoutCheckbox", "Y");
				waitScrollAndClickJs(15,getListOfElements(secureCheckout).get(3), "secureCheckout", "Y");
				if(insuranceStatus.equalsIgnoreCase("Available")) {
					waitScrollAndClickJs(15,insuranceDocument, "insuranceDocument", "Y");
					pause(2);
					waitScrollAndClickJs(15,agreeButton, "agreeButton", "Y");
					pause(2);
					waitScrollAndClickJs(15,insuranceAgreement, "insuranceAgreement", "Y");
					pause(2);
					waitScrollAndClickJs(15,agreeButton, "agreeButton", "Y");
					pause(2);
					waitScrollAndClickJs(10,getListOfElements(insuranceRadio).get(1), "insuranceRadio", "Y");
					waitScrollAndClickJs(10,getListOfElements(secureCheckout).get(4), "secureCheckout", "Y");
				}
			} else if (dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Pay in full") ||
					dataTable.getData("EPOS_E2E", "deviceType").contains("SIM Only")) {
				waitScrollAndClickJs(15,getListOfElements(secureCheckoutCheckbox).get(1), "secureCheckoutCheckbox", "Y");
				waitScrollAndClickJs(15,getListOfElements(secureCheckoutCheckbox).get(2), "secureCheckoutCheckbox", "Y");
				waitScrollAndClickJs(15,getListOfElements(secureCheckout).get(0), "secureCheckout", "Y");	
				if(insuranceStatus.equalsIgnoreCase("Available")) {
					waitScrollAndClickJs(15,insuranceDocument, "insuranceDocument", "Y");
					pause(2);
					waitScrollAndClickJs(15,agreeButton, "agreeButton", "Y");
					pause(2);
					waitScrollAndClickJs(15,insuranceAgreement, "insuranceAgreement", "Y");
					pause(2);
					waitScrollAndClickJs(15,agreeButton, "agreeButton", "Y");
					pause(2);
					waitScrollAndClickJs(10,getListOfElements(insuranceRadio).get(0), "insuranceRadio", "Y");
					waitScrollAndClickJs(10,getListOfElements(secureCheckout).get(1), "secureCheckout", "Y");
				}
			}
		}
		else {
			completeOrderAccessories();
		}
		if (!(dataTable.getData("EPOS_E2E", "deviceType").equalsIgnoreCase("Tech and accessories") && 
				dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Pay in full"))) {
			try {
				waitScrollAndClickJs(15,placeOrderAndPay, "secureCheckout", "Y");	            
			} catch (Exception e) {
				waitScrollAndClickJs(15,getListOfElements(secureCheckout).get(getListOfElements(secureCheckout).size()-1), "secureCheckout", "Y");	           
			}
		}
		waitScrollAndClickJs(15,skipButton, "skipButton", "Y"); 
		pause(5);
		waitScrollAndClickJs(20, orderConfirmEpos, "orderConfirmEpos", "Y");
	}


	public void eposWarrantyAndDeviceTier() {
		EcomAdftPage ecomObj = new EcomAdftPage(scriptHelper);
		if (dataTable.getData("EPOS_E2E", "extendedWarranty").equalsIgnoreCase("Yes") || 
				(!dataTable.getData("EPOS_E2E", "customPlan").equalsIgnoreCase("NA"))){
			ecomObj.OrderInCsrd(email);
			if(!dataTable.getData("EPOS_E2E", "customPlan").equals("NA")) {
				ecomObj.customPlanValidation(dataTable.getData("EPOS_E2E", "customPlan"));
			}
			if(!dataTable.getData("EPOS_E2E", "extendedWarranty").equals("NA")) {
				ecomObj.extendedWarrantyValidation();
			}
		}
	}


	public void completeOrderAccessories() {
		pause(5);
		if (dataTable.getData("EPOS_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
			waitScrollAndClickJs(15,continueCreditCheck, "continueCreditCheck", "Y");                
			pause(5);
			try {
				waitScrollAndClickJs(15,getListOfElements(secureCheckout).get(0), "secureCheckout", "Y");	                    
			} catch (Exception e) {
				System.out.println("accesory");
			}
			pause(20);
			waitScrollAndClickJs(15,getListOfElements(secureCheckout).get(0), "secureCheckout", "Y");
			waitScrollAndClickJs(15,readPcci, "readPcci", "Y");  			
			pause(2);
			waitScrollAndClickJs(15,agreeButton, "agreeButton", "Y");  			
			pause(2);
			waitScrollAndClickJs(15,getListOfElements(secureCheckout).get(1), "secureCheckout", "Y");
			waitScrollAndClickJs(15,equipmentOnlyAgreement, "equipmentOnlyAgreement", "Y");
			pause(2);
			waitScrollAndClickJs(15,agreeButton, "agreeButton", "Y"); 
			pause(2);
			waitScrollAndClickJs(15,getListOfElements(secureCheckout).get(2), "secureCheckout", "Y");
			waitScrollAndClickJs(15,consumerCreditAgreement, "consumerCreditAgreement", "Y");
			pause(2);
			waitScrollAndClickJs(15,agreeButton, "agreeButton", "Y"); 
			pause(2);
			waitScrollAndClickJs(15,getListOfElements(secureCheckout).get(3), "secureCheckout", "Y");
			pause(2);
		} 
	}
}
