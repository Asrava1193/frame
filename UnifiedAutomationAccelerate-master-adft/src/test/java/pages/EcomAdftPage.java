package pages;

import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.cognizant.framework.VMOReusableLibrary;

public class EcomAdftPage  extends VMOReusableLibrary
{
	public EcomAdftPage(ScriptHelper scriptHelper) 
	{
		super(scriptHelper);
	}

	//******************locators********************
	//Device type, colour and capacity selection
	private static final By acceptAllCookiesBtn = By.xpath("//button[contains(text(),'Accept all cookies')]");	
	private static final By shopLink = By.xpath("//a[text()=' Shop ']");
	private static final By deviceSearch = By.xpath("//input[contains(@class,'secondary-search__input ')]");
	private static final By searchResults = By.xpath("//*[contains(@class,'secondary-search__suggestion-text')]");
	private static final By customisePlan = By.xpath("//*[text()='Customise your plan']");	
	private static final By payInFull = By.xpath("//button[contains(text(),'pay for your device in full')]");
	private static final By spreadCost = By.xpath("//button[contains(text(),'Use our calculator')]");
	private static final By payInFullBtn = By.xpath("//*[text()='Pay in full']");
	private static final By spreadCostBtn = By.xpath("//*[text()='Spread the cost']");
	private static final By selectPlan = By.xpath("//button[@autotest-target='select-plan-button-at-id']");
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


	private static final By resetCalculator = By.xpath("//*[text()=' Reset calculator ']");
	private static final By deviceCurrency = By.xpath("//div[@class='device-calculator__price-value']/o2uk-price/div/div/div[1]");
	private static final By devicePrice = By.xpath("//div[@class='device-calculator__price-value']/o2uk-price/div/div/div[2]");
	private static final By deviceDecimalPrice = By.xpath("//div[@class='device-calculator__price-value']/o2uk-price/div/div/div[3]/span");
	private static final By accessoriesPrice = By.xpath("//div[contains(@class,'margin_bottom')]/o2uk-price/div/div/div[2]");
	private static final By accessoriesDecimalPrice = By.xpath("//div[contains(@class,'margin_bottom')]/o2uk-price/div/div/div[3]/span");
	private static final By accessoriesCurrency = By.xpath("//div[contains(@class,'margin_bottom')]/o2uk-price/div/div/div[1]");
	private static final By ccaAmountField = By.xpath("//*[@class='o2uk-datapicker-footer-price ng-star-inserted']/span");

	private static final By allowanceCapacity = By.xpath("//*[@id='dataInput']/parent::div/div/div");
	private static final By calculatorField = By.xpath("//*[contains(text(),'Payment calculator') or contains(text(),'Package calculator')]");
	private static final By ccaminmonthfield = By.xpath("(//div[@class='o2uk-plan-datapicker__footer-label o2uk-plan-datapicker__footer-label_left']/span)[1]");
	private static final By ccamaxmonthfield = By.xpath("(//div[@class='o2uk-plan-datapicker__footer-label o2uk-plan-datapicker__footer-label_right']/span)[1]");

	private static final By inStockAvailability = By.xpath("//strong[@class='o2uk-stock-availability__info-title']");
	private static final By allowanceCurrency = By.xpath("//div[@class='device-calculator__price-value']/div/div/o2uk-price-new/div/div[1]");
	private static final By allowancePrice = By.xpath("//div[@class='device-calculator__price-value']/div/div/o2uk-price-new/div/div[2]");
	private static final By allowanceDecimalPrice = By.xpath("//div[@class='device-calculator__price-value']/div/div/o2uk-price-new/div/div[3]/span");
	private static final By decreaseAllowance = By.xpath("//*[contains(@aria-label,'Decrease tariff data')]");
	private static final By increaseAllowance = By.xpath("//*[contains(@aria-label,'Increase tariff data')]");
	private static final By allowanceMonthlyPrice = By.xpath("//*[@class='amount-info-monthly _margin_top-xs']/div");
	private static final By dataPlan = By.xpath("//*[text()=' Choose your data plan ']");
	private static final By insuranceList = By.xpath("//*[@class='insurance__info-title']");
	private static final By addInsuranceBtn = By.xpath("//*[text()=' Add insurance ']/parent::button");


	//Add to basket page
	private static final By noInsurance = By.xpath("//*[contains(text(),' No insurance required ')]/parent::button");
	//private static final By addBasket = By.xpath("//div[contains(@class,'order-configuration-total-cost__footer')]/div/button");
	private static final By addBasket = By.xpath("//span[contains(text(),' Add to basket ')]/parent::button");
	private static final By listOfExtras = By.xpath("//o2uk-extra-card[@class='extra-card ng-star-inserted']/add-on/div/div/div[3]/div/div[2]/div/strong");
	private static final By addToBasketAccessories = By.xpath("//*[text()=' Add to basket ']/parent::button");
	//private static final By addSimToBasket = By.xpath("//*[contains(@aria-label,'Add to basket')]");
	private static final By addSimToBasket = By.xpath("//span[contains(text(),' Add to basket ')]/parent::button");
	private static final By simAllowanceCapacity = By.xpath("//*[@class='order-configuration__control']/div/h3");
	private static final By showAllowanceDetails = By.xpath("//*[text()=' Show package details ']");
	private static final By simAllowancePrice = By.xpath("//*[@class='order-configuration-plan__container']/div/order-configuration-cost-item/div/div/div[3]/o2uk-price/div/div/span");
	private static final By basketOptions = By.xpath("//*[text()=' Basket total ']");
	private static final By checkOutBtn = By.xpath("//div[contains(@class,'basket-section-cta__checkout-button')]/button");	
	private static final By customerCreateEmail = By.id("email");
	private static final By loginEmail = By.xpath("//*[@class='login-btn']");
	private static final By typeLikeNew = By.xpath("//p[text()='Like New']");

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
	//	private static final By homeDelivery = By.xpath("//*[text()='Home delivery']/ancestor::button");
	//	private static final By clickAndCollect = By.xpath("//*[text()='Click and collect']/ancestor::button");
	//	private static final By todayAtStore = By.xpath("//*[text()='Today at this store']/ancestor::button");
	//	private static final By selectStore = By.xpath("//button//span[text()=' Select a store ']");
	//	private static final By clickNCollectPostCode = By.xpath("//div[@class='click-and-collect-dialog__control-town']//input");
	//	private static final By findByPostcodeButton = By.xpath("//span[text()=' Find ']/parent::button");
	//	private static final By listViewOfClickNCollectStores = By.xpath("//o2uk-click-and-collect-dialog//o2uk-tabs/div/button[1]");
	//	private static final By chooseFirstStore = By.xpath("//div[1]/o2uk-retail-shop-card/div[1]//button");	
	//	private static final By errorPageCloseButton = By.xpath("//*[@class='o2uk-icon-font icon-cross']");
	private static final By confirmDeliveryOption = By.xpath("//button[contains(@autotest-target,'delivery-confirm-button-at-id')]");
	private static final By continueButton = By.xpath("//span[text()=' Continue ']/parent::button");


	//Eligibility check page
	private static final By timeAtAddress = By.xpath("//o2uk-select[@formcontrolname='timeAtAddressFC']");
	private static final By eligibilityCheckheckOptions = By.xpath("//o2uk-option[contains(@id,'mat-option-')]");
	private static final By employmentStatus = By.xpath("//o2uk-select[@formcontrolname='employmentStatusFC']");
	private static final By personalAnnualIncome = By.xpath("//o2uk-select[@formcontrolname='annualIncomeFC']");
	private static final By eligibilityCheckAgree = By.xpath("//div[contains(@class,'o2uk-checkbox-frame')]");
	private static final By eligibilityCheckContinue = By.xpath("(//span[contains(text(),' Confirm and continue ')])[2]");
	private static final By eligibilityCheckContinueSecond = By.xpath("(//span[contains(text(),' Confirm and continue ')])[3]");	
	private static final By contractInfoButton = By.xpath("//span[text()=' Send Contract Info & Summary ']/parent::button");
	private static final By contractCheckbox = By.xpath("(//div[@class='o2uk-checkbox-frame'])[2]");
	private static final By confirmContinue = By.xpath("//span[text()=' Confirm and continue ']/parent::button");


	//Bank details page
	private static final By bankAccountHolder = By.xpath("//input[@placeholder='As displayed on your account']");
	private static final By sortCode = By.xpath("//input[@placeholder='00-00-00']");
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
	private static final By continueCreditCheck = By.xpath("//span[text()=' Continue ']/parent::button");
	private static final By confirmCreditButtton = By.xpath("//span[text()=' Confirm ']/parent::button");
	private static final By notNowBtn = By.xpath("//*[text()=' Not now ']");
	private static final By packageNme = By.xpath("//input[contains(@id,'mat-input-')][contains(@placeholder,'eg.')]");
	private static final By confirmContinueBtn = By.xpath("//span[contains(text(),' Confirm and continue ')]/parent::button");
	private static final By payAccessories = By.xpath("//span[text()=' Pay now ']/parent::button");


	//Order review page
	private static final By reviewOrder = By.xpath("//button[@class='mat-focus-indicator mat-button-base o2uk-primary-button']");
	private static final By secureCheckout = By.xpath("//span[text()=' Continue ']/parent::button");
	private static final By secureCheckoutCheckbox = By.xpath("//div[@class='o2uk-checkbox-inner-container']");
	private static final By insuranceRadio = By.xpath("//*[text()=' By email only ']");
	private static final By placeOrderAndPay = By.xpath("//span[text()=' Place order and pay ']/parent::button");
	private static final By orderNumEcomm = By.xpath("//div[@title='Order number']");
	private static final By seeOrderSummary = By.xpath("//div[text()='See order summary']");

	//CSRD Login page
	private static final By lanId = By.id("user");
	private static final By password = By.id("pass");
	private static final By loginButton = By.xpath("//input[@value='Log In']");
	private static final By csrdTextField = By.xpath("//*[@class='gwt-TextBox nc-field-text-input']");
	private static final By searchButton = By.xpath("//*[contains(@class,'gwt-Button button_action_id_') and text()='Search']");
	private static final By overrideButton = By.xpath("//*[@id='mandatoryOverride']");
	private static final By submitButtons = By.xpath("//*[@class='login-btn']");
	private static final By leftCollapse = By.xpath("//*[@class='gwt-Button left-panel-collapse-button collapsed']");
	private static final By ordersButton = By.xpath("//div[@title='Orders']/a");
	private static final By orderNumber = By.xpath("//*[contains(@aria-label,'Name Order #')]");
	private static final By orderItemsButton = By.xpath("//div[text()='Order Items']");
	private static final By customPlanList = By.xpath("//a[contains(@aria-label,'Name') and contains(text(),'Custom')]");
	private static final By nameFilter = By.xpath("//*[@aria-label='Name']");
	private static final By extendedWarranty = By.xpath("//*[contains(text(),'3-Year Warranty')]");

	private static final By voucherCode = By.xpath("//input[contains(@class,'o2uk-input-element mat-input-element mat-form-field-autofill-control ng-tns')]");
	private static final By updateButton = By.xpath("//button[@type='submit']");
	private static final By monthlyVoucherTotalPrice = By.xpath("//div[@class='total-section__total-costs-item-last-monthly-detail']");
	//private static final By upfrontTotalPrice = By.xpath("//div[@class='total-section__total-costs-item-last-upfront-detail']//div[@class='o2uk-price__amount ng-star-inserted']");
	private static final By upfrontTotalPrice = By.xpath("//div[@class='total-section__total-costs-item-last-upfront-detail']//div[contains(@class,'ng-star-inserted')]");

	private static final By simoFilter = By.xpath("//button[contains(@class,'o2uk-pseudo-dropdown')]//following::span[contains(@class,'o2uk-filter__selected-options')]");
	private static final By filterBy = By.xpath("//span[text()=' Filter by ']");
	//private static final By monthlyData = By.xpath("//p[text()='Monthly data']");
	private static final By monthlyData = By.xpath("//div[text()='Monthly data']");
	private static final By monthlyDataSelectAll = By.xpath("(//span[text()='Select all'])[1]");
	private static final By contractLengthfilter = By.xpath("//button[contains(@aria-label,'Contract length')]"); 
	//private static final By contractLength = By.xpath("//p[text()='Contract length']");

	private static final By orderItemName = By.xpath("(//a[contains(text(),'Custom Plan')])[1]");
	private static final By characteristicsButton = By.xpath("//div[text()='Characteristics']");
	private static final By deviceTier = By.xpath("(//div[text()='Device Tier']//following::div[@class='nc-field-text-readonly nc-field-html-focusable-content'])[1]");
	private static final By extendedWarrantyTerm = By.xpath("(//div[text()='Extended Warranty Term']//following::div[@class='nc-field-text-readonly nc-field-html-focusable-content'])[1]");

	private static String email = "";
	private static String insuranceStatus = "";


	//declarations
	java.util.List<WebElement> l1=new ArrayList<WebElement>();
	VMOReusableLibrary Vmor = new VMOReusableLibrary(scriptHelper);

	//***************** Actions **********************

	public void invokeApplicationEcom() 
	{
		String AdftEnvironment = properties.getProperty("AdftEnvironment");
		if(AdftEnvironment==null)
		{
			report.updateTestLog("The variable is null","Please give a URL", Status.FAIL);
			driver.quit();
		}
		else
		{	
			driver.get(getEnvironmentUrl(AdftEnvironment, "ECOMM"));
			report.updateTestLog("Url is launched successfully",getEnvironmentUrl(AdftEnvironment, "ECOMM"), Status.PASS);
		}
	}


	public void selectDeviceEcom() 
	{		
		try {
			craftFluentWait(acceptAllCookiesBtn,5);
			click(acceptAllCookiesBtn, "acceptAllCookiesBtn", "Y");
		} catch (Exception e) {
			e.printStackTrace();
		}
		craftFluentWait(shopLink,5);
		mouseHover(shopLink, "shopLink", "Y");
		if(dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) {
			String accessoriesUrl=driver.getCurrentUrl();
			driver.navigate().to(accessoriesUrl+"accessories/all");
		}
		else {
			By deviceType = By.linkText(dataTable.getData("ECOM_E2E", "deviceType"));
			craftFluentWait(deviceType,10);
			click(deviceType, "deviceType", "Y");
		}
		pause(5);
		if (!dataTable.getData("ECOM_E2E", "deviceType").contains("Monthly sims")) {
			craftFluentWait(deviceSearch,10);
			if(dataTable.getData("ECOM_E2E","Condition").contains("Like New")) {
				craftFluentWait(typeLikeNew, 5);
				click(typeLikeNew,"typeLikeNew","Y");
			}
			enterText(deviceSearch, "deviceSearch", dataTable.getData("ECOM_E2E", "searchName"), null);
			pause(5);
			for (int i = 0; i < getListOfElements(searchResults).size(); i++) {
				if (getListOfElements(searchResults).get(i).getText().equals(dataTable.getData("ECOM_E2E", "deviceName"))) {			
					waitScrollAndClickJs(10, getListOfElements(searchResults).get(i), "searchResults", "Y");		
					break;
				}
			}
			pause(8);
			if (!dataTable.getData("ECOM_E2E", "deviceDeactivation").equalsIgnoreCase("NA")) {
				if(getListOfElements(searchResults).size()==0) {
					report.updateTestLog("Deactivation of devices ","Device is deactivated ", Status.PASS);
				}
			}
		}
	}


	//validate Promo
	public void validtePromos()
	{
		pause(5);
		scrollIntoView(viewPromo);
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
		report.updateTestLog("Number of Gifts","Number of Gifts Count is " +numberOfGifts, Status.PASS);

	}



	public void selectColorCapacityEcom() 
	{
		boolean colorVal = false;
		boolean capacityVal = false;

		if (!dataTable.getData("ECOM_E2E", "deviceColor").equalsIgnoreCase("NA")) {
			try {
				waitScrollAndClickJs(10,colorDropdown,"colorDropdown", "Y");
				for (WebElement obj : getListOfElements(colorDropdownList)) {
					if (obj.getText().contains(dataTable.getData("ECOM_E2E", "deviceColor"))) {			
						waitScrollAndClickJs(10,obj, "colorDropdownList", "Y");  
						colorVal = true;
						break;
					}
				}
				scrollIntoView(colorDropdownField);
				if (r_getText(colorDropdownField).equalsIgnoreCase(dataTable.getData("ECOM_E2E", "deviceColor"))) {
					colorVal = true;
				}
			} catch (Exception e) {
				if (r_getText(defaultColor).equalsIgnoreCase(dataTable.getData("ECOM_E2E", "deviceColor"))) {
					colorVal = true;
				}
			}
			if (!colorVal) {
				report.updateTestLog("color is not available as expected","color is not available as expected", Status.FAIL);
			}
			if (!dataTable.getData("ECOM_E2E", "deviceCapacity").equalsIgnoreCase("NA")) {
				try {			
					waitScrollAndClickJs(10,capacityDropdown, "capacityDropdown", "Y");
					for (WebElement obj : getListOfElements(capacityDropdownList)) {
						if (obj.getText().contains(dataTable.getData("ECOM_E2E", "deviceCapacity"))) {
							waitScrollAndClickJs(10,obj, "capacityDropdownList", "Y");  
							pause(3);
							capacityVal = true;
							break;
						}
					}
					scrollIntoView(capacityDropdownField);
					if (r_getText(capacityDropdownField).equalsIgnoreCase(dataTable.getData("ECOM_E2E", "deviceCapacity"))) {
						capacityVal = true;
					}
				} catch (Exception e) {
					if (r_getText(defaultCapacity).equalsIgnoreCase(dataTable.getData("ECOM_E2E", "deviceCapacity"))) {
						capacityVal = true;
					}
				}
				if (!capacityVal) {
					report.updateTestLog("capacity is not available as expected","capacity is not available as expected", Status.FAIL);
				}
			}
			if (!dataTable.getData("ECOM_E2E", "deviceDeactivation").equalsIgnoreCase("NA")) {
				if(!(colorVal && capacityVal)) {
					report.updateTestLog("Deactivation of devices ","Device is deactivated ", Status.PASS);
				}
				else {
					report.updateTestLog("Deactivation of devices ","Device is not deactivated ", Status.FAIL);
				}
			}
		}
		pause(5);

		if (dataTable.getData("ECOM_E2E", "deviceDeactivation").equalsIgnoreCase("NA")) {
			scrollIntoView(deviceNameField);
			pause(3);
			String stockAvailability = r_getText(inStockAvailability);
			if(stockAvailability.contains("In stock")) {
				report.updateTestLog("Stock check","Device is in stock", Status.PASS);
			}
			else {
				report.updateTestLog("Stock check","Device is not in stock", Status.FAIL);
			}
		}
		pause(5);
		if(dataTable.getData("ECOM_E2E","promoGWP").equalsIgnoreCase("Yes")) {
			validtePromos();
		}
	}



	public void paymentPlanSelectionEcom() 
	{	
		String devicePriceVal = "";
		if (!dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) {
			try {
				waitScrollAndClickJs(15,customisePlan, "customisePlan", "Y");
			}catch(Exception e) {
				e.getMessage();
			}	
			waitScrollAndClickJs(15,payInFull, "payInFull", "Y");
			pause(2);
			scrollIntoView(resetCalculator);
			devicePriceVal = r_getText(deviceCurrency) + r_getText(devicePrice) + r_getText(deviceDecimalPrice);
		}
		else {
			pause(5);
			try {

				if(getElement(payInFullBtn).isDisplayed()) {
					waitScrollAndClickJs(15,payInFullBtn, "payInFullBtn", "Y");
				}
			}
			catch (Exception e) {
				e.getMessage();
			}
			scrollIntoView(accessoriesPrice);
			devicePriceVal = r_getText(accessoriesCurrency) + r_getText(accessoriesPrice) + r_getText(accessoriesDecimalPrice);   
		}
		if (!dataTable.getData("ECOM_E2E", "devicePrice").equalsIgnoreCase("NA")) {				
			if (devicePriceVal.equals(dataTable.getData("ECOM_E2E", "devicePrice"))) {
				report.updateTestLog("Expected Device price "+dataTable.getData("ECOM_E2E", "devicePrice"),"Actual Device price is correct "+devicePriceVal, Status.PASS);		            	
			} else {
				report.updateTestLog("Expected Device price "+dataTable.getData("ECOM_E2E", "devicePrice"),"Actual Device price is incorrect "+devicePriceVal, Status.FAIL);		  
			}
		}
		if (dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
			if (!dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) {
				waitScrollAndClickJs(15,spreadCost, "spreadCost", "Y");	
			} else if (dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) {
				waitScrollAndClickJs(15,spreadCostBtn, "spreadCost", "Y");	
				if (!dataTable.getData("ECOM_E2E", "devicePrice").equalsIgnoreCase("NA")) {
					scrollIntoView(accessoriesPrice);
					String upfrontdevicePriceVal = r_getText(accessoriesCurrency) + r_getText(accessoriesPrice) + r_getText(accessoriesDecimalPrice);   	
					if (upfrontdevicePriceVal.equals(dataTable.getData("ECOM_E2E", "minUpfront")) && upfrontdevicePriceVal.equals(dataTable.getData("ECOM_E2E", "maxUpfront"))) {	   
						report.updateTestLog("Expected Maximum upfront amount is "+dataTable.getData("ECOM_E2E", "maxUpfront"), "Actual Maximum upfront amount is "+upfrontdevicePriceVal, Status.PASS);
						report.updateTestLog("Expected Minimum upfront amount is "+dataTable.getData("ECOM_E2E", "minUpfront"), "Actual Minimum upfront amount is "+upfrontdevicePriceVal, Status.PASS);
					} else {
						report.updateTestLog("Expected Maximum upfront amount is "+dataTable.getData("ECOM_E2E", "maxUpfront"), "Actual Maximum upfront amount is "+upfrontdevicePriceVal, Status.FAIL);
						report.updateTestLog("Expected Minimum upfront amount is "+dataTable.getData("ECOM_E2E", "minUpfront"), "Actual Minimum upfront amount is "+upfrontdevicePriceVal, Status.FAIL);
					}
				}	

			} 
			pause(5);
			if (!(dataTable.getData("ECOM_E2E", "devicePrice").equalsIgnoreCase("NA") ||  dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tech and accessories"))) {
				scrollIntoView(getListOfElements(ccaAmountField).get(0));
				String minAmount = getListOfElements(ccaAmountField).get(0).getText();
				String maxAmount = getListOfElements(ccaAmountField).get(1).getText();
				scrollIntoView(calculatorField);	            
				if (maxAmount.equals(dataTable.getData("ECOM_E2E", "maxUpfront")) && minAmount.equals(dataTable.getData("ECOM_E2E", "minUpfront"))) {
					report.updateTestLog("Expected Maximum upfront amount is "+dataTable.getData("ECOM_E2E", "maxUpfront"), "Actual Maximum upfront amount is "+maxAmount, Status.PASS);
					report.updateTestLog("Expected Minimum upfront amount is "+dataTable.getData("ECOM_E2E", "minUpfront"), "Actual Minimum upfront amount is "+minAmount, Status.PASS);
				} else {
					report.updateTestLog("Expected Maximum upfront amount is "+dataTable.getData("ECOM_E2E", "maxUpfront"), "Actual Maximum upfront amount is "+maxAmount, Status.FAIL);
					report.updateTestLog("Expected Minimum upfront amount is "+dataTable.getData("ECOM_E2E", "minUpfront"), "Actual Minimum upfront amount is "+minAmount, Status.FAIL);			
				}
				pause(5);
				scrollIntoView(ccamaxmonthfield);
				String ccamaxmonth = r_getText(ccamaxmonthfield);
				String ccaminmonth = r_getText(ccaminmonthfield);
				if (ccamaxmonth.equals(dataTable.getData("ECOM_E2E", "maxMonth")) && ccaminmonth.equals(dataTable.getData("ECOM_E2E", "minMonth"))) {	  
					report.updateTestLog("Expected Maximum month is "+dataTable.getData("ECOM_E2E", "maxMonth") + " Actual Maximum month is "+ccamaxmonth,"Expected Minimum month is "+dataTable.getData("ECOM_E2E", "minMonth") + " Actual Minimum month is "+ccaminmonth, Status.PASS);
				} else {
					report.updateTestLog("Expected Maximum month is "+dataTable.getData("ECOM_E2E", "maxMonth") + " Actual Maximum month is "+ccamaxmonth,"Expected Minimum month is "+dataTable.getData("ECOM_E2E", "minMonth") + " Actual Minimum month is "+ccaminmonth, Status.FAIL);			
				}

			}	
		}
		if (!dataTable.getData("ECOM_E2E", "allowanceBundle").equalsIgnoreCase("NA")) {
			validateAllowanceBundle();
		}
	}


	public void validateAllowanceBundle() {
		pause(5);
		while(getElement(decreaseAllowance).isEnabled()) {
			click(decreaseAllowance, "decreaseAllowance", null);
			pause(2);
		}
		if (dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
			report.updateTestLog("First Allowance bundle selected is "+r_getText(allowanceCapacity),"Allowance Price is "+r_getText(allowanceMonthlyPrice).split(" ")[2], Status.PASS);    
		} else if(dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Pay in full")) {
			report.updateTestLog("First Allowance bundle selected is "+r_getText(allowanceCapacity),"Allowance Price is "+r_getText(allowanceCurrency) + r_getText(allowancePrice) + r_getText(allowanceDecimalPrice), Status.PASS);
		}
		while(getElement(increaseAllowance).isEnabled()) {
			pause(3);
			if (dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
				scrollIntoView(getListOfElements(ccaAmountField).get(1));                       
			} else if(dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Pay in full")) {
				scrollIntoView(dataPlan);
			}
			click(increaseAllowance, "increaseAllowance", null);
			pause(3);
			String otherAllowanceCapacity = r_getText(allowanceCapacity);
			String otherAllowancePrice = r_getText(allowanceCurrency) + r_getText(allowancePrice) + r_getText(allowanceDecimalPrice); 
			if (dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
				String airTimePrice =  r_getText(allowanceMonthlyPrice).split(" ")[2]; 
				report.updateTestLog("Allowance bundle selected is "+otherAllowanceCapacity,"Allowance monthly price is "+airTimePrice, Status.PASS);                       
			} else if(dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Pay in full")) {
				report.updateTestLog("Allowance bundle selected is "+otherAllowanceCapacity,"Allowance monthly price is "+otherAllowancePrice, Status.PASS);
			}
		}
		if (dataTable.getData("ECOM_E2E", "allowanceBundle").contains("GB") || dataTable.getData("ECOM_E2E", "allowanceBundle").contains("Unlimited")) {
			String otherAllowanceCapacity = "";
			for (int i = 0; i <= 10; i++) {
				pause(3);
				otherAllowanceCapacity = r_getText(allowanceCapacity); 
				if (dataTable.getData("ECOM_E2E", "allowanceBundle").split(",")[0].equals(otherAllowanceCapacity)) {
					report.updateTestLog("Required Allowance bundle ","Required Allowance bundle is correct "+otherAllowanceCapacity, Status.DONE);
					if (dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
						String airTimePrice =  r_getText(allowanceMonthlyPrice).split("[\\s+]+")[2];
						if(dataTable.getData("ECOM_E2E", "allowancePrice").equals(airTimePrice)) {
							report.updateTestLog("Expected allowance price is "+dataTable.getData("ECOM_E2E", "allowancePrice"), "Actual allowance price is correct "+airTimePrice , Status.PASS); 
						} 
						else {
							report.updateTestLog("Expected allowance price is "+dataTable.getData("ECOM_E2E", "allowancePrice"), "Actual allowance price is incorrect "+airTimePrice, Status.FAIL); 
						}
					}
					else {
						String otherAllowancePrice = r_getText(allowanceCurrency) + r_getText(allowancePrice) + r_getText(allowanceDecimalPrice);
						if(dataTable.getData("ECOM_E2E", "allowancePrice").equals(otherAllowancePrice)) {
							report.updateTestLog("Expected allowance price is "+dataTable.getData("ECOM_E2E", "allowancePrice"), "Actual allowance price is correct "+otherAllowancePrice, Status.PASS); 
						} 
						else {
							report.updateTestLog("Expected allowance price is "+dataTable.getData("ECOM_E2E", "allowancePrice"),"Actual allowance price is incorrect "+otherAllowancePrice, Status.FAIL); 
						}					
					}

					break;
				}
				click(decreaseAllowance, "decreaseAllowance", null);
			}
			if (dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
				scrollIntoView(getListOfElements(ccaAmountField).get(1));                       
			} else if(dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Pay in full")) {
				scrollIntoView(dataPlan);
			}			
		}
	}



	public void validateInsurance() {
		if( getListOfElements(insuranceList).size()==0) {
			report.updateTestLog("Insurance ","Insurance is not available", Status.FAIL);
		}
		else {
			if (dataTable.getData("ECOM_E2E", "insurance").contains("O2 Insure Damage Cover")) {
				for (int i = 0; i <= getListOfElements(insuranceList).size() - 1; i++) {
					if (getListOfElements(insuranceList).get(i).getText().contains("O2 Insure Damage Cover")) {
						addInsurance(i);
					}
				}
			}
			else if (dataTable.getData("ECOM_E2E", "insurance").contains("O2 Insure Full Cover")) {
				for (int i = 0; i <= getListOfElements(insuranceList).size() - 1; i++) {
					if (getListOfElements(insuranceList).get(i).getText().contains("O2 Insure Full Cover")) {
						addInsurance(i);
					}
				}
			}
			else if (dataTable.getData("ECOM_E2E", "insurance").equalsIgnoreCase("No cover"))
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
		waitScrollAndClickJs(10,voucherCode, "voucherCode", "Y");	
		enterText(voucherCode, "voucherCode", dataTable.getData("ECOM_E2E", "voucherCode") , null);
		pause(5);
		clickByJse(updateButton, "updateButton", "Y");
		pause(5);
		if(r_getText(monthlyVoucherTotalPrice).contains(dataTable.getData("ECOM_E2E", "voucherDiscountPrice"))){
			report.updateTestLog("Expected Monthly Voucher Discount Price is "+dataTable.getData("ECOM_E2E", "voucherDiscountPrice"),"Actual Monthly Voucher Discount Price is correct "+r_getText(monthlyVoucherTotalPrice), Status.PASS);
		}
		else if(r_getText(upfrontTotalPrice).contains(dataTable.getData("ECOM_E2E", "voucherDiscountPrice"))){
			report.updateTestLog("Expected Upfront Voucher Discount Price is "+dataTable.getData("ECOM_E2E", "voucherDiscountPrice"), "Actual Upfront Voucher Discount Price is correct "+r_getText(upfrontTotalPrice), Status.PASS);
		}
		else{	
			report.updateTestLog("Voucher Discount Price","Voucher Discount Price is incorrect ", Status.FAIL);
		}
	}


	public void enterCustomerDetailsEcom() 
	{
		if (!(dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")
				|| dataTable.getData("ECOM_E2E", "deviceType").contains("Monthly sims"))) {
			waitScrollAndClickJs(10,selectPlan, "selectPlan", "Y");
			pause(5);
			if (!dataTable.getData("ECOM_E2E", "insurance").equalsIgnoreCase("NA")) {
				validateInsurance();
			}
			if (!dataTable.getData("ECOM_E2E", "opalExtras").equalsIgnoreCase("NA")) {
				validateExtras();
			}
			waitScrollAndClickJs(10,addToBasketAccessories, "addBasket", "Y");
		}else if (dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) {
			waitScrollAndClickJs(20,addToBasketAccessories, "addToBasketAccessories", "Y");
		} else if(dataTable.getData("ECOM_E2E", "deviceType").contains("Monthly sims")){
			if (dataTable.getData("ECOM_E2E", "searchName").equalsIgnoreCase("30 Day") || dataTable.getData("ECOM_E2E", "searchName").equalsIgnoreCase("12 Month") || dataTable.getData("ECOM_E2E", "searchName").equalsIgnoreCase("24 Month")) {

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
				String planName = dataTable.getData("ECOM_E2E", "searchName");
				By contractLengthSelection = By.xpath("//input[contains(@aria-label,'Select filter by "+planName+"')]//parent::div[@class='o2uk-checkbox-inner-container']");
				scrollIntoView(contractLengthSelection);
				pause(5);
				clickByJse(contractLengthSelection, "contractLengthSelection", "Y");
				pause(5);
				String deviceName = dataTable.getData("ECOM_E2E", "deviceName");
				By simaddtobasket = By.xpath("//h2[text()=' "+deviceName+" ']//following::button[@aria-label='Add to Basket "+deviceName+" tariff plan']");
				scrollIntoView(simaddtobasket);
				waitScrollAndClickJs(5, simaddtobasket, "simaddtobasket", "Y");*/

				scrollIntoView(filterBy);
				pause(5);
				clickByJse(contractLengthfilter, "contractLengthfilter", "Y");			
				pause(5);
				String planName = dataTable.getData("ECOM_E2E", "searchName");
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
				String deviceName = dataTable.getData("ECOM_E2E", "deviceName");
				By simaddtobasket = By.xpath("//h2[text()=' "+deviceName+" ']//following::button[@aria-label='Add to basket "+deviceName+" tariff plan']"); 
				scrollIntoView(simaddtobasket);
				waitScrollAndClickJs(5, simaddtobasket, "simaddtobasket", "Y");
				pause(2);
			}
			else {
				String offeringUrl = driver.getCurrentUrl()+"/configuration?plan-offering-id="+dataTable.getData("ECOM_E2E", "searchName");
				waitScrollAndClickJs(10,getListOfElements(addSimToBasket).get(0), "addSimToBasket", "Y");
				pause(5);
				driver.get(offeringUrl);
				pause(5);
			}
			try {
				waitScrollAndClickJs(10, showAllowanceDetails, "showAllowanceDetails", "Y");
			}
			catch (Exception e) {
				e.getMessage();
			}
			scrollIntoView(simAllowanceCapacity);
			if (dataTable.getData("ECOM_E2E", "deviceName").split(",")[0].equalsIgnoreCase(r_getText(simAllowanceCapacity))) {
				report.updateTestLog("Expected Simo plan capacity is "+dataTable.getData("ECOM_E2E", "deviceName").split(",")[0],"Actual Simo plan capacity is correct "+r_getText(simAllowanceCapacity), Status.PASS);
			}
			else {
				report.updateTestLog("Expected Simo plan capacity is "+dataTable.getData("ECOM_E2E", "deviceName").split(",")[0],"Actual Simo plan capacity is incorrect "+r_getText(simAllowanceCapacity), Status.FAIL);
			}
			if (r_getText(simAllowancePrice).contains(dataTable.getData("ECOM_E2E", "devicePrice"))) {
				pause(5);
				report.updateTestLog("Expected Simo plan price is "+dataTable.getData("ECOM_E2E", "devicePrice"),"Actual Simo plan price is correct "+r_getText(simAllowancePrice), Status.PASS);
			}
			else {
				pause(5);
				report.updateTestLog("Expected Simo plan price is "+dataTable.getData("ECOM_E2E", "devicePrice"),"Actual Simo plan price is incorrect "+r_getText(simAllowancePrice), Status.FAIL);
			}
			if (!dataTable.getData("ECOM_E2E", "opalExtras").equalsIgnoreCase("NA")) {
				validateExtras();
			}
			waitScrollAndClickJs(10,addToBasketAccessories, "addToBasketAccessories", "Y"); 
		}
		if (!dataTable.getData("ECOM_E2E", "voucherCode").equalsIgnoreCase("NA")) {
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
		enterText(customerFirstName, "customerFirstName",dataTable.getData("General_Data", "firstName")+RandomStringUtils.randomAlphabetic(5), "Y");
		enterText(customerLastName, "customerLastName", dataTable.getData("General_Data", "lastName"), "Y");
		enterText(customerDOB, "customerDOB",dataTable.getData("General_Data", "dob"), "Y");
		enterText(customerTelephoneNum, "customerTelephoneNum",dataTable.getData("General_Data", "mobile") , "Y");
		enterText(customerPostalCode, "customerPostalCode",dataTable.getData("General_Data", "postalCode"), "Y");
		waitScrollAndClickJs(20,customerFindButton, "customerFindButton", "Y");
	}


	public void enterAddressDetailsEcom() 
	{
		try {
			craftFluentWait(addressDropdown,25);
			click(addressDropdown, "addressDropdown", "Y");
		} catch (Exception e) {
			enterText(customerPostalCode, "customerPostalCode",dataTable.getData("General_Data", "postalCode"), "Y");
			waitScrollAndClickJs(20,customerFindButton, "customerFindButton", "Y");
			craftFluentWait(addressDropdown,15);
			click(addressDropdown, "addressDropdown", "Y");
		}
		pause(5);
		try {
			waitScrollAndClickJs(20,getListOfElements(addressDropdownOptions).get(0), "addressDropdownOptions", "Y");
		} catch (Exception e) {
			waitScrollAndClickJs(20,getListOfElements(addressDropdownOptions).get(0), "addressDropdownOptions", "Y");
		}
		waitScrollAndClickJs(20,addressCheckbox, "addressCheckbox", "Y");

		try {
			waitScrollAndClickJs(20,addressConfirm, "addressConfirm", "Y");
		} catch (Exception e) {
			pause(5);
			waitScrollAndClickJs(20,addressConfirm, "addressConfirm", "Y");
		}
	}


	public void selectDeliveryOptionEcom() 
	{
		//				pause(5);
		//				if (dataTable.getData("ECOM_E2E", "deliveryType").equalsIgnoreCase("Home delivery")) {
		//					waitScrollAndClickJs(20,homeDelivery, "homeDelivery");
		//		
		//				} else if (dataTable.getData("ECOM_E2E", "deliveryType").equalsIgnoreCase("Click and Collect")) {
		//					waitScrollAndClickJs(20,clickAndCollect, "clickAndCollect");
		//					waitScrollAndClickJs(20,selectStore, "selectStore");
		//					waitScrollAndClickJs(20,clickNCollectPostCode, "clickNCollectPostCode");
		//					enterText(clickNCollectPostCode, "clickNCollectPostCode",dataTable.getData("General_Data", "collectCode"), "Y");
		//					waitScrollAndClickJs(20,findByPostcodeButton, "findByPostcodeButton");
		//					waitScrollAndClickJs(20,listViewOfClickNCollectStores, "findByPostcodeButton");
		//					waitScrollAndClickJs(20,chooseFirstStore, "findByPostcodeButton");
		//				} else if (dataTable.getData("ECOM_E2E", "deliveryType").equalsIgnoreCase("Today at this store")) {         
		//					waitScrollAndClickJs(20,todayAtStore, "todayAtStore");       
		//				}
		//		try {			
		//			pause(10);
		//			waitScrollAndClickJs(10,errorPageCloseButton, "errorPageCloseButton");			
		//		} catch (Exception e1) {
		//			e1.getMessage();	
		//		}
		pause(10);
		waitScrollAndClickJs(20,confirmDeliveryOption, "confirmDeliveryOption", "Y");		
	}


	public void eligibiltyCheckEcom() {

		if (!(dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tech and accessories") &&
				dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Pay in full"))) {
			try {
				waitScrollAndClickJs(20,timeAtAddress, "timeAtAddress", "Y");
			} catch (Exception e) {
				pause(5);
				waitScrollAndClickJs(20,timeAtAddress, "timeAtAddress", "Y");
			}		
			for (WebElement obj : getListOfElements(eligibilityCheckheckOptions)) {
				if (obj.getText().contains(dataTable.getData("General_Data", "liveAtAddressPeriod"))) {
					waitScrollAndClickJs(10,obj, "eligibilityCheckheckOptions", "Y");   
					break;
				}
			}
			waitScrollAndClickJs(20,employmentStatus, "employmentStatus", "Y");		
			for (WebElement obj : getListOfElements(eligibilityCheckheckOptions)) {
				if (obj.getText().contains(dataTable.getData("General_Data", "employmentStatus"))) {
					waitScrollAndClickJs(10,obj, "eligibilityCheckheckOptions", "Y");   
					break;
				}
			}
			waitScrollAndClickJs(20,personalAnnualIncome, "personalAnnualIncome", "Y");
			for (WebElement obj : getListOfElements(eligibilityCheckheckOptions)) {
				if (obj.getText().contains(dataTable.getData("General_Data", "personalAnnualIncome"))) {
					waitScrollAndClickJs(10,obj, "eligibilityCheckheckOptions", "Y");   
					break;
				}
			}
			waitScrollAndClickJs(15,eligibilityCheckAgree, "EligibilityCheckAgree", "Y");
			try {
				waitScrollAndClickJs(15,eligibilityCheckContinue, "EligibilityCheckContinue", "Y");
			}catch (Exception e) {
				waitScrollAndClickJs(15,eligibilityCheckContinueSecond, "eligibilityCheckContinueSecond", "Y");
			} 
			pause(10); 			
			if (!dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) {
				waitScrollAndClickJs(20,contractInfoButton, "contractInfoButton", "Y");
				waitScrollAndClickJs(15,continueButton, "continueButton", "Y");       
				pause(10);
				waitScrollAndClickJs(20,contractInfoButton, "contractInfoButton", "Y");  
				pause(10);
				waitScrollAndClickJs(15,contractCheckbox, "contractCheckbox", "Y"); 
				try {
					waitScrollAndClickJs(15,getListOfElements(confirmContinue).get(3), "confirmContract", "Y");
				} catch (Exception e) {
					waitScrollAndClickJs(15,getListOfElements(confirmContinue).get(2), "confirmContract", "Y");
				} 
				pause(5);
			}
			else {
				waitScrollAndClickJs(15,continueButton, "continueButton", "Y"); 
				pause(5);
			}
		}
		waitScrollAndClickJs(15,continueButton, "continueButton", "Y");       
		pause(5);
	}


	public void enterBankDetailsEcom() {

		if (!(dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tech and accessories") 
				&& dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Pay in full"))) {
			craftFluentWait(bankAccountHolder, 10);
			enterText(bankAccountHolder, "bankAccountHolder", dataTable.getData("General_Data", "name"), null);
			enterText(bankAccountNumber, "bankAccountNumber", dataTable.getData("General_Data", "bankAccount"), null);
			enterText(sortCode, "sortCode", dataTable.getData("General_Data", "bankSortCode"), null);
			craftFluentWait(validateButton, 10);
			click(validateButton, "validateButton", "Y");			
			craftFluentWait(checkBox, 10);
			click(checkBox, "checkBox", "Y");
			click(saveContinueBtn, "saveContinueBtn", "Y");	
		}
		pause(10);
		switchTo("Interface");			
		try {
			craftFluentWait(CardHolderName, 20);
			scrollIntoView(CardHolderName);
			enterText(CardHolderName, "CardHolderName", dataTable.getData("General_Data", "name"), null);
		} catch (Exception e) {
			switchToTab(1);
			craftFluentWait(CardHolderName, 20);
			scrollIntoView(CardHolderName);
			enterText(CardHolderName, "CardHolderName", dataTable.getData("General_Data", "name"), null);
		}
		craftFluentWait(CardHolderName, 20);
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
		craftFluentWait(completePurchase, 10);
		scrollIntoView(completePurchase);
		clickByJse(completePurchase, "completePurchase", "Y");	
		pause(5);
		try {
			switchToDefault();
		} catch (Exception e) {
			report.updateTestLog("The variable is null","No Frame", Status.DONE);				
		}
		try {
			switchToTab(0);
		} catch (Exception e) {
			report.updateTestLog("The variable is null","No Window", Status.DONE);
		}
		if (!(dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tech and accessories") 
				&& dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Pay in full"))) {
			waitScrollAndClickJs(20,confirmContinue, "confirmContinue", "Y");
		}
		waitScrollAndClickJs(20,continueCreditCheck, "continueCreditCheck", "Y");
		pause(5);
	}


	public void checkoutOrderEcom() {
		if (!dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tech and accessories")) {
			craftFluentWait(packageNme, 15);
			scrollIntoView(packageNme);
			enterText(packageNme, "packageNme",dataTable.getData("General_Data", "name") , "Y");
			pause(5);
			waitScrollAndClickJs(10,getListOfElements(confirmCreditButtton).get(0), "confirmCreditButtton", "Y");
			waitScrollAndClickJs(10,getListOfElements(confirmCreditButtton).get(1), "confirmCreditButtton", "Y");
			if (!dataTable.getData("ECOM_E2E", "deviceType").equalsIgnoreCase("Tablets and Laptops")) {
				try {
					waitScrollAndClickJs(10,notNowBtn, "notNowBtn", "Y");
					waitScrollAndClickJs(10,getListOfElements(confirmCreditButtton).get(2), "confirmCreditButtton", "Y");
				} catch (Exception e1) {
					try {
						waitScrollAndClickJs(10,getListOfElements(confirmCreditButtton).get(2), "confirmCreditButtton", "Y");
					} catch (Exception e) {
						e.getMessage();
					}			
				}
				try {
					waitScrollAndClickJs(20,getListOfElements(confirmCreditButtton).get(3), "confirmCreditButtton", "Y");
				}catch(Exception e) {
					e.getMessage();
				}
			}
			pause(5);
			waitScrollAndClickJs(20,continueCreditCheck, "continueCreditCheck", "Y");
			pause(5);
			waitScrollAndClickJs(20,reviewOrder, "reviewOrder", "Y");
			try {
				pause(15);
				waitScrollAndClickJs(10,getListOfElements(secureCheckout).get(0), "secureCheckout", "Y");
			}catch(Exception e) {
				waitScrollAndClickJs(20,reviewOrder, "reviewOrder", "Y");
				waitScrollAndClickJs(20,getListOfElements(secureCheckout).get(0), "secureCheckout", "Y");
			}
			pause(5);
			waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(0), "secureCheckoutCheckbox", "Y");
			pause(5);
			if (dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Pay in full") ||
					dataTable.getData("ECOM_E2E", "deviceType").contains("Monthly sims")) {
				waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(1), "secureCheckoutCheckbox", "Y");
				waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(2), "secureCheckoutCheckbox", "Y");
				if(insuranceStatus.equalsIgnoreCase("Available")) {
					pause(8);
					waitScrollAndClickJs(10,getListOfElements(secureCheckout).get(0), "secureCheckout", "Y");
					waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(3), "secureCheckoutCheckbox", "Y");
					waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(4), "secureCheckoutCheckbox", "Y");
					waitScrollAndClickJs(10,getListOfElements(insuranceRadio).get(0), "insuranceRadio", "Y");					
				}
			}
			else if (dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
				waitScrollAndClickJs(10,getListOfElements(secureCheckout).get(1), "secureCheckout", "Y");
				waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(1), "secureCheckoutCheckbox", "Y");
				pause(5);
				waitScrollAndClickJs(10,getListOfElements(secureCheckout).get(2), "secureCheckout", "Y");
				waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(2), "secureCheckoutCheckbox", "Y");	
				waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(3), "secureCheckoutCheckbox", "Y");
				waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(4), "secureCheckoutCheckbox", "Y");
				if(insuranceStatus.equalsIgnoreCase("Available")) {
					pause(5);
					waitScrollAndClickJs(10,getListOfElements(secureCheckout).get(3), "secureCheckout", "Y");
					waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(5), "secureCheckoutCheckbox", "Y");
					waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(6), "secureCheckoutCheckbox", "Y");
					waitScrollAndClickJs(10,getListOfElements(insuranceRadio).get(1), "insuranceRadio", "Y");					
				}
			} 
			pause(5);
			waitScrollAndClickJs(10,getListOfElements(secureCheckout).get(getListOfElements(secureCheckout).size()-1), "secureCheckout", "Y");
			try {
				waitScrollAndClickJs(10,placeOrderAndPay, "placeOrderAndPay", "Y");
			} catch (Exception e) {
				waitScrollAndClickJs(10,seeOrderSummary, "reviewOrder", "Y");
			}
			pause(5);
			waitScrollAndClickJs(35, orderNumEcomm, "orderNumEcomm", "Y");
		}
		else {
			completeOrderAccessories();
		}
	}



	public void completeOrderAccessories() {
		pause(5);
		if (dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Spread the cost")) {
			waitScrollAndClickJs(15,confirmContinueBtn, "confirmContinueBtn", "Y");
			waitScrollAndClickJs(15,continueCreditCheck, "continueCreditCheck", "Y"); 
			pause(5);
			waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(0), "secureCheckoutCheckbox", "Y");
			waitScrollAndClickJs(20,getListOfElements(secureCheckout).get(1), "secureCheckout", "Y");
			waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(1), "secureCheckoutCheckbox", "Y");
			waitScrollAndClickJs(20,getListOfElements(secureCheckout).get(2), "secureCheckout", "Y");
			waitScrollAndClickJs(10,getListOfElements(secureCheckoutCheckbox).get(2), "secureCheckoutCheckbox", "Y");
			waitScrollAndClickJs(20,getListOfElements(secureCheckout).get(3), "secureCheckout", "Y");
			try {
				waitScrollAndClickJs(20,getListOfElements(secureCheckout).get(4), "secureCheckout", "Y");
			} catch (Exception e) {
				waitScrollAndClickJs(10,placeOrderAndPay, "placeOrderAndPay", "Y");
			}		
			pause(5);
			waitScrollAndClickJs(35, orderNumEcomm, "orderNumEcomm", "Y");
		} else if (dataTable.getData("ECOM_E2E", "paymentType").equalsIgnoreCase("Pay in full"))
		{ 
			pause(5);
			waitScrollAndClickJs(15,payAccessories, "payAccessories", "Y"); 
			pause(5);
			waitScrollAndClickJs(35, orderNumEcomm, "orderNumEcomm", "Y");
		}
	}

	public void OrderInCsrd(String emailId) {

		CsrdAdftPage csrdobj = new CsrdAdftPage(scriptHelper);
		driver.get(getEnvironmentUrl(properties.getProperty("AdftEnvironment"), "CSRD"));
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println("Maximize");
		}
		csrdobj.loginCSRD();
		pause(10);
		scrollIntoView(getListOfElements(csrdTextField).get(12));
		enterText(getListOfElements(csrdTextField).get(12), "csrdTextField", emailId, "Y");
		pause(10);
		waitScrollAndClickJs(15,searchButton, "searchButton", "Y");
		pause(5);
		try {
			waitScrollAndClickJs(15,searchButton, "searchButton", "Y");
			pause(5);
		}
		catch(Exception e) {
			e.getMessage();
		}
		waitScrollAndClickJs(15,overrideButton, "overrideButton", "Y");
		waitScrollAndClickJs(15,getListOfElements(submitButtons).get(0), "submitButtons", "Y");
		waitScrollAndClickJs(15,getListOfElements(submitButtons).get(3), "submitButtons", "Y");
		pause(5);
		waitScrollAndClickJs(15,leftCollapse, "leftCollapse", "Y");
		pause(5);
		waitScrollAndClickJs(15,ordersButton, "ordersButton", "Y");
		pause(15);
		scrollIntoView(orderNumber);
		report.updateTestLog("Order ID ","Order ID is "+r_getText(orderNumber), Status.PASS);
		waitScrollAndClickJs(15,orderNumber, "orderNumber", "Y");
		waitScrollAndClickJs(15,orderItemsButton, "orderItemsButton", "Y");
		pause(5);
	}


	public void customPlanValidation(String customPlan){
		scrollIntoView(orderItemName);
		pause(5);
		waitScrollAndClickJs(15, orderItemName, "orderItem", "Y");
		pause(5);
		waitScrollAndClickJs(15, characteristicsButton, "characteristicsButton", "Y");
		pause(10);
		scrollIntoView(deviceTier);
		if(r_getText(deviceTier).contains(customPlan))
		{
			report.updateTestLog("Expected Device tier is "+customPlan,"Actual Device Tier selected is correct "+r_getText(deviceTier), Status.PASS);
		}else {
			report.updateTestLog("Expected Device tier is "+customPlan, "Actual Device Tier selected is incorrect " + r_getText(deviceTier), Status.FAIL);
		}
	}

	public void extendedWarrantyValidation() {
		String extWarrantyVal = "";
		try {
			pause(3);
			scrollIntoView(extendedWarranty);
			extWarrantyVal = r_getText(extendedWarranty);
		} catch (Exception e) {
			report.updateTestLog("Extended warranty","Extended warranty is not present "+extWarrantyVal,Status.FAIL);
		}
		if (extWarrantyVal.contains("Year Warranty")) {
			pause(3);
			waitScrollAndClickJs(15,extendedWarranty, "extendedWarranty", "Y");
			pause(3);
			report.updateTestLog("Extended warranty","Extended warranty is present "+extWarrantyVal,"Extended Warranty Term is "+r_getText(extendedWarrantyTerm),Status.PASS);
		}
	}


	public void ecomWarrantyAndDeviceTier() {
		if (dataTable.getData("ECOM_E2E", "extendedWarranty").equalsIgnoreCase("Yes") || 
				(!dataTable.getData("ECOM_E2E", "customPlan").equalsIgnoreCase("NA"))) {
			OrderInCsrd(email);
			if(!dataTable.getData("ECOM_E2E", "customPlan").equals("NA")) {
				customPlanValidation(dataTable.getData("ECOM_E2E", "customPlan"));
			}
			if(!dataTable.getData("ECOM_E2E", "extendedWarranty").equals("NA")) {
				extendedWarrantyValidation();
			}
		}
	}
}
