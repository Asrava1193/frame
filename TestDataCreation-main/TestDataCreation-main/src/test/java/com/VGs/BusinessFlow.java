package com.VGs;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.Status;
import com.cognizant.framework.APIFunctionality;
import com.cognizant.framework.ExcelData;
import com.cognizant.framework.ExtentReport;
import Pages.CSRD;
import Pages.Ecom;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BusinessFlow {

	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public void invokeBrowser(String envoirment, String application) throws MalformedURLException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		driver = new ChromeDriver();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		//WebDriverManager.chromedriver().setup();
		
		/*//GRID
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setCapability("browserName", "chrome");
		String nodeurl= "http://10.173.171.5:4444";
		
		try {driver = new RemoteWebDriver(new URL(nodeurl), cap);
		}
		catch (Exception e){
			e.printStackTrace();
		}*/
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));

		if (application.equals("CSRD")) {

			if (envoirment.equals("E2E3")) {

				driver.get("https://toms-e2e3.vip.a.itdev.uk.pri.o2.com/");

			} else if (envoirment.equals("E2E2")) {
				driver.get("https://toms-e2e2.vip.a.itdev.uk.pri.o2.com/");

			} else if (envoirment.equals("E2E1")) {
				driver.get("https://toms-e2e.vip.a.itdev.uk.pri.o2.com");

			} else {
				driver.get("https://toms-uat.vip.a.itdev.uk.pri.o2.com");

			}
		} else {
			if (envoirment.equals("E2E3")) {

				driver.get("https://ecommerce-e2e3.vip.a.itdev.uk.pri.o2.com");
			} else if (envoirment.equals("E2E2")) {
				driver.get("https://ecommerce-e2e2.vip.a.itdev.uk.pri.o2.com");
			} else if (envoirment.equals("E2E1")) {
				driver.get("https://ecommerce-e2e.vip.a.itdev.uk.pri.o2.com");
			} else {
				driver.get("https://ecommerce-uat.vip.a.itdev.uk.pri.o2.com");
			}

		}
	}

	public void quit() {
		driver.quit();

	}

	public void VGC_CSRD(int curriteration, int iteration) throws Exception {
		CSRD csrd = new CSRD();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.writeDataExcel();
	}

	public void VG11_CSRD(int curriteration, int iteration) throws Exception {

		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String current_url = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addnewSimoPlan();
		csrd.selectAllowanceBundle(ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForSIMO();
		csrd.afterChkOut();
		csrd.FetchOrderDetails();
		csrd.writeDataExcel();
		api1.initializeAPI(current_url);// intialize API
		api1.validate_put_request_SIMO(ExcelData.SerialNo1);

	}

	public void VG112SIMO_CSRD(int curriteration, int iteration) throws Exception {

		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String current_url = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addnewSimoPlan();
		csrd.selectAllowanceBundle(ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForSIMO();
		csrd.afterChkOut();
		csrd.FetchOrderDetails();
		Thread.sleep(10000);
		api1.initializeAPI(current_url);// intialize API
		api1.validate_put_request_SIMO(ExcelData.SerialNo1);

		Thread.sleep(3000);
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.add2SimoPlan();
		csrd.selectAllowanceBundle(ExcelData.spendcap2);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPagesecondorder();
		csrd.reviewPageForSecondOrderSIMO();
		csrd.afterChkOut();
		csrd.FetchOrderDetails();
		Thread.sleep(10000);
		api1.initializeAPI(current_url);// intialize API
		api1.validate_put_request_SIMO(ExcelData.SerialNo2);
		Thread.sleep(3000);
		csrd.writeDataExcel();

	}

	public void VG7_CSRD(int curriteration, int iteration) throws Exception {

		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String current_url = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addnewSimoPlan();
		csrd.selectAllowanceBundle(ExcelData.spendcap1);
		csrd.cafeynExtra();
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForSIMO();
		csrd.afterChkOut();
		csrd.FetchOrderDetails();
		csrd.writeDataExcel();
		api1.initializeAPI(current_url);// intialize API
		api1.validate_put_request_SIMO(ExcelData.SerialNo1);

	}

	public void VG11U_CSRD(int curriteration, int iteration) throws Exception {

		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String current_url = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addnewSimoPlan();
		csrd.selectAllowanceBundle(ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForSIMO();
		csrd.afterChkOut();
		csrd.FetchOrderDetails();
		csrd.writeDataExcel();
		api1.initializeAPI(current_url);// intialize API
		api1.validate_put_request_SIMO(ExcelData.SerialNo1);

	}

	public void VG11MBB_CSRD(int curriteration, int iteration) throws Exception {

		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String current_url = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addnewSimoPlan();
		csrd.selectAllowanceBundle(ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForSIMO();
		csrd.afterChkOut();
		csrd.FetchOrderDetails();
		csrd.writeDataExcel();
		api1.initializeAPI(current_url);// intialize API
		api1.validate_put_request_SIMO(ExcelData.SerialNo1);

	}

	public void VG55_CSRD(int curriteration, int iteration) throws Exception {

		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String current_url = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addSmartKeyboard(ExcelData.smartKeyboard);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForSFFOrder();
		csrd.afterChkOut();
		csrd.FetchOrderDetails();
		csrd.writeDataExcel(); 
		api1.initializeAPI(current_url);// intialize API
		api1.validate_put_request_SFF();

	}

	public void VG10_CSRD(int curriteration, int iteration) throws Exception {

		System.out.println("VG10");
		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String currenturl = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addiphone(ExcelData.phone1, "Standard Plan");
		csrd.addStandardPlanforphone(ExcelData.CustomPlanAllowanceBundle,ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForCustomPlan();
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Standard Plan");
		csrd.writeDataExcel();
		api1.initializeAPI(currenturl);
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo1); 

	}

	public void VG14_CSRD(int curriteration, int iteration) throws Exception {

		System.out.println("VG14");
		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String currenturl = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addiphone(ExcelData.phone1, "Custom Plan with CCA");
		csrd.addCustomPlanforphone(ExcelData.CustomPlanAllowanceBundle,ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForCustomPlan();
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();
		api1.initializeAPI(currenturl);
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo1);

	}

	public void VG14_U_CSRD(int curriteration, int iteration) throws Exception {

		System.out.println("VG14_U");
		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String currenturl = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addandroidphone(ExcelData.phone1, "Custom Plan with CCA");
		csrd.addCustomPlanforphone(ExcelData.CustomPlanAllowanceBundle,ExcelData.spendcap1);
		csrd.DamageCoverTandC();
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForCustomPlan();
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();
		api1.initializeAPI(currenturl);
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo1);

	}

	public void VG25_CSRD(int curriteration, int iteration) throws Exception {

		System.out.println("VG25");
		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String currenturl = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addiphone(ExcelData.phone1, "Custom Plan with CCA");
		csrd.addCustomPlanVG25(ExcelData.CustomPlanAllowanceBundle);
		csrd.customerInfoPage();
		csrd.reviewPageForCustomPlan();
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();
		api1.initializeAPI(currenturl);
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo1);

	}

	public void VG26_CSRD(int curriteration, int iteration) throws Exception {

		System.out.println("VG26");
		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String currenturl = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addiphone(ExcelData.phone1, "Custom Plan with CCA");
		csrd.addCustomPlanforphone(ExcelData.CustomPlanAllowanceBundle,ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForCustomPlan();
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();
		api1.initializeAPI(currenturl);
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo1);
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addwatch(ExcelData.watch);
		csrd.addCustomPlanforwatch();
		csrd.HomedeliveryReserve();
		csrd.customerInfoPagesecondorder();
		csrd.reviewPageForCustomPlan();// is this currect?
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();// not called API intialize method why may I know?
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo2);

	}

	public void VG76_1_CSRD(int curriteration, int iteration) throws Exception {

		System.out.println("VG76.1");
		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String currenturl = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addiphone(ExcelData.phone1, "Custom Plan with CCA");
		csrd.addCustomPlanforphone(ExcelData.CustomPlanAllowanceBundle,ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForCustomPlan();
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();
		api1.initializeAPI(currenturl);
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo1);
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addiphone(ExcelData.phone2, "Custom Plan with CCA");
		csrd.addCustomPlanforphone(ExcelData.CustomPlanAllowanceBundle,ExcelData.spendcap2);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPagesecondorder();
		csrd.Billingtab();
		csrd.reviewPageForCustomPlan();
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo2);

	}
	
	public void VG13_CSRD(int curriteration, int iteration) throws Exception {

		System.out.println("VG13");
		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String currenturl = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addiphone(ExcelData.phone1, "Custom Plan with CCA");
		csrd.addCustomPlanforphone(ExcelData.CustomPlanAllowanceBundle,ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.addO2Recycle();	
		csrd.customerInfoPage();
		csrd.reviewPageForCustomPlan();
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();
		api1.initializeAPI(currenturl);
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo1);

	}

	public void VG55_5GBolton_CSRD(int curriteration, int iteration) throws Exception {

		System.out.println("VG55_5GBolton");
		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String currenturl = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addiphone(ExcelData.phone1, "Custom Plan with CCA");
		csrd.addCustomPlanforphone(ExcelData.CustomPlanAllowanceBundle,ExcelData.spendcap1);
		csrd.bolton5GAccess();
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForCustomPlan();
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();
		api1.initializeAPI(currenturl);
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo1);

	}
	public void VG84_CSRD(int curriteration, int iteration) throws Exception {

		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String current_url = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addnewSimoPlan();
		csrd.selectAllowanceBundle(ExcelData.spendcap1);
        csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForSIMO();
		csrd.afterChkOut();
		csrd.FetchOrderDetails();
		csrd.writeDataExcel();
		api1.initializeAPI(current_url);// intialize API
		api1.validate_put_request_SIMO(ExcelData.SerialNo1);
	    Thread.sleep(3000);
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addwatch(ExcelData.watch);
		csrd.addCustomPlanforwatch();
		csrd.HomedeliveryReserve();
		csrd.customerInfoPagesecondorder();
		csrd.reviewPageForCustomPlan();// is this currect?
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();// not called API intialize method why may I know?
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo2);
		
		
	}
	public void VG24_CSRD(int curriteration, int iteration) throws Exception {

		System.out.println("VG24");
		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String currenturl = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addIpad(ExcelData.watch);
		csrd.addCustomPlanforipad(ExcelData.AllowanceBundle,ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForCustomPlan();
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();
		api1.initializeAPI(currenturl);
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo1);
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addiphone(ExcelData.phone1, "Custom Plan with CCA");
		csrd.addCustomPlanforphone(ExcelData.CustomPlanAllowanceBundle,ExcelData.spendcap2);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPagesecondorder();
		csrd.reviewPageForCustomPlan();// is this currect?
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();// not called API intialize method why may I know?
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo2);

	}
	
	public void VG45_CSRD(int curriteration, int iteration) throws Exception {

		System.out.println("VG45");
		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String currenturl = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addiphone(ExcelData.phone1, "Custom Plan with full upfront payment");
		csrd.addCustomPlanforphone(ExcelData.CustomPlanAllowanceBundle,ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForCustomPlan();
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();
		api1.initializeAPI(currenturl);
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo1);

	}
	public void VG46_CSRD(int curriteration, int iteration) throws Exception {

		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String current_url = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addnewSimoPlan();
		csrd.selectAllowanceBundle(ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForSIMO();
		csrd.afterChkOut();
		csrd.FetchOrderDetails();
		csrd.writeDataExcel();
		api1.initializeAPI(current_url);// intialize API
		api1.validate_put_request_SIMO(ExcelData.SerialNo1);
		Thread.sleep(2000);
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addiphone(ExcelData.phone1, "Custom Plan with CCA");
		csrd.addCustomPlanforphone(ExcelData.CustomPlanAllowanceBundle,ExcelData.spendcap1);
		csrd.HomedeliveryReserve();
		csrd.customerInfoPage();
		csrd.reviewPageForCustomPlan();
		csrd.afterChkOut();
		csrd.FetchOrderDetailsCustomPlan("Custom Plan");
		csrd.writeDataExcel();
		api1.initializeAPI(current_url);
		api1.validate_put_request_CustomPlan(ExcelData.SerialNo2);

	}

	public void VG_11_SIMO_Order_Broadband_CSRD(int curriteration, int iteration) throws Exception {

		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		String currenturl = csrd.getCurrenturl();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.CsrdnewLogin();
		csrd.csrdNewDetails();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.addnewSimoPlan();
		csrd.selectAllowanceBundle(ExcelData.spendcap1);
		csrd.customerInfoPage();
		csrd.reviewPageForSIMO();
		csrd.afterChkOut();
		csrd.FetchOrderDetails();
		csrd.writeDataExcel();
		api1.initializeAPI(currenturl);
		api1.validate_put_request_SIMO(ExcelData.SerialNo1);

	}

	public void BroadbandOrder_CSRD(int curriteration, int iteration) throws Exception {

		CSRD csrd = new CSRD();
		csrd.readDataExcel(curriteration, iteration);
		csrd.loginToCSRD();
		csrd.enteringMail();
		csrd.clickingOnsearch();
		csrd.acceptingAgentAuth();
		csrd.billingAndMandate();
		csrd.creatingNewOrder();
		csrd.verifyOrderNo();
		csrd.placeBroadbandOrder();
		csrd.Scheduleappointment();
		csrd.Billingtab();
		csrd.reviewPageForBroadband();
		csrd.afterChkOut();
		csrd.writeDataExcel();

	}
	

	public void VG11_ECOM(int curriteration, int iteration) throws Exception {

		Ecom ecom = new Ecom();
		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		
		ecom.readDataExcel(curriteration, iteration);
		ecom.acceptingCookies();
		ecom.shoppingSIMOs();
		ecom.selectingSIMOfromShops();
		ecom.clickCheckOut();
		ecom.acceptingCookies();
		ecom.ecommNewLogin();
		ecom.step1YourDetails();
		ecom.step1Delivery();
		ecom.step1EligibilityChk();
		ecom.step1ChooseTheRightPlan();
		ecom.step1DDPage();
		ecom.AddcardDetails();
		ecom.step2AffordCheck();
		ecom.step3MoreOptions();
		ecom.step4ReviewOrder();
		ecom.step5_499389();
		ecom.captureOrderNumber(); 
		ecom.getenviurl();
		csrd.loginToCSRD();
		csrd.enteringEcomUserEMail();
		csrd.FetchOrderDetails(); 
		String current_url = csrd.getCurrenturl();
		api1.initializeAPI(current_url);
		api1.validate_put_request_SIMO(ExcelData.SerialNo1);

	}

	public void VG14_ECOM(int curriteration, int iteration) throws Exception {

		System.out.println("VG14");
		
		
		
		Ecom ecom = new Ecom();
		CSRD csrd = new CSRD();
		APIFunctionality api1 = new APIFunctionality();
		
		
		
		ecom.readDataExcel(curriteration, iteration);
		ecom.acceptingCookies();
		ecom.shoppingPhones();
		ecom.searchingForProduct483232();
		ecom.selectingFirstSearchResult();
		ecom.selectPlan();
		ecom.addToBasket();
		ecom.clickCheckOut();
		/////////Login 
		ecom.acceptingCookies();
		ecom.ecommNewLogin();
		ecom.step1YourDetails();
		ecom.step1Delivery();
		ecom.step1EligibilityChk();
		ecom.step1ChooseTheRightPlan();
		ecom.step1DDPage();
		
		//pending
		//ecom.deliveryPage();
		ecom.securityPage();
		ecom.step1();
		ecom.step2();
		ecom.step3();
		ecom.step4();
		ecom.step5(); 
		ecom.getenviurl();
		csrd.loginToCSRD();
		csrd.enteringEcomUserEMail();
		csrd.FetchOrderDetails(); 
		String current_url = ecom.getCurrenturl();
		api1.initializeAPI(current_url);
		api1.validate_put_request_SIMO(ExcelData.SerialNo1);

	}
	
	
}
