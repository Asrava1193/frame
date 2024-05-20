package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VGs.BusinessFlow;
import com.cognizant.framework.ExcelData;
import com.cognizant.framework.ExtentReport;
import com.aventstack.extentreports.Status;
//import com.cognizant.framework.Status;
import com.cognizant.framework.VMOReusableLibrary;

public class Ecom {

	private WebDriver driver= BusinessFlow.getDriver();
	public static String storeEmail=null;
	public static String firstName=null;
	public static String lastName=null;
	public static String ExternalReservationID =null;
	public static String FulfillmentOrderNo =null;
	public static String ProductCode=null;
	public static String ProductDescription=null;
	public static  String OrderID=null;
	public static String ecomUserEmail = null;
	
	
	
	
	//Constructor of the ECOM class page
	public Ecom() throws Exception {

		PageFactory.initElements(driver, this);

	}
	
	ExcelData readData = new ExcelData();
      //** Reading Input Excel**///
	public void readDataExcel(int curriteration,int iteration) throws IOException,Exception {

		readData.readinputdata(curriteration, iteration);

	}
	 //** Writing Output Excel**//
	public void writeDataExcel() throws IOException,Exception {

		readData.Writeoutputdata();

	}
	
	//** getting Current Url**//
	public String getCurrenturl()
	{
		String selectedurl=driver.getCurrentUrl().trim();
		return selectedurl;
	}
	
	
	//
	public RemoteWebDriver getRemoteWebDriver() {
		return (RemoteWebDriver) driver;
	}
	
	VMOReusableLibrary Vmor = new VMOReusableLibrary();
	// VG11
	
	//acceptingCookies
	@FindBy(xpath = "//button[@id='privacy_pref_optin']")
	WebElement cookies;
	// dealing with cookies button
		public void acceptingCookies() throws Exception {
			
			Thread.sleep(5000);
			Vmor.r_clickByJseIfExists(cookies,"cookies");

		}
		
		
		// navigating to shop-> Pay Monthly sims
		@FindBy(xpath = "//a[text()=' Shop ']")
		WebElement shopLink;
		@FindBy(xpath = "//a[@title='Pay Monthly sims']")
		WebElement paymontlysims;
		

		public void shoppingSIMOs() throws InterruptedException {
			
			Thread.sleep(5000);
			Vmor.hoverAndClickElement(shopLink, paymontlysims, 2,"paymontlysims");
		}
		
		/*//selecting simo from shops
		@FindBy(xpath = "(//span[contains(text(),' Add to basket ')])[1]")
		WebElement simOnlyResult;
		@FindBy(xpath = "//span[contains(text(),' Add to basket ')]")
		WebElement addToBasketButton;
		
		public void selectingSIMOfromShops() throws Exception {
			Thread.sleep(6000);
			Vmor.r_click(simOnlyResult,"simOnlyResult");
			Thread.sleep(13000);		
			Vmor.r_click(addToBasketButton,"addToBasketButton");
			Thread.sleep(6000);
		}*/
		
		//selecting simo from shops
		
				@FindBy(xpath = "//span[contains(text(),' Add to basket ')]")
				WebElement addToBasketButton;
				@FindBy(xpath = "//span[contains(text(),' Add to basket ')]")
				WebElement addToBasketButton1;
				@FindBy(xpath = "//span[contains(text(),'Show the next')]//ancestor::button")
				WebElement seeMorePlans;
				@FindBy(xpath = "//span[contains(text(),' Add to basket ')]")
				WebElement addToBasketButton2;
				
				public void selectingSIMOfromShops() throws Exception {
					
					String current_url = driver.getCurrentUrl();

					if (current_url.contains("e2e3")) {
					Thread.sleep(6000);
					Vmor.scroll(addToBasketButton);
					Thread.sleep(5000);
					Vmor.r_click(addToBasketButton,"addToBasketButton");
					Thread.sleep(5000);
					Vmor.scroll(addToBasketButton1);
					Thread.sleep(5000);
					Vmor.r_click(addToBasketButton1,"addToBasketButton1");
					Thread.sleep(5000);
				}
					else if (current_url.contains("e2e2")){
						Thread.sleep(5000);
						Vmor.scroll(seeMorePlans);
						Vmor.r_click(seeMorePlans, "seeMorePlans");
						Thread.sleep(5000);
						System.out.println(ExcelData.AllowanceBundle);
						WebElement chooseplan = driver.findElement(By.xpath("//span[text()=' "+ExcelData.AllowanceBundle+" ']//ancestor::div[@class='tariff-card__wrapper']//span[contains(text(),' Choose this plan')]"));
						//System.out.println(ExcelData.AllowanceBundle);
						Vmor.scroll(chooseplan);
						System.out.println(chooseplan);
						Thread.sleep(5000);
						Vmor.r_clickByJse(chooseplan, "chooseplan");
						Thread.sleep(5000);
						Vmor.scroll(addToBasketButton2);
						Thread.sleep(5000);
						Vmor.r_click(addToBasketButton2,"addToBasketButton2");
						Thread.sleep(5000);
					
					}
					else {
						/*Thread.sleep(5000);
						Vmor.scroll(seeMorePlans);
						Vmor.r_click(seeMorePlans, "seeMorePlans");*/
						Thread.sleep(5000);
						WebElement chooseplan = driver.findElement(By.xpath("//span[text()=' "+ExcelData.AllowanceBundle+" ']//ancestor::div[@class='tariff-card__wrapper']//span[contains(text(),' Choose this plan')]"));
						System.out.println(chooseplan);
						Vmor.scroll(chooseplan);
						System.out.println(chooseplan);
						Thread.sleep(5000);
						Vmor.r_clickByJse(chooseplan, "chooseplan");
						Thread.sleep(5000);
						Vmor.scroll(addToBasketButton2);
						Thread.sleep(5000);
						Vmor.r_click(addToBasketButton2,"addToBasketButton2");
						Thread.sleep(5000);
					
					}
					}
		//clickCheckOut
		@FindBy(xpath = "//span[contains(text(),' Checkout ')]")
		WebElement checkOutBtn1;
		public void clickCheckOut() throws Exception {
			Thread.sleep(5000);
			Vmor.scroll(checkOutBtn1);
			Vmor.r_clickByJse(checkOutBtn1, "checkOutBtn");
		}
		
		//ecommNewLogin
		
		@FindBy(xpath = "//a[contains(text(),'New to O2? Register now')]")
		WebElement newToO2Btn;
		//newToO2Btn = By.xpath("//a[contains(text(),'New to O2? Register now')]");
		@FindBy(xpath = "//input[@id='emailOnly']")
		WebElement NewLoginemailBox;
		//NewLoginemailBox = By.xpath("//input[@id='emailOnly']");
		@FindBy(xpath = "//input[@id='password']")
		WebElement NewLoginPwdBox;
		//NewLoginPwdBox = By.xpath("//input[@id='password']");
		@FindBy(xpath = "(//span[@class='checkmark'])[1]")
		WebElement chkBx1afterpwd;
		//chkBx1afterpwd = By.xpath("(//span[@class='checkmark'])[1]");
		@FindBy(xpath = "(//span[@class='checkmark'])[5]")
		WebElement chkBx2afterpwd;
		//chkBx2afterpwd = By.xpath("(//span[@class='checkmark'])[5]");
		@FindBy(xpath = "//input[@value='Register']")
		WebElement registerBtnInLogin;
		//registerBtnInLogin = By.xpath("//input[@value='Register']");
		
		public void ecommNewLogin() throws Exception
		{	
			String randomEmail = RandomStringUtils.randomAlphanumeric(5);
			System.out.println("EmailID: "+ "Testi"+randomEmail+"@yopmail.com");
			
			Vmor.r_click(newToO2Btn, "newToO2Btn");
			Thread.sleep(2000);
			Vmor.r_enterText(NewLoginemailBox, "Testi"+randomEmail+"@yopmail.com", "NewLoginemailBox");
			//Thread.sleep(2000);
			//Vmor.r_click(btnContinueLogin, "btnContinueLogin");

			Vmor.r_enterText(NewLoginPwdBox, "Qwerty12345!","NewLoginPwdBox" );
			Thread.sleep(2000);
			Vmor.r_click(chkBx1afterpwd, "chkBx1afterpwd");
			Thread.sleep(2000);
			Vmor.r_click(chkBx2afterpwd, "chkBx2afterpwd");
			Thread.sleep(2000);
			Vmor.r_click(registerBtnInLogin, "registerBtnInLogin");
			Thread.sleep(8000);
		}
		
		
		//step1YourDetails
		@FindBy(xpath = "(//span[@class='o2uk-icon-font icon-chevron-down'])[2]")
		WebElement step1TitleArrow;
		@FindBy(xpath = "//span[contains(text(),' Mr ')]")
		WebElement step1TitleArrowValue;
		//By step1TitleArrowValue = By.xpath("//span[contains(text(),' Mr ')]");
		@FindBy(xpath = "//input[@name='fname']")
		WebElement step1Fname;
		////step1Fname = By.xpath("//input[@name='fname']");
		@FindBy(xpath = "//input[@name='lname']")
		WebElement step1Lname;
		//step1Lname = By.xpath("//input[@name='lname']");
		
		@FindBy(xpath = "//input[@name='bday']")
		WebElement step1DOB;
		//step1DOB = By.xpath("//input[@name='bday']");
		@FindBy(xpath = "//input[@placeholder='e.g. 07700900900']")
		WebElement step1MobileNum;
		//step1MobileNum = By.xpath("//input[@placeholder='e.g. 07700900900']");
		@FindBy(xpath = "//input[@placeholder='e.g. RG2 6UU']")
		WebElement step1PostCode;
		//step1PostCode = By.xpath("//input[@placeholder='e.g. RG2 6UU']");
		@FindBy(xpath = "//*[contains(text(),' Find ')]")
		WebElement step1Find;
		//step1Find = By.xpath("//*[contains(text(),' Find ')]");
		@FindBy(xpath = "//span[contains(text(),' Please select an option... ')]")
		WebElement step1SelectAddressDD;
		//step1SelectAddressDD = By.xpath("//span[contains(text(),' Please select an option... ')]");
		
		
		
		@FindBy(xpath = "(//span[@class='o2uk-option-content sessioncamhidetext'])[2]")
		WebElement step1SelectAddressDDValue;
		//private static final By step1SelectAddressDDValue = By.xpath("(//span[@class='o2uk-option-content sessioncamhidetext'])[2]");
		@FindBy(xpath = "//input[@id='mat-checkbox-1-input']")
		WebElement step1ChkBx11;
		//private static final By step1ChkBx1 = By.xpath("//input[@id='mat-checkbox-1-input']");
		
		//private static final By step1ChkBx2 = By.xpath("//input[@id='mat-checkbox-2-input']");
		
		@FindBy(xpath = "//span[contains(text(),' Confirm and continue ')]")
		WebElement step1CnfrmAndCntBtn1;
		//step1CnfrmAndCntBtn1 = By.xpath("//span[contains(text(),' Confirm and continue ')]");
		
		
		
		public void step1YourDetails() throws Exception
		{
			//Regex method to generate random phone number
			//		*************************************************************
			String s1 = "078";
			Random rand = new Random();

			int n = rand.nextInt(100000000);
			n += 1;
					System.out.println("078"+n);

			String s2 = String.valueOf(n);
			String s3 = s1.concat(s2);
			//******************************************************************		
			// create a string of all characters
			String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

			// create random string builder
			StringBuilder sb = new StringBuilder();

			// create an object of Random class
			Random random = new Random();

			// specify length of random string
			int length = 7;
			for(int i = 0; i < length; i++) {

				// generate random index number
				int index = random.nextInt(alphabet.length());

				// get character specified by index
				// from the string
				char randomChar = alphabet.charAt(index);

				// append the character to string builder
				sb.append(randomChar);
			}

			String randomString = sb.toString();
			//		System.out.println("Random String is: " + randomString);

			//	***************************************************************************


			//Vmor.craftWait(step1TitleArrow, 20);
			Vmor.r_click(step1TitleArrow, "step1TitleArrow");
			Thread.sleep(2000);
			Vmor.r_click(step1TitleArrowValue, "step1TitleArrowValue");
			Thread.sleep(2000);
			Vmor.r_enterText(step1Fname, randomString,"step1Fname");
			Thread.sleep(2000);
			Vmor.r_enterText(step1Lname, "enahar","step1Lname");
			Thread.sleep(2000);
			Vmor.r_enterText(step1DOB, "04042000","step1DOB");
			Thread.sleep(2000);
			Vmor.r_enterText(step1MobileNum, s3,"step1MobileNum" );
			Thread.sleep(2000);
			Vmor.r_enterText(step1PostCode, ExcelData.Postcode,"step1PostCode");
			Thread.sleep(4000);
			Vmor.r_click(step1Find, "step1Find");
			Thread.sleep(5000);
			Vmor.r_clickByJse(step1SelectAddressDD, "step1SelectAddressDD");
			Thread.sleep(3000);
			Vmor.r_clickByJse(step1SelectAddressDDValue, "step1SelectAddressDDValue");
			Thread.sleep(2000);
			Vmor.r_click(step1ChkBx11, "step1ChkBx1");
			Thread.sleep(2000);
			Vmor.r_click(step1CnfrmAndCntBtn1, "step1CnfrmAndCntBtn1");
			Thread.sleep(2000);

		}
		
		
		
		//step1Delivery
		
		@FindBy(xpath = "(//span[contains(text(),' Confirm and continue ')])[2]")
		WebElement step1CnfrmAndCntBtn21;
		//step1CnfrmAndCntBtn2 = By.xpath("(//span[contains(text(),' Confirm and continue ')])[2]");
		
		public void step1Delivery() throws Exception
		{
			Thread.sleep(7000);
			Vmor.r_click(step1CnfrmAndCntBtn21, "step1CnfrmAndCntBtn2");
			Thread.sleep(7000);
		}
		
		//step1EligibilityChk
		
		@FindBy(xpath = "(//span[@class='o2uk-icon-font icon-chevron-down'])[2]")
		WebElement step1EligibltyChkArrowDD1;
		
		@FindBy(xpath = "//span[contains(text(),' 3 to 4 years ')]")
		WebElement step1EligibltyChkArrowDDValue1;
		//private static final By step1EligibltyChkArrowDDValue1 = By.xpath("//span[contains(text(),' 3 to 4 years ')]");
		@FindBy(xpath = "(//span[@class='o2uk-icon-font icon-chevron-down'])[3]")
		WebElement step1EligibltyChkArrowDD2;
		//@FindBy(xpath = "(//span[contains(.,' Please select an option... ')])[1]")
		//private static final By step1EligibltyChkArrowDD2 = By.xpath("(//span[@class='o2uk-icon-font icon-chevron-down'])[3]");
		@FindBy(xpath = "//span[contains(text(),' Employed ')]")
		WebElement step1EligibltyChkArrowDDValue2;
		//private static final By step1EligibltyChkArrowDDValue2 = By.xpath("//span[contains(text(),' Employed ')]");
		@FindBy(xpath = "(//span[@class='o2uk-icon-font icon-chevron-down'])[4]")
		WebElement step1EligibltyChkArrowDD3;
		//private static final By step1EligibltyChkArrowDD3 = By.xpath("(//span[@class='o2uk-icon-font icon-chevron-down'])[4]");
		@FindBy(xpath = "//span[.=' £30,001-£40,000 ']")
		WebElement step1EligibltyChkArrowDDValue33;
		//private static final By step1EligibltyChkArrowDDValue3 = By.xpath("//span[contains(text(),' Â£30,001-Â£40,000 ')]");
		@FindBy(xpath = "//div[@class='o2uk-checkbox-inner-container']")
		WebElement step1EligibltyChkbox11;
		//private static final By step1EligibltyChkbox1 = By.xpath("//div[@class='o2uk-checkbox-inner-container']");
		@FindBy(xpath = "(//span[contains(text(),' Confirm and continue ')])[2]")
		WebElement step1CnfrmAndCntBtn211;
		//private static final By step1CnfrmAndCntBtn3 = By.xpath("(//span[contains(text(),' Confirm and continue ')])[3]");
		public void step1EligibilityChk() throws Exception
		{	
			Thread.sleep(2000);
			//Vmor.craftWait(step1EligibltyChkArrowDD1, 20);
			Vmor.r_click(step1EligibltyChkArrowDD1, "step1EligibltyChkArrowDD1");
			Thread.sleep(2000);
			Vmor.r_clickByJse(step1EligibltyChkArrowDDValue1, "step1EligibltyChkArrowDDValue1");
			Thread.sleep(2000);
			Vmor.r_click(step1EligibltyChkArrowDD2, "step1EligibltyChkArrowDD2");
			Thread.sleep(2000);
			Vmor.r_clickByJse(step1EligibltyChkArrowDDValue2, "step1EligibltyChkArrowDDValue1");
			Thread.sleep(2000);
			Vmor.r_click(step1EligibltyChkArrowDD3, "step1EligibltyChkArrowDD3");
			Thread.sleep(2000);
			Vmor.r_clickByJse(step1EligibltyChkArrowDDValue33, "step1EligibltyChkArrowDDValue3");
			Thread.sleep(2000);
			Vmor.r_click(step1EligibltyChkbox11, "step1EligibltyChkbox1");
			Thread.sleep(2000);
			Vmor.r_click(step1CnfrmAndCntBtn211, "step1CnfrmAndCntBtn2");
			Thread.sleep(4000);

		}
		
		
		//step1ChooseTheRightPlan
		

		//@FindBy(xpath = "//input[@id='mat-checkbox-3-input']")
		@FindBy(xpath = "//span[contains(text(),' Send Contract Info & Summary ')]")
		WebElement step1SendContractBtn;
		 //step1SendContractBtn = By.xpath("//span[contains(text(),' Send Contract Info & Summary ')]");
		
		@FindBy(xpath = "//input[@id='mat-checkbox-3-input']")
		WebElement step1confirmbtnInChooseRightPlan;
		//div[@class='o2uk-checkbox-inner-container']/input[@id='mat-checkbox-3-input']
		//step1CntBtnInChooseRightPlan = By.xpath("//span[contains(text(),' Continue ')]");
		
		@FindBy(xpath = "(//span[.=' Confirm and continue '])[3]")
		WebElement step1SendContractBtn11;
		// step1SendContractBtn = By.xpath("//span[contains(text(),' Send Contract Info & Summary ')]");
		
		
		@FindBy(xpath = "//span[.=' Continue ']")
		WebElement step1ContBx111;
		//step1ChkBx1 = By.xpath("//input[@id='mat-checkbox-1-input']");
		
		/*@FindBy(xpath = "(//span[contains(text(),' Confirm and continue ')])[3]")
		WebElement step1CnfrmAndCntBtn3;
		//step1CnfrmAndCntBtn3 = By.xpath("(//span[contains(text(),' Confirm and continue ')])[3]");
		
		@FindBy(xpath = "(//span[contains(text(),' Continue ')])")
		WebElement step1ContinueBtn;
		//step1ContinueBtn = By.xpath("(//span[contains(text(),' Continue ')])");
*/		
		
		public void step1ChooseTheRightPlan() throws Exception
		{
			Thread.sleep(8000);
			Vmor.r_click(step1SendContractBtn, "step1SendContractBtn");
			Thread.sleep(10000);
		//	Vmor.craftWait(step1CntBtnInChooseRightPlan, 30);
			Vmor.r_click(step1confirmbtnInChooseRightPlan, "step1confirmbtnInChooseRightPlan");
		//	Vmor.craftWait(step1SendContractBtn, 30);
			Thread.sleep(9000);
			Vmor.r_click(step1SendContractBtn11, "step1SendContractBtn11");
			Thread.sleep(10000);
			//Vmor.craftWait(step1ChkBx1, 20);
			Vmor.r_click(step1ContBx111, "step1ContBx111");
			/*Thread.sleep(3000);
			Vmor.r_clickByJse(step1CnfrmAndCntBtn3, "step1CnfrmAndCntBtn3");
			Thread.sleep(4000);
			Vmor.r_clickByJse(step1ContinueBtn, "step1ContinueBtn");
			Thread.sleep(5000);*/
		}
		
		//step1DDPage
		
			//@FindBy (id="cardname")
			@FindBy(xpath = "//input[@data-placeholder='As displayed on your account']")
			WebElement step1AccNameInDDpage;
			// step1AccNameInDDpage = By.xpath("//input[@data-placeholder='As displayed on your account']");
			@FindBy(xpath = "//input[@placeholder='00-00-00']")
			WebElement step1SortCodeInDDpage;
			//step1SortCodeInDDpage = By.xpath("//input[@placeholder='00-00-00']");
			@FindBy(xpath = "//input[@placeholder='8 numbers long']")
			WebElement step1AccNumInDDpage;
			//step1AccNumInDDpage = By.xpath("//input[@placeholder='8 numbers long']");
			@FindBy(xpath = "//span[contains(text(),' Validate ')]")
			WebElement step1ValidateBtnInDDpage;
			//step1ValidateBtnInDDpage = By.xpath("//span[contains(text(),' Validate ')]");
			@FindBy(xpath = "//input[@autotest-target='account-holder-checkbox-at-id']")
			WebElement step1DDChkbox1;
			// step1DDChkbox1 = By.xpath("//input[@autotest-target='account-holder-checkbox-at-id']");
			@FindBy(xpath = "//span[contains(text(),' Save and continue ')]")
			WebElement btnSaveNCtn;
			//btnSaveNCtn = By.xpath("//span[contains(text(),' Save and continue ')]");
			
			public void step1DDPage() throws Exception
			{	
				Thread.sleep(10000);
				//Vmor.craftWait(step1AccNameInDDpage, 25);
				Vmor.r_enterText(step1AccNameInDDpage, "Test123","step1AccNameInDDpage");
				Thread.sleep(2000);
				//Vmor.craftWait(step1SortCodeInDDpage, 10);
				Vmor.r_enterText(step1SortCodeInDDpage,"201596", "step1SortCodeInDDpage");
				Thread.sleep(2000);
				//Vmor.craftWait(step1AccNumInDDpage, 10);
				Vmor.r_enterText(step1AccNumInDDpage, "10207136","step1AccNumInDDpage");
				Thread.sleep(2000);
				//Vmor.craftWait(step1ValidateBtnInDDpage, 10);
				Vmor.r_click(step1ValidateBtnInDDpage, "step1ValidateBtnInDDpage");
				//Thread.sleep(5000);
				//Vmor.craftWait(step1DDChkbox1, 10);
				Vmor.r_click(step1DDChkbox1, "step1DDChkbox1");
				//String parentWindowHandle = driver.getWindowHandle();
				Thread.sleep(2000);
				Vmor.r_click(btnSaveNCtn, "btnSaveNCtn");
				
				}
	
			
			
//AddcardDetails
			
			@FindBy(xpath="//iframe[@name='Interface']")
			
			WebElement cardFrame;
			//@FindBy (id="cardname")
			@FindBy(xpath = "//input[@placeholder='The name on the card']")
			WebElement step2AccNameInDDpage;
			// step1AccNameInDDpage = By.xpath("//input[@data-placeholder='As displayed on your account']");
			@FindBy(xpath = "//input[@placeholder='XXXX-XXXX-XXXX-XXXX']")
			WebElement step2SortCodeInDDpagecardnum;
			//step1SortCodeInDDpage = By.xpath("//input[@placeholder='00-00-00']");
			@FindBy(xpath = "//input[@id='expiryDateMonthyearInput']")
			WebElement step2expirydateDDpage;
			//step1AccNumInDDpage = By.xpath("//input[@placeholder='8 numbers long']");
			@FindBy(xpath = "//input[@id='csc']")
			WebElement step2CVV;
			@FindBy(xpath = "//span[.='Register card']")
			//button[@id='bConfirmPaymentButton']
			WebElement step2regstrcardbtn;
			
			public void AddcardDetails() throws Exception
			{
				/*//Store the ID of the original window
				String originalWindow = driver.getWindowHandle();
				System.out.println("Entered add card details");

				//Check we don't have other windows open already
				assert driver.getWindowHandles().size() == 1;

				//Click the link which opens in a new window
//				Vmor.r_click(btnSaveNCtn, "btnSaveNCtn");
				Thread.sleep(12000);

				//Loop through until we find a new window handle
				for (String windowHandle : driver.getWindowHandles()) {
				    if(!originalWindow.contentEquals(windowHandle)) {
				        driver.switchTo().window(windowHandle);
				        break;
				    }
				}*/
				//WebElement CARDFRAME = driver.findElement((By) cardFrame);
				//System.out.println("Entered add card details");
				Thread.sleep(15000);
				driver.switchTo().frame(cardFrame);
				Thread.sleep(4000);
				//Vmor.scroll(step2AccNameInDDpage);
				Vmor.r_enterText(step2AccNameInDDpage,  "Test","step2AccNameInDDpage");
				Thread.sleep(4000);
			//	Vmor.craftWait(step1SortCodeInDDpage, 10);
				Vmor.r_enterText(step2SortCodeInDDpagecardnum, "4546380000000009","step2SortCodeInDDpagecardnum");
				Thread.sleep(4000);
				//Vmor.craftWait(step1AccNumInDDpage, 10);
				Vmor.r_enterText(step2expirydateDDpage,"03/25","step2expirydateDDpage");
				Thread.sleep(4000);
				//Vmor.craftWait(step1ValidateBtnInDDpage, 10);
				Vmor.r_enterText(step2CVV, "242" , "step2CVV");
				Thread.sleep(4000);
			    Vmor.r_click(step2regstrcardbtn, "step2regstrcardbtn");
			    Thread.sleep(4000);
			    driver.switchTo().defaultContent();
			}

		//no spend cap //span[contains(text(),'Â£0.00')]//parent::span[@class='o2uk-option-content']
		//step2AffordCheck
				
				@FindBy(xpath = "//span[contains(text(),' Confirm and continue ')]")
				WebElement btnCfrmCtn;
				//btnCfrmCtn = By.xpath("//span[contains(text(),' Confirm and continue ')]");
				@FindBy(xpath = "(//span[contains(text(),' Continue ')])")
				WebElement btnCtnu;
				//btnCtnu = By.xpath("(//span[contains(text(),' Continue ')])");
				
				public void step2AffordCheck() throws Exception {
					        Thread.sleep(10000);
							//Vmor.craftWait(btnCfrmCtn, 60);
					
							Vmor.r_click(btnCfrmCtn, "btnCfrmCtn");
							Thread.sleep(4000);
							Vmor.r_click(btnCtnu, "btnCtnu");
				}
				
		//step3MoreOptions
				
				@FindBy(xpath = "(//input[contains(@class,'o2uk-input-element mat-input-element')])[1]")
				WebElement step3EnterPackageName1;
				// step3EnterPackageName1 = By.xpath("(//input[contains(@class,'o2uk-input-element mat-input-element')])[1]");
				@FindBy(xpath = "(//span[contains(text(),' Confirm ')])[1]")
				WebElement step3Confirm1;
				//step3Confirm1 = By.xpath("(//span[contains(text(),' Confirm ')])[1]");
				@FindBy(xpath = "//button[@autotest-target='number-transfer-confirm-button-at-id']")
				WebElement numTransferConfirm;
				//step3Confirm2 = By.xpath("(//span[contains(text(),' Confirm ')])[2]");
				@FindBy(xpath = "(//input[@value='Not now'])[1]")
				WebElement rdBtnNotNow;
				//rdBtnNotNow = By.xpath("(//input[@value='Not now'])[1]");
				@FindBy(xpath = "//button[@autotest-target='spend-cap-confirm-button-at-id']")
				WebElement spendcapConfirm;
				//btnConfirm3 = By.xpath("(//span[contains(text(),' Confirm ')])[3]");
				@FindBy(xpath = "//button[@autotest-target='yourself-package-confirm-button-at-id']")
				WebElement yourselfconfirm;
				
				
				
				public void step3MoreOptions() throws Exception {
			/*		//Vmor.craftWait(step3EnterPackageName1, 25);
					Vmor.r_clickByJse(step3EnterPackageName1, "step3EnterPackageName1");
					Thread.sleep(5000);
					Vmor.r_enterText(step3EnterPackageName1,"Test1","Package Name 1");		
					//Vmor.enterTextWithJSExecutor(step3EnterPackageName1, "Test1");				
					Thread.sleep(2000);
					Vmor.r_click(step3Confirm1, "step3Confirm1");
					Thread.sleep(4000);
					//Vmor.r_click(rdBtnNotNow, "rdBtnNotNow");
					//Thread.sleep(2000);    */

					Vmor.r_click(spendcapConfirm, "step3Confirm2");
					Thread.sleep(4000);

					Vmor.r_click(rdBtnNotNow, "rdBtnNotNow");
					Thread.sleep(2000);
					Vmor.r_click(numTransferConfirm, "btnConfirm3");
					Thread.sleep(2000);
					Vmor.r_click(yourselfconfirm, "btnConfirm4");
					Thread.sleep(4000);
					Vmor.r_click(btnCtnu, "btnCtnu");		
				}
		
		 //step4ReviewOrder	
				public void step4ReviewOrder() throws Exception 
				{
					Thread.sleep(9000);
					Vmor.scroll(btnCtnu);
					Vmor.r_click(btnCtnu, "btnCfrmCtn1");
				}
		
		//step5
				@FindBy(xpath = "(//input[contains(@id,'mat-checkbox')])[1]")
				WebElement step5CheckBox1PCCI;
				//step5CheckBox1PCCI = By.xpath("(//input[contains(@id,'mat-checkbox')])[1]");
				@FindBy(xpath = "(//input[contains(@id,'mat-checkbox')])[2]")
				WebElement step5CheckBox2CCA;
				//step5CheckBox2CCA = By.xpath("(//input[contains(@id,'mat-checkbox')])[2]");
				@FindBy(xpath = "(//input[contains(@id,'mat-checkbox')])[3]")
				WebElement step5CheckBox3CCA;
				//step5CheckBox3CCA = By.xpath("(//input[contains(@id,'mat-checkbox')])[3]");
				@FindBy(xpath = "(//span[contains(text(),' Continue ')])[1]")
				WebElement step5ContinueBtn1;
				//step5ContinueBtn1 = By.xpath("(//span[contains(text(),' Continue ')])[1]");
				@FindBy(xpath = "//button[@autotest-target='place-and-pay-button-at-id']")
				WebElement step5ContinueBtn2;
				//step5ContinueBtn2 = By.xpath("(//span[contains(text(),' Continue ')])[2]");
				
				
				public void step5_499389() throws Exception {
					Thread.sleep(4000);
//					Vmor.r_click(btnCtn2, "btnCtn");
//					Vmor.r_click(step5ContinueBtn1, "step5ContinueBtn1");
//					Vmor.r_clickByJse(, "step5CheckBox1PCCI");
//					Thread.sleep(2000);
//					Vmor.r_click(step5ContinueBtn2, "step5ContinueBtn2");
//					Thread.sleep(2000);
//					Vmor.r_clickByJse(step5CheckBox2CCA, "step5CheckBox2CCA");
//					Thread.sleep(2000);
//					Vmor.r_click(step5ContinueBtn3, "step5CheckBox1PCCIstep5ContinueBtn2");
					
					//Handle Pay Monthly Mobile Agreement
					Vmor.r_clickByJse(step5CheckBox1PCCI, "step5CheckBox1PCCI");
					Thread.sleep(2000);
					//Vmor.r_click(step5ContinueBtn1, "step5ContinueBtn1");
					Thread.sleep(2000);
					//Vmor.r_click(step5ContinueBtn2, "step5ContinueBtn2");
					Thread.sleep(2000);
					Vmor.r_clickByJse(step5CheckBox2CCA, "step5CheckBox3CCA");
					Thread.sleep(2000);
					//Vmor.r_click(step5ContinueBtn3, "step5ContinueBtn3");
					Thread.sleep(2000);
					Vmor.r_clickByJse(step5CheckBox3CCA, "step5CheckBox3CCA");
					Thread.sleep(2000);
					Vmor.r_click(step5ContinueBtn1, "step5ContinueBtn1");
					Thread.sleep(2000);		

					Vmor.r_click(step5ContinueBtn2, "step5ContinueBtn2");
					Thread.sleep(10000);
				}
		
		
		//captureOrderNumber
				
				
				@FindBy(xpath = "//iframe[@id='kampyleInvite']")
				WebElement feedbackframe;
				//button[text()='Not right now']
				@FindBy(xpath = "//button[text()='Not right now']")
				WebElement feedbacknotnow;
		/*		@FindBy(xpath = "//h1[contains(text(),' Your order is complete ')]")
				WebElement txtOrderComplete;*/
				// txtOrderComplete = By.xpath("//h1[contains(text(),' Your order is complete ')]");
				@FindBy(xpath = "//div[contains(@class,'order-info__order-details-title')]")
				WebElement txtNCOrderNum;
				//txtNCOrderNum = By.xpath("//div[contains(@class,'order-info__order-details-title')]");
				
				public void captureOrderNumber() throws Exception {

					Thread.sleep(10000);
					By txtOrderComplete = By.xpath(
							"//h1[contains(text(),' Your order is complete ')]");
					Vmor.validateText("Your order is complete", txtOrderComplete, "txtOrderComplete");
					Thread.sleep(7000);
					String orderNum = driver.findElement((By) txtNCOrderNum).getText();
					System.out.println("Order Number is : " + orderNum);
					
					WebElement userEmail = driver.findElement(By.xpath("//strong[contains(text(),'com')]"));
					
					ecomUserEmail=userEmail.getText();
					
				}
				
				
				
				public void getenviurl() {
					String current_url = driver.getCurrentUrl();
				 System.out.println(current_url);
					if (current_url.contains("e2e3")) {
						driver.get("https://toms-e2e3.vip.a.itdev.uk.pri.o2.com");
					}
					else if(current_url.contains("e2e2")){
						driver.get("https://toms-e2e2.vip.a.itdev.uk.pri.o2.com");
					}
					else if(current_url.contains("e2e")){
						driver.get("https://toms-e2e.vip.a.itdev.uk.pri.o2.com");
					}

				}
						
			


//VG14
//launching the URL
//ecom.acceptingCookies();
//ecom.shoppingPhones();






//ecom.shoppingPhones();

//navigating to shop->phones pages

				@FindBy(xpath = "//a[text()=' Phones ']")
				WebElement phonesLink;
				//a[text()=' Phones ']
				//span[.=' Phones']
//navigating to shop->phones pages method
	//@SuppressWarnings("deprecation")
	
	public void shoppingPhones() throws InterruptedException {
		/*Actions a1 = new Actions(getRemoteWebDriver());
		a1.moveToElement(driver.findElement((By) shopLink)).moveToElement(driver.findElement((By) phonesLink)).click().build()
				.perform();
		ExtentReport.log("Phones link is selected by hovering on SHOP", "Phones", Status.PASS);
		//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(15000);*/
		Thread.sleep(10000);
		Vmor.hoverAndClickElement(shopLink, phonesLink, 5,"phonesLink");
		ExtentReport.log("Phones link is selected by hovering on SHOP", "Phones", Status.PASS);
	}
	


	//searching product pages
	
	@FindBy(xpath = "//input[@placeholder='Search phones']")
	WebElement searchBar;
	
	@FindBy(xpath = "//button[@aria-label='Start search']")
	WebElement searchButton;
	
	
	//searching product pages method
	public void searchingForProduct483232() throws Exception {
		Thread.sleep(10000);
		Vmor.r_enterText(searchBar,"Apple iPhone 11","searchBar");
				
		Thread.sleep(10000);
		Vmor.r_click(searchButton, "searchButton");

	}
	
	
	
	
	//selectingFirstSearchResult pages
	
	@FindBy(xpath = "//a[@class='device-card__link']")
	WebElement firstSearchResult;
	
	
	//selectingFirstSearchResult method
	
	public void selectingFirstSearchResult() throws InterruptedException {
		Thread.sleep(12000);
		Vmor.r_clickByJse(firstSearchResult, "firstSearchResult");
		Thread.sleep(8000);
	}


	//selectPlan pages
	
	@FindBy(xpath = "(//span[contains(text(),' Choose this plan ')])[1]")
	WebElement selectplan;
	//(//span[contains(text(),' Choose this plan ')])[1]
	//span[contains(text(),' Choose this plan ')]
	
	//selectPlan method	
	
	public void selectPlan() throws Exception {
		Thread.sleep(15000);
		Vmor.r_click(selectplan, "selectplan");	
		Thread.sleep(15000);
	}
	

	//addToBasket page
	
	@FindBy(xpath = "//span[contains(text(),' Add to basket ')]")
	WebElement AddToBasketButton;
	
	//addToBasket method

	public void addToBasket() throws Exception {
		Thread.sleep(15000);
		Vmor.r_click(AddToBasketButton, "AddToBasketButton");
		Thread.sleep(20000);
	}

	
	/*//deliveryPage page
	@FindBy(xpath = "//span[contains(text(),' Confirm and continue ')]")
	WebElement confirmAndContinueBtn;
	
	
	//deliveryPage method
	public void deliveryPage() throws Exception {
		Vmor.r_click(confirmAndContinueBtn, "confirmAndContinueBtn");
	}
	*/
	
	//securityPage pages
	
	@FindBy(xpath = "//span[@id='msisdnListSelectBoxItText']")
	WebElement mobileDropdownBtn;
	@FindBy(xpath = "//li[contains(@class,'selectboxit-option-last')]")
	WebElement mobileDropdownValue;
	@FindBy(xpath = "//button[@id='continueButton']")
	WebElement securityContinueBtn;
	@FindBy(xpath = "//input[@id='otacDigitOne']")
	WebElement otpBox1;
	@FindBy(xpath = "//input[@id='otacDigitTwo']")
	WebElement otpBox2;
	@FindBy(xpath = "//input[@id='otacDigitThree']")
	WebElement otpBox3;
	@FindBy(xpath = "//input[@id='otacDigitFour']")
	WebElement otpBox4;
	@FindBy(xpath = "//input[@id='otacDigitFive']")
	WebElement otpBox5;
	@FindBy(xpath = "//input[@id='otacDigitSix']")
	WebElement otpBox6;

	
	//securityPage method
	
	public void securityPage() throws Exception {
		Vmor.craftWait(mobileDropdownBtn, 20);
		if (driver.findElement((By) mobileDropdownBtn).isDisplayed()) {
			// security page, selecting mobile number and entering security code
			Vmor.r_clickByJse(mobileDropdownBtn, "mobileDropdownBtn");
			Vmor.craftWait(mobileDropdownValue, 5);
			Vmor.r_click(mobileDropdownValue, "mobileDropdownValue");
			Thread.sleep(5000);
			Vmor.r_click(securityContinueBtn, "securityContinueBtn");

			Thread.sleep(5000);
			Vmor.craftWait(otpBox1, 18);

			// Vmor.r_enterText(otpBox1, "otpBox1");
			Vmor.r_enterText(otpBox1, "otpBox1", "9");
			Vmor.r_enterText(otpBox2, "otpBox2", "9");
			Vmor.r_enterText(otpBox3, "otpBox3", "9");
			Vmor.r_enterText(otpBox4, "otpBox4", "9");
			Vmor.r_enterText(otpBox5, "otpBox5", "9");
			Vmor.r_enterText(otpBox6, "otpBox6", "9");

			Thread.sleep(5000);
			Vmor.r_click(securityContinueBtn, "securityContinueBtn");
			
		} else {
			Vmor.craftWait(otpBox1, 18);
			// Vmor.r_enterText(otpBox1, "otpBox1");
			Vmor.r_enterText(otpBox1, "otpBox1", "9");
			Vmor.r_enterText(otpBox2, "otpBox2", "9");
			Vmor.r_enterText(otpBox3, "otpBox3", "9");
			Vmor.r_enterText(otpBox4, "otpBox4", "9");
			Vmor.r_enterText(otpBox5, "otpBox5", "9");
			Vmor.r_enterText(otpBox6, "otpBox6", "9");

			Thread.sleep(3000);
			Vmor.r_click(securityContinueBtn, "securityContinueBtn");
		}

	}
	
	
	//step1 pages
	
	@FindBy(xpath = "(//span[contains(text(),' Confirm and continue ')])[2]")
	WebElement step1ConfirmAndContinueBtn1;
	// step1ConfirmAndContinueBtn1 = By.xpath("(//span[contains(text(),' Confirm and continue ')])[2]");
	@FindBy(xpath = "//span[contains(text(),' Please select an option... ')]")
	WebElement timeAtAddressDropDown;
	//timeAtAddressDropDown = By.xpath("//span[contains(text(),' Please select an option... ')]");
	@FindBy(xpath = "//span[contains(text(),' 3 to 4 years ')]")
	WebElement timeAtAddressDDValue;
	//timeAtAddressDDValue = By.xpath("//span[contains(text(),' 3 to 4 years ')]");
	@FindBy(xpath = "(//span[contains(text(),' Please select an option... ')])[1]")
	WebElement empStatusDropDown;
	//empStatusDropDown = By.xpath("(//span[contains(text(),' Please select an option... ')])[1]");
	@FindBy(xpath = "//span[contains(text(),' Employed ')]")
	WebElement empStatusDDValue;
	//empStatusDDValue = By.xpath("//span[contains(text(),' Employed ')]");
	@FindBy(xpath = "(//span[contains(text(),' Please select an option... ')])[1]")
	WebElement annualIncomeDropDown;
	//annualIncomeDropDown = By.xpath("(//span[contains(text(),' Please select an option... ')])[1]");
	@FindBy(xpath = "//span[contains(text(),' £20,001-£30,000 ')]")
	WebElement annualIncomeDDValue;
	// annualIncomeDDValue = By.xpath("//span[contains(text(),' £20,001-£30,000 ')]");
	@FindBy(xpath = "//input[@id='mat-checkbox-1-input']")
	WebElement pre_creditCheckBox;
	//pre_creditCheckBox = By.xpath("//input[@id='mat-checkbox-1-input']");
	@FindBy(xpath = "(//span[contains(text(),' Confirm and continue ')])[3]")
	WebElement step1ConfirmAndContinueBtn3;
	//step1ConfirmAndContinueBtn3 = By.xpath("(//span[contains(text(),' Confirm and continue ')])[3]");
	@FindBy(xpath = "//span[contains(text(),' Send Contract Info & Summary ')]")
	WebElement sendContractAndSummary;
	//sendContractAndSummary = By.xpath("//span[contains(text(),' Send Contract Info & Summary ')]");
	@FindBy(xpath = "//span[contains(text(),' Continue ')]")
	WebElement creditCheckContinueBtn;
	//creditCheckContinueBtn = By.xpath("//span[contains(text(),' Continue ')]");
	@FindBy(xpath = "//input[contains(@autotest-target,'confirm-contract-info-checkbox')]")
	WebElement chkboxContract;
	//chkboxContract = By.xpath("//input[contains(@autotest-target,'confirm-contract-info-checkbox')]");
	@FindBy(xpath = "(//span[contains(text(),' Confirm and continue ')])[4]")
	WebElement step1ConfirmAndContinueBtn4;
	//step1ConfirmAndContinueBtn4 = By.xpath("(//span[contains(text(),' Confirm and continue ')])[4]");
	@FindBy(xpath = "//span[contains(text(),' Continue ')]")
	WebElement btnContinueSW;
	// btnContinueSW = By.xpath("//span[contains(text(),' Continue ')]");
	
	
	//step1 method
	public void step1() throws Exception {
		Thread.sleep(6000);
		Vmor.r_click(step1ConfirmAndContinueBtn1, "step1ConfirmAndContinueBtn1");
		Thread.sleep(6000);
		// eligibility check
		// time at address
		Vmor.r_click(timeAtAddressDropDown, "timeAtAddressDropDown");
		Thread.sleep(3000);
		Vmor.r_clickByJse(timeAtAddressDDValue, "timeAtAddressDDValue");
		Thread.sleep(3000);
		// employee status
		Vmor.r_click(empStatusDropDown, "empStatusDropDown");
		Thread.sleep(3000);
		Vmor.r_clickByJse(empStatusDDValue, "empStatusDDValue");
		Thread.sleep(3000);
		// personal annual income
		Vmor.r_click(annualIncomeDropDown, "annualIncomeDropDown");
		Thread.sleep(3000);
		Vmor.r_clickByJse(annualIncomeDDValue, "annualIncomeDDValue");
		Thread.sleep(3000);
		Vmor.r_clickByJse(pre_creditCheckBox, "pre_creditCheckBox");
		Thread.sleep(6000);
		Vmor.r_clickByJse(step1ConfirmAndContinueBtn3, "step1ConfirmAndContinueBtn3");
		// Vmor.r_click(step1ConfirmAndContinueBtn3, "step1ConfirmAndContinueBtn3",
		// "Y");
		Thread.sleep(4000);
		Vmor.r_click(sendContractAndSummary, "sendContractAndSummary");
		Thread.sleep(15000);

		// You’re likely to pass the credit check page:
		Vmor.r_click(creditCheckContinueBtn, "creditCheckContinueBtn");
		Thread.sleep(5000);

		// Vmor.r_click(step1ConfirmAndContinueBtn3, "step1ConfirmAndContinueBtn3",
		// "Y");
		// Vmor.r_click(btnContinueSW, "btnContinueSW");
		// Thread.sleep(2000);
		Vmor.r_click(sendContractAndSummary, "sendContractAndSummary");
		Thread.sleep(8000);
		Vmor.r_click(chkboxContract, "chkboxContract");
		Thread.sleep(3000);
		Vmor.r_click(step1ConfirmAndContinueBtn4, "step1ConfirmAndContinueBtn4");
		Thread.sleep(3000);
		Vmor.r_click(btnContinueSW, "btnContinueSW");
		Thread.sleep(5000);
		// Vmor.r_click(ConfirmAndContinueBtn, "ConfirmAndContinueBtn");
		// Thread.sleep(5000);
		// Vmor.r_click(step1ConfirmAndContinueBtn1, "ConfirmAndContinueBtn");
		// Thread.sleep(5000);
		System.out.println("step 1 exit");
	}


	
	//step2 pages
	
	@FindBy(xpath = "//span[contains(text(),' Validate ')]")
	WebElement validateBtn;
	@FindBy(xpath = "//input[@id='mat-checkbox-3-input']")
	WebElement step2CheckCheckBox;
	@FindBy(xpath = "(//span[contains(text(),' Save and continue ')])[1]")
	WebElement step2SaveAndContinueBtn;
	@FindBy(xpath = "//span[contains(text(),' Continue with credit check ')]")
	WebElement step2ContinueWithCreditCheckBtn;
	@FindBy(xpath = "//span[contains(text(),' Continue ')]")
	WebElement continuebuttonnew;
	
	
	//step2 method
	public void step2() throws Exception {
		System.out.println("step 2");

		// ddDetails();
		// Step 2: Set up your Direct Debit for
		Vmor.r_click(validateBtn, "validateBtn");
		Thread.sleep(10000);
		Vmor.r_clickByJse(step2CheckCheckBox, "step2CheckCheckBox");
		Thread.sleep(5000);
		Vmor.r_click(step2SaveAndContinueBtn, "step2SaveAndContinueBtn");
		Thread.sleep(15000);
		AddcardDetails();
		Vmor.r_click(step2ContinueWithCreditCheckBtn, "step2ContinueWithCreditCheckBtn");
		Thread.sleep(5000);
		Vmor.r_click(continuebuttonnew, "continuebuttonnew");
		Thread.sleep(10000);
	}
	
	//step3 pages
	
	@FindBy(xpath = "(//span[contains(text(),' Confirm ')])[2]")
	WebElement step3Confirm2;	
	@FindBy(xpath = "//span[contains(text(),' Confirm and continue ')]")
	WebElement confirmContinue;
	@FindBy(xpath = "//input[@id='mat-input-1']")
	WebElement step3EnterPackageName2;
	@FindBy(xpath = "(//span[contains(text(),' Confirm ')])[4]")
	WebElement step3Confirm4;
	@FindBy(xpath = "(//span[contains(text(),' Continue ')])")
	WebElement step3ContinueBtn;
	
	
	//step3 method
	public void step3() throws Exception {
		System.out.println("step 3");

		// your package name
		// Vmor.r_enterText(step3EnterPackageName1, "Package Name 1","Test1","Y");

		//driver.findElement(step3EnterPackageName1).sendKeys("Test1");
		Vmor.r_enterText(step3EnterPackageName1, "Test1", "step3EnterPackageName1");
		Thread.sleep(5000);
		Vmor.r_click(step3Confirm1, "step3Confirm1");
		Thread.sleep(5000);

		Vmor.r_click(rdBtnNotNow, "rdBtnNotNow");
		Thread.sleep(5000);

		Vmor.r_click(step3Confirm2, "step3Confirm2");
		Thread.sleep(5000);

		Vmor.r_click(confirmContinue, "confirmContinue");
		Thread.sleep(15000);
		// span[contains(text(),' Confirm and continue ')]

		//driver.findElement(step3EnterPackageName2).sendKeys("Test1");
		Vmor.r_enterText(step3EnterPackageName2, "Test1", "step3EnterPackageName2");
		// Vmor.r_enterText(step3EnterPackageName2, "Package Name 2","Test1","Y");
		Thread.sleep(5000);
		Vmor.r_click(step3Confirm2, "step3Confirm2");
		Thread.sleep(5000);

		// No spend cap action: Vmor.r_click(step3Confirm3, "step3Confirm3");
		Thread.sleep(5000);
		Vmor.r_click(step3Confirm4, "step3Confirm4");
		Thread.sleep(5000);
		Vmor.r_click(step3ContinueBtn, "step3ContinueBtn");
		Thread.sleep(5000);

	}
	
	
	//step4 pages
	@FindBy(xpath = "(//span[contains(text(),' Confirm and continue ')])")
	WebElement step4confirmAndContinueBtn;
	
	 
	//step4 method
	public void step4() throws Exception {
		Vmor.r_click(step4confirmAndContinueBtn, "step4confirmAndContinueBtn");
		Thread.sleep(4000);
	}
	
	
	//step5 pages
	@FindBy(xpath = "(//input[contains(@id,'mat-checkbox')])[3]")
	WebElement step5PmmaChkBox3new;
	@FindBy(xpath = "(//input[contains(@id,'mat-checkbox')])[4]")
	WebElement step5PmmaChkBox4new;
	@FindBy(xpath = "(//span[contains(text(),' Continue ')])[5]")
	WebElement step5ContinueBtn5new;
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[4]")
	WebElement continueforStep5;
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[5]")
	WebElement continueForLastStep5;
	
	
	//step5 method
	
	public void step5() throws Exception {
		// Vmor.r_click(step5ContinueBtn1, "step5ContinueBtn1");
		Vmor.r_clickByJse(step5CheckBox1PCCI, "step5CheckBox1PCCI");
		Thread.sleep(5000);
		Vmor.r_click(step5ContinueBtn2, "step5ContinueBtn2");
		Thread.sleep(5000);
		Vmor.r_clickByJse(step5CheckBox2CCA, "step5CheckBox2CCA");
		/*
		 * Thread.sleep(5000); Vmor.r_clickByJse(step5CheckBox3CCA,
		 * "step5CheckBox3CCA");
		 */
		// Thread.sleep(5000);
		// Vmor.r_click(step5ContinueBtn1, "step5ContinueBtn1");
		/*
		 * Thread.sleep(2000); Vmor.r_click(step5ContinueBtn2, "step5ContinueBtn2",
		 * "Y");
		 */
		/*
		 * Thread.sleep(2000); Vmor.r_clickByJse(step5CheckBox4PCCI,
		 * "step5CheckBox4PCCI"); Thread.sleep(2000); Vmor.r_click(step5ContinueBtn3,
		 * "step5ContinueBtn3"); Thread.sleep(2000);
		 * Vmor.r_clickByJse(step5PmmaChkBox1, "step5PmmaChkBox1"); Thread.sleep(2000);
		 * Vmor.r_click(step5ContinueBtn4, "step5ContinueBtn3");
		 * Thread.sleep(2000);
		 */
		Vmor.r_clickByJse(step5PmmaChkBox3new, "step5PmmaChkBox3");
		Thread.sleep(2000);
		Vmor.r_clickByJse(step5PmmaChkBox4new, "step5PmmaChkBox3");
		Thread.sleep(2000);
		Vmor.r_click(step5ContinueBtn5new, "step5ContinueBtn5");
		Thread.sleep(2000);
		Vmor.r_click(continueforStep5, "continueforStep5");
		Thread.sleep(5000);
		Vmor.r_click(continueForLastStep5, "continueForLastStep5");
		Thread.sleep(10000);
		System.out.println("Testcase Got Passed");

	}
	
	
	

}

		
